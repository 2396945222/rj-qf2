package com.xst.qf.controller;

import com.xst.qf.beans.HttpResult;
import com.xst.qf.beans.UploadBase;
import com.xst.qf.beans.jztBean.GET_InStock;
import com.xst.qf.beans.jztBean.JztRKJson;
import com.xst.qf.beans.qfBean.ZxyUploadbill;
import com.xst.qf.dao.ZxyUploadbillDao;
import com.xst.qf.service.BuyBillService;
import com.xst.qf.service.GetService.GetInStockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("buyBill")
@Api(tags = "采购订单controller")
@Slf4j
public class BuyBillController {
    @Autowired
    private GetInStockService getInStockService;//获取九州通入库信息service
    @Autowired
    private BuyBillService buyBillService;//千方采购service
    @Autowired
    private ZxyUploadbillDao zxyUploadbillDao;
    @GetMapping("/uploadBuyBill")
    @ApiOperation(value = "上传采购订单")
    public Object uploadBuyBill(String billCode) {
        log.info("上传采购订单controller访问成功");
        return buyBillService.uoloadBuyBill(billCode);
    }


    @GetMapping("/getJztBuyBill")
    @ApiOperation(value = "获取九州通采购入库单")
    public Object getJztBuyBill(String billCode) {
        log.info("获取九州通采购入库单controller访问成功");
        JztRKJson jztRKJson = new JztRKJson(billCode,"1");
        UploadBase<JztRKJson> jztRKJsonUploadBase= new UploadBase("rksc","select",jztRKJson);
        HttpResult<List<GET_InStock>> httpResult = getInStockService.getBuy(jztRKJsonUploadBase);
        List<GET_InStock> get_inStocks = httpResult.getMsgInfo();
        return get_inStocks;
    }

    @GetMapping("/addZxyUpload")
    @ApiOperation(value = "添加单据到中间库")
    public Object addZxyUpload(String billCode,Integer ord,Integer billType,String Create_date) {
        log.info("添加单据到中间库");
        ZxyUploadbill zxyUploadbill = new ZxyUploadbill();
        zxyUploadbill.setOrd(ord);
        zxyUploadbill.setBillcode(billCode);
        zxyUploadbill.setBilltype(billType);
        zxyUploadbill.setCreate_Date(Create_date);
        return zxyUploadbillDao.insertSelective(zxyUploadbill);
    }
}
