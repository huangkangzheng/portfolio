package com.citi.portfoliomanager.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
//import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * @ClassName: JSONUtil
 * @Description: TODO
 * @Function List: TODO
 * @author: xtf
 * @version:
 * @Date: 2016/3/4 15:48
 * @History: //历史修改记录
 * <author>  // 修改人
 * <time> //修改时间
 * <version> //版本
 * <desc> // 描述修改内容
 */
public class JSONUtil {
    protected static final Logger logger = LogManager.getLogger(JSONUtil.class);
    private static SerializeConfig mapping = new SerializeConfig();
    private static String dateFormat;

    static {
        dateFormat = "yyyy-MM-dd HH:mm:ss";
        mapping.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
    }

    /**
     * 对象转json字符串
     *
     * @param obj
     * @return
     */
    public static String toJsonString(Object obj) {
        try {
            ;
            return JSON.toJSONString(obj, mapping);
        } catch (Exception e) {
            logger.error(e);
            logger.info("json tranfer failure");
            return "";
        }

    }

    /**
     * 获取json字符串中指定属性名的值
     *
     * @param json
     * @param propertyName
     * @return
     */
    public static Object getPropertyValue(String json, String propertyName) {
        try {
            JSONObject obj = JSON.parseObject(json);
            return obj.get(propertyName);
        } catch (Exception e) {
            logger.error(e);
            logger.info("json tranfer failure");
            return null;
        }
    }

    /**
     * 获取json字符串中指定属性名String值
     *
     * @param json
     * @param propertyName
     * @return
     */
    public static String getPropertyStrValue(String json, String propertyName) {
        try {
            JSONObject obj = JSON.parseObject(json);
            String str = (String) (obj.get(propertyName));
            if (str != null)
                return str;
            return "";
        } catch (Exception e) {
            logger.error(e);
            logger.info("json tranfer failure");
            return "";
        }
    }


    /**
     * 移除json字符串中指定属性名，并返回移除后的结果
     *
     * @param json
     * @param propertyName
     * @return
     */
    public static String removeProperty(String json, String propertyName) {
        try {
            JSONObject obj = JSON.parseObject(json);
            Set set = obj.keySet();
            Object propertyValue = set.remove(propertyName);
            return obj.toString();
        } catch (Exception e) {
            logger.error(e);
            logger.info("json tranfer failure");
            return "";
        }
    }

    /**
     * 修改json中的某个属性的值
     *
     * @param json
     * @param propertyName
     * @param propertyValue
     * @return
     */
    public static String updateProperty(String json, String propertyName, Object propertyValue) {
        try {
            JSONObject obj = JSON.parseObject(json);
            Set set = obj.keySet();
            if (set.contains(propertyName))
                obj.put(propertyName, JSON.toJSONString(propertyValue));
            return obj.toString();
        } catch (Exception e) {
            logger.error(e);
            logger.info("json tranfer failure");
            return "";
        }
    }

    /**
     * 判断json中是否存在某属性
     *
     * @param json
     * @param propertyName
     * @return
     */
    public static boolean isContainProperty(String json, String propertyName) {
        try {
            boolean isContain = false;
            JSONObject obj = JSON.parseObject(json);
            Set set = obj.keySet();
            isContain = set.contains(propertyName);
            return isContain;
        } catch (Exception e) {
            logger.error(e);
            logger.info("json tranfer failure");
            return false;
        }
    }

    /**
     * 添加json字符串中新的属性及对应的值，并返回添加后的结果
     *
     * @param json
     * @param propertyName
     * @param propertyValue
     * @return
     */
    public static String addProperty(String json, String propertyName, Object propertyValue) {
        try {
            JSONObject obj = JSON.parseObject(json);
            if (propertyValue instanceof String) {
                obj.put(propertyName, propertyValue);//如果是字符串不需要再转成json
            } else {
                obj.put(propertyName, JSON.toJSONString(propertyValue));
            }
            return obj.toString();
        } catch (Exception e) {
            logger.error(e);
            logger.info("json tranfer failure");
            return "";
        }
    }


    /**
     * 添加多个属性
     *
     * @param json
     * @param propertyMap
     * @return
     */
    public static String addProperties(String json, Map<String, Object> propertyMap) {
        try {
            JSONObject obj = JSON.parseObject(json);
            Set<String> set = propertyMap.keySet();
            for (String key : set) {
                Object propertyValue = propertyMap.get(key);
                if (propertyValue instanceof String) {
                    obj.put(key, propertyValue);//如果是字符串不需要再转成json
                } else {
                    obj.put(key, JSON.toJSONString(propertyValue));
                }

            }
            return obj.toString();
        } catch (Exception e) {
            logger.error(e);
            logger.info("json tranfer failure");
            return "";
        }
    }

    /**
     * 添加多个属性
     *
     * @param propertyMap
     * @return
     */
    public static String addProperties(Map<String, Object> propertyMap) {
        try {
            JSONObject obj = new JSONObject();
            Set<String> set = propertyMap.keySet();
            for (String key : set) {
                Object propertyValue = propertyMap.get(key);
                obj.put(key, propertyValue);
            }
            return toJsonString(obj);
        } catch (Exception e) {
            logger.error(e);
            logger.info("json tranfer failure");
            return "{}";
        }
    }


    /**
     * 先将对象转成json字符串，并添加新的属性
     *
     * @param obj
     * @param propertyName
     * @param propertyValue
     * @return
     */
    public static String convertAndAddProperty(Object obj, String propertyName, Object propertyValue) {
        try {
            String json = toJsonString(obj);
            return addProperty(json, propertyName, propertyValue);
        } catch (Exception e) {
            logger.error(e);
            logger.info("json tranfer failure");
            return "";
        }
    }


    /**
     * json字符串转JSONObject
     *
     * @param json
     * @return
     */
    public static JSONObject toJsonObject(String json) {
        try {
            return JSON.parseObject(json);
        } catch (Exception e) {
            logger.error(e);
            logger.info("json tranfer failure");
            return null;
        }
    }

    /**
     * json字符串转javaBean对象
     *
     * @param str
     * @param clazz
     * @return
     */
    public static Object toBean(String str, Class<?> clazz) {
        try {
            return JSON.parseObject(str, clazz);
        } catch (Exception e) {
            logger.error(e);
            logger.info("json tranfer failure");
            return null;
        }
    }

    public static List toBeanList(String str, Class<?> clazz) {
        try {
            List list = new ArrayList();
            JSONArray jsonArray = JSONArray.parseArray(str);
            for (int i = 0; i < jsonArray.size(); i++) {
                list.add(toBean(jsonArray.get(i).toString(), clazz));
            }
            return list;
        } catch (Exception e) {
            logger.error(e);
            logger.info("json tranfer failure");
            return null;
        }
    }


    /**
     * 将数组形式的json字符串转成List
     *
     * @param jsonStr
     * @return
     */
    public static List<String> jsonArrayToList(String jsonStr) {
        try {
            List<String> messages = new ArrayList<String>();
            JSONArray jsonArray = JSONArray.parseArray(jsonStr);
            for (int i = 0; i < jsonArray.size(); i++) {
                String message = (jsonArray.get(i)).toString();//必须使用toString
                messages.add(message);
            }
            return messages;
        } catch (Exception e) {
            logger.error(e);
            logger.info("transfer jsonArray failure");
            return null;
        }
    }


    public static Map jsonToMap(String json) {
        return JSON.parseObject(json);
    }


/*    *//**
     * 组装easyui分页
     * @param rows
     * @param <T>
     * @return
     *//*
    public static <T> String pageHelper(List<T> rows) {
        PageInfo p = new PageInfo<T>(rows);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("total",Long.valueOf(p.getTotal()));
        map.put("rows",rows);
        String result =  JSONUtil.addProperties(map);
        logger.info(result);
        return result;
    }
    *//**
     * 组装easyui分页
     * @param rows
     * @param <T>
     * @return
     *//*
    public static <T> long getTotalPage(List<T> rows, int pageSize) {
        PageInfo p = new PageInfo<T>(rows);
        return  (p.getTotal() - 1) / pageSize + 1;
    }

    *//**
     * 组装easyui分页
     * @param rows：数据
     * @param pageSize: 每页的数量
     * @param <T>
     * @return
     *//*
    public static <T> String pageHelper(List<T> rows, int pageSize) {
        PageInfo p = new PageInfo<T>(rows);
        Map<String,Object> map = new HashMap<String, Object>();
        long size = p.getTotal() / pageSize;
        size = p.getTotal() % pageSize == 0 ? size : size + 1;
        map.put("total",Long.valueOf(size));
        map.put("rows",rows);
        logger.debug("total:" + size);
        String result =  JSONUtil.addProperties(map);
        return result;
    }*/

}
