package com.xst.qf.beans.jztBean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 　* @description:上传九州通商品资料bean
 　* @author zxy
 　* @date 2020-07-20 10:39
 　*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Ptype_Upload  implements Serializable {
    private int LIUS_NO= 0;//流水号
    private String Goods_Id= "";//商品ID
    private String Goods_No= "";//商品编号
    private String Goods_Name= "";//中文名
    private String Universal_Name= "";//通用名
    private String Mnemonic_Code= "";//助记码
    private String Drug_Spec= "";//药品规格
    private String Manufacturer= "";//生产厂家
    private String Producing_Area= "";//产地
    private String Package_Qty= "";//包装数量
    private String Package_Unit= "";//包装单位
    private String Approval_No= "";//批准文号/注册证号
    private String Approval_No_Valid_Until= "";//批准文号/注册证号有效期至
    private String Manufacturer_License= "";//生产企业许可证
    private String Manufacturer_License_Valid_Until = "";//生产企业许可证有效期至
    private String Mta_Manufacturer_License= "";
    private String Mta_Manufacturer_License_Valid_Until= "";
    private String Dosage_Form= "";//剂型
    private String Drug_Cate= "";//药品大类
    private String M_Package_Qty= "";//中包装数量
    private String Is_Active= "Y";//是否启用
    private String Status= "1";//状态
    private String Con_Id= Sign_Utils.Con_id;//委托方ID
    private String Creator= Sign_Utils.Creator;//申请人
    private String Created_Time= LocalDate.now().toString();//
    private String Updated_Time= LocalDate.now().toString();//
    private String Goods_Length= "";//长（CM）
    private String Goods_Width= "";//宽（CM）
    private String Goods_Height= "";//高（CM）
    private String Goods_Weight= "";//商品重量（KG）
    private String Storage_Condition= "";//存储条件
    private String Is_Chilleddrug= "N";//是否冷藏药品
    private String Is_Valuabledrug= "N";//是否贵重药品
    private String Is_Importeddrug= "N";//是否进口药品
    private String Is_Psychotropicdrug= "N";//是否精神药品
    private String Is_2c_Psychotropicdrug= "N";//是否二类精神药品
    private String Is_Specialcontroldrug= "N";//是否特管药品
    private String Is_Hydroxystenozole= "N";//是否蛋肽药品
    private String Ldc_Id= Sign_Utils.Ldc_Id;//物流中心ID
    private String Stock_Upperlimit= "0";//库存上限数量
    private String Stock_Lowerlimit= "0";//库存下限数量
    private String marketingAuthorisationHolder = "";//上市许可持有人
    @JSONField(name = "Refrigeration_Type")
    private String Refrigeration_Type = "";// 温层
    /**
     * LIUS_NO : 1
     * Goods_Id : DSFLM0007
     * Goods_No : DSFLM0007
     * Goods_Name : 龙牡壮骨颗粒3
     * Universal_Name : 龙牡壮骨颗粒
     * Mnemonic_Code : LMZGKL
     * Drug_Spec : 5g*40*50盒
     * Manufacturer : 武汉健民集团股份有限公司
     * Producing_Area : 武汉
     * Package_Qty : 1
     * Package_Unit : 盒
     * Approval_No : 2121231231
     * Approval_No_Valid_Until : 2019-10-24
     * Manufacturer_License :
     * Manufacturer_License_Valid_Until :
     * Mta_Manufacturer_License :
     * Mta_Manufacturer_License_Valid_Until :
     * Dosage_Form : 000
     * Drug_Cate : 000
     * M_Package_Qty : 1
     * Is_Active : Y
     * Status : 1
     * Con_Id : 305828464622808
     * Creator : 305828464622808
     * Created_Time : 2017-10-24 22:28:22
     * Updated_Time : 2017-10-24 22:28:22
     * Goods_Length : 10
     * Goods_Width : 20
     * Goods_Height : 30
     * Goods_Weight : 6
     * Storage_Condition : Y
     * Is_Chilleddrug : N
     * Is_Valuabledrug : N
     * Is_Importeddrug : N
     * Is_Psychotropicdrug : N
     * Is_2c_Psychotropicdrug : N
     * Is_Specialcontroldrug : N
     * Is_Hydroxystenozole : N
     * Ldc_Id : 199647602156719
     * Stock_Upperlimit : 100
     * Stock_Lowerlimit : 10
     */
//    private Integer LIUS_NO = 0;//流水号
//    private String Goods_Id = "";//商品ID
//    private String Goods_No = "";//商品编号
//    private String Goods_Name = "";//中文名
//    private String Universal_Name = "";//通用名
//    private String Mnemonic_Code = "";//助记码
//    private String Drug_Spec = "";//药品规格
//    private String Manufacturer = "";//生产厂家
//    private String Producing_Area = "";//产地
//    private double Package_Qty =0.0;//包装数量
//    private String Package_Unit = "";//包装单位
//    private String Approval_No = "";//批准文号/注册证号
//    private String Approval_No_Valid_Until = "";//批准文号/注册证号有效期至
//    private String Manufacturer_License = "";//生产企业许可证
//    private String Manufacturer_License_Valid_Until = "";//生产企业许可证有效期至
//    private String First_Mta_Manufacturer_License = "";//医疗器械产品注册证或备案凭证编号
//    private String First_Mta_Manufacturer_License_Valid_Until = "";//医疗器械产品注册证或备案凭证编号有效期至
//    private String GMP_License = "";//GMP证件/GSP证件
//    private String GMP_License_Valid_Until = "";//GMP效期/GSP效期
//    private String foodManufacturerLicense = "";//食品生产企业许可证
//    private String foodManufacturerLicenseValidUntil = "";//食品生产企业许可证有效期
//    private String Con_GMP_License = "";//委托GMP
//    private String Con_GMP_License_Valid_Until = "";//委托GMP效期
//    private String Dosage_Form = "";//剂型
//    private String Drug_Cate = "";//药品大类
//    private double M_Package_Qty =0.0;//中包装数量
//    private String Is_Active = "Y";//是否启用
//    private String Status = "1";//状态  1:申请
//    private String Con_Id = "";//委托方ID 见调用通用接口参数
//    private String Creator = "";//申请人  见调用通用接口参数
//    private String Created_Time = LocalDate.now().toString();//申请时间
//    private String Updated_Time = "";//修改时间
//    private String Goods_Length = "";//长
//    private String Goods_Width = "";//宽
//    private String Goods_Height = "";//高
//    private String Goods_Weight = "";//重量
//    private String Storage_Condition = "";//存储条件
//    private String Refrigeration_Type = "";//中文名
//    private String Is_Chilleddrug = "";//是否冷藏药品
//    private String Is_Valuabledrug = "";//是否贵重药品
//    private String Is_Importeddrug = "";//是否进口药品
//    private String Is_Psychotropicdrug = "";//是否精神药品
//    private String Is_2c_Psychotropicdrug = "";//是否二类精神药品
//    private String Is_Specialcontroldrug = "";//是否特管药品
//    private String Is_Hydroxystenozole = "";//是否蛋肽药品
//    private String Business_Model = "";//商品业务模式
//    private String Goods_Type = "";//商品类型
//    private String Cost_Price = "";//成本价
//    private String Retail_Price = "";//零售价
//    private String Wholesale_Price = "";//批发价
//    private String Standard_Pallet_Qty = "";//标准托盘数量(件)
//    private String Ldc_Id = "";//物流中心ID
//    private double Stock_Upperlimit;//库存上限数量
//    private double Stock_Lowerlimit;//库存下限数量
//    private String Download_Side = "1";//单据下传方
//    private String Tcm_Producing_Area = "";//中药产地
//    private String Split_Granularity = "";//拆分粒度
//    private String Min_InvoiceUnit = "";//最小开票单位
//    private String Is_Primary_Control = "";//是否重点控制（养护）
//    private String Drug_Qs = "";//药品质量执行标准
//    private String Prescription_Cate = "";//处方分类
//    private String marketingAuthorisationHolder = "";//上市许可持有人





}
