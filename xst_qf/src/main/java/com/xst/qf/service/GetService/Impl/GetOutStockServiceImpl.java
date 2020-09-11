package com.xst.qf.service.GetService.Impl;

import com.alibaba.fastjson.JSON;
import com.xst.qf.beans.HttpResult;
import com.xst.qf.beans.UploadBase;
import com.xst.qf.beans.jztBean.GET_OutStock;
import com.xst.qf.https.JztApi;
import com.xst.qf.service.GetService.GetOutStockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 　* @description:获取出库service实现了
 　* @author zxy
 　* @date 2020-07-23 14:33
 　*/
@Service
@Slf4j
public class GetOutStockServiceImpl implements GetOutStockService {

    /**
     * 获取销售单回传
     * @param uploadBase
     * @return
     */
    @Override
    public HttpResult getSale(UploadBase uploadBase) {
        log.info("获取九州通销售单回传(上传数据)"+ JSON.toJSONString(uploadBase));
        HttpResult<GET_OutStock> httpResult = JztApi.HttpRequest(uploadBase);
        log.info("获取九州通销售单回传(上传数据)"+JSON.toJSONString(httpResult));
        return httpResult;
    }
    /**
     *  获取采购退回单回传
     * @param uploadBase
     * @return
     */
    @Override
    public HttpResult getBuyBack(UploadBase uploadBase) {
        log.info("获取九州通采购退回单回传(上传数据)"+ JSON.toJSONString(uploadBase));
        HttpResult<GET_OutStock> httpResult = JztApi.HttpRequest(uploadBase);
        log.info("获取九州通采购退回单回传(回传数据)"+JSON.toJSONString(httpResult));
        return httpResult;
    }
}
