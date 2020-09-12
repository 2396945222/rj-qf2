package com.rj.qf.controller;

import com.rj.qf.bean.common.ResultData;
import com.rj.qf.bean.dto.buy.BuyBillIndex_d;
import com.rj.qf.service.BuyBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "采购业务相关接口")
@RequestMapping("/buy")
public class BuyBillController {
    @Autowired
    private BuyBillService buyBillService;
    @PostMapping("/addBuyBill")
    @ApiOperation(value = "新增采购订单接口",response = ResultData.class)
    public Object addBuyBill(@RequestBody @ApiParam(name="采购订单json",value="json格式",required=true) BuyBillIndex_d buyBillIndex_d){
        return buyBillService.addBuyBill(buyBillIndex_d);
    }
}

