package com.rj.qf.bean.qf.sale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
/**
 * @author zxy
 * @description:销售退回详细单据
 * @date 2020-09-05 17:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SaleBackBill implements Serializable {
    private int BillID;//
    private int pRec;//商品rec
    private String jobnumber;
    private String GermJobnumber;//灭菌批号
    private String ValidityPeriod;//有效期
    private String OutFactoryDate;//生产日期
    private double qty;//
    private double price;//
    private double Total;//
    private double unitRate = 1.0;//小单位换算率
    private double unitIndex = 1.0;//单位Index
    private String memo = "";//注释
    private double Costprice = 0;//
    private int ProviderId = 0;//供应商id
    private int PtypeSource = 0;//
    private String StockUniqueid;//仓库uid
    private String jobcodel = "";//批次条码
    private String CheckReportNo = "";//药监报告号
    private int Ord;//行号
    private int pricetype = 0;// 价格类型
    private String BackReason = "";//退回原因
    private int sourcesaleid;//原销售明细id
    private double Tax;//税率
    private double Taxprice;//含税单价
    private double TaxTotal;//含税总金额
    private String GJobID = "0";//
}
