package com.rj.qf.service.impl;

import com.rj.qf.bean.common.ResultData;
import com.rj.qf.bean.dto.buy.BuyBackBillIndex_d;
import com.rj.qf.bean.dto.buy.BuyBackBill_d;
import com.rj.qf.bean.qf.buy.BuyBackBill;
import com.rj.qf.bean.qf.buy.BuyBackIndex;
import com.rj.qf.bean.qf.qf_btype;
import com.rj.qf.bean.qf.qf_employee;
import com.rj.qf.bean.qf.qf_ptype;
import com.rj.qf.bean.qf.qf_stock;
import com.rj.qf.dao.BuyBackBillDao;
import com.rj.qf.dao.UtilsDao;
import com.rj.qf.service.BuyBackBillService;
import com.rj.qf.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class BuyBackBillServiceImpl implements BuyBackBillService {
    @Autowired
    private UtilsDao utilsDao;
    @Autowired
    private BuyBackBillDao buyBackBillDao;

    @Override
    public synchronized ResultData addSaleBill(BuyBackBillIndex_d buyBackBillIndex_d) {
        qf_btype btype = utilsDao.getBtypeByUserCode(buyBackBillIndex_d.getBuserCode());
        if (btype == null) {
            return new ResultData(0, "编号【" + buyBackBillIndex_d.getBuserCode() + "】的往来单位信息不存在,插入单据失败", null);
        }
        qf_stock stock = utilsDao.getStockByUserCode(buyBackBillIndex_d.getKuserCode());
        if (stock == null) {
            return new ResultData(0, "编号【" + buyBackBillIndex_d.getKuserCode() + "】的仓库信息不存在,插入单据失败", null);
        }
        qf_employee employee = utilsDao.getEmployeeByUserCode(Utils.BUY_EUSER_NAME);
        if (employee == null) {
            return new ResultData(0, "职员信息不存在,插入单据失败,请联系开发人员", null);
        }
        if (buyBackBillIndex_d.getBackBill_ds().size() != buyBackBillIndex_d.getBillDetailCount()) {
            return new ResultData(0, "明细单据总条数和主单据总条数不匹配,不允许进行生单操作", null);
        }
        if (buyBackBillIndex_d.getBackBill_ds().size() == 0) {
            return new ResultData(0, "未检测到单据明细数据,不允许进行生单操作", null);
        }
        //检验采购订单是否存在
        HashMap<String, Object> resultIsBuyBill = utilsDao.getBillInfoByBillCode(buyBackBillIndex_d.getRkBillCode());
        if (resultIsBuyBill == null) {
            return new ResultData(0, "采购入库单号[" + buyBackBillIndex_d.getRkBillCode() + "]不存在！", null);
        }
        for (BuyBackBill_d backBill_d : buyBackBillIndex_d.getBackBill_ds()) {
            qf_ptype ptype = utilsDao.getPtypeByUserCode(backBill_d.getPuserCode());
            if (ptype == null) {
                return new ResultData(0, "第" + backBill_d.getOrd() +
                        "行明细,商品编号为【" + backBill_d.getPuserCode() + "】的商品信息不存在", null);
            }
        }
        //赋值采购退回主表
        BuyBackIndex buyBackIndex = new BuyBackIndex();
        String BillUid = utilsDao.getNewId();
        buyBackIndex.setBillDate(buyBackBillIndex_d.getBillDate()).setBillCode(buyBackBillIndex_d.getBillCode())
                .setComment(buyBackBillIndex_d.getComment()).setBREc(btype.getRec()).setERec(employee.getRec())
                .setKRec(stock.getRec()).setBillE(employee.getRec()).setTotalMoney(buyBackBillIndex_d.getTotalMoney())
                .setTotalQty(buyBackBillIndex_d.getTotalQty()).setUniqueBillid(BillUid);
        //插入采购退回主表
        int BillId = buyBackBillDao.addBuyBackBillIndex(buyBackIndex);
        List<BuyBackBill> buyBackBills = new ArrayList<>();
        for (BuyBackBill_d backBill_d : buyBackBillIndex_d.getBackBill_ds()) {
            //获取商品信息
            qf_ptype qfPtype = utilsDao.getPtypeByUserCode(backBill_d.getPuserCode());
            //获取采购入库单信息信息明细数据
            HashMap<String, Object> getBuyInfoParams = new HashMap<>();
            getBuyInfoParams.put("billCode", buyBackBillIndex_d.getRkBillCode());
            getBuyInfoParams.put("ord", backBill_d.getRkOrd());
            HashMap<String, Object> getBuyInfoResult = utilsDao.getBuyInfoByBillCodeAndOrd(getBuyInfoParams);
            //获取采购入库单信息信息明细数据结束
            BuyBackBill buyBackBill = new BuyBackBill();
            buyBackBill.setBillID(BillId).setKRec(stock.getRec())
                    .setPRec(qfPtype.getRec())
                    .setQty(backBill_d.getQty()).setAssQty(backBill_d.getQty())
                    .setSalePrice(backBill_d.getSalePrice()).setAssSalePrice(backBill_d.getSalePrice())
                    .setDiscountPrice(backBill_d.getSalePrice()).setAssDiscountPrice(backBill_d.getSalePrice())
                    .setTotal(backBill_d.getTotal()).setTax(backBill_d.getTax()).setTaxPrice(backBill_d.getTaxPrice())
                    .setAssTaxPrice(backBill_d.getTaxPrice()).setTaxTotal(backBill_d.getTaxTotal())
                    .setCostPrice(Double.parseDouble(getBuyInfoResult.get("SalePrice").toString())).setJobnumber(backBill_d.getJobnumber())
                    .setOutFactoryDate(backBill_d.getOutFactoryDate()).setValidityPeriod(backBill_d.getValidityPeriod())
                    .setJobCode(backBill_d.getJobCode()).setGermJobNumber(backBill_d.getGermJobNumber())
                    .setCheckReportNo(backBill_d.getCheckReportNo())
                    .setProviderId(Integer.parseInt(getBuyInfoResult.get("ProviderId").toString()))
                    .setComment(backBill_d.getComment()).setOrd(backBill_d.getOrd())
                    .setStockUniqueid(getBuyInfoResult.get("StockUniqueid").toString())
                    .setBackQty(Double.parseDouble(getBuyInfoResult.get("buyid").toString()))//原单据buyid
                    .setBackreason(backBill_d.getBackReason());
            buyBackBills.add(buyBackBill);
        }
        //插入详细单据
        for (BuyBackBill buyBackBill : buyBackBills) {
            buyBackBillDao.addBuyBackBill(buyBackBill);
        }
        return new ResultData(1, "生成单据成功", null);
    }
}
