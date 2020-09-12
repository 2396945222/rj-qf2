package com.rj.qf.service;

import com.rj.qf.bean.common.ResultData;
import com.rj.qf.bean.dto.buy.BuyBillIndex_d;

public interface BuyBillService {
    //添加采购订单
    ResultData addBuyBill(BuyBillIndex_d billIndexD);

    //回传采购入库单
}
