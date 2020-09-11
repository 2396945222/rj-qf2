package com.xst.qf.utils;

import java.security.MessageDigest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MD5Generator {
    private static final Logger logger = LoggerFactory.getLogger(MD5Generator.class);
    private static MD5Generator instance = null;

    private MD5Generator() {
    }

    public static synchronized MD5Generator getInstance() {
        if (instance == null) {
            instance = new MD5Generator();
        }

        return instance;
    }

    public String encrypt(String str) {
        String methodTitle = logger.isDebugEnabled() ? "【MD5加密字符串】" : "";
        logger.debug(methodTitle + "开始...");
        String returnStr = null;

        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] byteArray = str.getBytes("utf-8");
            byte[] md5Bytes = md5.digest(byteArray);
            StringBuffer hexValue = new StringBuffer();

            for(int i = 0; i < md5Bytes.length; ++i) {
                int val = md5Bytes[i] & 255;
                if (val < 16) {
                    hexValue.append("0");
                }

                hexValue.append(Integer.toHexString(val));
            }

            returnStr = hexValue.toString();
        } catch (Exception var10) {
            if (logger.isDebugEnabled()) {
                var10.printStackTrace();
            } else {
                logger.info(var10.toString());
            }
        }

        logger.debug(methodTitle + str + "的加密结果为：" + returnStr);
        logger.debug(methodTitle + "结束。");
        return returnStr;
    }
}