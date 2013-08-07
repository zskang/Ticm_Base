package com.joyin.ticm.common.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * JSON数据处理工具类
 * 
 * @author colin
 * @version 1.0
 * @since Jul 3, 2013, 11:40:48 AM
 */
public class JsonUtil {

    /**
     * 将普通对象转换成JSON数据
     * 
     * @return String
     */
    public static String objectToJson(Object object) {
        JSONObject jsonObject = JSONObject.fromObject(object);
        return jsonObject.toString();
    }

    /**
     * 将List对象转换成JSON数据
     * 
     * @return String
     */
    @SuppressWarnings("unchecked")
    public static String objectListToJson(List list) {
        JSONArray object = JSONArray.fromObject(list);
        return object.toString();
    }

    /**
     * 将JSON数据转换成类对象
     * 
     * @return Object
     */
    @SuppressWarnings("unchecked")
    public static Object jsonToObject(String jsonString, Class beanClass) {
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        Object object = JSONObject.toBean(jsonObject, beanClass);

        return object;
    }

    /**
     * 将JSON数据转换成List对象
     * 
     * @return List
     */
    @SuppressWarnings("unchecked")
    public static List jsonToObjectList(String jsonString, Class entityClass) {
        JSONArray jsonArray = JSONArray.fromObject(jsonString);
        List objectList = new ArrayList();
        for (Iterator iter = jsonArray.iterator(); iter.hasNext();) {
            JSONObject jsonObject = (JSONObject) iter.next();
            objectList.add(JSONObject.toBean(jsonObject, entityClass));
        }
        return objectList;
    }

    /**
     * 检查JSON对象中是否包含某一键值
     * 
     * @param jsonString
     *            JSON对象
     * @param key
     *            键值名称
     * @return boolean
     */
    public static boolean jsonContainsKey(String jsonString, String keyName) {
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        return jsonObject.containsKey(keyName);
    }

}
