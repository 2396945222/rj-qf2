package com.rj.qf.bean.qf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
 /**
 　* @description:职员
 　* @author zxy
 　* @date 2020-08-31 13:45
 　*/
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
 @Accessors(chain = true)
public class qf_employee implements Serializable {
  private int rec;
  private String fullName;
  private String userCode;
}
