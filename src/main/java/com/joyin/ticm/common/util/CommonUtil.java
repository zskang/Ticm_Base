package com.joyin.ticm.common.util;

import java.io.PrintWriter;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 常用工具类
 * 
 * @author colin
 * @version 1.0
 * @since Jul 3, 2013, 11:40:48 AM
 */
public class CommonUtil {
    public static String trim(String val) {
        if (CommonUtil.isEmpty(val)) {
            return "";
        }
        else {
            return val.trim();
        }
    }

    public static int getSize(List<?> list) {
        if (CommonUtil.isEmpty(list)) {
            return 0;
        }
        else {
            return list.size();
        }
    }

    public static String nvl(String val, String defValue) {
        if (isEmpty(trim(val))) {
            return defValue;
        }
        else {
            return trim(val);
        }
    }

    /**
     * Add by weiwei in phase3 Translate the List<String> to List<Long>
     * 
     * @param list
     * @return List<Long>
     */
    public static List<Long> translateList(List<String> list) {
        ArrayList<Long> longList = new ArrayList<Long>();
        if (list == null || list.isEmpty()) {
            return longList;
        }

        for (String str : list) {
            longList.add(Long.valueOf(str.trim()));
        }

        return longList;
    }

    /**
     * Encodes <code>val</code> for URL parameter.
     * 
     * @param val
     * @param enc
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String URLEncode(String val, String enc)
            throws UnsupportedEncodingException {
        String str = URLEncoder.encode(CommonUtil.nvl(val, ""), enc);

        return str;
    }

    /**
     * Encodes <code>val</code> for URL parameter.
     * 
     * @param val
     * @return String
     */
    public static String URLEncode(String val) {
        String str;
        try {
            str = CommonUtil.URLEncode(val, "utf-8");
        }
        catch (UnsupportedEncodingException uee) {
            str = ""; // will not come here since "utf-8" is supported
        }
        catch (Exception e) {
            str = "";
        }

        return str;
    }

    /**
     * validate object is or not Empty
     * 
     * @param obj
     * @return boolean
     */
    public static boolean isEmpty(Object obj) {
        if (null == obj)
            return true;

        if (obj instanceof List<?>) {
            return ((List<?>) obj).size() <= 0;
        }

        if (obj instanceof Map<?, ?>) {
            return ((Map<?, ?>) obj).size() <= 0;
        }

        if (obj instanceof Set<?>) {
            return ((Set<?>) obj).size() <= 0;
        }

        if (obj instanceof String) {
            return ((String) obj).trim().length() <= 0;
        }

        if (obj instanceof StringBuffer) {
            return ((StringBuffer) obj).toString().length() <= 0;
        }

        return false;
    }

    /**
     * validate object is or not Empty
     * 
     * @param obj
     * @return boolean
     * @author colin
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * format Message
     * 
     * @param pattern
     * @param objects
     * @return String
     * @author colin
     */
    public static String formatMessage(String pattern, Object... objects) {
        String formatted = "";
        formatted = MessageFormat.format(pattern, objects);
        return formatted;
    }

    /**
     * get Exception StackTrace message
     * 
     * @param aThrowable
     * @return String
     * @author colin
     */
    public static String getStackTrace(Throwable aThrowable) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        aThrowable.printStackTrace(printWriter);
        return result.toString();
    }

    /**
     * fix string for CSV cell content, replace " to "" ,add " to front and end
     * 
     * @param content
     * @return
     */
    public static String fixStringForCSVCell(String content) {
        return "\"".concat(content.replace("\"", "\"\"")).concat("\"");
    }

    /**
     * just return , for CSV new cell
     * 
     * @return
     */
    public static String getNewCellForCSV() {
        return ",";
    }

    /**
     * just return \r\n for CSV new line
     * 
     * @return
     */
    public static String getNewLineForCSV() {
        return "\r\n";
    }

}
