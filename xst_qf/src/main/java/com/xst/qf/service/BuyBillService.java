package com.xst.qf.service;

import com.xst.qf.beans.HttpResult;

/**
 * 　* @description:采购单service
 * 　* @author zxy
 * 　* @date 2020-07-23 14:58
 *
 */
public interface BuyBillService {
    //TODO 上传采购单
    HttpResult uoloadBuyBill(String BillCode);

}
