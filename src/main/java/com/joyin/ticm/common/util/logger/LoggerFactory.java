package com.joyin.ticm.common.util.logger;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.LogFactory;

/**
 * Logger Factory in charge of returning loggers stored in instances or creating
 * new logger instances if necessary
 * 
 * @author colin
 * @version 1.0
 * @since Jul 3, 2013, 11:40:48 AM
 */
public class LoggerFactory {

    public LoggerFactory() {
    }

    @SuppressWarnings("unchecked")
    public static synchronized ILogger getLogger(String logType, Class<?> clazz) {
        Map<String, Object> instances = (Map<String, Object>) LOGTYPES
                .get(logType);
        if (instances == null) {
            instances = new Hashtable<String, Object>();
            LOGTYPES.put(logType, instances);
        }
        return getLoggerInstance(getShortName(clazz), logType, instances);
    }

    /**
     * Gets the <code>Logger</code> for the Business Tier
     * 
     * @param clazz
     *            the class requesting for the Logger
     * @return ILogger
     */
    @SuppressWarnings("unchecked")
    public static ILogger getBusinessLogger(Class<?> clazz) {
        Map<String, Object> instances = (Map<String, Object>) LOGTYPES
                .get(BUSINESS_LOG);
        return getLoggerInstance(getShortName(clazz), BUSINESS_LOG, instances);
    }

    /**
     * Gets the <code>Logger</code> for the Persistence Tier
     * 
     * @param clazz
     *            the class requesting for the Logger
     * @return ILogger
     */
    @SuppressWarnings("unchecked")
    public static ILogger getPersistenceLogger(Class<?> clazz) {
        Map<String, Object> instances = (Map<String, Object>) LOGTYPES
                .get(PERSISTENT_LOG);
        return getLoggerInstance(getShortName(clazz), PERSISTENT_LOG, instances);
    }

    /**
     * Gets the <code>Logger</code> for the Web Tier
     * 
     * @param clazz
     *            the class requesting for the Logger
     * @return ILogger
     */
    @SuppressWarnings("unchecked")
    public static ILogger getWebLogger(Class<?> clazz) {
        Map<String, Object> instances = (Map<String, Object>) LOGTYPES
                .get(WEB_LOG);
        return getLoggerInstance(getShortName(clazz), WEB_LOG, instances);
    }

    /**
     * Gets the <code>Logger</code> for the Audit Tier
     * 
     * @param clazz
     *            the class requesting for the Logger
     * @return ILogger
     */
    @SuppressWarnings("unchecked")
    public static ILogger getAuditLogger(Class<?> clazz) {
        Map<String, Object> instances = (Map<String, Object>) LOGTYPES
                .get(AUDIT_LOG);
        return getLoggerInstance(getShortName(clazz), AUDIT_LOG, instances);
    }

    /**
     * Gets the <code>Logger</code> for the Alert Tier
     * 
     * @param clazz
     *            the class requesting for the Logger
     * @return ILogger
     */
    @SuppressWarnings("unchecked")
    public static ILogger getAlertLogger(Class<?> clazz) {
        Map<String, Object> instances = (Map<String, Object>) LOGTYPES
                .get(ALERT_LOG);
        return getLoggerInstance(getShortName(clazz), ALERT_LOG, instances);
    }

    /**
     * Gets the <code>Logger</code> for the PERFORMANCE Tier
     * 
     * @param clazz
     *            the class requesting for the Logger
     * @return ILogger
     */
    @SuppressWarnings("unchecked")
    public static ILogger getPerformanceLogger(Class<?> clazz) {
        Map<String, Object> instances = (Map<String, Object>) LOGTYPES
                .get(PERFORMANCE_LOG);
        return getLoggerInstance(getShortName(clazz), PERFORMANCE_LOG,
                instances);
    }

    /**
     * Gets the <code>Logger</code> for the Audit Tier
     * 
     * @param clazz
     *            the class requesting for the Logger
     * @return ILogger
     */
    @SuppressWarnings("unchecked")
    public static ILogger getTaskLogger(Class<?> clazz) {
        Map<String, Object> instances = (Map<String, Object>) LOGTYPES
                .get(TASK_LOG);
        return getLoggerInstance(getShortName(clazz), TASK_LOG, instances);
    }

    /**
     * Release resources used
     */
    @SuppressWarnings("unchecked")
    public void release() {
        log("Releasing resources ...");
        Map<String, Object> instances = null;
        for (Iterator cacheIte = LOGTYPES.values().iterator(); cacheIte
                .hasNext(); instances.clear()) {
            instances = (Map<String, Object>) cacheIte.next();
        }

        LOGTYPES.clear();
        log("Resources released");
    }

    protected static String getKey(Class<?> clazz) {
        return clazz.getName();
    }

    protected static String getShortName(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        else {
            String fullName = clazz.getName();
            int index = fullName.lastIndexOf('.');
            return fullName.substring(++index);
        }
    }

    @SuppressWarnings("all")
    protected static void log(String s) {
    }

    /**
     * Creates a new instance of <code>Logger</code> using the
     * <code>Class</code> as the identifier
     * 
     * @param logType
     *            the log to send statements to
     * @param key
     *            identity key for the class requesting for log
     * @return the Logger instance
     */
    @SuppressWarnings("unchecked")
    protected static ILogger newLoggerInstance(String logType, String key) {
        log((new StringBuilder()).append(
                "Creating new Logger instances of type, ").append(logType)
                .append(", ").append(key).toString());
        Map<String, Object> instances = (Map<String, Object>) LOGTYPES
                .get(logType);
        org.apache.commons.logging.Log log = LogFactory.getLog(logType);
        log("Obtained Log Implementation object");
        Logger logger = new Logger(log, key);
        log("Logger created");
        instances.put(key, logger);
        log((new StringBuilder()).append("Logger placed in cache with key, ")
                .append(key).toString());
        return logger;
    }

    @SuppressWarnings("unchecked")
    private static ILogger getLoggerInstance(String key, String logType,
            Map instances) {
        if (instances.containsKey(key)) {
            log((new StringBuilder()).append("Instance found in ").append(
                    logType).append(" with key, ").append(key).toString());
            return (Logger) instances.get(key);
        }
        else {
            newLoggerInstance(logType, key);
            log((new StringBuilder()).append("Instance not found in ").append(
                    logType).append(" with key, ").append(key).toString());
            return (Logger) instances.get(key);
        }

    }

    public static final String WEB_LOG = "WEB";
    public static final String BUSINESS_LOG = "BIZ";
    public static final String PERSISTENT_LOG = "PERSISTENCE";
    public static final String ALERT_LOG = "ALERT";
    public static final String AUDIT_LOG = "AUDIT";
    public static final String TASK_LOG = "TASK";
    public static final String INTEGRATE_LOG = "INTEGRATE";
    public static final String PERFORMANCE_LOG = "PERFORMANCE";
    private static Map<String, Object> LOGTYPES;

    static {
        LOGTYPES = new Hashtable<String, Object>();
        LOGTYPES.put("BIZ", new Hashtable<String, Object>());
        LOGTYPES.put("WEB", new Hashtable<String, Object>());
        LOGTYPES.put("PERSISTENCE", new Hashtable<String, Object>());
        LOGTYPES.put("ALERT", new Hashtable<String, Object>());
        LOGTYPES.put("AUDIT", new Hashtable<String, Object>());
        LOGTYPES.put("TASK", new Hashtable<String, Object>());
        LOGTYPES.put("PERFORMANCE", new Hashtable<String, Object>());
    }
}
