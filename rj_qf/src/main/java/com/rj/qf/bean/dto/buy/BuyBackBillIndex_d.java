package com.rj.qf.bean.dto.buy;

import com.rj.qf.bean.dto.sale.SaleBill_d;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@ApiModel(value="采购退回主单据",description="采购退回主单据")
@Data
public class BuyBackBillIndex_d implements Serializable {
    @ApiModelProperty(value = "单据编号",name="billCode",required=true)
    private String billCode;//单据编号
    @ApiModelProperty(value = "入库单编号(千方)",name="rkBillCode",required=true)
    private String rkBillCode;//单据编号
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
    @ApiModelProperty(value = "明细集合",name="backBill_ds",required=true)
    private ArrayList<BuyBackBill_d> backBill_ds = new ArrayList<>();
}
