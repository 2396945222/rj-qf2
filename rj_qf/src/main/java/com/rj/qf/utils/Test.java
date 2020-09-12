package com.rj.qf.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(7);
        System.out.println(JSON.toJSONString(list));
        String str = "[1,2,3,4,5,6,7]";
        List<Integer> list1  = JSONObject.parseArray(str,Integer.class);
        for (Integer integer : list1) {
            System.out.println(integer);
        }
        String md5 = MD5Generator.getInstance().encrypt(str);
        System.out.println(md5);
        System.out.println(Utils.get3Day());
    }
}
