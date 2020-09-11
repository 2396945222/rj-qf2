package com.xst.qf.beans.qfBean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 上传到九州通的单据编号
 * zxy_UpLoadBill
 * @author 
 */
@Data
public class ZxyUploadbill implements Serializable {
    private Integer id;
    private String billcode;
    /**
     * 行号
     */
    private Integer ord;
    /**
     * 单据类型
        11：销售单
        34：采购单
        6 ：采购退货单
        45：销售退货单
     */
    private Integer billtype;

    private String create_Date;

    private Integer deleted;//是否删除 0 未删除  1 删除

    private String deleted_Date;//删除时间

    private static final long serialVersionUID = 1L;
}