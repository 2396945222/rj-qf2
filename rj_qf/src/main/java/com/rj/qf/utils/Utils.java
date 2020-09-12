package com.rj.qf.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 　* @description:公共类
 　* @author zxy
 　* @date 2020-09-02 10:12
 　*/
public class Utils {
    public  static  String BUY_EUSER_NAME = "00006";//采购操作员名称
    public  static  String SALE_EUSER_NAME = "00006";//销售操作员名称
     public static String  get3Day(){
         Calendar calendar2 = Calendar.getInstance();
         SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd ");
         calendar2.add(Calendar.DATE, 3);
         String three_days_after = sdf2.format(calendar2.getTime());
//         System.out.println(calendar2.getTime());
         return three_days_after;
     }

}
