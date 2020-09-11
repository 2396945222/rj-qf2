package com.xst.qf.dao;

import com.xst.qf.beans.qfBean.ZxyUploadbill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ZxyUploadbillDao {

    //TODO  插入数据
    int insertSelective(ZxyUploadbill record);
    //TODO  根据单据类型查询数据
    List<ZxyUploadbill> getUploadBillByBilltype(int billType);
    //TODO  逻辑删除数据
    int deleted(ZxyUploadbill uploadbill);

}