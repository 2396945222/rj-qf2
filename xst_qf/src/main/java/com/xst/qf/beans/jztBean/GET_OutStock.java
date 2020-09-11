package com.xst.qf.beans.jztBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
/**
 　* @description:出库回传bean
 　* @author zxy
 　* @date 2020-07-23 13:57
 　*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class GET_OutStock implements Serializable {
    private String Operator_Id;//运营方ID
    private String Con_Id;//委托方ID
    private String Ldc_Id;//物流中心ID
    private String Biz_Bill_No;//业务单据编号
    private String Ssa_No;//客户编号
    private String Goods_Type;//产品大类
    private String Outbound_Mode;//出库方式
    private String Outbaddress_Id;//出库地址ID
    private String Delivery_Address_Id;//送货地址ID
    private String Invoice_Staff;//开票员
    private String Invoice_Time;//开票时间
    private Object Remarks;//备注
    private String Sale_Type;//销售类型
    private String Delivery_Time;//送货日期
    private String Bill_Dtl_Id;//行号
    private String Goods_No;//商品编号
    private String Instorebill_No;//购进入库单号
    private String Goods_Lotno;//商品批号
    private String Production_Date;//生产日期
    private String Valid_Until;//有效期
    private String Outnbound_Quantity;//出库数量
    private String Price;//单价
    private String Amount;//金额
    private String Goods_Value;//商品价值
    private String Kilometers;//公里数
    private String Aging;//时效
    private String Is_Sceneprint;//是否现场打印
    private String Is_Receipt;//是否回单
    private String Rp_Cate;//退货类别
    private String Rp_Reasons;//退货原因
    private String Bill_Dtl_Id_Old;//订单原行号
    private String Recheck_Staff;//复核员
    private String Is_Reversion;//是否冲红Y：是 N：否
    private String Bill_Dtl_Id_jzyc;//九州云仓ID
    private String Auditor;//单据审核人
    private String Auditor_Time;//单据审核时间
    private String pickingStaff;//拣货员

/**
 * Operator_Id : 见调用通用接口参数
 * Con_Id : 见调用通用接口参数
 * Ldc_Id : 690251255778594
 * Biz_Bill_No : WKPFDG00004370
 * Ssa_No : 0020001
 * Goods_Type : 1
 * Outbound_Mode : 2
 * Outbaddress_Id : 238204909477859
 * Delivery_Address_Id : 238204909477859
 * Invoice_Staff : 581ce542c9dfe711b63a000c29d6c8f4
 * Invoice_Time : 2017-12-13 20:04:53
 * Remarks : null
 * Sale_Type : 1
 * Delivery_Time : 2017-12-13 17:00:00
 * Bill_Dtl_Id : 2
 * Goods_No : 05020140029
 * Instorebill_No :
 * Goods_Lotno : 20170101
 * Production_Date : 2017-01-01
 * Valid_Until : 2019-01-01
 * Outnbound_Quantity : 2.00
 * Price : 232.36316
 * Amount : 464.73000
 * Goods_Value : 0.00000
 * Kilometers : 0.00
 * Aging : 24.000
 * Is_Sceneprint : N
 * Is_Receipt : N
 * Rp_Cate : 1
 * Rp_Reasons :
 * Bill_Dtl_Id_Old : 2
 * Recheck_Staff : 李四
 */
}
