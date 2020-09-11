package com.xst.qf.dao;

import com.xst.qf.beans.jztBean.InStockPlan_Upload;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 　* @description:销售退货dao
 　* @author zxy
 　* @date 2020-07-23 15:27
 　*/
@Mapper
public interface SaleBackBillDao {
    //TODO 获取销售退货（返回类型为上传入库类型）
    List<InStockPlan_Upload> getSaleBackBill_Upload(String billCode);
}
