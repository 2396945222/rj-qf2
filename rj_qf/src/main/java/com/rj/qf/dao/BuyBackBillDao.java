package com.rj.qf.dao;

import com.rj.qf.bean.qf.buy.BuyBackBill;
import com.rj.qf.bean.qf.buy.BuyBackIndex;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BuyBackBillDao {

    //添加采购退回主表
    int addBuyBackBillIndex(BuyBackIndex backIndex);
    //添加采购退回详细
    void addBuyBackBill(BuyBackBill backBill);
}
