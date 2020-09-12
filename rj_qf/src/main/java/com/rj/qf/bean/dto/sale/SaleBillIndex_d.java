package com.rj.qf.bean.dto.sale;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.ArrayList;

@ApiModel(value="销售单索引",description="销售单索引")
@Data
public class SaleBillIndex_d implements Serializable {
    @ApiModelProperty(value = "单据编号",name="billCode",required=true)
    private String billCode;//单据编号
    @ApiModelProperty(value = "单据日期",name="billDate",required=true)
    private String billDate;//单据日期
    @ApiModelProperty(value = "备注",name="comment",required=true)
    private String comment;//备注
    @ApiModelProperty(value = "客户单位编号",name="buserCode",required=true)
    private String buserCode;//客户单位编号
    @ApiModelProperty(value = "仓库编号",name="kuserCode",required=true)
    private String kuserCode;//仓库编号
    @ApiModelProperty(value = "总数量",name="totalQty",required=true)
    private double totalQty;//总数量
    @ApiModelProperty(value = "含税总金额",name="totalMoney",required=true)
    private double totalMoney;//含税总金额
    @ApiModelProperty(value = "税率",name="tax",required=true)
    private double tax;//税率
    @ApiModelProperty(value = "单据明细总行数量",name="billDetailCount",required=true)
    private double billDetailCount;//单据明细总行数量
    @ApiModelProperty(value = "明细集合",name="saleBillds",required=true)
    private ArrayList<SaleBill_d> saleBillds = new ArrayList<>();
}
