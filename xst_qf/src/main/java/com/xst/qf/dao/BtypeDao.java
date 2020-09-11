package com.xst.qf.dao;

import com.xst.qf.beans.qfBean.Btype_qf;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
@Mapper
public interface BtypeDao {
    //TODO 根据编号获取往来单位信息
    List<Btype_qf> getBtypeByUserCode(String userCode);
}
