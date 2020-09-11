package com.xst.qf.beans.jztBean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author zxy
 * @description:九州通入库查询内容
 * @date 2020-07-28 16:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class JztCKJson implements Serializable {
    @JSONField(name = "Operator_Id")
    private String Operator_Id;
    @JSONField(name = "Con_Id")
    private String Con_Id;
    @JSONField(name = "Businessbill_No")
    private String Businessbill_No = "";
    @JSONField(name = "Invoice_Staff")
    private String Invoice_Staff = "%";
    @JSONField(name = "Sale_Type")
    private String Sale_Type = "";
    public JztCKJson(String Businessbill_No, String Sale_Type) {
        this.Operator_Id = Sign_Utils.Operator_Id;
        this.Con_Id = Sign_Utils.Con_id;
        this.Businessbill_No = Businessbill_No;
        this.Invoice_Staff = "%";
        this.Sale_Type = Sale_Type;
    }

}
