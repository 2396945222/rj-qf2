package com.rj.qf.controller;

import com.rj.qf.bean.common.ResultData;
import com.rj.qf.service.UpLoadBillToJdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 　* @description: 千方单据过账存储过程
 　* @author zxy
 　* @date 2020-09-07 13:47
 　*/
@RestController
@Api(tags = "废弃接口")
@RequestMapping("/qf")
public class BillAuditingController {
    @Autowired
    private UpLoadBillToJdService upLoadBillToJdService;
    @GetMapping("/qfBillAuditing")
    @ApiOperation(value = "废弃接口",response = ResultData.class)
    public ResultData qfBillAuditing(Integer billId){
        return upLoadBillToJdService.upLoadBill(billId);
    }
}
