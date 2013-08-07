/**
 * 文件名：BigDecimalUtils.java<br>
 * 作者：lidefu<br>
 * 作成时间：2010-9-17<br>
 * 修改时间：2010-9-17<br>
 * 版本：V1.0
 */
package com.joyin.ticm.common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 类名：BigDecimalUtils.java <br>
 * 说明：<br>
 * 备注：<br>
 * 作者：lidefu
 *
 */
public class BigDecimalUtils {
    private static final int MAX_SCALE = 6;
    //债券记账用
    private static final int MAX_SCALE_SEC = 2;
    
    /**
     * 加法
     * 说明：<br>
     * 备注：<br>
     * @param param1
     * @param param2
     * @return
     */
    public static String add(String param1, String param2){
        if (CommonUtils.isEmptyString(param1)) {
            param1 = "0";
        }
        if (CommonUtils.isEmptyString(param2)) {
            param2 = "0";
        }
        BigDecimal b1 = new BigDecimal(param1);
        BigDecimal b2 = new BigDecimal(param2);
        return String.valueOf(b1.add(b2));
    }
    
    /**
     * 减法
     * 说明：<br>
     * 备注：<br>
     * @param param1
     * @param param2
     * @return
     */
    public static String subtract(String param1, String param2){
        if (CommonUtils.isEmptyString(param1)) {
            param1 = "0";
        }
        if (CommonUtils.isEmptyString(param2)) {
            param2 = "0";
        }
        BigDecimal b1 = new BigDecimal(param1);
        BigDecimal b2 = new BigDecimal(param2);
        return String.valueOf(b1.subtract(b2));
    }

    /**
     * 除法
     * 说明：<br>
     * 备注：<br>
     * @param param1
     * @param param2
     * @return
     */
    public static String divide(String param1, String param2){
        if (CommonUtils.isEmptyString(param1)) {
            param1 = "0";
        }
        if (CommonUtils.isEmptyString(param2)) {
            param2 = "0";
        }
        BigDecimal b1 = new BigDecimal(param1);
        BigDecimal b2 = new BigDecimal(param2);
        return String.valueOf(b1.divide(b2, MAX_SCALE, RoundingMode.HALF_UP));
    }
    /**
     * 除法
     * 说明：<br>
     * 备注：<br>
     * @param param1
     * @param param2
     * @return
     */
    public static String divideScale2(String param1, String param2){
        if (CommonUtils.isEmptyString(param1)) {
            param1 = "0";
        }
        if (CommonUtils.isEmptyString(param2)) {
            param2 = "0";
        }
        BigDecimal b1 = new BigDecimal(param1);
        BigDecimal b2 = new BigDecimal(param2);
        return String.valueOf(b1.divide(b2, MAX_SCALE_SEC, RoundingMode.HALF_UP));
    }
    
    /**
     * 
     * 说明：<br>
     * 备注：输入数字 UP DOWN CEILING FLOOR HALF_UP HALF_DOWN HALF_EVEN UNNECESSARY 
                5.5  6   5     6       5      6       5         6     抛出 ArithmeticException 
               -5.5 -6  -5    -5      -6     -6      -5        -6     抛出 ArithmeticException 
     * @param param1 被除数
     * @param param2 除数
     * @param mode   舍入方式
     * @return
     */
    public static String divide(String param1, String param2, RoundingMode mode){
        if (CommonUtils.isEmptyString(param1)) {
            param1 = "0";
        }
        if (CommonUtils.isEmptyString(param2)) {
            param2 = "0";
        }
        BigDecimal b1 = new BigDecimal(param1);
        BigDecimal b2 = new BigDecimal(param2);
        return String.valueOf(b1.divide(b2, MAX_SCALE, mode));
    }
    
    /**
     * 乘法
     * 说明：<br>
     * 备注：<br>
     * @param param1
     * @param param2
     * @return
     */
    public static String multiply(String param1, String param2){
        if (CommonUtils.isEmptyString(param1)) {
            param1 = "0";
        }
        if (CommonUtils.isEmptyString(param2)) {
            param2 = "0";
        }
        BigDecimal b1 = new BigDecimal(param1);
        BigDecimal b2 = new BigDecimal(param2);
        return String.valueOf(b1.multiply(b2));
    }
    
    /**
     * 比较大小
     * 说明：param1小于、等于或大于param2 时，返回 -1、0 或 1。<br>
     * 备注：值相等但具有不同标度的两个 BigDecimal 对象（如，2.0 和 2.00）被认为是相等的<br>
     * @param param1
     * @param param2
     * @return
     */
    public static int compareTo(String param1, String param2){
        if (CommonUtils.isEmptyString(param1)) {
            param1 = "0";
        }
        if (CommonUtils.isEmptyString(param2)) {
            param2 = "0";
        }
        BigDecimal b1 = new BigDecimal(param1);
        BigDecimal b2 = new BigDecimal(param2);
        return b1.compareTo(b2);
    }
    
    /**
     * 
     * 说明：获取绝对值<br>
     * 备注：<br>
     * @param param1
     * @param param2
     * @return
     */
    public static String abs(String param1){
        if (CommonUtils.isEmptyString(param1)) {
            param1 = "0";
        }
        BigDecimal b1 = new BigDecimal(param1);
        return String.valueOf(b1.abs());
    }
    
    /**
     * 
     * 说明：转化科学计数法<br>
     * 备注：<br>
     * @param arg
     * @return
     */
    public static String doubleToString(double arg){
        BigDecimal b = new BigDecimal(arg);
        return b.toPlainString();
    }
    
    /**
     * 
     * 说明：转化科学计数法<br>
     * 备注：<br>
     * @param arg
     * @return
     */
    public static String StringToString(String arg){
        BigDecimal b = new BigDecimal(arg);
        return b.toPlainString();
    }
}
