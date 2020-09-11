package com.xst.qf.service;

import com.xst.qf.beans.HttpResult;

/**
 　* @description:采购退回单service
 　* @author zxy
 　* @date 2020-07-23 14:58
 　*/
public interface BuyBackBillService {
 //TODO 上传采购退回
 HttpResult uploadBuyBackBill(String billcode);
}
