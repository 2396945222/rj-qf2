package com.xst.qf.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class GetBase<T> implements Serializable {
    private String callCategory;//操作类别 dw
    private String funcType;//方法类别(方法类别)
    private String id;//用户名
    private String pwd;//密码
    private T jsondata;//上传数据
}
