package com.xst.qf.beans.jztBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
 /**
 　* @description:入库回传bean
 　* @author zxy
 　* @date 2020-07-23 13:57
 　*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class GET_InStock implements Serializable {
     /**
      * Biz_Bill_No : 103
      * Arrival_Mode : A1
      * Production_Date : 2020-01-01 00:00:00
      * Storage_Type : 1
      * Rp_Reasons : P06
      * Bill_Dtl_Id_jzyc : 2c551f636bf94cf7ae179f336282997a
      * Invoice_Time : 2020-07-29 17:41:35
      * Goods_Value : 0
      * Receiving_Clerk : 系统管理员
      * Valid_Until : 2022-01-01 00:00:00
      * Remarks : JD0000000085
      * Aging : 0
      * InstoreBill_No_LMIS : KPD06100234668
      * Ssa_No : 00011
      * Storageaddress_Id : 5a9a2764d9c5e71196061866dafb6f91
      * Con_Id : dc3641ee514b4d93ac588ede445c90db
      * Invoice_Staff : 唐晓峰
      * Acceptance_Check_Rlt : 3
      * Storage_Quantity : 100
      * Acceptance_Check_Date : 2020-07-29 17:18:29
      * Kilometers : 0
      * Amount : 862.069
      * Tdeladdress_Id :
      * Operator_Id : 346820465830730
      * Bill_Dtl_Id_Old : 1
      * Goods_No : HJS01
      * Ldc_Id : 599a2764d9c5e71196061866dafb6f91
      * Takegds_Time : 2020-07-29 00:00:00
      * Sterilization_Lotno :
      * Price : 8.62069
      * Quality_Inspector : 系统管理员
      * Bill_Dtl_Id : 1
      * Outstorebill_No :
      * Goods_Lotno : 20200729
      * Goods_Type : 8
      */
     private String Biz_Bill_No;
     private String Arrival_Mode;
     private String Production_Date;
     private String Storage_Type;
     private String Rp_Reasons;
     private String Bill_Dtl_Id_jzyc;
     private String Invoice_Time;
     private String Goods_Value;
     private String Receiving_Clerk;
     private String Valid_Until;
     private String Remarks;
     private int Aging;
     private String Auditor_Time;
     private String InstoreBill_No_LMIS;
     private String Ssa_No;
     private String Storageaddress_Id;
     private String Con_Id;
     private String Invoice_Staff;
     private String Acceptance_Check_Rlt;
     private int Storage_Quantity;
     private String Acceptance_Check_Date;
     private int Kilometers;
     private double Amount;
     private String Tdeladdress_Id;
     private String Operator_Id;
     private String Bill_Dtl_Id_Old;
     private String Goods_No;
     private String Ldc_Id;
     private String Takegds_Time;
     private String Sterilization_Lotno;
     private double Price;
     private String Quality_Inspector;
     private String Bill_Dtl_Id;
     private String Outstorebill_No;
     private String Goods_Lotno;
     private String Goods_Type;

     public String getBiz_Bill_No() {
         return Biz_Bill_No;
     }

     public void setBiz_Bill_No(String Biz_Bill_No) {
         this.Biz_Bill_No = Biz_Bill_No;
     }

     public String getArrival_Mode() {
         return Arrival_Mode;
     }

     public void setArrival_Mode(String Arrival_Mode) {
         this.Arrival_Mode = Arrival_Mode;
     }

     public String getProduction_Date() {
         return Production_Date;
     }

     public void setProduction_Date(String Production_Date) {
         this.Production_Date = Production_Date;
     }

     public String getStorage_Type() {
         return Storage_Type;
     }

     public void setStorage_Type(String Storage_Type) {
         this.Storage_Type = Storage_Type;
     }

     public String getRp_Reasons() {
         return Rp_Reasons;
     }

     public void setRp_Reasons(String Rp_Reasons) {
         this.Rp_Reasons = Rp_Reasons;
     }

     public String getBill_Dtl_Id_jzyc() {
         return Bill_Dtl_Id_jzyc;
     }

     public void setBill_Dtl_Id_jzyc(String Bill_Dtl_Id_jzyc) {
         this.Bill_Dtl_Id_jzyc = Bill_Dtl_Id_jzyc;
     }

     public String getInvoice_Time() {
         return Invoice_Time;
     }

     public void setInvoice_Time(String Invoice_Time) {
         this.Invoice_Time = Invoice_Time;
     }

     public String getGoods_Value() {
         return Goods_Value;
     }

     public void setGoods_Value(String Goods_Value) {
         this.Goods_Value = Goods_Value;
     }

     public String getReceiving_Clerk() {
         return Receiving_Clerk;
     }

     public void setReceiving_Clerk(String Receiving_Clerk) {
         this.Receiving_Clerk = Receiving_Clerk;
     }

     public String getValid_Until() {
         return Valid_Until;
     }

     public void setValid_Until(String Valid_Until) {
         this.Valid_Until = Valid_Until;
     }

     public String getRemarks() {
         return Remarks;
     }

     public void setRemarks(String Remarks) {
         this.Remarks = Remarks;
     }

     public int getAging() {
         return Aging;
     }

     public void setAging(int Aging) {
         this.Aging = Aging;
     }

     public String getInstoreBill_No_LMIS() {
         return InstoreBill_No_LMIS;
     }

     public void setInstoreBill_No_LMIS(String InstoreBill_No_LMIS) {
         this.InstoreBill_No_LMIS = InstoreBill_No_LMIS;
     }

     public String getSsa_No() {
         return Ssa_No;
     }

     public void setSsa_No(String Ssa_No) {
         this.Ssa_No = Ssa_No;
     }

     public String getStorageaddress_Id() {
         return Storageaddress_Id;
     }

     public void setStorageaddress_Id(String Storageaddress_Id) {
         this.Storageaddress_Id = Storageaddress_Id;
     }

     public String getCon_Id() {
         return Con_Id;
     }

     public void setCon_Id(String Con_Id) {
         this.Con_Id = Con_Id;
     }

     public String getInvoice_Staff() {
         return Invoice_Staff;
     }

     public void setInvoice_Staff(String Invoice_Staff) {
         this.Invoice_Staff = Invoice_Staff;
     }

     public String getAcceptance_Check_Rlt() {
         return Acceptance_Check_Rlt;
     }

     public void setAcceptance_Check_Rlt(String Acceptance_Check_Rlt) {
         this.Acceptance_Check_Rlt = Acceptance_Check_Rlt;
     }

     public int getStorage_Quantity() {
         return Storage_Quantity;
     }

     public void setStorage_Quantity(int Storage_Quantity) {
         this.Storage_Quantity = Storage_Quantity;
     }

     public String getAcceptance_Check_Date() {
         return Acceptance_Check_Date;
     }

     public void setAcceptance_Check_Date(String Acceptance_Check_Date) {
         this.Acceptance_Check_Date = Acceptance_Check_Date;
     }

     public int getKilometers() {
         return Kilometers;
     }

     public void setKilometers(int Kilometers) {
         this.Kilometers = Kilometers;
     }

     public double getAmount() {
         return Amount;
     }

     public void setAmount(double Amount) {
         this.Amount = Amount;
     }

     public String getTdeladdress_Id() {
         return Tdeladdress_Id;
     }

     public void setTdeladdress_Id(String Tdeladdress_Id) {
         this.Tdeladdress_Id = Tdeladdress_Id;
     }

     public String getOperator_Id() {
         return Operator_Id;
     }

     public void setOperator_Id(String Operator_Id) {
         this.Operator_Id = Operator_Id;
     }

     public String getBill_Dtl_Id_Old() {
         return Bill_Dtl_Id_Old;
     }

     public void setBill_Dtl_Id_Old(String Bill_Dtl_Id_Old) {
         this.Bill_Dtl_Id_Old = Bill_Dtl_Id_Old;
     }

     public String getGoods_No() {
         return Goods_No;
     }

     public void setGoods_No(String Goods_No) {
         this.Goods_No = Goods_No;
     }

     public String getLdc_Id() {
         return Ldc_Id;
     }

     public void setLdc_Id(String Ldc_Id) {
         this.Ldc_Id = Ldc_Id;
     }

     public String getTakegds_Time() {
         return Takegds_Time;
     }

     public void setTakegds_Time(String Takegds_Time) {
         this.Takegds_Time = Takegds_Time;
     }

     public String getSterilization_Lotno() {
         return Sterilization_Lotno;
     }

     public void setSterilization_Lotno(String Sterilization_Lotno) {
         this.Sterilization_Lotno = Sterilization_Lotno;
     }

     public double getPrice() {
         return Price;
     }

     public void setPrice(double Price) {
         this.Price = Price;
     }

     public String getQuality_Inspector() {
         return Quality_Inspector;
     }

     public void setQuality_Inspector(String Quality_Inspector) {
         this.Quality_Inspector = Quality_Inspector;
     }

     public String getBill_Dtl_Id() {
         return Bill_Dtl_Id;
     }

     public void setBill_Dtl_Id(String Bill_Dtl_Id) {
         this.Bill_Dtl_Id = Bill_Dtl_Id;
     }

     public String getOutstorebill_No() {
         return Outstorebill_No;
     }

     public void setOutstorebill_No(String Outstorebill_No) {
         this.Outstorebill_No = Outstorebill_No;
     }

     public String getGoods_Lotno() {
         return Goods_Lotno;
     }

     public void setGoods_Lotno(String Goods_Lotno) {
         this.Goods_Lotno = Goods_Lotno;
     }

     public String getGoods_Type() {
         return Goods_Type;
     }

     public void setGoods_Type(String Goods_Type) {
         this.Goods_Type = Goods_Type;
     }


//    private String Operator_Id = "";//运营方ID
//    private String Con_Id = "";//运营方ID
//    private String Ldc_Id = "";//物流中心ID
//    private String Biz_Bill_No = "";//业务单据编号
//    private String Ssa_No = "";//客户编号
//    private String Goods_Type = "";//产品大类
//    private String Arrival_Mode = "";//到货方式
//    private String Tdeladdress_Id = "";//提货地址ID
//    private String Storageaddress_Id = "";//入库地址ID
//    private String Takegds_Time = "";//接货时间
//    private String Invoice_Staff = "";//开票员
//    private String Invoice_Time = "";//开票时间
//    private String Remarks = "";//备注
//    private String Storage_Type = "";//入库类型
//    private String Bill_Dtl_Id = "";//行号
//    private String Bill_Dtl_Id_Old = "";//旧的入库行号
//    private String Goods_No = "";//商品编号
//    private String Outstorebill_No = "";//出库单号
//    private String Goods_Lotno = "";//商品批号
//    private String Production_Date = "";//生产日期
//    private String Valid_Until = "";//有效期
//    private String Storage_Quantity = "";//入库数量
//    private String Price = "";//单价
//    private String Amount = "";//金额
//    private String Acceptance_Check_Rlt = "";//验收评定
//    private String Rp_Reasons = "";//退货原因
//    private String Goods_Value = "";//商品价值
//    private String Kilometers = "";//公里数
//    private String Aging = "";//时效
//    private String Receiving_Clerk = "";//收货员
//    private String Quality_Inspector = "";//质检员
//    private String InstoreBill_No_LMIS = "";//LMIS入库单号
//    private String Acceptance_Check_Date = "";//验收日期
//    private String Sterilization_Lotno = "";//灭菌批号
//    private String Qualified = "";//验收合格数量
//    private String UnQualified_Qty = "";//验收不合格数量
//    private String SpotCheck_Qty = "";//抽检数量
//    private String Treatment_Measures;//处理措施
//    private String Transport_Mode = "";//运输方式(工具)
//    private String Tprt_Mode = "";//温控方式
//    private String Tprt_Record = "";//到货温度(验收温度)
//    private String recorderNo = "";//记录仪型号或编号
//    private String OutPackingCheck = "";//外包装检查
//    private String LabelCheck = "";//标签检查
//    private String SpecificationsCheck = "";//说明书检查
//    private String VisForeignMatter = "";//可见异物检查
//    private String Is_Stock = "";//是否记账
//    private String Bill_Dtl_Id_jzyc = "";//九州云仓ID
//    private String Auditor = "";//单据审核人
//    private String Auditor_Time = "";//单据审核时间

}
