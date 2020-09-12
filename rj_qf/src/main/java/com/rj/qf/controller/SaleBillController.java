package com.rj.qf.controller;

import com.rj.qf.bean.common.ResultData;
import com.rj.qf.bean.dto.buy.BuyBillIndex_d;
import com.rj.qf.bean.dto.sale.SaleBillIndex_d;
import com.rj.qf.service.SaleBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "销售业务单据接口")
@RequestMapping("/sale")
public class SaleBillController {

    @Autowired
    private SaleBillService saleBillService;
    @PostMapping("/addSaleBill")
    @ApiOperation(value = "新增销售单接口",response = ResultData.class)
    public Object addSaleBill(@RequestBody @ApiParam(name="销售单json",value="json格式",required=true) SaleBillIndex_d saleBillIndex_d){
        return saleBillService.addSaleBill(saleBillIndex_d);
    }
}
