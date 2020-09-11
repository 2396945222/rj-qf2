package com.xst.qf.controller;

import com.xst.qf.beans.HttpResult;
import com.xst.qf.beans.UploadBase;
import com.xst.qf.beans.jztBean.GET_OutStock;
import com.xst.qf.beans.jztBean.JztRKJson;
import com.xst.qf.service.BuyBackBillService;
import com.xst.qf.service.BuyBillService;
import com.xst.qf.service.GetService.GetOutStockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("buyBackBill")
@Api(tags = "采购退货订单controller")
@Slf4j
public class BuyBackBillController {
    @Autowired
    private BuyBillService buyBillService;
    @Autowired
    private BuyBackBillService buyBackBillService;
    @Autowired
    private GetOutStockService getOutStockService;
    @GetMapping("/uploadBuyBackBill")
    @ApiOperation(value = "上传采购退货单")
    public Object uploadBuyBill(String billCode){
        log.info("上传采购退货单controller访问成功");
        return  buyBackBillService.uploadBuyBackBill(billCode);
    }

    @GetMapping("/getJztBuyBackBill")
    @ApiOperation(value = "获取九州通采购退回单")
    public Object getJztBuyBackBill(String billCode) {
        log.info("获取九州通采购退回单controller访问成功");
        JztRKJson jztRKJson = new JztRKJson(billCode,"4");
        UploadBase<JztRKJson> jztRKJsonUploadBase= new UploadBase("gtsc","select",jztRKJson);
        HttpResult<List<GET_OutStock>> httpResult = getOutStockService.getBuyBack(jztRKJsonUploadBase);
        return httpResult;
    }
}
