package com.xst.qf.beans.qfBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 　* @description:千方商品bean
 * 　* @author zxy
 * 　* @date 2020-07-22 11:49
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Ptype_qf implements Serializable {
    private Integer rec;
    private String userCode;
    private String fullName;

}
