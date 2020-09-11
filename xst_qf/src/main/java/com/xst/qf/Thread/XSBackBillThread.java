package com.xst.qf.Thread;

import com.alibaba.fastjson.JSON;
import com.xst.qf.beans.HttpResult;
import com.xst.qf.beans.UploadBase;
import com.xst.qf.beans.jztBean.GET_InStock;
import com.xst.qf.beans.jztBean.JztRKJson;
import com.xst.qf.beans.qfBean.ZXY_GJ_RK_SC_BILL_Bean;
import com.xst.qf.beans.qfBean.ZxyUploadbill;
import com.xst.qf.dao.BuyBillDao;
import com.xst.qf.dao.ZxyUploadbillDao;
import com.xst.qf.service.GetService.GetInStockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 　* @description:销售退回数据处理线程
 　* @author zxy
 　* @date 2020-08-05 16:44
 　*/
@Component
@Slf4j
public class XSBackBillThread extends  Thread{

    private ZxyUploadbillDao zxyUploadbillDao ;
    private BuyBillDao buyBillDao;
    private GetInStockService getInStockService;

    public XSBackBillThread(ZxyUploadbillDao zxyUploadbillDao,BuyBillDao buyBillDao,GetInStockService getInStockService){
            this.zxyUploadbillDao = zxyUploadbillDao;
            this.buyBillDao = buyBillDao;
            this.getInStockService = getInStockService;
    }
    @Override
    public void run() {

        log.info("销售退回数据处理线程开启");
        List<ZxyUploadbill> jzt_buyBills = zxyUploadbillDao.getUploadBillByBilltype(45);
        for (ZxyUploadbill jzt_buyBill : jzt_buyBills) {
            JztRKJson jztRKJson = new JztRKJson(jzt_buyBill.getBillcode(), "4");
            UploadBase<JztRKJson> jztRKJsonUploadBase = new UploadBase("xtsc", "select", jztRKJson);
            HttpResult<List<GET_InStock>> httpResult = getInStockService.getSaleBack(jztRKJsonUploadBase);
            if (httpResult.isFlag()) {
                List<GET_InStock> inStocks = httpResult.getMsgInfo();
                for (int i = 0; i < inStocks.size(); i++) {
                    GET_InStock get_inStock = JSON.parseObject(JSON.toJSONString(inStocks.get(i)), GET_InStock.class);
                    ZXY_GJ_RK_SC_BILL_Bean rk_scbill = new ZXY_GJ_RK_SC_BILL_Bean();
                    rk_scbill.setDANJ_NO(get_inStock.getInstoreBill_No_LMIS());//九州通单据编号
                    rk_scbill.setPicihao(get_inStock.getGoods_Lotno());//批次号
                    rk_scbill.setYx_date(get_inStock.getValid_Until());//有效期
                    rk_scbill.setSc_date(get_inStock.getProduction_Date());//生产日期
                    rk_scbill.setSs_qty(get_inStock.getStorage_Quantity() + "");//入库数量（实收数量）
                    rk_scbill.setCHOUY_QTY("3");//抽样数量
                    rk_scbill.setPRICE(get_inStock.getPrice() + "");//单价
                    rk_scbill.setBillid(get_inStock.getBiz_Bill_No());//单据编号
                    rk_scbill.setPrec(get_inStock.getGoods_No());//商品编号
                    rk_scbill.setChecker(get_inStock.getQuality_Inspector());//质检员（验收人）
                    rk_scbill.setSHR(get_inStock.getReceiving_Clerk());//收货员
                    rk_scbill.setRIQI_CHAR(get_inStock.getTakegds_Time());//验收日期
                    rk_scbill.setRUK_TYPE(4);
                    rk_scbill.setYANS_RLT(Integer.parseInt(get_inStock.getAcceptance_Check_Rlt()));
                    if (rk_scbill.getYANS_RLT() == 1 || rk_scbill.getYANS_RLT() == 2 || rk_scbill.getYANS_RLT() == 3) {
                        buyBillDao.ZXY_GJ_RK_SC_BILL(rk_scbill);
                    }
                }
            }
        }
        log.info("销售退回数据处理线程结束");
    }
}
