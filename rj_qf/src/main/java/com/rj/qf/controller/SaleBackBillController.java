package com.rj.qf.controller;

import com.rj.qf.bean.common.ResultData;
import com.rj.qf.bean.dto.buy.BuyBillIndex_d;
import com.rj.qf.bean.dto.sale.SaleBackBillIndex_d;
import com.rj.qf.service.SaleBackBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "销售退回业务单据接口")
@RequestMapping("/saleBack")
public class SaleBackBillController {
    @Autowired
    private SaleBackBillService saleBackBillService;
    @PostMapping("/addSaleBackBill")
    @ApiOperation(value = "新增销售单退回接口",response = ResultData.class)
    public Object addSaleBackBill(@RequestBody @ApiParam(name="销售退回json",value="json格式",required=true) SaleBackBillIndex_d saleBackBillIndex_d){
        return saleBackBillService.addSaleBackBill(saleBackBillIndex_d);
    }
}
