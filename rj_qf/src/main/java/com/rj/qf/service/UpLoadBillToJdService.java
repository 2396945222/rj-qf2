package com.rj.qf.service;

import com.rj.qf.bean.common.ResultData;

/**
 　* @description:上传单据到金蝶service
 　* @author zxy
 　* @date 2020-09-07 14:03
 　*/
public interface UpLoadBillToJdService {


  ResultData upLoadBill(int billId);

}
