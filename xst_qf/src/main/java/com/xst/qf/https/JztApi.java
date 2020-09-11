package com.xst.qf.https;


import com.alibaba.fastjson.JSON;
import com.xst.qf.beans.HttpResult;
import com.xst.qf.beans.UploadBase;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class JztApi {
    public static final  String JZT_URL = "https://www.56jzt.com/zuul/sa-oinf/entrance";
    public static final String ID = "11";//用户名
    public static final String PSW = "22";//密码
    /**
     * 测试
     * @param uploadStr
     * @return
     */
    public String testHttp(String uploadStr){
        Map<String, String> map = new HashMap<>();
        OKHttpUtilForSelfSSL http = OKHttpUtilForSelfSSL.Builder();
        String url = JZT_URL;
        System.out.println(url);
        String codeData = "";
        try {
            codeData =  http.postJsonParams
                    (url, JSON.toJSONString(new UploadBase("dw", "saveData",ID,PSW)));
        }catch (Exception e){
        }
        return codeData;
    }
    /**
     * http请求
     * @param uploadBase   上传字符串json
     * @return codeData 接口调用返回数据
     */
    public static HttpResult HttpRequest(UploadBase uploadBase){
        OKHttpUtilForSelfSSL http = OKHttpUtilForSelfSSL.Builder();
        String url = JZT_URL;
        String codeData = "";
        try {
            codeData =  http.postJsonParams
                    (url, JSON.toJSONString(uploadBase));
        }catch (Exception e){
        }
        return JSON.parseObject(codeData, HttpResult.class);
    }
}
