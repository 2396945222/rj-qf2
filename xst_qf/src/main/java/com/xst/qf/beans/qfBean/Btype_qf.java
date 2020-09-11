package com.xst.qf.beans.qfBean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Btype_qf implements Serializable {
    private String rec;
    private String userCode;
    private String fullName;
    private String PYZJM;
    private String Ssa_Sign;
    private String Is_Hospital_Customer;
    private String Is_Active;
    private String Creator;
    private String Address;
    private String Contact_Name;
    private String Contact_Phone;
    private String Is_Default;
    private String Con_Id;
    private String Bankaccount;
    private String Ssa_Addr_Phone;
    private String Business_Licence_No;//营业执照号
    private String Business_Licence_No_Valid_Until;//营业执照号有效期至
    private String Production_License_No;//生产/经营许可证号
    private String Production_License_No_Valid_Until;//生产/经营许可证号有效期至
    private String GMP_License;//GMP证件/GSP证件
    private String GMP_License_Valid_Until;//GMP效期/GSP效期
}
