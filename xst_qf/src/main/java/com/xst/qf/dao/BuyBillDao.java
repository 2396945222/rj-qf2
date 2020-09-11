package com.xst.qf.dao;

import com.xst.qf.beans.jztBean.InStockPlan_Upload;
import com.xst.qf.beans.qfBean.ZXY_GJ_RK_SC_BILL_Bean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 　* @description:采购订单dao
 　* @author zxy
 　* @date 2020-07-23 15:27
 　*/
@Mapper
public interface BuyBillDao {
    //TODO 获取采购订单（返回类型为上传入库类型）
    List<InStockPlan_Upload> getBuyBill_Upload(String billCode);
    //TODO 九州通入库单回传调用存储过程(采购入库,销售退回通用)
    int ZXY_GJ_RK_SC_BILL(ZXY_GJ_RK_SC_BILL_Bean zxy_gj_rk_sc_bill_bean);

}
