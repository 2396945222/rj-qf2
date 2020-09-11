package com.xst.qf.service.impl;

import com.alibaba.fastjson.JSON;
import com.xst.qf.beans.jztBean.Btype_Upload;
import com.xst.qf.beans.HttpResult;
import com.xst.qf.beans.UploadBase;
import com.xst.qf.beans.qfBean.Btype_qf;
import com.xst.qf.dao.BtypeDao;
import com.xst.qf.https.JztApi;
import com.xst.qf.service.BtypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BtypeServiceImpl implements BtypeService {
    @Autowired
    private BtypeDao btypeDao;
    @Override
    public HttpResult uploadBtype(String userCode) {
        List<Btype_qf> btype_qfs = btypeDao.getBtypeByUserCode(userCode);
        if (btype_qfs.size() == 0) {
            log.info("往来单位信息不存在");
            return null;
        }
        log.info("开始上传往来单位信息");
        List<Btype_Upload> uploads = new ArrayList<>();
        for (int i = 0; i < btype_qfs.size(); i++) {
            Btype_qf btype_qf = btype_qfs.get(i);
            Btype_Upload btype_upload = new Btype_Upload();
            btype_upload.setLIUS_NO(btype_qf.getRec());//流水号
            btype_upload.setSsa_No(btype_qf.getUserCode());//编号
            btype_upload.setSsa_Name(btype_qf.getFullName());//名称
            btype_upload.setSsa_Shortname(btype_qf.getFullName());//客户简称
            btype_upload.setMnemonic_Code(btype_qf.getPYZJM());//助记码
            btype_upload.setSsa_Addr_Phone(btype_qf.getSsa_Addr_Phone());//客户注册地址电话
            btype_upload.setSsa_Sign(btype_qf.getSsa_Sign());//客户标示（上游、下游）
            btype_upload.setAddress(btype_qf.getAddress());
            btype_upload.setAddress_Shortname("");
            btype_upload.setContact_Name(btype_qf.getContact_Name());//联系人名
            btype_upload.setContact_Phone(btype_qf.getContact_Phone());//联系电话
            btype_upload.setBankaccount(btype_qf.getBankaccount());//卡号
            btype_upload.setBusiness_Licence_No(btype_qf.getBusiness_Licence_No());
            btype_upload.setBusiness_Licence_No_Valid_Until(btype_qf.getBusiness_Licence_No_Valid_Until());
            btype_upload.setProduction_License_No(btype_qf.getProduction_License_No());
            btype_upload.setProduction_License_No_Valid_Until(btype_qf.getProduction_License_No_Valid_Until());
            btype_upload.setGMP_License(btype_qf.getGMP_License());
            btype_upload.setGMP_License_Valid_Until(btype_qf.getGMP_License_Valid_Until());
            uploads.add(btype_upload);
        }
        UploadBase uploadBase =new UploadBase("dw","saveData", uploads);
        log.info("上传往来单位信息结束,上传信息"+ JSON.toJSONString(uploadBase));
        HttpResult httpResult = JztApi.HttpRequest(uploadBase);
        log.info("上传往来单位信息结束,返回信息"+httpResult);
        return httpResult;
    }
}
