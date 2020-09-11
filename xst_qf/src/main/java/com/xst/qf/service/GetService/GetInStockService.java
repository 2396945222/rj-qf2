package com.xst.qf.service.GetService;

import com.xst.qf.beans.HttpResult;
import com.xst.qf.beans.UploadBase;
import com.xst.qf.beans.jztBean.GET_InStock;

import java.util.List;

/**
 * 　* @description:获取入库service
 * 　* @author zxy
 * 　* @date 2020-07-23 14:33
 *
 */
public interface GetInStockService {
    //TODO 采购入库查询
    HttpResult<List<GET_InStock>> getBuy(UploadBase uploadBase);
    //TODO 销售查询
    HttpResult<List<GET_InStock>> getSaleBack(UploadBase uploadBase);

    //TODO 采购入库验收记录接口
    HttpResult<List<GET_InStock>> getrkysjl(UploadBase uploadBase);
}
