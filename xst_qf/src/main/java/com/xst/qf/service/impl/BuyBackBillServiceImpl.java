package com.xst.qf.service.impl;

import com.alibaba.fastjson.JSON;
import com.xst.qf.beans.HttpResult;
import com.xst.qf.beans.UploadBase;
import com.xst.qf.beans.jztBean.OutStockPlan_Upload;
import com.xst.qf.beans.qfBean.ZxyUploadbill;
import com.xst.qf.dao.BuyBackBillDao;
import com.xst.qf.dao.ZxyUploadbillDao;
import com.xst.qf.https.JztApi;
import com.xst.qf.service.BuyBackBillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
/**
 　* @description:采购退回单service实现类
 　* @author zxy
 　* @date 2020-07-23 14:58
 　*/
@Service
@Slf4j
public class BuyBackBillServiceImpl implements BuyBackBillService {
    @Autowired
    private BuyBackBillDao buyBackBillDao;
    @Autowired
    private ZxyUploadbillDao zxyUploadbillDao;
    @Override
    public HttpResult uploadBuyBackBill(String billCode) {
        log.info("采购退回单BuyBackBillServiceImpl访问成功");
        List<OutStockPlan_Upload> outStockPlan_uploads = buyBackBillDao.getBuyBackBill_Upload(billCode);
        log.info("采购退回上传json串"+ JSON.toJSONString(outStockPlan_uploads));
        HttpResult httpResult = JztApi.HttpRequest(
                new UploadBase("gt", "saveData", outStockPlan_uploads));
        log.info("上传采购退回单返回数据" + JSON.toJSONString(httpResult));
        if (httpResult.isFlag()) {
            //如果返回的是true,证明上传成功,需要将上床的数据插入到zxyuploabill表中
            for (int i = 0; i < outStockPlan_uploads.size(); i++) {
                ZxyUploadbill zxyUploadbill = new ZxyUploadbill();
                zxyUploadbill.setBillcode(outStockPlan_uploads.get(i).getBiz_Bill_No());//单号
                zxyUploadbill.setBilltype(6);//采购退货
                zxyUploadbill.setCreate_Date(LocalDate.now().toString());
                zxyUploadbill.setOrd(Integer.parseInt(outStockPlan_uploads.get(i).getBill_Dtl_Id()));
                int count = zxyUploadbillDao.insertSelective(zxyUploadbill);
                if(count > 0){
                    log.info("采购退回单保存到zxyUploadbill表中成功"+billCode);
                }else {
                    log.info("采购退回单保存到zxyUploadbill表中失败"+billCode);
                }
            }
        } else {
            httpResult = this.uploadBuyBackBill(billCode);
        }
        return httpResult;
    }
}
