package com.xst.qf.beans.jztBean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 　* @description:九州通入库查询内容
 * 　* @author zxy
 * 　* @date 2020-07-28 16:49
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class JztRKJson implements Serializable {
    @JSONField(name = "Operator_Id")
    private String Operator_Id;
    @JSONField(name = "Con_Id")
    private String Con_Id;
    @JSONField(name = "Businessbill_No")
    private String Businessbill_No = "";
    @JSONField(name = "Invoice_Staff")
    private String Invoice_Staff = "%";
    @JSONField(name = "Business_Type")
    private String Business_Type = "";

    public JztRKJson(String Businessbill_No, String Business_Type) {
        this.Operator_Id = Sign_Utils.Operator_Id;
        this.Con_Id = Sign_Utils.Con_id;
        this.Businessbill_No = Businessbill_No;
        this.Invoice_Staff = "";
        this.Business_Type = Business_Type;
    }

}
