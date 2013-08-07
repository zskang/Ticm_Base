/**
 * 文件名：DateUtils.java<br>
 * 作者：THINKPAD USER<br>
 * 作成时间：2010-7-28<br>
 * 修改时间：2010-7-28<br>
 * 版本：V1.0
 */
package com.joyin.ticm.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.joyin.alg.common.AlgCommonConstants;

import exception.UnitException;

/**
 * 类名：DateUtils.java <br>
 * 说明：<br>
 * 备注：<br>
 * 作者：THINKPAD USER
 */
public class DateUtils {

    // 一天是多少毫秒
    public final static long DAY = 24L * 60L * 60L * 1000L;

    public static int getBetweenDayNumber(Date d1, Date d2) {
        // 根据兩個个日期，取得相隔的天数
        long dayNumber = 0;
        try {
            // 计算两个日期的时间差（以毫秒记）
            dayNumber = (d2.getTime() - d1.getTime()) / DAY;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (int) dayNumber;
    }

    public static int getBetweenDayNumber(String date1, String date2) {
        // 根据兩個个日期，取得相隔的天数
        long dayNumber = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = sdf.parse(date1);
            Date d2 = sdf.parse(date2);
            // 计算两个日期的时间差（以毫秒记）
            dayNumber = (d2.getTime() - d1.getTime()) / DAY;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (int) dayNumber;
    }

    /**
     * 说明：比较两个日期大小,Calendar格式<br>
     * 备注：cal1>cal2 返回1 ,cal1 = cal2 返回0 , cal1 <cal2 返回 -1<br>
     * @param cal1 日期1
     * @param cal2 日期2
     * @return 比较结果
     */
    public static int CompareDate(Calendar cal1, Calendar cal2) {
        if (cal1.getTimeInMillis() > cal2.getTimeInMillis()) {
            return 1;
        } else if (cal1.getTimeInMillis() == cal2.getTimeInMillis()) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 说明：比较两个日期大小,Date格式<br>
     * 备注：date1>date2 返回1 ,date1 = date2 返回0 , date1 <date2 返回 -1<br>
     * @param date1 日期1
     * @param date2 日期2
     * @return 比较结果
     */
    public static int CompareDate(Date date1, Date date2) {
        if (date1.getTime() > date2.getTime()) {
            return 1;
        } else if (date1.getTime() == date2.getTime()) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 说明：比较两个日期大小,YYYY-MM-DD格式<br>
     * 备注：d1>d2 返回1 ,d1 = d2 返回0 , d1 <d2 返回 -1<br>
     * @param d1 日期1
     * @return 比较结果
     * @throws ParseException 格式转化异常
     */
    public static int CompareDate(String d1, String d2) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(AlgCommonConstants.DATE_FORMAT_YYYY_MM_DD);
        Date date1 = sdf.parse(d1);
        Date date2 = sdf.parse(d2);
        return CompareDate(date1, date2);
    }

    /*
     * 计算一个日期加上payment_freq*payment_unit后的日期 payment_freq 收付息周期
     */
    public static Date addDate(Date d, int payment_freq, String payment_unit)
            throws ParseException, UnitException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        if (payment_unit.equals("D")) {
            cal.add(Calendar.DAY_OF_MONTH, payment_freq);
        } else if (payment_unit.equals("M")) {

            cal.add(Calendar.MONTH, payment_freq);
        } else if (payment_unit.equals("Y")) {
            cal.add(Calendar.YEAR, payment_freq);
        } else {
            throw new UnitException();
        }
        return cal.getTime();
    }

    public static int getMonth(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        // 月份从0-11
        int ke = cal.get(Calendar.MONTH) + 1;
        return ke;
    }
    
    /**
     * 
     * 说明：获取年<br>
     * 备注：<br>
     * @param date
     * @return
     * @throws ParseException
     */
    public static int getYear(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        int ke = cal.get(Calendar.YEAR);
        return ke;
    }

    /*
     * 计算一个日期加上day天后的日期 date为“yyyy-MM-dd”的形式
     *
     */
    public static String addDate(String date, int day) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.DAY_OF_MONTH, day);
        return sdf.format(cal.getTime());
    }

    /*
     * 计算一个日期加上day天后的日期 date为“yyyy-MM-dd”的形式
     *
     */
    public static Date addDate(Date date, int day) {
        Date d = date;
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

    /*
     * 计算一个日期加上day天后的日期 date为“yyyy-MM-dd”的形式
     *
     */
    public static Calendar addDate(Calendar cal, int day) {
        cal.add(Calendar.DAY_OF_MONTH, day);
        return cal;
    }

    /**
     * 获取当前系统时间
     */
    public static String getSysDate() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
    }
    
    public static String getSysDatetime(){
    	return new SimpleDateFormat("yyyyMMddhhmmssSSS").format(Calendar.getInstance().getTime());
    }

    /**
     * 说明： 判断两个日期段是否交叉<br>
     * 备注：算头不算尾<br>
     * @param date1F
     * @param date1T
     * @param date2F
     * @param date2T
     * @return
     * @throws ParseException
     */
    public static boolean isDateCross(String date1F, String date1T, String date2F, String date2T)
            throws ParseException {
        // 日期段2的起始日介于日期段1区间内
        if (CompareDate(date1F, date2F) <= 0 && CompareDate(date2F, date1T) < 0) {
            return true;
            // 日期段1的起始日介于日期段2区间内
        } else if (CompareDate(date2F, date1F) <= 0 && CompareDate(date1F, date2T) < 0) {
            return true;
            // 其余场合
        } else {
            return false;
        }
    }

    /**
     * 将double型的数字m保留n位小数
     */
    public static double getPrecision(double m, int n) {
        return Math.round(m * Math.pow(10, n)) / Math.pow(10, n);
    }

    /**
     * 判断是不是一个月的最后一天
     *
     */
	public static boolean isLstDayOfMonth(String date) throws ParseException {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        
        Date targetDate = cal.getTime();
        Calendar targetCalendar = Calendar.getInstance();
        targetCalendar.setTime(targetDate);
        if(targetCalendar.get(Calendar.MONTH) 
    			!= cal.get(Calendar.MONTH)){
        	return false;
        }else {
			return true;
		}
    }
    
	/**
     * 获取一个月的第一天
     *
     */
	public static String getfstDayOfMonth(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(date);
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        
        Date targetDate = cal.getTime();
        Calendar targetCalendar = Calendar.getInstance();
        
        for(int i=0;i<31;i++){
        	cal.add(Calendar.DAY_OF_MONTH, -1);
        	targetDate = cal.getTime();
        	targetCalendar.setTime(targetDate);
        	if(targetCalendar.get(Calendar.MONTH) 
        			!= cal.get(Calendar.MONTH)){
            	break;
            }
        }
        return sdf.format(targetDate);
    }
	
    /**
     * 获取一个月的最后一天
     *
     */
	public static String getLstDayOfMonth(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(date);
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        
        Date targetDate = cal.getTime();
        Calendar targetCalendar = Calendar.getInstance();
        
        for(int i=0;i<31;i++){
        	cal.add(Calendar.DAY_OF_MONTH, 1);
        	targetDate = cal.getTime();
        	targetCalendar.setTime(targetDate);
        	if(targetCalendar.get(Calendar.MONTH) 
        			!= cal.get(Calendar.MONTH)){
            	break;
            }
        }
        return sdf.format(targetDate);
    }
	
	/**
     * 获取上个月的最后一天
     *
     */
	public static String getLstDayOfLstMonth(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MONTH, -1);
        
        return getLstDayOfMonth(sdf.format(cal.getTime()));
    }
	
	/**
     * 获取去年同期最后一天
     *
     */
	public static String getLstDayOfLstYearTermMonth(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.YEAR, -1);
        
        return getLstDayOfMonth(sdf.format(cal.getTime()));
    }
	
	/**
     * 获取去年最后一天
     *
     */
	public static String getLstDayOfLstYear(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.YEAR, -1);
        
        return getLstDayOfMonth(sdf.format(cal.getTime()));
    }
}
