package com.joyin.ticm.common.util.logger.appender;

/**
 * LogLog extends org.apache.log4j.helpers.LogLog in order to log log4j info
 * instead of debug and error and warn
 * 
 * @author colin
 * @version 1.0
 * @since Jul 3, 2013, 11:40:48 AM
 */
public class LogLog extends org.apache.log4j.helpers.LogLog {
    private static final String INFO_PREFIX = "log4j:INFO ";

    /**
     * info method to log log4j INFO level messages
     * 
     * @param msg
     *            message to print
     */
    public static void info(String msg) {
        System.out.println(INFO_PREFIX + msg);
    }
}
