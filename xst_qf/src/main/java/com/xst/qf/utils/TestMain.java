package com.xst.qf.utils;
import com.xst.qf.dao.BtypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.*;

public class TestMain {
    @Autowired
    private BtypeDao btypeDao;
    public static void main(String[] args) {
        System.out.println(new Date().getTime());
//        JztApi jztApi = new JztApi();
//        HttpResult str = jztApi.HttpRequest(new UploadBase());
//        System.out.println(str.isFlag());
//        System.out.println(str.getMsgInfo());
//        System.out.println(str.getErrInfo());


//        SortedMap<Object, Object> testMap = new TreeMap<Object, Object>();
//        testMap.put("key1", "value1");
//        testMap.put("key2", "value2");
//        String createSign = createSign(testMap);
//        System.out.println(TestMain.createSign(testMap));

        System.out.println("郑晓羽");
    }
    static String  API_KEY = "zykj_B2B";
    public static String createSign(SortedMap<Object, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        Set<Map.Entry<Object, Object>> set = parameters.entrySet();
        Iterator<Map.Entry<Object, Object>> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<Object, Object> entry = (Map.Entry<Object, Object>) it.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            if (StringUtils.hasText(value) && !"sign".equals(key) && !"key".equals(key)) {
                sb.append(key + "=" + value + "&");
            }
        }
        sb.append("key=" + API_KEY);
        System.out.println(sb.toString());
        String sign = MD5Generator.getInstance().encrypt(sb.toString()).toUpperCase();
        System.out.println(sign);
        return sign;
    }
}
