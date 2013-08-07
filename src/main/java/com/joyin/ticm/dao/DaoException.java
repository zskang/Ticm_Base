package com.joyin.ticm.dao;

import com.joyin.ticm.exception.TicmException;

/**
 * 数据库异常管理类
 * 
 * @author colin
 * @version 1.0
 * @since Jul 4, 2013, 10:07:34 AM
 */
public class DaoException extends TicmException {
    private static final long serialVersionUID = 76080000L;

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
     * Constructs a new DaoException.
     */
    public DaoException() {
        super();
    }

    /**
     * Constructs a new EnltDaoException.
     * 
     * @param errorCode
     *            error code
     * @param throwable
     *            cause
     */
    public DaoException(String errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    /**
     * Constructs a new EnltDaoException.
     * 
     * @param errorCode
     *            error code
     * @param message
     *            description
     * @param throwable
     *            cause
     */
    public DaoException(String errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }
}
