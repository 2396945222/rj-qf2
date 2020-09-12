package com.rj.qf.bean.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 　* @description:返回结果
 　* @author zxy
 　* @date 2020-08-29 18:27
 　*/
@ApiModel(value="返回数据结果集",description="返回数据结果集")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ResultData<T> implements Serializable {
    @ApiModelProperty(value="状态码(0或1),0失败,1成功",name="code")
    private Integer code;
    @ApiModelProperty(value="提示信息(code为0时,该字段为失败原因)",name="message")
    private String message;
    @ApiModelProperty(value="返回数据集合",name="data")
    private T data;
    public ResultData(int code, String message){
        this(code,message,null);
    }

}
