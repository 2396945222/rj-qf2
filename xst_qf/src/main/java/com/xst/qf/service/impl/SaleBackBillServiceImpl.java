package com.xst.qf.service.impl;
/**
 　* @description:销售退回单service实现类
 　* @author zxy
 　* @date 2020-07-23 14:59
 　*/
import com.alibaba.fastjson.JSON;
import com.xst.qf.beans.HttpResult;
import com.xst.qf.beans.UploadBase;
import com.xst.qf.beans.jztBean.InStockPlan_Upload;
import com.xst.qf.beans.qfBean.ZxyUploadbill;
import com.xst.qf.dao.SaleBackBillDao;
import com.xst.qf.dao.ZxyUploadbillDao;
import com.xst.qf.https.JztApi;
import com.xst.qf.service.SaleBackBillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class SaleBackBillServiceImpl  implements SaleBackBillService {
    @Autowired
    private SaleBackBillDao saleBackBillDao;
    @Autowired
    private ZxyUploadbillDao zxyUploadbillDao;
    @Override
    public HttpResult uoloadSaleBackBill(String billCode) {

        log.info("上传销售退回单SaleBackBillServiceImpl访问成功");
        //获取采购订单
        List<InStockPlan_Upload> inStockPlan_uploads =
                saleBackBillDao.getSaleBackBill_Upload(billCode);
        log.info("销售退回单" + JSON.toJSONString(inStockPlan_uploads));
        HttpResult httpResult = JztApi.HttpRequest(
                new UploadBase("xt", "saveData", inStockPlan_uploads));
        log.info("上传销售退回单返回数据" + JSON.toJSONString(httpResult));
        if (httpResult.isFlag()) {
            //如果返回的是true,证明上传成功,需要将上床的数据插入到zxyuploabill表中
            for (int i = 0; i < inStockPlan_uploads.size(); i++) {
                ZxyUploadbill zxyUploadbill = new ZxyUploadbill();
                zxyUploadbill.setBillcode(inStockPlan_uploads.get(i).getBUSINESSBILL_NO());//单号
                zxyUploadbill.setBilltype(45);//销售退回45
                zxyUploadbill.setCreate_Date(LocalDate.now().toString());
                zxyUploadbill.setOrd(Integer.parseInt(inStockPlan_uploads.get(i).getBILL_DTL_ID_OLD()));
                int count = zxyUploadbillDao.insertSelective(zxyUploadbill);
                if(count > 0){
                    log.info("销售退回单保存到zxyUploadbill表中成功" +count);
                }else {
                    log.info("销售退回单保存到zxyUploadbill表中失败" +count);
                }
            }
        } else {
            httpResult = this.uoloadSaleBackBill(billCode);
        }
        return httpResult;
    }
}
