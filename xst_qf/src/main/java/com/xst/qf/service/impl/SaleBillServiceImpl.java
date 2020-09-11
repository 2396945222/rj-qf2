package com.xst.qf.service.impl;
/**
 　* @description:销售单service实现类
 　* @author zxy
 　* @date 2020-07-23 14:59
 　*/
import com.alibaba.fastjson.JSON;
import com.xst.qf.beans.HttpResult;
import com.xst.qf.beans.UploadBase;
import com.xst.qf.beans.jztBean.OutStockPlan_Upload;
import com.xst.qf.beans.qfBean.ZxyUploadbill;
import com.xst.qf.dao.SaleBillDao;
import com.xst.qf.dao.ZxyUploadbillDao;
import com.xst.qf.https.JztApi;
import com.xst.qf.service.SaleBillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class SaleBillServiceImpl implements SaleBillService {
    @Autowired
    private SaleBillDao saleBillDao;
    @Autowired
    private ZxyUploadbillDao zxyUploadbillDao;
    @Override
    public HttpResult uploadSaleBill(String billCode) {
        log.info("上传销售单SaleBillServiceImpl访问成功");
        //获取销售订单
        List<OutStockPlan_Upload> outStockPlan_uploads = saleBillDao.getSaleBill_Upload(billCode);
        log.info("销售单上传json串"+ JSON.toJSONString(outStockPlan_uploads));

        HttpResult httpResult = JztApi.HttpRequest(
                new UploadBase("ck", "saveData", outStockPlan_uploads));
        log.info("上传销售单返回数据" + JSON.toJSONString(httpResult));

        if (httpResult.isFlag()) {
            //如果返回的是true,证明上传成功,需要将上床的数据插入到zxyuploabill表中
            for (int i = 0; i < outStockPlan_uploads.size(); i++) {
                ZxyUploadbill zxyUploadbill = new ZxyUploadbill();
                zxyUploadbill.setBillcode(outStockPlan_uploads.get(i).getBiz_Bill_No());//单号
                zxyUploadbill.setBilltype(11);//销售单11
                zxyUploadbill.setCreate_Date(LocalDate.now().toString());
                zxyUploadbill.setOrd(Integer.parseInt(outStockPlan_uploads.get(i).getBill_Dtl_Id()));
                int count = zxyUploadbillDao.insertSelective(zxyUploadbill);
                if(count > 0){
                    log.info("销售单保存到zxyUploadbill表中成功" +count);
                }else {
                    log.info("销售单保存到zxyUploadbill表中失败" +count);
                }
            }
        } else {
            httpResult = this.uploadSaleBill(billCode);
        }
        return httpResult;
    }
}
