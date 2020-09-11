package com.xst.qf.beans.qfBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * 　* @description:入库上传调用存储过程bean
 * 　* @author zxy
 * 　* @date 2020-07-29 13:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ZXY_GJ_RK_SC_BILL_Bean implements Serializable {
    private String DANJ_NO;//九中通单据号
    private String picihao;//批次号
    private String yx_date;//有效日期
    private String sc_date;///生产日期
    private String ss_qty;//实收数量
    private String CHOUY_QTY;//抽样数量
    private String PRICE;//单价
    private String billid;//单据编号
    private String prec;//商品编号
    private String Checker;//验收人
    private String SHR;//收货人
    private String RIQI_CHAR;//日期_字符（验收日期）
    private int RUK_TYPE;// 入库类型 1 代表采购入库，4 代表销售退回  34   45
    private int zxy_countId = 0;//(默认传0) 中间表billid 总数,如果总数等于1 ,证明已经有一tiao相同billid 的数据返回,,是分批单据,如果等于0,不是分批,第一条记录
    private int return_billid = 0;//（默认0）存储过程返回billid
    private int YANS_RLT;//验收类型 1为合格,2不合格
}
