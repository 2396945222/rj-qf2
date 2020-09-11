package com.xst.qf.service;

import com.xst.qf.beans.HttpResult;

/**
 * 　* @description:销售退回单service
 * 　* @author zxy
 * 　* @date 2020-07-23 14:59
 */
public interface SaleBackBillService {
    //TODO 上传销售退回
    HttpResult uoloadSaleBackBill(String billCode);
}
