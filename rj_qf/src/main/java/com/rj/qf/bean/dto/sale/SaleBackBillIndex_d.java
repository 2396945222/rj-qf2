package com.rj.qf.bean.dto.sale;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@ApiModel(value="销售退回索引",description="销售退回索引")
@Data
public class SaleBackBillIndex_d implements Serializable {
    @ApiModelProperty(value = "往来单位编号",name="buserCode",required=true)
    private String buserCode;//往来单位编号
    @ApiModelProperty(value = "单据日期",name="billDate",required=true)
    private String billDate;//单据日期
    @ApiModelProperty(value = "单据编号",name="billcode",required=true)
    private String billcode;//单据编号
    @ApiModelProperty(value = "总金额",name="totalmoney",required=true)
    private double totalmoney;//总金额
    @ApiModelProperty(value = "总数量",name="totalqty",required=true)
    private double totalqty;//总数量
    @ApiModelProperty(value = "备注",name="comment",required=true)
    private String comment;//备注
    @ApiModelProperty(value = "销售单据编号",name="xsbillCode",required=true)
    private String xsbillCode;//销售单据编号
    private ArrayList<SaleBackBill_d> saleBackBill_ds = new ArrayList<>();
}
