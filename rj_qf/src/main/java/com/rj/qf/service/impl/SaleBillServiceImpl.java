package com.rj.qf.service.impl;

import com.rj.qf.bean.common.ResultData;
import com.rj.qf.bean.dto.buy.BuyBill_d;
import com.rj.qf.bean.dto.sale.SaleBillIndex_d;
import com.rj.qf.bean.dto.sale.SaleBill_d;
import com.rj.qf.bean.qf.qf_btype;
import com.rj.qf.bean.qf.qf_employee;
import com.rj.qf.bean.qf.qf_ptype;
import com.rj.qf.bean.qf.qf_stock;
import com.rj.qf.bean.qf.sale.SaleBill;
import com.rj.qf.bean.qf.sale.SaleIndex;
import com.rj.qf.dao.SaleBillDao;
import com.rj.qf.dao.UtilsDao;
import com.rj.qf.service.SaleBillService;
import com.rj.qf.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.LazyReflectiveObjectGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class SaleBillServiceImpl implements SaleBillService {
    @Autowired
    private UtilsDao utilsDao;
    @Autowired
    private SaleBillDao saleBillDao;

    @Override
    public synchronized ResultData addSaleBill(SaleBillIndex_d saleBillIndex_d) {
        qf_btype btype = utilsDao.getBtypeByUserCode(saleBillIndex_d.getBuserCode());
        if (btype == null) {
            return new ResultData(0, "编号【" + saleBillIndex_d.getBuserCode() + "】的往来单位信息不存在,插入单据失败", null);
        }
        qf_stock stock = utilsDao.getStockByUserCode(saleBillIndex_d.getKuserCode());
        if (stock == null) {
            return new ResultData(0, "编号【" + saleBillIndex_d.getKuserCode() + "】的仓库信息不存在,插入单据失败", null);
        }
        qf_employee employee = utilsDao.getEmployeeByUserCode(Utils.BUY_EUSER_NAME);
        if (employee == null) {
            return new ResultData(0, "职员信息不存在,插入单据失败,请联系开发人员", null);
        }
        if (saleBillIndex_d.getSaleBillds().size() != saleBillIndex_d.getBillDetailCount()) {
            return new ResultData(0, "明细单据总条数和主单据总条数不匹配,不允许进行生单操作", null);
        }
        if (saleBillIndex_d.getSaleBillds().size() == 0) {
            return new ResultData(0, "未检测到单据明细数据,不允许进行生单操作", null);
        }
        for (SaleBill_d saleBilld : saleBillIndex_d.getSaleBillds()) {
            qf_ptype ptype = utilsDao.getPtypeByUserCode(saleBilld.getPuserCode());
            if (ptype == null) {
                return new ResultData(0, "第" + saleBilld.getOrd() +
                        "行明细,商品编号为【" + saleBilld.getPuserCode() + "】的商品信息不存在", null);
            }
        }
        //检测库存是否存在
        for (SaleBill_d saleBilld : saleBillIndex_d.getSaleBillds()) {
            qf_ptype Ptypes = utilsDao.getPtypeByUserCode(saleBilld.getPuserCode());
            HashMap<String, Object> params = new HashMap<>();
            params.put("pRec", Ptypes.getRec());
            params.put("scDate", saleBilld.getOutFactoryDate());
            params.put("yxDate", saleBilld.getValidityPeriod());
            params.put("kRec", stock.getRec());
            params.put("jobNumber", saleBilld.getJobnumber());
            //获取库存uid和供应商id
            HashMap<String, Object> stockMap = utilsDao.getGoodsStcokUidAndProviderId(params);
            if (stockMap == null) {
                return new ResultData(0, saleBilld.getPuserCode() + "商品库存为空", null);
            }

        }
        SaleIndex saleIndex = new SaleIndex();
        String BillUid = utilsDao.getNewId();
        saleIndex.setBillDate(saleBillIndex_d.getBillDate()).setBillCode(saleBillIndex_d.getBillCode())
                .setComment(saleBillIndex_d.getComment()).setBREc(btype.getRec()).setERec(employee.getRec())
                .setKRec(stock.getRec()).setBillE(employee.getRec()).setTotalMoney(saleBillIndex_d.getTotalMoney())
                .setTotalQty(saleBillIndex_d.getTotalQty()).setUniqueBillid(BillUid);
        int BillId = saleBillDao.addSaleBillIndex(saleIndex);
        List<SaleBill> saleBills = new ArrayList<>();
        for (SaleBill_d saleBilld : saleBillIndex_d.getSaleBillds()) {
            log.info("批次号为"+saleBilld.getJobnumber());
            qf_ptype qfPtype = utilsDao.getPtypeByUserCode(saleBilld.getPuserCode());
            HashMap<String, Object> params = new HashMap<>();
            params.put("pRec", qfPtype.getRec());
            params.put("scDate", saleBilld.getOutFactoryDate());
            params.put("yxDate", saleBilld.getValidityPeriod());
            params.put("kRec", stock.getRec());
            params.put("jobNumber", saleBilld.getJobnumber());
            //获取库存uid和供应商id
            HashMap<String, Object> stockMap = utilsDao.getGoodsStcokUidAndProviderId(params);
            SaleBill saleBill = new SaleBill();
            saleBill.setBillID(BillId).setKRec(stock.getRec())
                    .setPRec(qfPtype.getRec())
                    .setQty(saleBilld.getQty()).setAssQty(saleBilld.getQty())
                    .setSalePrice(saleBilld.getSalePrice()).setAssSalePrice(saleBilld.getSalePrice())
                    .setDiscountPrice(saleBilld.getSalePrice()).setAssDiscountPrice(saleBilld.getSalePrice())
                    .setTotal(saleBilld.getTotal()).setTax(saleBilld.getTax()).setTaxPrice(saleBilld.getTaxPrice())
                    .setAssTaxPrice(saleBilld.getTaxPrice()).setTaxTotal(saleBilld.getTaxTotal())
                    .setCostPrice(Double.parseDouble(stockMap.get("price").toString())).setJobnumber(saleBilld.getJobnumber())
                    .setOutFactoryDate(saleBilld.getOutFactoryDate()).setValidityPeriod(saleBilld.getValidityPeriod())
                    .setJobCode(saleBilld.getJobCode()).setGermJobNumber(saleBilld.getGermJobNumber())
                    .setCheckReportNo(saleBilld.getCheckReportNo())
                    .setProviderId(Integer.parseInt(stockMap.get("ProviderId").toString()))
                    .setComment(saleBilld.getComment()).setOrd(saleBilld.getOrd())
                    .setStockUniqueid(stockMap.get("StockUniqueid").toString());
            saleBills.add(saleBill);
        }
        for (SaleBill saleBill : saleBills) {
            saleBillDao.addSaleBill(saleBill);
        }
        return new ResultData(1, "生成单据成功", null);
    }
}
