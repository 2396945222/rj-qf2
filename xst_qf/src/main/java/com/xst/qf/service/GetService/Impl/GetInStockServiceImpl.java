package com.xst.qf.service.GetService.Impl;

import com.alibaba.fastjson.JSON;
import com.xst.qf.beans.HttpResult;
import com.xst.qf.beans.UploadBase;
import com.xst.qf.beans.jztBean.GET_InStock;
import com.xst.qf.https.JztApi;
import com.xst.qf.service.GetService.GetInStockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 　* @description:获取入库service实现类
 　* @author zxy
 　* @date 2020-07-23 14:33
 　*/
@Slf4j
@Service
public class GetInStockServiceImpl implements GetInStockService {
    /**
     * 采购入库回传
     * @param uploadBase
     * @return
     */
    @Override
    public HttpResult getBuy(UploadBase uploadBase) {
        log.info("获取九州通入库单查询条件(采购入库回传)"+ JSON.toJSONString(uploadBase));
        HttpResult<GET_InStock> httpResult = JztApi.HttpRequest(uploadBase);
        log.info("获取九州通入库单返回的数据(采购入库回传)"+JSON.toJSONString(httpResult));
        return httpResult;
    }
    /**
     * 销售退回回传
     * @param uploadBase
     * @return
     */
    @Override
    public HttpResult getSaleBack(UploadBase uploadBase)
    {
        log.info("获取九州通出库单查询条件(销售退回回传)"+ JSON.toJSONString(uploadBase));
        HttpResult<GET_InStock> httpResult = JztApi.HttpRequest(uploadBase);
        log.info("获取九州通出库单返回的数据(销售退回回传)"+JSON.toJSONString(httpResult));
        return httpResult;
    }
    /**
     * 采购入库记录
     * @param uploadBase
     * @return
     */
    @Override
    public HttpResult<List<GET_InStock>> getrkysjl(UploadBase uploadBase) {
        log.info("获取九州通出库单查询条件(销售退回回传)"+ JSON.toJSONString(uploadBase));
        HttpResult<GET_InStock> httpResult = JztApi.HttpRequest(uploadBase);
        log.info("获取九州通出库单返回的数据(销售退回回传)"+JSON.toJSONString(httpResult));
        return null;
    }

}
