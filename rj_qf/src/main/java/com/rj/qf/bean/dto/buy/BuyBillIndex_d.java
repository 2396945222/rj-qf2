package com.rj.qf.bean.dto.buy;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.ArrayList;

/**
  * 采购订单索引
 　* @description:
 　* @author zxy
 　* @date 2020-08-29 18:27
 　*/
@ApiModel(value="采购订单索引",description="采购订单索引")
@Data
public class BuyBillIndex_d  implements Serializable {
    @ApiModelProperty(value = "单据编号",name="billCode",required=true)
    private String billCode;//单据编号
    @ApiModelProperty(value = "单据日期",name="billDate",required=true)
    private String billDate;//单据日期
    @ApiModelProperty(value = "仓库编号",name="kuserCode",required=true)
    private String kuserCode;//仓库编号
    @ApiModelProperty(value = "往来单位编号",name="buserCode",required=true)
    private String buserCode;//往来单位编号
    @ApiModelProperty(value = "税率(需要传递不含百分比税率,例(13.00,17.00))",name="tax",required=true)
    private double tax;//税率
    @ApiModelProperty(value = "总金额",name="totalMoney",required=true)
    private double totalMoney;//总金额
    @ApiModelProperty(value = "总数量",name="totalQty",required=true)
    private double totalQty;//总数量
    @ApiModelProperty(value = "备注(如果没有传空字符串'')",name="comment",required=true)
    private String comment;//总数量
    @ApiModelProperty(value = "单据明细数组",name="buyBills",required=true)
    private ArrayList<BuyBill_d> buyBills = new ArrayList<>();
}
