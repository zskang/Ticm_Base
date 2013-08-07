package com.joyin.ticm.datadict.service;

import java.util.List;

import com.joyin.ticm.datadict.model.DataDict;
import com.joyin.ticm.datadict.model.DataList;
import com.joyin.ticm.service.ServiceException;

/**
 * 参数字典与类列表 业务操作接口类
 * 
 * @author colin
 * @version 1.0
 * @since Jul 31, 2013, 7:12:59 PM
 */
public interface DataDictService {
    /**
     * 获取所有参数字典
     * 
     * @return List<DataDict> 参数字典集合
     * @throws ServiceException
     *             数据库操作异常
     * @author colin
     */
    public List<DataDict> getDataDicts() throws ServiceException;

    /**
     * 获取所有参数类列表
     * 
     * @return List<DataList> 参数类列表集合
     * @throws ServiceException
     *             数据库操作异常
     * @author colin
     */
    public List<DataList> getDataLists() throws ServiceException;
}