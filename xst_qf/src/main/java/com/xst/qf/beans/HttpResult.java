package com.xst.qf.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class HttpResult<T> implements Serializable {
    private boolean Flag;
    private String ErrInfo;
    private T MsgInfo;

}
