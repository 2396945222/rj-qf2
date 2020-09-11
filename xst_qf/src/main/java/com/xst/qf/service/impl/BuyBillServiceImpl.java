package com.xst.qf.service.impl;

import com.alibaba.fastjson.JSON;
import com.xst.qf.beans.HttpResult;
import com.xst.qf.beans.UploadBase;
import com.xst.qf.beans.jztBean.InStockPlan_Upload;
import com.xst.qf.beans.qfBean.ZxyUploadbill;
import com.xst.qf.dao.BuyBillDao;
import com.xst.qf.dao.ZxyUploadbillDao;
import com.xst.qf.https.JztApi;
import com.xst.qf.service.BuyBillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * 　* @description:采购单service实现类
 * 　* @author zxy
 * 　* @date 2020-07-23 14:58
 */
@Service
@Slf4j
public class BuyBillServiceImpl implements BuyBillService {
    @Autowired
    private BuyBillDao buyBillDao;
    @Autowired
    private ZxyUploadbillDao zxyUploadbillDao;

    @Override
    public HttpResult uoloadBuyBill(String BillCode) {
        log.info("上传采购订单BuyBillServiceImpl访问成功");
        //获取采购订单
        List<InStockPlan_Upload> inStockPlan_uploads =
                buyBillDao.getBuyBill_Upload(BillCode);
        log.info("上传采购订单数据" + JSON.toJSONString(inStockPlan_uploads));
        HttpResult httpResult = JztApi.HttpRequest(
                new UploadBase("rk", "saveData", inStockPlan_uploads));
        log.info("上传采购订单返回数据" + JSON.toJSONString(httpResult));
        if (httpResult.isFlag()) {
            //如果返回的是true,证明上传成功,需要将上床的数据插入到zxyuploabill表中
            for (int i = 0; i < inStockPlan_uploads.size(); i++) {
                ZxyUploadbill zxyUploadbill = new ZxyUploadbill();
                zxyUploadbill.setBillcode(inStockPlan_uploads.get(i).getBUSINESSBILL_NO());//单号
                zxyUploadbill.setBilltype(34);//采购单34
                zxyUploadbill.setCreate_Date(LocalDate.now().toString());
                zxyUploadbill.setOrd(Integer.parseInt(inStockPlan_uploads.get(i).getBILL_DTL_ID_OLD()));
                int count = zxyUploadbillDao.insertSelective(zxyUploadbill);
                if(count > 0){
                    log.info("采购订单保存到zxyUploadbill表中成功" +count);
                }else {
                    log.info("采购订单保存到zxyUploadbill表中失败" +count);
                }
            }
        } else {
            httpResult = this.uoloadBuyBill(BillCode);
        }
        return httpResult;
    }

//    @Override
//    public HttpResult<GET_InStock> getJZTBuyBill(String billCode) {
//        JztRKJson jztRKJson = new JztRKJson(billCode,"1");
//        UploadBase<JztRKJson> jztRKJsonUploadBase= new UploadBase("rksc","select",jztRKJson);
//        log.info("获取九州通入库单查询条件"+JSON.toJSONString(jztRKJsonUploadBase));
//        HttpResult<GET_InStock> httpResult = JztApi.HttpRequest(jztRKJsonUploadBase);
//        log.info("获取九州通入库单返回的数据"+JSON.toJSONString(httpResult));
//        return httpResult;
//    }
}
