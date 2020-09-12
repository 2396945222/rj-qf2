package com.rj.qf.service.impl;

import com.rj.qf.bean.common.ResultData;
import com.rj.qf.bean.dto.sale.SaleBackBillIndex_d;
import com.rj.qf.bean.dto.sale.SaleBackBill_d;
import com.rj.qf.bean.qf.qf_btype;
import com.rj.qf.bean.qf.qf_employee;
import com.rj.qf.bean.qf.qf_ptype;
import com.rj.qf.bean.qf.sale.SaleBackBill;
import com.rj.qf.bean.qf.sale.SaleBackIndex;
import com.rj.qf.dao.SaleBackBillDao;
import com.rj.qf.dao.UtilsDao;
import com.rj.qf.service.SaleBackBillService;
import com.rj.qf.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class SaleBackBillServiceImpl implements SaleBackBillService {
    @Autowired
    private UtilsDao utilsDao;
    @Autowired
    private SaleBackBillDao saleBackBillDao;

    @Override
    public synchronized ResultData addSaleBackBill(SaleBackBillIndex_d saleBackBillIndex_d) {
        qf_btype btype = utilsDao.getBtypeByUserCode(saleBackBillIndex_d.getBuserCode());
        if (btype == null) {
            return new ResultData(0, "编号【" + saleBackBillIndex_d.getBuserCode() + "】的往来单位信息不存在,插入单据失败", null);
        }
        qf_employee employee = utilsDao.getEmployeeByUserCode(Utils.BUY_EUSER_NAME);
        if (employee == null) {
            return new ResultData(0, "职员信息不存在,插入单据失败,请联系开发人员", null);
        }
        if (saleBackBillIndex_d.getSaleBackBill_ds().size() == 0) {
            return new ResultData(0, "未检测到单据明细数据,不允许进行生单操作", null);
        }
        for (SaleBackBill_d saleBackBill_d : saleBackBillIndex_d.getSaleBackBill_ds()) {
            qf_ptype ptype = utilsDao.getPtypeByUserCode(saleBackBill_d.getPuserCode());
            if (ptype == null) {
                return new ResultData(0, "第" + saleBackBill_d.getOrd() +
                        "行明细,商品编号为【" + saleBackBill_d.getPuserCode() + "】的商品信息不存在", null);
            }
        }
        //检验销售单是否存在
        HashMap<String, Object> resultIsSaleBill = utilsDao.getBillInfoByBillCode(saleBackBillIndex_d.getXsbillCode());
        if (resultIsSaleBill == null) {
            return new ResultData(0, "采购入库单号[" + saleBackBillIndex_d.getXsbillCode() + "]不存在！", null);
        }
        for (SaleBackBill_d backBill_d : saleBackBillIndex_d.getSaleBackBill_ds()) {
            qf_ptype ptype = utilsDao.getPtypeByUserCode(backBill_d.getPuserCode());
            if (ptype == null) {
                return new ResultData(0, "第" + backBill_d.getOrd() +
                        "行明细,商品编号为【" + backBill_d.getPuserCode() + "】的商品信息不存在", null);
            }
        }
        //赋值主单据
        SaleBackIndex saleBackIndex = new SaleBackIndex();
        saleBackIndex.setBillcode(saleBackBillIndex_d.getBillcode()).setBillDate(saleBackBillIndex_d.getBillDate())
                .setBillE(employee.getRec()).setBRec(btype.getRec()).setERec(employee.getRec())
                .setComment(saleBackBillIndex_d.getComment()).setTotalmoney(saleBackBillIndex_d.getTotalmoney())
                .setTotalqty(saleBackBillIndex_d.getTotalqty()).setSourceBillCode(resultIsSaleBill.get("BillCode").toString())
                .setSourceId(Integer.parseInt(resultIsSaleBill.get("BillId").toString()));
        //插入主单据
        int billId = saleBackBillDao.addSaleBackBillIndex(saleBackIndex);
        //赋值详细数据
        List<SaleBackBill> saleBackBills = new ArrayList<>();
        for (SaleBackBill_d saleBackBill_d : saleBackBillIndex_d.getSaleBackBill_ds()) {
            SaleBackBill saleBackBill = new SaleBackBill();
            //获取商品信息
            qf_ptype qfPtype = utilsDao.getPtypeByUserCode(saleBackBill_d.getPuserCode());
            //根据商品rec,有效期,生产日期,销售billcode 获取销售单明细数据
            HashMap<String, Object> params = new HashMap<>();
            params.put("billCode", saleBackBillIndex_d.getXsbillCode());
            params.put("pRec", qfPtype.getRec());
            params.put("scDate", saleBackBill_d.getOutFactoryDate());
            params.put("yxDate", saleBackBill_d.getValidityPeriod());
            HashMap<String, Object> salemxInfoMap = utilsDao.getSaleInfoStockUidBypRecAndSCDateAndYXDate(params);
            saleBackBill.setBillID(billId).setPRec(qfPtype.getRec()).setJobnumber(saleBackBill_d.getJobnumber())
                    .setGermJobnumber(saleBackBill_d.getGermJobnumber()).setValidityPeriod(saleBackBill_d.getValidityPeriod())
                    .setOutFactoryDate(saleBackBill_d.getOutFactoryDate()).setQty(saleBackBill_d.getQty())
                    .setPrice(saleBackBill_d.getPrice()).setTotal(saleBackBill_d.getTotal())
                    .setMemo(saleBackBill_d.getComment()).setCostprice(Double.parseDouble(salemxInfoMap.get("costprice").toString()))
                    .setProviderId(Integer.parseInt(salemxInfoMap.get("ProviderId").toString()))
                    .setPtypeSource(0).setStockUniqueid(salemxInfoMap.get("StockUniqueid").toString())
                    .setJobcodel("").setCheckReportNo(saleBackBill_d.getCheckReportNo()).setOrd(saleBackBill_d.getOrd())
                    .setBackReason(saleBackBill_d.getBackReason())
                    .setSourcesaleid(Integer.parseInt(salemxInfoMap.get("saleid").toString())).setTax(saleBackBill_d.getTax())
                    .setTaxprice(saleBackBill_d.getTaxPrice()).setTaxTotal(saleBackBill_d.getTaxTotal());
            saleBackBills.add(saleBackBill);
        }
        //插入详细数据
        for (SaleBackBill saleBackBill : saleBackBills) {
            saleBackBillDao.addSaleBackBill(saleBackBill);
        }
        return new ResultData(1, "生成单据成功", null);
    }
}
