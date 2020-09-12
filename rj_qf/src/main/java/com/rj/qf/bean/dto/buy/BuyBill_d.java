package com.rj.qf.bean.dto.buy;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
/**
 　* @description:采购订单详细
 　* @author zxy
 　* @date 2020-08-29 18:27
 　*/
@ApiModel(value="采购订单明细",description="采购订单明细(默认两面最小单位相同,不需要传递单位信息)")
@Data
public class BuyBill_d implements Serializable {
    @ApiModelProperty(value = "商品编号",name="puserCode",required=true)
    private String puserCode;//商品编号
    @ApiModelProperty(value = "仓库编号",name="kuserCode",required=true)
    private String kuserCode;//仓库编号
    @ApiModelProperty(value = "数量",name="qty",required=true)
    private double qty;//数量
    @ApiModelProperty(value = "单价",name="price",required=true)
    private double price;//单价
    @ApiModelProperty(value = "总金额",name="total",required=true)
    private double total;//总金额
    @ApiModelProperty(value = "税率(需要传递不含百分比税率,例(13.00,17.00))",name="tax",required=true)
    private double tax;//税率
    @ApiModelProperty(value = "含税单价",name="taxPrice",required=true)
    private double taxPrice;//含税单价
    @ApiModelProperty(value = "含税总金额",name="taxTotal",required=true)
    private double taxTotal;//含税总金额
    @ApiModelProperty(value = "备注",name="comment",required=true)
    private String comment;//备注
    @ApiModelProperty(value = "单据行号",name="ord",required=true)
    private int ord;//单据行号

}
