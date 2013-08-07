/**
 * 文件名：CommonUtil.java<br>
 * 作者：THINKPAD USER<br>
 * 作成时间：2010-7-28<br>
 * 修改时间：2010-7-28<br>
 * 版本：V1.0
 */
package com.joyin.ticm.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import com.joyin.ticm.common.constant.Constant;


/**
 * 类名：CommonUtil.java <br>
 * 说明：<br>
 * 备注：<br>
 * 作者：THINKPAD USER
 */
public class CommonUtils {
	
	// 四舍五入位数
    private static String BITS_TWO = "0.00";

    // 四舍五入位数
    private static String BITS_FOUR = "0.00000";

    /**
     * 说明：判断字符串是否为空<br>
     * 备注：<br>
     * 
     * @param strDesc
     * @return null和空的情况返回true, 否则false
     */
    public static boolean isEmptyString(String strDesc) {
        return strDesc == null || "".equals(strDesc);
    }

    /**
     * 说明：判断List 是否为空<br>
     * 备注：<br>
     * 
     * @param list
     * @return null和空的情况返回true, 否则false
     */
    public static boolean isEmptyList(List<?> list) {
        return list == null || list.size() == 0;
    }

    /**
     * 
     * 说明：付息周期的转化<br>
     * 备注：<br>
     * 
     * @param payCycle
     * @return
     */
    public static int convertPayCycle(String payCycle) {
        if (Constant.PAY_CYCLE_PRE_YEAR.equals(payCycle)) {
            // 如果付息周期为一年付息一次则返回 1
            return 1;
        } else if (Constant.PAY_CYCLE_PRE_HALF_YEAR.equals(payCycle)) {
            // 否则如果付息周期为每半年付息一次则返回 2
            return 2;
        } else if (Constant.PAY_CYCLE_PRE_SEASON.equals(payCycle)) {
            // 否则如果付息周期为每季度付息一次则返回4
            return 4;
        } else if (Constant.PAY_CYCLE_PRE_MONTH.equals(payCycle)) {
            // 否则如果付息周期为每月付息一次则返回12
            return 12;
        } else {
            // 否则返回0
            return 0;
        }
    }
    
    
    /**
     * BigDecimal转String
     * @param data
     * @return
     */
    public static String formatString (int m, BigDecimal deSource){
    	if (null == deSource){
    		deSource = new BigDecimal(0);
        }
        return deSource.setScale(m, BigDecimal.ROUND_HALF_UP).toString();
    }
    
    /**
     * String转BigDecimal
     * @param data
     * @return
     */
    public static BigDecimal formatBigDecimal (String deSource){
    	if (null == deSource || deSource.trim().equals("")){
    		deSource = "0";
        }
        return new BigDecimal(deSource);
    }
    
    /**
     * 
     * 说明：<br>
     * 备注：<br>
     * 
     * @param data
     * @return
     */
    public static String round(String data) {
        if (null == data || data.trim().equals(""))
        {
            data="0";
        }
        BigDecimal deSource = new BigDecimal(data);
        DecimalFormat df = new DecimalFormat(BITS_FOUR);
        double iRound = deSource.setScale(4, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        return df.format(iRound);
    }
    
    /**
     * 两位小数
     * 说明：<br>
     * 备注：<br>
     * 
     * @param data
     * @return
     */
    public static String format(double data) {

        BigDecimal deSource = new BigDecimal(data);
        DecimalFormat df = new DecimalFormat(BITS_TWO);
        double iRound = deSource.setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        return df.format(iRound);
    }
    
    public static BigDecimal doubleToBigDecimal(double data){
    	BigDecimal deSource = new BigDecimal(data);
    	return deSource;
    }
    
    /**
     * 
     * 说明：格式化利率
     * @param data
     * @return
     */
    public static String yield(String data) {
        if (null == data || data.trim().equals(""))
        {
            data="0";
        }
    	DecimalFormat df = new DecimalFormat("0.000000000000");
    	BigDecimal b1 = new BigDecimal(data);
        return df.format(b1);
    }
    
    /**
     * 
     * 说明：格式化利率
     * @param data
     * @return
     */
    public static String yields(String data) {
        if (null == data || data.trim().equals(""))
        {
            data="0";
        }
    	DecimalFormat df = new DecimalFormat("0.0000");
    	BigDecimal b1 = new BigDecimal(data);
        return df.format(b1);
    }
    
    /**
     * 
     * 说明：格式化利率
     * @param data
     * @return
     */
    public static String formatAcctate(String data) {
        if (null == data || data.trim().equals(""))
        {
            data="0";
        }
    	DecimalFormat df = new DecimalFormat("0.00000000");
    	BigDecimal b1 = new BigDecimal(data);
        return df.format(b1);
    }
    
    /**
     * 
     * 说明：格式化利率5位
     * @param data
     * @return
     */
    public static String yields7(String data) {
        if (null == data || data.trim().equals(""))
        {
            data="0";
        }
    	DecimalFormat df = new DecimalFormat("0.0000000");
    	BigDecimal b1 = new BigDecimal(data);
        return df.format(b1);
    }
    
    /**
     * 
     * 说明：格式化单位应计利息 
     * ll add 2011-10-20
     * @param data
     * @return
     */
    public static String accuir(String data) {
        if (null == data || data.trim().equals(""))
        {
            data="0";
        }
    	DecimalFormat df = new DecimalFormat("0.00000");
    	BigDecimal b1 = new BigDecimal(data);
        return df.format(b1);
    }
    
    /**
     * 
     * 说明：格式化利率
     * @param data
     * @return
     */
    public static String yield_dec(String data) {
        if (null == data || data.trim().equals(""))
        {
            data="0";
        }
        DecimalFormat df = new DecimalFormat("0.000000000000");
        BigDecimal b1 = new BigDecimal(data);
        BigDecimal b2 = new BigDecimal(100);

        //b1 = b1.divide(b1,100);
        return df.format(b1.divide(b2));
    }
    /**
     * 
     * 说明：格式化金额
     * @param data
     * @return
     */
    public static String amt(String data) {
        if (null == data || data.trim().equals(""))
        {
            data="0";
        }
        DecimalFormat df = new DecimalFormat("0.0000");
        BigDecimal b1 = new BigDecimal(data);
        return df.format(b1);
    }
    
    /**
     * 
     * 说明：格式化份额
     * @param data
     * @return
     */
    public static String qty(String data) {
        if (null == data || data.trim().equals(""))
        {
            data="0";
        }
        DecimalFormat df = new DecimalFormat("0.0000");
        BigDecimal b1 = new BigDecimal(data);
        return df.format(b1);
    }

    /**
     * 
     * 说明：加负号<br>
     * 备注：<br>
     * 
     * @param data
     * @return
     */
    public static String negativeRound(String data) {
//        BigDecimal deSource = new BigDecimal(data);
        DecimalFormat df = new DecimalFormat(BITS_FOUR);
//        double iRound = -deSource.setScale(4, BigDecimal.ROUND_HALF_UP)
//                .doubleValue();
        if (null == data){
            data = "0";
        }
    	BigDecimal b1 = new BigDecimal(data);
    	BigDecimal b2 = new BigDecimal("-1");
        return df.format(b1.multiply(b2));
    }

//    public static void main(String[] args){
//    	DecimalFormat df = new DecimalFormat("0.00000000");
//    	BigDecimal b1 = new BigDecimal("999999999999999999999999999.0009");
//    	System.out.print(df.format(b1));
//    }
    
    /**
     * 将计息基础类型转换成模型算法中匹配的计息基础
     * 
     * @param type
     *            债项专用，不需要的时候传Null
     * @param base
     *            计息基础
     * @return 模型算法中匹配的计息基础
     */
    public static String convertBasisFromAMSToAlg(String type, String base) {
        // 如果类型为sec并且计息基础为ACTUAL则返回A/A_B
        if ("sec".equals(type) && "ACTUAL".equals(base)) {
            return "A/A_B";
            // 否则如果计息基础为A360则返回A/360
        } else if ("A360".equals(base)) {
            return "A/360";
            // 否则如果计息基础为A365则返回A/365
        } else if ("A365".equals(base)) {
            return "A/365";
            // 否则如果计息基础为NL365则返回A/365F
        } else if ("NL365".equals(base)) {
            return "A/365F";
            // 否则返回计息基础
        } else {
            return base;
        }
    }
    
    /**
     * 
     * 说明：<br>
     * 备注：<br>
     * @param value1
     * @param value2
     * @return
     */
    public static String compareValue(String value1, String value2){
    	// 不为空
    	if(value1 != null && value2 != null){
    		double parm1 = Double.valueOf(value1);
    		double parm2 = Double.valueOf(value2);
    		if(parm1 > parm2){
    			return Constant.STRING_ONE;
    		} else if(parm1 == parm2){
    			return Constant.STRING_ZERO;
    		} else{
    			return Constant.STRING_NEGATIVE_ONE;
    		}
    	} else {
    		return Constant.EMPTY;
    	}
    }
    
    /**
     * 
     * 说明：判断两字符串是否相等
     * 备注：add zhangjian
     * @param str1
     * @param str2
     * @return 1 代表相等 0 不相等
     */
    public static int compareStr(String str1,String str2)
	 {
		 if(str1==null && str2==null)
		 {
			 return 1;
		 }
		 else if(str1==null)
		 {
			 return 0;
		 }
		 else if (str2==null)
		 {
			 return 0;
		 }
		 else 
		 {
			if(str1.equals(str2))
			{
				return 1;
			}
		 }
		 return 0;
	 }
    
    
}
