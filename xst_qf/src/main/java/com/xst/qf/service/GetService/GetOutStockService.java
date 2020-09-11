package com.xst.qf.service.GetService;

import com.xst.qf.beans.HttpResult;
import com.xst.qf.beans.UploadBase;
import com.xst.qf.beans.jztBean.GET_OutStock;

import java.util.List;

/**
 * 　* @description:获取出库service
 * 　* @author zxy
 * 　* @date 2020-07-23 14:33
 */
public interface GetOutStockService {
    //TODO 销售出库查询
    HttpResult<List<GET_OutStock>> getSale(UploadBase uploadBase);
    //TODO 采购退回查询
    HttpResult<List<GET_OutStock>> getBuyBack(UploadBase uploadBase);
}
