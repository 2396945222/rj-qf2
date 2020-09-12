package com.rj.qf.controller;

import com.rj.qf.bean.common.ResultData;
import com.rj.qf.bean.dto.buy.BuyBackBillIndex_d;
import com.rj.qf.bean.dto.buy.BuyBillIndex_d;
import com.rj.qf.service.BuyBackBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "采购退回业务单据接口")
@RequestMapping("/buyBack")
public class BuyBackBillController {

    @Autowired
    private BuyBackBillService buyBackBillService;
    @PostMapping("/addBuyBackBill")
    @ApiOperation(value = "新增采购退回单接口",response = ResultData.class)
    public Object addBuyBackBill(@RequestBody @ApiParam(name="采购退回订单json",value="json格式",required=true) BuyBackBillIndex_d backBillIndex_d){
        return buyBackBillService.addSaleBill(backBillIndex_d);
    }
}
