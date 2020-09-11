package com.xst.qf.service;

import com.xst.qf.beans.HttpResult;

/**
 　* @description:销售单service
 　* @author zxy
 　* @date 2020-07-23 14:59
 　*/
public interface SaleBillService {

 //TODO 上传销售
  HttpResult uploadSaleBill(String  billCode);
}
