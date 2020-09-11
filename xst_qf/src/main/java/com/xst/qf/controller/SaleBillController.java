package com.xst.qf.controller;

import com.xst.qf.beans.HttpResult;
import com.xst.qf.beans.UploadBase;
import com.xst.qf.beans.jztBean.GET_OutStock;
import com.xst.qf.beans.jztBean.JztCKJson;
import com.xst.qf.beans.jztBean.JztRKJson;
import com.xst.qf.service.GetService.GetOutStockService;
import com.xst.qf.service.SaleBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("saleBill")
@Api(tags = "销售单controller")
@Slf4j
public class SaleBillController {

    @Autowired
    private SaleBillService saleBillService;
    @Autowired
    private GetOutStockService getOutStockService;
    @GetMapping("/uploadSaleBill")
    @ApiOperation(value = "上传销售单")
    public Object uploadSaleBill(String billCode){
        log.info("上传销售单controller访问成功"+billCode);
        return  saleBillService.uploadSaleBill(billCode);
    }

    @GetMapping("/getJztSaleBill")
    @ApiOperation(value = "获取九州通销售单回传数据")
    public Object getJztSaleBill(String billCode){
        JztCKJson jztCKJson = new JztCKJson(billCode, "1");
        UploadBase<JztRKJson> jztCKJsonUploadBase = new UploadBase("cksc", "select", jztCKJson);
        HttpResult<List<GET_OutStock>> httpResult = getOutStockService.getSale(jztCKJsonUploadBase);
        log.info(billCode + "单号,出库回传数据" + httpResult.getMsgInfo());
        return  httpResult;
    }
}
