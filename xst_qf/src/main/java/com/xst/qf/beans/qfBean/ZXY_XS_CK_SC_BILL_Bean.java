package com.xst.qf.beans.qfBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 　* @description:出库上传调用存储过程bean
 　* @author zxy
 　* @date 2020-08-03 11:25
 　*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ZXY_XS_CK_SC_BILL_Bean implements Serializable {
    private String Checker;//复核人
    private  String cc_qty;//出库数量
    private String puserCode;//商品编号
    private String RIQI_CHAR;//复核日期
    private int YEW_TYPE;//业务类型  2 销售出库 3 采购退回
    private String billcode;//单据编号
    private String pici;//批次号
    private int hanghao;//行号(原始行号)
}
