package com.joyin.ticm.exception;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.exception.SQLGrammarException;

import com.joyin.ticm.dao.DaoException;

/**
 * 自定义应用程序异常处理类.
 * 
 * @author colin
 * @version 1.0
 * @since Jul 4, 2013, 10:07:34 AM
 */
public class TicmException extends Exception {
    private static final long serialVersionUID = 76090001L;
    private String errorCode;

    public TicmException() {
    }

    public TicmException(String errcode) {
        errorCode = errcode;
    }

    public TicmException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public TicmException(String errorCode, Throwable t) {
        super((new StringBuilder()).append("").append(t).toString());

        this.errorCode = errorCode;
    }

    public TicmException(String errorCode, String message, Throwable t) {
        super(
                t == null || message == null || !message.endsWith(t.toString()) ? (new StringBuilder())
                        .append(message).append(":").append(t).toString()
                        : message);
        this.errorCode = errorCode;
    }

    public String toString() {
        return (new StringBuilder()).append(super.toString()).append(
                " [ErrorCode: ").append(explainEnum(errorCode, getClass()))
                .append("]").toString();
    }

    public static String explainEnum(Object value,
            Class<? extends Exception> clazz) {
        List<String> list = decodeEnum(value, clazz);
        if (list.isEmpty())
            return (new StringBuilder()).append(value).append("").toString();
        else
            return (new StringBuilder()).append(value).append(" ").append(list)
                    .toString();
    }

    public static List<String> decodeEnum(Object value,
            Class<? extends Exception> clazz) {
        List<String> list = new ArrayList<String>();
        try {
            Field f[] = clazz.getFields();
            for (int i = 0; i < f.length; i++)
                try {
                    if (Modifier.isFinal(f[i].getModifiers())
                            && value.equals(f[i].get(null))) {
                        list.add(f[i].getName());
                    }
                }
                catch (Exception e) {
                }

        }
        catch (Exception e) {
        }
        return list;
    }

    public List<String> decodeEnum(int value, Class<? extends Exception> clazz) {
        return decodeEnum(new Integer(value), clazz);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String code) {
        errorCode = code;
    }

    /**
     * Get error code and error message from HibernateException.
     * 
     * @param methodName
     *            String
     * @param ex
     *            HibernateException
     * @return String[] The first element is error code, the second element is
     *         error message.
     */
    public static String[] processException(HibernateException ex) {
        String errorCode = null;
        String errorMessage = null;

        // The requested DML operation resulted in a violation of a defined
        // integrity constraint.
        if (ex instanceof ConstraintViolationException) {
            errorCode = DaoException.ERROR_CONSTRAINT_VIOLATION_EXCEPTION;
            errorMessage = "Constraint Violation Exception has occurred.";
            return new String[] { errorCode, errorMessage };
        }
        // Evaluation of the valid SQL statement against the given data resulted
        // in some illegal operation, mismatched types or incorrect cardinality.
        else if (ex instanceof DataException) {
            errorCode = DaoException.ERROR_DATA_EXCEPTION;
            errorMessage = "Data Exception has occurred.";
            return new String[] { errorCode, errorMessage };
        }
        // Generic, non-specific JDBCException.
        else if (ex instanceof GenericJDBCException) {
            errorCode = DaoException.ERROR_GENERIC_JDBC_EXCEPTION;
            errorMessage = "Generic JDBC Related Exception has occurred.";
            return new String[] { errorCode, errorMessage };
        }
        // The data has expired.Operation is not allowed.
        else if (ex instanceof org.hibernate.StaleObjectStateException) {
            errorCode = DaoException.ERROR_TIMESTAMP_VERSION;
            errorMessage = "Row was updated or deleted by another transaction.";
            return new String[] { errorCode, errorMessage };
        }
        // The SQL sent to the database server was invalid.
        else if (ex instanceof SQLGrammarException) {
            errorCode = DaoException.ERROR_SQL_GRAMMAR_EXCEPTION;
            errorMessage = "SQL Grammar Exception has occurred.";
            return new String[] { errorCode, errorMessage };
        }
        else {
            errorCode = DaoException.ERROR_UNKNOWN_EXCEPTION;
            errorMessage = "Unknown exception.";
            return new String[] { errorCode, errorMessage };
        }
    }

}
