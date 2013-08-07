package com.joyin.ticm.datadict.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.JDBCException;

import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.dao.impl.AbstractDao;
import com.joyin.ticm.datadict.dao.DataDictDao;
import com.joyin.ticm.datadict.model.DataDict;
import com.joyin.ticm.datadict.model.DataList;

/**
 * 参数字典与类列表 数据持久化操作实现类
 * 
 * @author colin
 * @version 1.0
 * @since Jul 31, 2013, 7:42:24 PM
 */
@SuppressWarnings("unchecked")
public class DataDictDaoImpl extends AbstractDao implements DataDictDao {

    @Override
    public List<DataDict> getDataDicts() throws DaoException {
        String methodName = "getDataDicts";
        info(methodName, "查询参数字典");
        List<DataDict> list = new ArrayList<DataDict>();
        try {
            list = (List<DataDict>) getSession().createQuery(
                    "from DataDict order by clsno, orderno ")
                    .setCacheable(true).list();
        }
        catch (JDBCException de) {
            error(methodName, "查询参数字典出错", de);
            throw new DaoException(DaoException.ERROR_GENERIC_JDBC_EXCEPTION,
                    de);
        }
        catch (HibernateException ex) {
            error(methodName, "查询参数字典出错", ex);
            throw new DaoException(DaoException.ERROR_HIBERNATE, ex);
        }
        return list;
    }

    @Override
    public List<DataList> getDataLists() throws DaoException {
        String methodName = "getDataDicts";
        info(methodName, "查询参数类列表");
        List<DataList> list = new ArrayList<DataList>();
        try {
            list = (List<DataList>) getSession().createQuery("from DataList")
                    .setCacheable(true).list();
        }
        catch (JDBCException de) {
            error(methodName, "查询参数类列表出错", de);
            throw new DaoException(DaoException.ERROR_GENERIC_JDBC_EXCEPTION,
                    de);
        }
        catch (HibernateException ex) {
            error(methodName, "查询参数类列表出错", ex);
            throw new DaoException(DaoException.ERROR_HIBERNATE, ex);
        }
        return list;
    }

}