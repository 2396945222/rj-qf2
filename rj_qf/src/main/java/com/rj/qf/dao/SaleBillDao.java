package com.rj.qf.dao;

import com.rj.qf.bean.qf.sale.SaleBill;
import com.rj.qf.bean.qf.sale.SaleIndex;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SaleBillDao {

    //添加销售单主表
    int addSaleBillIndex(SaleIndex saleIndex);
    //添加销售单详细数据
    void  addSaleBill(SaleBill saleBill);
}
