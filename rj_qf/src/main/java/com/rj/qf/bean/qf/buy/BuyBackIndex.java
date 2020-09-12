package com.rj.qf.bean.qf.buy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 　* @description:销售单主表
 　* @author zxy
 　* @date 2020-09-02 17:02
 　*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BuyBackIndex implements Serializable {
    private String BillDate;//单据日期
    private String BillCode;//单据编号
    private int BillType = 6;//单据类型(采购退回6)
    private String Comment;//单据备注
    private int ARec = 0;//资金账户
    private int BREc;//往来单位rec
    private int ERec;//操作员rec
    private int KRec;//仓库rec
    private int KRec2 = 0;//仓库2rec
    private int CheckE = 0;//审核人rec
    private int ifchecked = 0;//是否过账
    private int BillE;//制单人
    private double TotalMoney;//含税总金额
    private double TotalQty;//总数量
    private double TotalInMoney = 0 ;//实际收付现金额
    private double BenefitMoney = 0;//优惠金额
    private double jsyetotal = 0;//计算金额
    private double Tax = -10.00;//税率
    private String Explain = "";//说明
    private int OrderId = 0 ;//订单id
    private int posid= 0;//门店id
    private String MoneyDate = "";//收款期限
    private int QualityStatus = 0;//质检状态标志
    private String UniqueBillid ;//。单据唯一id
    private int BillStatus = 0;//（单据状态，表示单据传输状态：0表示普通单据或还未传输11表示门店上传到配送中心单据13表示配送中心单据已经下传到门店）
    private int PrintTime = 0;//打印次数
    private int nSysFlag = 0;//打印次数
    private String NextBillId;//下一个单据uid
    private int OfficeId = 0;//操作门店ID
    private String OutStockLaw = "z";//打印次数
    private String SendWay = "";//送货方式
    private int RedBillid = 0;//红字单据ID
    private int BillDetailCount = 0;//单据明细行数
    private String InvoiceID;//
    private String HandOverTime ;//零售交班时间
    private String invoice = "";//进项发票号
    private String JsFlag = " ";//结算标识符
    private int BillID  = 0;//原始单据id
    private int KeepBillID = 0 ;//是否保证原单据id不变
    private int flag = 0 ;//
    private int DRec = 0 ;//
    private int VipCardID = 0 ;//会员卡id
    private int BTYPEAttorneyid = 0 ;//
    private String YS_Weway = "";//运输方式
    private String YS_ADDR = "";//运输地址
    private String YS_DW = "";//运输单位
    private String YS_Date;//运输时间
    private String YS_WKFS = "";//
    private String YS_WKZT = "";//
    private String YS_DHWD = "";//
    private String CGJLSinge = "";//
    private String ZGJLSinge = "";//
    private String TSChecker = "";//
    private String IPAddress = "";//id地址
    private String ComputerName = "";//
    private int LoginUserID = 0;//登录用户id
    private int Auditid = 0;//
    private int WTPosid = 0;//
    private int pricetype = 0;//价格方式
    private int costrate = 0;//
    private int JSBRec = 0;//结算rec
    private int DealBlackJGM = 0;//运输方式
    private int ORec = 0;//
    private int ORec2 = 0;//

}
