package com.xst.qf.controller;

import com.xst.qf.beans.HttpResult;
import com.xst.qf.service.PtypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ptype")
@Api(tags = "商品信息controller")
@Slf4j
public class PtypeController {

    @Autowired
    private PtypeService ptypeService;
    @GetMapping("/uploadPtype")
    @ApiOperation(value = "上传商品信息",response = HttpResult.class)
    public Object uploadPtype(String userCode){
        log.info("上传商品信息controller访问成功");
        return  ptypeService.uploadPtype(userCode);
    }
}
