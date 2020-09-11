package com.xst.qf.dao;

import com.xst.qf.beans.jztBean.OutStockPlan_Upload;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 　* @description:采购退货dao
 　* @author zxy
 　* @date 2020-07-23 15:27
 　*/
@Mapper
public interface BuyBackBillDao {
    //TODO 获取采购退货（返回类型为上传出库类型）
    List<OutStockPlan_Upload> getBuyBackBill_Upload(String billCode);
}
