package com.rj.qf.bean.qf.buy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;

/**
 　* @description:采购订单主表
 　* @author zxy
 　* @date 2020-08-31 13:45
 　*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BuyIndexBean implements Serializable {
    private int BRec  = 0;//往来单位rec
    private int ERec  = 0;//操作员rec
    private int CheckEId = 0;//是否过账
    private int BillEId  = 0 ;//制单人
    private int KRec = 0;//仓库rec
    private String BillDate = "";//单据日期
    private String BillCode = "";//单据编号
    private int BillType = 301;//单据类型(301采购订单)
    private double TotalMoney = 0.0;//总金额
    private double TotalQty = 0.0;//总数量
    private int Period = 1;//单据期号(默认为1)
    private int Checked = 0;//是否审核
    private int RedWord = 0;//红冲
    private String Explain = "";//说明
    private String ReachDate = "";//到货日期
    private String Comment = "";//备注
    private double Tax = 0.0;//税率
    private int BillID = 0;//单据id
    private ArrayList<BuyBillBean> buyBills = new ArrayList<>();//单据详细集合
}
