package com.joyin.ticm.service;

import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.exception.TicmException;

/**
 * Service层异常处理类
 * 
 * @author colin
 * @version 1.0
 * @since Jul 18, 2013, 9:59:43 AM
 */
public class ServiceException extends TicmException {
    private static final long serialVersionUID = 76100000L;

    // 数据异常
    public static final String ERROR_DATA_EXCEPTION = "76100001";

    // JDBC连接异常
    public static final String ERROR_GENERIC_JDBC_EXCEPTION = "76100002";

    // SQL语句异常
    public static final String ERROR_SQL_GRAMMAR_EXCEPTION = "76100003";

    // 违反约束
    public static final String ERROR_CONSTRAINT_VIOLATION_EXCEPTION = "76100004";

    // 违反主键约束
    public static final String ERROR_PARAM_NULL = "76100005";

    // 时间错误
    public static final String ERROR_TIMESTAMP_VERSION = "76100006";

    // 找不到数据
    public static final String DATE_NOT_FOUNT = "761000007";

    // Hibernate异常
    public static final String ERROR_HIBERNATE = "761000008";

    // 未知异常
    public static final String ERROR_UNKNOWN_EXCEPTION = "76100009";

    /**
     * 数据已更新
     */
    public static final String DATA_HAS_BEEN_UPDATED = "761000012";

    /**
     * Constructs a new ManagerException.
     * 
     * @param errorcode
     *            String
     */
    public ServiceException(String errorcode) {
        super(errorcode);
    }

    /**
     * Constructs a new ManagerException.
     * 
     * @param errorcode
     *            String
     * @param message
     *            String
     */
    public ServiceException(String errorcode, String message) {
        super(errorcode, message);
    }

    /**
     * Constructs a new ManagerException.
     * 
     * @param errorcode
     *            String
     * @param message
     *            String
     * @param t
     *            Throwable
     */
    public ServiceException(String errorcode, String message, Throwable t) {
        super(errorcode, message, t);
    }

    /**
     * Constructs a new ManagerException.
     * 
     * @param errorcode
     *            String
     * @param t
     *            Throwable
     */
    public ServiceException(String errorcode, Throwable t) {
        super(errorcode, t);
    }

    /**
     * Get error code and error message from DaoException.
     * 
     * @param ex
     *            DaoException
     * @return String error code
     */
    public static String processDaoException(DaoException ex) {
        String errorCode = null;

        // The requested DML operation resulted in a violation of a defined
        // integrity constraint.
        if (ex.getErrorCode().equals(
                DaoException.ERROR_CONSTRAINT_VIOLATION_EXCEPTION)) {
            errorCode = ServiceException.ERROR_CONSTRAINT_VIOLATION_EXCEPTION;
        }
        // Evaluation of the valid SQL statement against the given data resulted
        // in some illegal operation, mismatched types or incorrect cardinality.
        else if (ex.getErrorCode().equals(DaoException.ERROR_DATA_EXCEPTION)) {
            errorCode = ServiceException.ERROR_DATA_EXCEPTION;
        }
        // Problems with communicating with the database.
        else if (ex.getErrorCode().equals(
                DaoException.ERROR_GENERIC_JDBC_EXCEPTION)) {
            errorCode = ServiceException.ERROR_GENERIC_JDBC_EXCEPTION;
        }
        // The data has expired.Operation is not allowed.
        else if (ex.getErrorCode().equals(DaoException.ERROR_TIMESTAMP_VERSION)) {
            errorCode = ServiceException.ERROR_TIMESTAMP_VERSION;
        }
        // The SQL sent to the database server was invalid.
        else if (ex.getErrorCode().equals(
                DaoException.ERROR_SQL_GRAMMAR_EXCEPTION)) {
            errorCode = ServiceException.ERROR_SQL_GRAMMAR_EXCEPTION;
        }
        else if (ex.getErrorCode().equals(DaoException.ERROR_HIBERNATE)) {
            errorCode = ServiceException.ERROR_HIBERNATE;
        }
        else {
            errorCode = ServiceException.ERROR_UNKNOWN_EXCEPTION;
        }

        return errorCode;
    }

}
