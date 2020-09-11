package com.xst.qf.Thread;

import com.alibaba.fastjson.JSON;
import com.xst.qf.beans.HttpResult;
import com.xst.qf.beans.UploadBase;
import com.xst.qf.beans.jztBean.GET_OutStock;
import com.xst.qf.beans.jztBean.JztCKJson;
import com.xst.qf.beans.jztBean.JztRKJson;
import com.xst.qf.beans.qfBean.ZXY_XS_CK_SC_BILL_Bean;
import com.xst.qf.beans.qfBean.ZxyUploadbill;
import com.xst.qf.dao.SaleBillDao;
import com.xst.qf.dao.ZxyUploadbillDao;
import com.xst.qf.service.GetService.GetOutStockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
 /**
 　* @description:销售数据处理线程
 　* @author zxy
 　* @date 2020-08-05 16:44
 　*/
@Component
@Slf4j
public class XSBillThread extends Thread {

    private ZxyUploadbillDao zxyUploadbillDao;
    private SaleBillDao saleBillDao;
    private GetOutStockService getOutStockService;

    public XSBillThread(ZxyUploadbillDao zxyUploadbillDao,SaleBillDao saleBillDao,GetOutStockService getOutStockService){
        this.zxyUploadbillDao= zxyUploadbillDao;
        this.saleBillDao= saleBillDao;
        this.getOutStockService= getOutStockService;

    }
    @Override
    public void run() {
        log.info("处理销售单回传数据开始");
        List<ZxyUploadbill> jzt_saleBills = zxyUploadbillDao.getUploadBillByBilltype(11);
        Set<String> SaleBillCodeList = new TreeSet<>();//销售单编号list,为了去掉重复单据编号,防止重复访问
        for (ZxyUploadbill jzt_saleBill : jzt_saleBills) {
            SaleBillCodeList.add(jzt_saleBill.getBillcode());
        }
        //循环取销售单回传数据
        for (String billCode : SaleBillCodeList) {
            JztCKJson jztCKJson = new JztCKJson(billCode, "1");
            UploadBase<JztRKJson> jztCKJsonUploadBase = new UploadBase("cksc", "select", jztCKJson);
            HttpResult<List<GET_OutStock>> httpResult = getOutStockService.getSale(jztCKJsonUploadBase);
            List<GET_OutStock> outStocks = httpResult.getMsgInfo();
            for (int i = 0; i < outStocks.size(); i++) {
                GET_OutStock get_outStock = JSON.parseObject(JSON.toJSONString(outStocks.get(i)), GET_OutStock.class);
                //不是红冲字段才处理,红冲字段不进行处理
                if (get_outStock.getIs_Reversion().equals("N")) {
                    ZXY_XS_CK_SC_BILL_Bean zxy_xs_ck_sc_bill_bean = new ZXY_XS_CK_SC_BILL_Bean();
                    zxy_xs_ck_sc_bill_bean.setBillcode(get_outStock.getBiz_Bill_No());// 单据编号
                    zxy_xs_ck_sc_bill_bean.setCc_qty(get_outStock.getOutnbound_Quantity());//出库数量
                    zxy_xs_ck_sc_bill_bean.setChecker(get_outStock.getRecheck_Staff());//复核人
                    zxy_xs_ck_sc_bill_bean.setHanghao(Integer.parseInt(get_outStock.getBill_Dtl_Id_Old()));//行号
                    zxy_xs_ck_sc_bill_bean.setPici(get_outStock.getGoods_Lotno());//批次号
                    zxy_xs_ck_sc_bill_bean.setPuserCode(get_outStock.getGoods_No());//商品编号
                    zxy_xs_ck_sc_bill_bean.setRIQI_CHAR(get_outStock.getDelivery_Time());//复核时间
                    zxy_xs_ck_sc_bill_bean.setYEW_TYPE(2);
                    //调用存储过程处理逻辑
                    saleBillDao.ZXY_XS_CK_SC_BILL(zxy_xs_ck_sc_bill_bean);

                }
            }
        }
        log.info("销售单号数量为" + SaleBillCodeList.size());
        log.info("处理销售单回传数据结束");

    }
}
