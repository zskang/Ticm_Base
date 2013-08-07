package com.joyin.ticm.common.constant;

/**
 * 常量类.
 * 
 * @author caowei
 * @version 1.0
 * @since Jul 3, 2013, 11:40:48 AM
 */
public class Constant
{
    /**
     * The PROPERTIE s_ fil e_ location.
     */
    public static interface PropertiesFile
    {
        final String WEB = "web.properties";
        final String KEY = "key.properties";
        final String MESSAGE = "message.properties";
        final String SQL = "sql.properties";
        final String JBPM = "jbpm.properties";
    }

    /**
     * Encryption and Decryption of password
     */
    public static interface CRYPTO
    {
        final String KEYHEX = "ticm.ivhex";
        final String IVHEX = "ticm.keyhex";
    }

    /**
     * A set of server date and time format.
     */
    public static interface DateFormat
    {

        /** default date format. */
        final String DEFAULT_DATE = "yyyyMMdd";

        /** default time format. */
        final String DEFAULT_TIME = "HHmmss";

        /** system line separator. */
        final String LINE_SEPARATOR = System.getProperty( "line.separator" );

        final String DATE_FORMAT_1 = "yyyy-MM-dd HH:mm:ss";
        final String DATE_FORMAT_2 = "ddMMyyyy_HHmmss";
        final String DATE_FORMAT_3 = "ddMMyy";
        final String DATE_FORMAT_4 = "yyyy-MM-dd";
        final String DATE_FORMAT_5 = "ddMMyyyy";
    }
    
    /**
     * 日志类型
     */
    public static interface LogType {
        final String INFO = "0";
        final String WARR = "1";
        final String ERR = "2";
    }
    
    /**
     * 业务编号类型
     * @author xusong
     * @version 1.0
     * @since 2013-7-26, 上午11:01:41
     */
    public static interface BusinessIdType
    {

        /** 约期存放 - 存放申请 */
        final int DEP_DEPOSIT = 1;

        /** 约期存放 - 提前支取 */
        final int DEP_ADVANCE = 2;
    }
    
	/****************************** 付息周期 *******************************/
	// 每年 Y
	public static final String PAY_CYCLE_PRE_YEAR = "Y";
	// 每半年 S
	public static final String PAY_CYCLE_PRE_HALF_YEAR = "S";
	// 每月 M
	public static final String PAY_CYCLE_PRE_MONTH = "M";
	// 每季 Q
	public static final String PAY_CYCLE_PRE_SEASON = "Q";
	// 利随本清
	public static final String PAY_CYCLE_IAM = "DSD";

	/****************************** 营业日准则 *******************************/
	// 向后 S
	public static final String PAY_RULE_SUCCEED = "next";
	// 调整的向后 M
	public static final String PAY_RULE_MODIFY = "adjust";
	// 向前 P
	public static final String PAY_RULE_PRECEDING = "last";
	// 不调整 N
	public static final String PAY_RULE_UNCHANGE = "unchanged";

	/****************************** 利息支付方式 *******************************/
	/**
	 * 利息支付方式:附息
	 */
	public static final String INTCALRULE_NPV = "NPV";
	/**
	 * 利息支付方式:贴现 DIS
	 */
	public static final String INTCALRULE_DIS = "DIS";
	/**
	 * 利息支付方式:零息 ZCO
	 */
	public static final String INTCALRULE_ZCO = "ZCO";
	/**
	 * 利息支付方式:利随本清 IAM
	 */
	public static final String INTCALRULE_IAM = "IAM";

	/****************************** 利率类型 *******************************/
	/**
	 * 利率类型: 固定 FI
	 */
	public static final String INTTYPE_FI = "FI";
	/**
	 * 利率类型:浮动 FL
	 */
	public static final String INTTYPE_FL = "FL";

	/****************************** 利率生效条件 *******************************/
	/**
	 * 利率生效条件:基准利率变动后固定间隔时间生效 H
	 */
	public static final String RATEVALUECDTN_H = "H";
	/**
	 * 利率生效条件:付息前指定日期的有效基准利率 Q
	 */
	public static final String RATEVALUECDTN_Q = "Q";

	/**************************** 基准利率生效方式 *****************************/
	/**
	 * 基准利率生效方式: 付息后生效 F
	 */
	public static final String RATEVALUETYPE_F = "F";
	/**
	 * 基准利率生效方式: 当期生效 D
	 */
	public static final String RATEVALUETYPE_D = "D";
	/**
	 * 基准利率生效方式:指定条件生效 Z
	 */
	public static final String RATEVALUETYPE_Z = "Z";

	/**************************** 利率生效时期 *****************************/
	/**
	 * 利率生效时期: 计息期有效 Q
	 */
	public static final String RATEVALUEPERIOD_Q = "Q";
	/**
	 * 利率生效时期: 计息年度有效 Y
	 */
	public static final String RATEVALUEPERIOD_Y = "Y";

	/**************************** 生成规则,即推算方法,VF 起息日向后, MB 到期日向前, FD 首次付息日 *****************************/
	public static final String VF = "VF";
	public static final String MB = "MB";
	public static final String FD = "FD";

	/**************************** 付息日准则 Succeeding,Preceding,Modified *****************************/
	public static final String SUCCEEDING = "S";
	public static final String PRECEDING = "P";
	public static final String MODIFIED = "M";
	
	
	// 空
	public static final String EMPTY = "";
	// 数字 0
	public static final int NUMBER_ZERO = 0;

	// 数字 1
	public static final int NUMBER_ONE = 1;

	// 数字 2
	public static final int NUMBER_TWO = 2;

	// 数字 3
	public static final int NUMBER_THREE = 3;

	// 数字 3
	public static final int NUMBER_FOUR = 4;

	// 数字 -1
	public static final int NUMBER_NEGATIVE_ONE = -1;

	// 字符：3
	public static final String STRING_THREE = "3";

	// 字符：2
	public static final String STRING_TWO = "2";

	// 字符：1
	public static final String STRING_ONE = "1";

	// 字符：0
	public static final String STRING_ZERO = "0";

	// 字符：-1
	public static final String STRING_NEGATIVE_ONE = "-1";

	// 字符：0.0000
	public static final String STRING_0000 = "0.0000";

	// 1000
	public static final String STRING_1000 = "-1000";

	// 操作标识符 插入：01
	public static final String INSERT_01 = "01";

	// 操作标识符 更新：02
	public static final String UPDATE_02 = "02";

	// 操作标识符 删除：03
	public static final String DELETE_03 = "03";

	// 操作标识符 查询：04
	public static final String SELECT_04 = "04";
}
