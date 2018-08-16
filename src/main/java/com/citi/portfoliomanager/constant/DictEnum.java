package com.citi.portfoliomanager.constant;

import com.citi.portfoliomanager.util.JSONUtil;

import java.util.Map;

/**
 * Created by hkz on 2017/4/23.
 * DictEnum
 */
public class DictEnum {

    /**
     * Portfolio's default status
     * 0 means active,1 means inactive
     */
    public static Integer STATUS_DEFAULT=0;

    public static class Side{
        public static final Integer BUY=0;
        public static final Integer SELL=1;
    }

    public static class Strategy{
        public static final Integer LIFO=0;
        public static final Integer FIFO=1;
    }

    public static final Integer EACH_DAY=24*3600000;

    public static final Integer DATA_LIST_NUM=20;

    public static final Integer SEARCHPOSITION=0;
}
