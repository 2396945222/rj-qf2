package com.xst.qf.dao;

import com.xst.qf.beans.jztBean.OutStockPlan_Upload;
import com.xst.qf.beans.qfBean.ZXY_XS_CK_SC_BILL_Bean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 　* @description:销售出库dao
 　* @author zxy
 　* @date 2020-07-23 15:27
 　*/
@Mapper
public interface SaleBillDao {
    //TODO 获取销售出库（返回类型为上传出库类型）
    List<OutStockPlan_Upload> getSaleBill_Upload(String billCode);
    //TODO 九州通出库单回传调用存储过程(销售出库,采购退货通用)
    int ZXY_XS_CK_SC_BILL(ZXY_XS_CK_SC_BILL_Bean zxy_xs_ck_sc_bill_bean);
}
