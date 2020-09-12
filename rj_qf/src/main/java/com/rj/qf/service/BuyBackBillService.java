package com.rj.qf.service;

import com.rj.qf.bean.common.ResultData;
import com.rj.qf.bean.dto.buy.BuyBackBillIndex_d;

public interface BuyBackBillService {
    //添加采购退货单据
    ResultData addSaleBill(BuyBackBillIndex_d buyBackBillIndex_d);
}
