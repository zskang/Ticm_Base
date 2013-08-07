package com.joyin.ticm.datadict.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.datadict.dao.DataDictDao;
import com.joyin.ticm.datadict.model.DataDict;
import com.joyin.ticm.datadict.model.DataList;
import com.joyin.ticm.datadict.service.DataDictService;
import com.joyin.ticm.service.ServiceBase;
import com.joyin.ticm.service.ServiceException;

/**
 * 参数字典与类列表 业务操作实现类
 * 
 * @author colin
 * @version 1.0
 * @since Jul 31, 2013, 7:14:53 PM
 */
@Service("dataDictService")
public class DataDictServiceImpl extends ServiceBase implements DataDictService {

    @Resource
    private DataDictDao dataDictDao;

    @Override
    public List<DataDict> getDataDicts() throws ServiceException {
        String methodName = "getDataDicts";
        info(methodName, "查询参数字典");
        try {
            return dataDictDao.getDataDicts();
        }
        catch (DaoException ex) {
            String msg = "查询参数字典出错";
            throw processException(methodName, msg, null, ex);
        }
    }

    @Override
    public List<DataList> getDataLists() throws ServiceException {
        String methodName = "getDataDicts";
        info(methodName, "查询参数字典");
        try {
            return dataDictDao.getDataLists();
        }
        catch (DaoException ex) {
            String msg = "查询参数字典出错";
            throw processException(methodName, msg, null, ex);
        }
    }

}