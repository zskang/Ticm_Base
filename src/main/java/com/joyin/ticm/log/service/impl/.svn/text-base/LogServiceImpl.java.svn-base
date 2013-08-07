package com.joyin.ticm.log.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.joyin.ticm.dao.BaseDao;
import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.log.model.Log;
import com.joyin.ticm.log.service.LogService;
import com.joyin.ticm.service.ServiceBase;
import com.joyin.ticm.service.ServiceException;

/**
 * 日志模块 业务逻辑实现类
 * 
 * @author colin
 * @version 1.0
 * @since Jul 18, 2013, 10:00:10 AM
 */
@Service("logService")
public class LogServiceImpl extends ServiceBase implements LogService {

    @Resource
    private BaseDao baseDao;

    public void insertToDB(Log log) throws ServiceException {
        String methodName = "insertToDB";
        info("insertToDB", "添加日志到数据库");
        try {
            baseDao.save(log);
        }
        catch (DaoException ex) {
            error(methodName, "添加错误日志发生数据库错误");
            throw new ServiceException(ServiceException.ERROR_HIBERNATE, ex
                    .getMessage(), ex);
        }
    }

}
