package com.rj.qf.bean.qf.sale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 　* @description:销售退回主单据
 * 　* @author zxy
 * 　* @date 2020-09-05 17:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SaleBackIndex implements Serializable {
    private int billId = 0;//单据id传0
    private int bRec;
    private int eRec;
    private int CheckEId = 0;
    private int BillE;
    private String BillDate;
    private String Billcode;//
    private int billtype = 718;//销售退货
    private double totalmoney;//总金额
    private double totalqty;//总数量
    private int checked = 0;//
    private String comment;//
    private String SourceBillCode;//
    private int SourceId = 0;//
    private int ORec = 0;//

}
