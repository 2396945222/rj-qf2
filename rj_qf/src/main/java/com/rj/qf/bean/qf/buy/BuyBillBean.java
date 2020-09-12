package com.rj.qf.bean.qf.buy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 　* @description:采购订单详细
 　* @author zxy
 　* @date 2020-09-02 9:51
 　*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BuyBillBean implements Serializable {
    private int BillID;
    private int PRec;
    private double Qty;
    private double Price;
    private double Total;
    private String Comment;
    private int Unit = 1;//
    private int KRec;
    private int SourceOrd = 0;//
    private double Tax;//
    private double TaxPrice;
    private double TaxTotal;
    private double AssQty;//单据数量
    private double AssPrice;//单据单价
    private double AssTaxPrice;//单据含税单价
    private double UnitRate = 1.0;//单位转换率
    private double PriceType = 0;//单价方式
    private int Ord;//明细行号
}

