package com.joyin.ticm.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import com.joyin.ticm.common.constant.Constant;
import com.joyin.ticm.common.enums.BusinessType;
import com.joyin.ticm.common.util.SqlUtil;
import com.joyin.ticm.common.util.logger.ILogger;
import com.joyin.ticm.common.util.logger.LoggerFactory;
import com.joyin.ticm.dao.BaseDao;
import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.log.model.Log;

/**
 * Service层基类
 * 
 * @author colin
 * @version 1.0
 * @since Jul 18, 2013, 9:59:43 AM
 */
public abstract class ServiceBase {
    private ILogger logger;
    private ILogger auditlogger;

    @Resource
    private BaseDao baseDao;

    private static final String SERIAL_NUMBER = "XXXX"; // 流水号格式

    public void debug(String methodName, String message) {
        getBusinessLogger().debug(
                (new StringBuilder()).append(methodName).append("():").append(
                        message).toString());
    }

    public void info(String methodName, String message) {
        getBusinessLogger().info(
                (new StringBuilder()).append(methodName).append("():").append(
                        message).toString());
    }

    public void warn(String methodName, String message) {
        getBusinessLogger().warn(
                (new StringBuilder()).append(methodName).append("():").append(
                        message).toString());
    }

    public void error(String methodName, String message, Throwable t) {
        getBusinessLogger().error(
                (new StringBuilder()).append(methodName).append("():").append(
                        message).toString(), t);
    }

    public void error(String methodName, String message) {
        error(methodName, message, null);
    }

    public void fatal(String methodName, String message, Throwable t) {
        getBusinessLogger().fatal(
                (new StringBuilder()).append(methodName).append("():").append(
                        message).toString(), t);
    }

    public void fatal(String methodName, String message) {
        fatal(methodName, message, null);
    }

    public void audit(String methodName, String message) {
        getAuditLogger().info(
                (new StringBuilder()).append(methodName).append("():").append(
                        message).toString());
    }

    /**
     * 获取业务编号
     * 
     * @param businessType
     * @return
     * @author xusong
     */
    public String getBusinessId(int businessIdType, String orgId) {
        String objName = "";
        String objIdName = "";
        String preNum = "";
        switch (businessIdType) {
        case Constant.BusinessIdType.DEP_DEPOSIT:
            objName = BusinessType.DEPOSIT.getObjName();
            objIdName = BusinessType.DEPOSIT.getObjIdName();
            preNum = BusinessType.DEPOSIT.getPreNum();
            break;
        case Constant.BusinessIdType.DEP_ADVANCE:
            objName = BusinessType.ADVANCE.getObjName();
            objIdName = BusinessType.ADVANCE.getObjIdName();
            preNum = BusinessType.ADVANCE.getPreNum();
            break;
        }

        try {
            String id = null;
            // 设置时间格式
            SimpleDateFormat sd = new SimpleDateFormat(
                    Constant.DateFormat.DEFAULT_DATE);
            Date d = new Date();
            // 获取时间字符串
            String t = sd.format(d);
            // 设置编号规则
            preNum += orgId + t;
            String strNum = baseDao.getMaxId(objName, objIdName, preNum);

            int count = SERIAL_NUMBER.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                sb.append("0");
            }
            if (strNum == null) {
                id = preNum + sb.replace(sb.length() - 1, sb.length(), "1");
            }
            else {
                DecimalFormat df = new DecimalFormat(sb.toString());
                id = preNum
                        + df.format(1 + Integer.parseInt(strNum.substring(
                                strNum.length() - count, strNum.length())));
            }
            return id;
        }
        catch (DaoException e) {
            error("getBusinessId", "Get BusinessId failed.", e);
        }

        return null;
    }

    /**
     * Get SQL or HQL Statement
     * 
     * @param keyValue
     * @return String
     * @author colin
     */
    protected String getSQLOrHQLText(String keyValue) {
        return SqlUtil.getText(keyValue);
    }

    /**
     * 处理DAO异常, 转换为 ServiceException并记录日志信息到数据库
     * 
     * @param methodName
     *            方法名
     * @param message
     *            错误信息
     * @param userid
     *            用户ID
     * @param ex
     *            DaoException
     * @return ServiceException
     * @author colin
     */
    protected ServiceException processException(String methodName,
            String message, String userid, DaoException ex) {
        String errorCode = ServiceException.processDaoException(ex);
        Date date = new Date();
        Log log = new Log();
        log.setUserid(userid);
        log.setLogcontent(message + ex.getMessage());
        log.setCreatetime(date);
        log.setLstmntuser(userid);
        log.setLstmntdate(date);
        log.setLogtype(Constant.LogType.ERR);
        try {
            baseDao.save(log);
        }
        catch (DaoException e) {
            error(methodName, "添加错误日志发生数据库错误");
            return new ServiceException(ServiceException.ERROR_HIBERNATE, ex
                    .getMessage(), ex);
        }
        error(methodName, message, ex);
        return new ServiceException(errorCode, ex.getMessage(), ex);
    }

    private synchronized ILogger getBusinessLogger() {
        if (logger == null)
            logger = LoggerFactory.getBusinessLogger(this.getClass());
        return logger;
    }

    private synchronized ILogger getAuditLogger() {
        if (auditlogger == null)
            auditlogger = LoggerFactory.getAuditLogger(this.getClass());
        return auditlogger;
    }

}
