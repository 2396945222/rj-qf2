package com.rj.qf.dao;

import com.rj.qf.bean.qf.sale.SaleBackBill;
import com.rj.qf.bean.qf.sale.SaleBackIndex;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SaleBackBillDao {
    //插入主单据
    int addSaleBackBillIndex(SaleBackIndex saleBackIndex);
    //插入详细单据
    void addSaleBackBill(SaleBackBill saleBackBill);
}
