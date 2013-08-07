package com.joyin.ticm.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.joyin.ticm.common.util.SqlUtil;
import com.joyin.ticm.common.util.logger.ILogger;
import com.joyin.ticm.common.util.logger.LoggerFactory;
import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.log.model.Log;

/**
 * DAO操作基类.
 * 
 * @author colin
 * @version 1.0
 * @since Jul 4, 2013, 10:07:34 AM
 */
public abstract class AbstractDao extends HibernateDaoSupport {

    /** The persist logger. */
    private ILogger persistLogger;

    private StringBuilder logBuffer;

    protected ILogger auditlogger;

    /**
     * Mother of all DAO constructor. All subclasses having own constructor must
     * remember to perform this constructor.
     */
    public AbstractDao() {
        initialiseLogBuffer();
    }

    /**
     * Writes the log buffer to the log at the INFO level. Buffer is flushed
     * after writing to log.
     * 
     * @param methodName
     *            name of method calling this logging method.
     */
    protected void flushBuffer(String methodName) {
        if (logBuffer != null) {
            info(methodName, logBuffer.toString());
        }
        initialiseLogBuffer();
    }

    /**
     * Add a string of text as a new line to the buffer.
     * 
     * @param text
     *            String to be added to the buffer.
     */
    protected void logBuffer(String text) {

        logBuffer.append(System.getProperty("line.separator"));
        logBuffer.append(text);
    }

    /**
     * Outputs a debug log.
     * 
     * @param methodName
     *            method name
     * @param message
     *            message
     */
    protected void debug(String methodName, String message) {
        _getPersistLogger().debug(methodName, message);
    }

    /**
     * Outputs an info log.
     * 
     * @param methodName
     *            method name
     * @param message
     *            message
     */
    protected void info(String methodName, String message) {
        _getPersistLogger().info(methodName, message);
    }

    /**
     * Outputs a warn log.
     * 
     * @param methodName
     *            method name
     * @param message
     *            message
     */
    protected void warn(String methodName, String message) {
        _getPersistLogger().warn(methodName, message);
    }

    /**
     * Outputs an error log with throwable.
     * 
     * @param methodName
     *            method name
     * @param message
     *            message
     * @param t
     *            throwable to dump
     */
    protected void error(String methodName, String message, Throwable t) {
        _getPersistLogger().error(methodName, message, t);
    }

    /**
     * Outputs an error log with no throwable.
     * 
     * @param methodName
     *            method name
     * @param message
     *            message
     */
    protected void error(String methodName, String message) {
        error(methodName, message, null);
    }

    /**
     * Outputs a fatal error log with throwable.
     * 
     * @param methodName
     *            method name
     * @param message
     *            message
     * @param t
     *            throwable to dump
     */
    protected void fatal(String methodName, String message, Throwable t) {
        _getPersistLogger().fatal(methodName, message, t);
    }

    /**
     * Outputs a fatal error log with no throwable.
     * 
     * @param methodName
     *            method name
     * @param message
     *            message
     */
    protected void fatal(String methodName, String message) {
        fatal(methodName, message, null);
    }

    /**
     * Outputs a audit log with no throwable.
     * 
     * @param methodName
     * @param message
     */
    protected void audit(String methodName, String message) {
        getAuditLogger().info(
                (new StringBuilder()).append(methodName).append("():").append(
                        message).toString());
    }

    /**
     * Save Log into DB
     * 
     * @param methodName
     * @param message
     */
    protected void saveLogToDB(Log log) {
        // this.getSession().save(log);
    }

    protected String getSQLOrHQLText(String keyValue) {
        return SqlUtil.getText(keyValue);
    }

    /**
     * 将HibernateException转换为DaoException.
     * 
     * @param methodName
     *            方法名
     * @param ex
     *            HibernateException
     * @return DaoException DaoException
     */
    protected DaoException processHibernateException(String methodName,
            HibernateException ex, Transaction tx) {
        String[] errorCodeAndMessage = DaoException.processException(ex);
        error(methodName, errorCodeAndMessage[1], ex);
        return new DaoException(errorCodeAndMessage[0], ex);
    }

    /**
     * clear the log buffer. No logs are written to.
     */
    private void initialiseLogBuffer() {
        logBuffer = new StringBuilder();
    }

    /**
     * Gets the business logger.
     * 
     * @return ILogger the logger.
     */
    private synchronized ILogger _getPersistLogger() {
        if (persistLogger == null)
            persistLogger = LoggerFactory.getPersistenceLogger(this.getClass());
        return persistLogger;
    }

    /**
     * get Interface object ILogger
     * 
     * @return ILogger
     */
    private synchronized ILogger getAuditLogger() {
        if (auditlogger == null)
            auditlogger = LoggerFactory.getAuditLogger(this.getClass());
        return auditlogger;
    }

}
