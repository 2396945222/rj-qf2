package com.rj.qf.dao;

import com.rj.qf.bean.qf.buy.BuyBillBean;
import com.rj.qf.bean.qf.buy.BuyIndexBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BuyBillDao {
    //添加采购订单主表orderIndex表
    int addBuyOrderIndex(BuyIndexBean buyIndexBean);
    //添加采购订单详细orderBill表
    void addBuyOrderBill(BuyBillBean buyBillBean);
}
