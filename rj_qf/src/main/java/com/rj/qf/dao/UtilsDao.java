package com.rj.qf.dao;
import com.rj.qf.bean.qf.qf_btype;
import com.rj.qf.bean.qf.qf_employee;
import com.rj.qf.bean.qf.qf_ptype;
import com.rj.qf.bean.qf.qf_stock;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface UtilsDao {
    //根据编号获取仓库信息
    qf_stock getStockByUserCode(String userCode);
    //根据编号获取往来单位信息
    qf_btype getBtypeByUserCode(String userCode);
    //根据编号获取商品信息
    qf_ptype getPtypeByUserCode(String userCode);
    //根据编号获取职员信息
    qf_employee getEmployeeByUserCode(String userCode);
    //根据批次号,效期获取库存uid和供应商rec
    HashMap<String,Object> getGoodsStcokUidAndProviderId(HashMap<String,Object> parmas);
    //获取newId
    String getNewId();
    //根据采购订单编号和详细订单行号,获取入库信息(库存uid,供应商id,及进货价格)
    HashMap<String,Object> getBuyInfoByBillCodeAndOrd(HashMap<String,Object> parmas);
    //根据采购订单编号获取入库信息,
    HashMap<String,Object> getBillInfoByBillCode(String billCode);
    //根据单据编号,生产日期，效期，商品rec 查询出库信息
    HashMap<String,Object> getSaleInfoStockUidBypRecAndSCDateAndYXDate(HashMap<String,Object> parmas);
    //根据单据id获取单据类型
    Integer getBillTypeByBillId(Integer billId);
}
