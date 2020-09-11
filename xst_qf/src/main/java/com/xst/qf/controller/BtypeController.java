package com.xst.qf.controller;

import com.xst.qf.beans.HttpResult;
import com.xst.qf.service.BtypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("btype")
@Api(tags = "往来单位controller")
@Slf4j
public class BtypeController {
    @Autowired
    private BtypeService btypeService;
    @GetMapping("/uploadBtype")
    @ApiOperation(value = "上传往来单位信息",response = HttpResult.class)
    public Object uploadBtype(String userCode){
        log.info("上传往来单位信息controller访问成功");
        return  btypeService.uploadBtype(userCode);
    }

}
