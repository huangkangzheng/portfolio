package com.citi.portfoliomanager.constant;

import com.citi.portfoliomanager.util.JSONUtil;

import java.util.Map;

/**
 * Created by hkz on 2017/4/23.
 * 数据词典
 */
public class DictEnum {
    /**-Person类别*/
    /*public static class PersonType{
        *//**user - 学生 *//*
        public static final String COMMON_USER = "Student";
        *//**artist - 管理员 *//*
        public static final String XSC = "XSC";
        *//**学院*//*
        public static final String XY = "XY";
        *//*管理员*//*
        public static final String ADMIN = "ADMIN";

        //管理员角色id，与RoleType对应
        public static final Map jsonMap = JSONUtil.jsonToMap("{1: \"XSC\"," +
                "4:\"XSC\"," +
                "5:\"XSC\"," +
                "}");
        public static String get(long k){ //返回角色
            if(jsonMap.get(String.valueOf(k)) != null) return XSC;
            return COMMON_USER;
        }
    }*/
}
