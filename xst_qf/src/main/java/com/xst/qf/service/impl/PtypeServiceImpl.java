package com.xst.qf.service.impl;

import com.alibaba.fastjson.JSON;
import com.xst.qf.beans.HttpResult;
import com.xst.qf.beans.UploadBase;
import com.xst.qf.beans.jztBean.Ptype_Upload;
import com.xst.qf.dao.PtypeDao;
import com.xst.qf.https.JztApi;
import com.xst.qf.service.PtypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PtypeServiceImpl implements PtypeService {
    @Autowired
    private PtypeDao ptypeDao;
    @Override
    public HttpResult uploadPtype(String userCode) {
        List<Ptype_Upload> ptype_uploads = ptypeDao.getPtypeByUserCode(userCode);
        log.info("上传商品json"+ JSON.toJSONString(new UploadBase("sp","saveData",ptype_uploads)));
        HttpResult result = JztApi.HttpRequest(new UploadBase("sp","saveData",ptype_uploads));
        log.info("上传商品返回结果"+ JSON.toJSONString(result));
        return result;
    }
}
