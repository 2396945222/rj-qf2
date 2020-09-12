package com.rj.qf.bean.dto.sale;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@ApiModel(value="销售退回明细数据",description="销售退回明细数据")
@Data
public class SaleBackBill_d implements Serializable {
    @ApiModelProperty(value = "商品编号",name="puserCode",required=true)
    private String puserCode ;//商品编号
    @ApiModelProperty(value = "批次号",name="jobnumber",required=true)
    private String jobnumber ;//批次号
    @ApiModelProperty(value = "商品编号",name="germJobnumber",required=true)
    private String germJobnumber ;//灭菌批号
    @ApiModelProperty(value = "有效期",name="validityPeriod",required=true)
    private String validityPeriod ;//有效期
    @ApiModelProperty(value = "生产日期",name="outFactoryDate",required=true)
    private String outFactoryDate ;//生产日期
    @ApiModelProperty(value = "数量",name="qty",required=true)
    private double qty ;//数量
    @ApiModelProperty(value = "单价",name="price",required=true)
    private double price ;//单价
    @ApiModelProperty(value = "总金额",name="total",required=true)
    private double total ;//总金额
    @ApiModelProperty(value = "备注",name="comment",required=true)
    private String comment ;//备注
    @ApiModelProperty(value = "成本价",name="costprice",required=true)
    private double costprice ;//成本价
    @ApiModelProperty(value = "药监报告号",name="checkReportNo",required=true)
    private String checkReportNo ;//药监报告号
    @ApiModelProperty(value = "行号",name="ord",required=true)
    private int ord;//行号
    @ApiModelProperty(value = "退回原因",name="backReason",required=true)
    private String backReason;//
    @ApiModelProperty(value = "税率",name="tax",required=true)
    private double tax;//税率
    @ApiModelProperty(value = "含税单价",name="taxPrice",required=true)
    private double taxPrice;//含税单价
    @ApiModelProperty(value = "含税总金额",name="taxTotal",required=true)
    private double taxTotal;//含税总金额

}
