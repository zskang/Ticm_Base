package com.joyin.ticm.common.util.logger;

import org.apache.commons.logging.Log;

/**
 * Logger Implementation
 * 
 * @author colin
 * @version 1.0
 * @since Jul 3, 2013, 11:40:48 AM
 */
public class Logger implements ILogger {

    public Logger(String id) {
        this.id = id;
        formatter = new Formatter();
    }

    public Logger(Log impl, String id) {
        logImpl = impl;
        this.id = id;
        formatter = new Formatter();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getLogType() {
        return logType;
    }

    public String getType() {
        return TYPE;
    }

    public void debug(String msg) {
        logImpl.debug(format(msg));
    }

    public void debug(String msg, Throwable ex) {
        logImpl.debug(format(msg), ex);
    }

    public void debug(String method, String msg) {
        logImpl.debug(format(method, msg));
    }

    public void debug(String method, String msg, Throwable ex) {
        logImpl.debug(format(method, msg), ex);
    }

    public void error(String msg, Throwable ex) {
        logImpl.error(format(msg), ex);
    }

    public void error(String msg) {
        logImpl.error(format(msg));
    }

    public void fatal(String msg) {
        logImpl.fatal(format(msg));
    }

    public void fatal(String msg, Throwable ex) {
        logImpl.fatal(format(msg), ex);
    }

    public void info(String msg) {
        logImpl.info(format(msg));
    }

    public void info(String msg, Throwable ex) {
        logImpl.info(format(msg), ex);
    }

    public void warn(String msg) {
        logImpl.warn(format(msg));
    }

    public void warn(String msg, Throwable ex) {
        logImpl.warn(format(msg), ex);
    }

    protected String format(String msg) {
        return formatter.format(id, msg);
    }

    protected String format(String method, String msg) {
        return formatter.format(id, method, msg);
    }

    public void setFormatter(IFormatter formatter) {
        this.formatter = (Formatter) formatter;
    }

    public void error(String method, String msg) {
        logImpl.error(format(method, msg));
    }

    public void error(String method, String msg, Throwable ex) {
        logImpl.error(format(method, msg), ex);
    }

    public void fatal(String method, String msg) {
        logImpl.fatal(format(method, msg));
    }

    public void fatal(String method, String msg, Throwable ex) {
        logImpl.fatal(format(method, msg), ex);
    }

    public void info(String method, String msg) {
        logImpl.info(format(method, msg));
    }

    public void info(String method, String msg, Throwable ex) {
        logImpl.info(format(method, msg), ex);
    }

    public void warn(String method, String msg) {
        logImpl.warn(format(method, msg));
    }

    public void warn(String method, String msg, Throwable ex) {
        logImpl.warn(format(method, msg), ex);
    }

    private static String TYPE = "Commons-Logging";
    private Log logImpl;
    private String id;
    private String logType;
    private Formatter formatter;
}
