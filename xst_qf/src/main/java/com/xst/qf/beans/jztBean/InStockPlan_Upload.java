package com.xst.qf.beans.jztBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
/**
 * 入库计划九州通bean
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class InStockPlan_Upload implements Serializable {
    private String Operator_Id = Sign_Utils.Operator_Id;//运营方ID
    private String Con_Id = Sign_Utils.Con_id;//委托方ID
    private String Ldc_Id = Sign_Utils.Ldc_Id;//物流中心ID
    private String BUSINESSBILL_NO = "";//业务单据编号 主键
    private String Ssa_No = "";//客户编号
    private String Goods_Type = "";//产品大类 8:冷藏品9:阴凉品
    private String Arrival_Mode = "";//到货方式 A1：待货入库 A2：提货入库
    private String Tdeladdress_Id = "";// 提货地址ID
    private String Storageaddress_Id = "";//入库地址ID
    private String Takegds_Time = "";//接货时间  提货入库传接货时间，待货入库填到货时间
    private String Invoice_Staff = "";//开票员  方式一：对接职员资料，传职员编号，可默认传委托方管理员职员编号 方式二：不对接职员资料，直接传职员名称
    private String Invoice_Time = "";//开票时间
    private String Remarks = "";//备注
    private String BUSINESS_TYPE = "";//入库类型 1：正常入库 4：销售退回
    private String BILL_DTL_ID_OLD = "";//行号 单据有多行，传具体的行号，主键，不允许重复
    private String Goods_No = "";// 商品编号
    private String Outstorebill_No = "";// 出库单号 入库类型=销售退回时，需传输此字段，为销售退回单据对应的原出库单据的业务单据编号
    private String Goods_Lotno = "";//商品批号
    private String Production_Date = "";// 生产日期
    private String Valid_Until = "";//有效期
    private String ACTUAL_QTY = "";// 入库数量
    private String Price = "";//单价
    private String Amount = "";//金额
    private String Acceptance_Check_Rlt = "";//金额入库类型 = 销售退回时，需传输此字段，默认为1：合格1: 合格2：不合格3：入库待验4：拒收5：待验确定 6：在库待验
    private String Rp_Reasons = "";//退货原因 入库类型=销售退回时，需传输此字段，为销售退回原因，例如：开票原因：开错批号
    private String Goods_Value = "";//商品价值  需提货入库时，填写商品价值后根据商品价值保价
    private String Kilometers = "";//公里数
    private String Aging = "";// 时效
    /**
     * Operator_Id : 684571324568415
     * Con_Id : 1a87d02d6bb5e711b639000c29d6c8f4
     * Ldc_Id : 199647602156719
     * BUSINESSBILL_NO : RKKN0000009
     * Ssa_No : HBHWDM
     * Goods_Type : 8
     * Arrival_Mode : 2
     * Tdeladdress_Id : 376218338456719
     * Storageaddress_Id :
     * Takegds_Time : 2017-11-12
     * Invoice_Staff : MACF
     * Invoice_Time : 2017-11-11 09:48:22
     * Remarks : 马春芬测试
     * BUSINESS_TYPE : 1
     * BILL_DTL_ID_OLD : 1
     * Goods_No : PCH049051O
     * Outstorebill_No :
     * Goods_Lotno : 1704116
     * Production_Date : 2017-04-21
     * Valid_Until : 2019-03-31
     * ACTUAL_QTY : 3
     * Price : 10
     * Amount : 30
     * Acceptance_Check_Rlt :
     * Rp_Reasons :
     * Goods_Value : 10
     * Kilometers : 0
     * Aging : 24
     */
}

