package com.rj.qf.bean.qf.buy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 　* @description:x销售单详细数据
 　* @author zxy
 　* @date 2020-09-02 17:02
 　*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BuyBackBill implements Serializable  {
    private int BillID;//单据id
    private int KRec;//仓库rec
    private int GRec = 0;//货位rec
    private int PRec;//商品rec
    private double Qty;//数量
    private double AssQty;//单据数量
    private double SalePrice;//销售单价
    private double AssSalePrice;//单据销售单价
    private double discount = 100;//折扣
    private double DiscountPrice;//折扣单价
    private double AssDiscountPrice;//单据折扣单价
    private double total;//总金额
    private double tax;//税率
    private double TaxPrice;//税后单价
    private double AssTaxPrice;//税后单据单价
    private double TaxTotal;//含税金额
    private double CostPrice;//成本单价
    private String jobnumber;//批次号
    private String OutFactoryDate;//出厂日期
    private String ValidityPeriod;//有效期
    private String JobCode = "";//药品监管码
    private String GermJobNumber;//灭菌批号
    private String CheckReportNo;//药监报告号
    private int ProviderId = 0;//供应商
    private int PtypeSource = 0;//商品来源
    private String comment;//备注
    private String Eligible = "合格";//合格标识
    private int unit = 1;//最小单位
    private double UnitRate = 1.0;//单位转换率
    private double retailprice = 0;//
    private int ord;//行号
    private double BackQty = 0.0;//原单据id
    private String StockUniqueid;//库存uid
    private int SaleETypeID ;//
    private int PriceType = 0;//价格类型
    private double invocetotal = 0.0;//
    private String backreason = "";
    private String CheckResult = "";//
    private String SNTEXT = "";
    private int JGMQty;//
    private int Gjobid = 0;//

}
