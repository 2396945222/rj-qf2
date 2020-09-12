package com.rj.qf.service.impl;

import com.rj.qf.bean.common.ResultData;
import com.rj.qf.bean.dto.buy.BuyBillIndex_d;
import com.rj.qf.bean.dto.buy.BuyBill_d;
import com.rj.qf.bean.qf.buy.BuyBillBean;
import com.rj.qf.bean.qf.buy.BuyIndexBean;
import com.rj.qf.bean.qf.qf_btype;
import com.rj.qf.bean.qf.qf_employee;
import com.rj.qf.bean.qf.qf_ptype;
import com.rj.qf.bean.qf.qf_stock;
import com.rj.qf.dao.BuyBillDao;
import com.rj.qf.dao.UtilsDao;
import com.rj.qf.service.BuyBillService;
import com.rj.qf.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuyBillServiceImpl implements BuyBillService {
    @Autowired
    private UtilsDao utilsDao;
    @Autowired
    private BuyBillDao buyBillDao;

    @Override
    public synchronized ResultData addBuyBill(BuyBillIndex_d billIndexD) {
        qf_btype btype = utilsDao.getBtypeByUserCode(billIndexD.getBuserCode());
        if (btype == null) {
            return new ResultData(0, "编号【" + billIndexD.getBuserCode() + "】的往来单位信息不存在,插入单据失败", null);
        }
        qf_stock stock = utilsDao.getStockByUserCode(billIndexD.getKuserCode());
        if (stock == null) {
            return new ResultData(0, "编号【" + billIndexD.getKuserCode() + "】的仓库信息不存在,插入单据失败", null);
        }
        qf_employee employee = utilsDao.getEmployeeByUserCode(Utils.BUY_EUSER_NAME);
        if (employee == null) {
            return new ResultData(0, "职员信息不存在,插入单据失败,请联系开发人员", null);
        }
        if (billIndexD.getBuyBills().size() == 0) {
            return new ResultData(0, "未检测到单据明细数据,不允许进行生单操作", null);
        }
        for (BuyBill_d buyBill_d : billIndexD.getBuyBills()) {
            qf_ptype ptype = utilsDao.getPtypeByUserCode(buyBill_d.getPuserCode());
            if (ptype == null) {
                return new ResultData(0, "第" + buyBill_d.getOrd() +
                        "行明细,商品编号为【" + buyBill_d.getPuserCode() + "】的商品信息不存在", null);
            }

        }
        BuyIndexBean buyIndex = new BuyIndexBean();
        List<BuyBillBean> buyBillList = new ArrayList<>();
        //插入主单据
        buyIndex.setBRec(btype.getRec())
                .setERec(employee.getRec())
                .setCheckEId(0)
                .setBillEId(employee.getRec())
                .setKRec(stock.getRec())
                .setBillDate(billIndexD.getBillDate())
                .setBillCode(billIndexD.getBillCode())
                .setBillType(301)
                .setTotalMoney(billIndexD.getTotalMoney())
                .setTotalQty(billIndexD.getTotalQty())
                .setPeriod(1)
                .setChecked(0)
                .setRedWord(0)
                .setExplain("")
                .setReachDate(Utils.get3Day())
                .setComment(buyIndex.getComment())
                .setTax(billIndexD.getTax())
                .setBillID(0);
        int BillId = buyBillDao.addBuyOrderIndex(buyIndex);
        //详细单据转换成qf实体
        for (BuyBill_d buyBill_d : billIndexD.getBuyBills()) {
            BuyBillBean buyBillBean = new BuyBillBean();
            buyBillBean.setBillID(BillId)
                    .setPRec(utilsDao.getPtypeByUserCode(buyBill_d.getPuserCode()).getRec())
                    .setQty(buyBill_d.getQty())
                    .setPrice(buyBill_d.getPrice())
                    .setTotal(buyBill_d.getTotal())
                    .setComment(buyBill_d.getComment())
                    .setUnit(1).setKRec(stock.getRec())
                    .setSourceOrd(0).setTax(buyBill_d.getTax())
                    .setTaxPrice(buyBill_d.getTaxPrice())
                    .setTaxTotal(buyBill_d.getTaxTotal())
                    .setAssQty(buyBill_d.getQty())
                    .setAssPrice(buyBill_d.getPrice())
                    .setAssTaxPrice(buyBill_d.getTaxPrice())
                    .setUnitRate(1.0).setPriceType(0)
                    .setOrd(buyBill_d.getOrd());
            buyBillList.add(buyBillBean);
        }
        //插入详细单据
        for (BuyBillBean buyBillBean : buyBillList) {
            buyBillDao.addBuyOrderBill(buyBillBean);
        }
        return new ResultData(1, "插入数据成功", null);
    }
}
