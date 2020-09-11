package com.xst.qf.beans.jztBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 出库计划九州通bean
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OutStockPlan_Upload implements Serializable {
    private String Operator_Id = Sign_Utils.Operator_Id;//运营方ID
    private String Con_Id = Sign_Utils.Con_id;//委托方ID
    private String Ldc_Id = Sign_Utils.Ldc_Id;//物流中心ID
    private String Biz_Bill_No = "";//业务单据编号 主键
    private String Ssa_No = "";//客户编号  终端客户编号
    private String Goods_Type = "";//产品大类  8:冷藏品9:阴凉品
    private String Outbound_Mode = "";// 出库方式  1：出库待配2：出库配送
    private String Outbaddress_Id = "";//出库地址ID 不传
    private String Delivery_Address_Id = "";// 送货地址ID 1.传地址资料接口中对接的Address_Old_Id 不传默认取客户的默认
    private String Invoice_Staff = "";//开票员 方式一：对接职员资料，传职员编号，可默认传委托方管理员职员编号  方式二：不对接职员资料，直接传职员名称
    private String Invoice_Time = "";//开票时间
    private String Remarks = "";//备注
    private String Sale_Type = "";// 销售类型 1：销售出库 4：购进退出
    private String Delivery_Time = "";//送货日期
    private String Bill_Dtl_Id = "";//行号
    private String Goods_No = "";//商品编号
    private String InstoreBill_No = "";//购进入库单号 销售类型=购进退出时，需传输编此字段，为购进退出单据对应的原入库单据的业务单据号
    private String Goods_Lotno = "";//商品批号
    private String Production_Date = "";// 生产日期
    private String Valid_Until = "";//有效期
    private String Outnbound_Quantity = "";//出库数量
    private String Price = "";//单价
    private String Amount = "";//金额
    private String Goods_Value = "";//商品价值
    private String Kilometers = "";//公里数
    private String Aging = "";//时效
    private String Is_Sceneprint = "";//是否现场打印
    private String Is_Receipt = "";//是否回单
    private String Rp_Cate = "";//退货类别
    private String Rp_Reasons = "";//退货原因

    /**  调用示例
     * Operator_Id : 684571324568415
     * Con_Id : 1a87d02d6bb5e711b639000c29d6c8f4
     * Ldc_Id : 199647602156719
     * Biz_Bill_No : HBKN0000007
     * Ssa_No : HBHWDM
     * Goods_Type : 8
     * Outbound_Mode : 2
     * Outbaddress_Id : 376218338456719
     * Delivery_Address_Id :
     * Invoice_Staff : MACF
     * Invoice_Time : 2017-11-11 09:48:22
     * Remarks : 马春芬测试
     * Sale_Type : 1
     * Delivery_Time : 2017-11-12
     * Bill_Dtl_Id : 1
     * Goods_No : PCH049051O
     * InstoreBill_No :
     * Goods_Lotno : 1704115
     * Production_Date : 2017-04-21
     * Valid_Until : 2019-03-31
     * Outnbound_Quantity : 2
     * Price : 10
     * Amount : 20
     * Goods_Value : 10
     * Kilometers : 0
     * Aging : 24
     * Is_Sceneprint : N
     * Is_Receipt : N
     * Rp_Cate :
     * Rp_Reasons :
     */

}
