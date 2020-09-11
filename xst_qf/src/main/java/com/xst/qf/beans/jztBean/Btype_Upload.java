package com.xst.qf.beans.jztBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 　* @description:上传九州通往来单位bean
 　* @author zxy
 　* @date 2020-07-20 8:48
 　*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Btype_Upload implements Serializable {

     /**
      * LIUS_NO : 1
      * Ssa_Id : 001
      * Ssa_No : DSFHNTXDSF001
      * Ssa_Name : 海南天祥药业有限公司
      * Ssa_Shortname : 海南天祥药业有限公司
      * Mnemonic_Code : HNTXYYYXGS
      * Ssa_Addr_Phone : 11111
      * Ssa_Sign : 2
      * Is_Hospital_Customer : N
      * Is_Active : Y
      * Creator : 305828464622808
      * Created_Time : 2017-10-24 22:28:22
      * Updated_Time : 2017-10-24 22:28:22
      * Status : 2
      * Yew_Staff : 张三
      * Yew_Staff_Phone : 18627883279
      * Address : 18627883279
      * Address_Shortname : 12334324234234
      * Contact_Name : 张三
      * Contact_Phone : 18627883279
      * Is_Default : Y
      * Con_Id : 305828464622808
      * Bankaccount : 88888888
      * Business_Licence_No : 33333
      * Business_Licence_No_Valid_Until : 2019-10-24
      * Production_License_No : 44444
      * Production_License_No_Valid_Until : 2019-10-24
      */

     private String LIUS_NO ="";//流水号
     private String Ssa_Id ="";//客户ID
     private String Ssa_No ="";//客户编号
     private String Ssa_Name ="";//客户名称
     private String Ssa_Shortname ="";//客户简称
     private String Mnemonic_Code ="";//.客户助记码
     private String Ssa_Addr_Phone ="";//客户注册地址电话
     private String Ssa_Sign = "";//客户标示（上游、下游）
     private String Is_Hospital_Customer = "N";//是否医院客户
     private String Is_Active = "Y";//是否活动
     private String Creator =Sign_Utils.Creator;//申请人  默认
     private String Created_Time = LocalDate.now().toString();//申请时间  默认
     private String Updated_Time = LocalDate.now().toString();//修改时间  默认
     private String Status = "1";//状态  默认
     private String Yew_Staff = "";//业务员 没填写
     private String Yew_Staff_Phone = "";//业务员电话 没填写
     private String Address = "";//详细地址
     private String Address_Shortname = "";//地址简称
     private String Contact_Name = "";//联系人
     private String Contact_Phone = ""; //联系人联系方式
     private String Is_Default = "Y";//是否默认配送地址
     private String Con_Id = Sign_Utils.Con_id;//委托方ID
     private String Bankaccount = "";//银行账号
     private String Business_Licence_No = "";//营业执照号
     private String Business_Licence_No_Valid_Until = "";//营业执照号有效期至
     private String Production_License_No = "";//生产/经营许可证号
     private String Production_License_No_Valid_Until = "";//生产/经营许可证号有效期至
     private String GMP_License= "";//GMP证件/GSP证件
     private String GMP_License_Valid_Until= "";//GMP效期/GSP效期
 }
