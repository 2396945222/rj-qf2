package com.xst.qf.dao;

import com.xst.qf.beans.jztBean.Ptype_Upload;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PtypeDao {
    //TODO 根据编号获取商品信息单位信息
    List<Ptype_Upload> getPtypeByUserCode(String userCode);
}
