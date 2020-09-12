package com.rj.qf.service;

import com.rj.qf.bean.common.ResultData;
import com.rj.qf.bean.dto.sale.SaleBackBillIndex_d;

public interface SaleBackBillService {
    //添加销售退回单据
    ResultData addSaleBackBill(SaleBackBillIndex_d saleBackBillIndex_d);

}
