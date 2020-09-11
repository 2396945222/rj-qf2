package com.xst.qf.controller;

import com.xst.qf.beans.HttpResult;
import com.xst.qf.beans.UploadBase;
import com.xst.qf.beans.jztBean.GET_InStock;
import com.xst.qf.beans.jztBean.JztRKJson;
import com.xst.qf.service.GetService.GetInStockService;
import com.xst.qf.service.SaleBackBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("saleBackBill")
@Api(tags = "销售退货单controller")
@Slf4j
public class SaleBackBillController {
    @Autowired
    private SaleBackBillService saleBackBillService;
    @Autowired
    private GetInStockService getInStockService;
    @GetMapping("/uploadSaleBackBill")
    @ApiOperation(value = "上传销售退货单")
    public Object uploadSaleBackBill(String billCode){
        log.info("上传销售退货单controller访问成功");
        return  saleBackBillService.uoloadSaleBackBill(billCode);
    }

    @GetMapping("/getJztSaleBackBill")
    @ApiOperation(value = "获取九州通销售退货单")
    public Object getJztSaleBackBill(String billCode){
        JztRKJson jztCKJson = new JztRKJson(billCode, "4");
        UploadBase<JztRKJson> jztCKJsonUploadBase = new UploadBase("xtsc", "select", jztCKJson);
        HttpResult<List<GET_InStock>> httpResult = getInStockService.getSaleBack(jztCKJsonUploadBase);
        return  httpResult;
    }

    @GetMapping("/test")
    @ApiOperation(value = "上传销售退货单")
    public Object test(String str){
        log.info("上传销售退货单controller访问成功"+str);

        return  "";
    }
}