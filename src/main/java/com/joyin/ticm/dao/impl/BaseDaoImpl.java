package com.joyin.ticm.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.joyin.ticm.dao.BaseDao;
import com.joyin.ticm.dao.DaoException;

/**
 * 基本DAO操作实现类.
 * 
 * @author colin
 * @version 1.0
 * @since Jul 4, 2013, 10:07:34 AM
 */
@SuppressWarnings("unchecked")
public class BaseDaoImpl extends AbstractDao implements BaseDao {

    public void deleteById(Class clazz, Integer id) throws DaoException {
        String methodName = "deleteById";
        Object o = this.getSession().get(clazz, id);
        try {
            getHibernateTemplate().delete(o);
        }
        catch (JDBCException de) {
            error(methodName, "Error Delete Object By Id", de);
            throw new DaoException(DaoException.ERROR_GENERIC_JDBC_EXCEPTION,
                    de);
        }
        catch (HibernateException ex) {
            error(methodName, "Error save or update object", ex);
            throw new DaoException(DaoException.ERROR_HIBERNATE, ex);
        }

    }

    public void deleteById(Class clazz, String id) throws DaoException {
        Object o = this.getSession().get(clazz, id);
        getHibernateTemplate().delete(o);
    }

    public void save(Object object) throws DaoException {
        String methodName = "save";
        debug(methodName, "param[object]: " + object);
        try {
            getHibernateTemplate().save(object);
        }
        catch (JDBCException de) {
            error(methodName, "Error save or update object", de);
            throw new DaoException(DaoException.ERROR_GENERIC_JDBC_EXCEPTION,
                    de);
        }
        catch (HibernateException ex) {
            error(methodName, "Error save or update object", ex);
            throw new DaoException(DaoException.ERROR_HIBERNATE, ex);
        }
    }

    public void saveOrUpdate(Object object) throws DaoException {
        String methodName = "saveOrUpdate";
        info(methodName, "saving Object instance.");
        debug(methodName, "param[object]: " + object);
        try {
            getHibernateTemplate().saveOrUpdate(object);
        }
        catch (JDBCException de) {
            error(methodName, "Error save or update object", de);
            throw new DaoException(DaoException.ERROR_GENERIC_JDBC_EXCEPTION,
                    de);
        }
        catch (HibernateException ex) {
            error(methodName, "Error save or update object", ex);
            throw new DaoException(DaoException.ERROR_HIBERNATE, ex);
        }
    }

    public void update(Object o) throws DaoException {
        this.getSession().update(o);
    }

    public Object findById(Class clazz, Long id) throws DaoException {
        Object obj = this.getHibernateTemplate().get(clazz, id);
        return obj;
    }

    public List findByParams(String queryString, Object[] paramValues)
            throws DaoException {
        if (paramValues != null) {
            List list = this.getHibernateTemplate().find(
                    queryString.toString(), paramValues);
            return list;
        }
        else {
            List list = this.getHibernateTemplate()
                    .find(queryString.toString());
            return list;
        }
    }

    public Object findUniqueByParams(String queryString, Object[] paramValues)
            throws DaoException {
        List list = null;
        if (paramValues != null) {
            list = this.getHibernateTemplate().find(queryString.toString(),
                    paramValues);
        }
        else {
            list = this.getHibernateTemplate().find(queryString.toString());
        }
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public List findByPage(final String hql, final Object[] values,
            final int offset, final int pageSize, final Boolean isPage)
            throws DaoException {
        List list = getHibernateTemplate().executeFind(new HibernateCallback() {

            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException {
                List result = null;
                try {
                    Query query = session.createQuery(hql);
                    for (int i = 0; i < values.length; i++) {
                        query.setParameter(i, values[i]);
                    }
                    if (isPage) {
                        result = query.setFirstResult(offset).setMaxResults(
                                pageSize).list();
                    }
                    else {
                        result = query.list();
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                    result = new ArrayList();
                }
                return result;
            }
        });
        return list;
    }

    public <T> List<T> findPageBySql(String queryString, Object[] paramValues,
            String[] listNames, List<List<Object>>[] listValues, int pageNo,
            int pageSize) throws DaoException {
        Query query = this.getSession().createSQLQuery(queryString);
        for (int i = 0; paramValues != null && i < paramValues.length; i++) {
            query.setParameter(i, paramValues[i]);
        }
        for (int i = 0; listNames != null && i < listNames.length; i++) {
            query.setParameterList(listNames[i], listValues[i]);
        }
        long sum = this.findTotalBySql("select count(*) from (" + queryString
                + ")", paramValues, listNames, listValues);
        int p = pageNo;
        if (pageNo * pageSize >= sum) {
            p = (int) ((sum + pageSize - 1) / pageSize);
        }
        if (pageNo < 1) {
            p = 1;
        }
        query.setFirstResult((p - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.list();
    }

    public <T> List<T> findPage(String queryString, String queryString2,
            Object[] paramValues, String[] listNames,
            List<List<Object>>[] listValues, int pageNo, int pageSize)
            throws DaoException {
        Query query = this.getSession().createQuery(queryString);
        for (int i = 0; paramValues != null && i < paramValues.length; i++) {
            query.setParameter(i, paramValues[i]);
        }
        for (int i = 0; listNames != null && i < listNames.length; i++) {
            query.setParameterList(listNames[i], listValues[i]);
        }
        long sum = 0;
        if (pageSize != 0) { // 为0时查询所有
            sum = this.findTotal(queryString2, paramValues, listNames,
                    listValues);
            int p = pageNo;
            if (pageNo * pageSize >= sum) {
                p = (int) ((sum + pageSize - 1) / pageSize);
            }
            if (pageNo < 1) {
                p = 1;
            }
            query.setFirstResult((p - 1) * pageSize);
            query.setMaxResults(pageSize);
        }
        return query.list();
    }

    public List findAll(String queryString) throws DaoException {
        List list = getHibernateTemplate().find(queryString);
        return list;
    }

    public <T> List<T> findAllByParameters_new(String queryString,
            Object[] paramValues) throws DaoException {
        List list = null;
        if (paramValues != null) {
            list = this.getHibernateTemplate().find(queryString.toString(),
                    paramValues);
        }
        else {
            list = this.getHibernateTemplate().find(queryString.toString());
        }
        return list;
    }

    public long findTotal(String queryString, Object[] paramValues,
            String[] listNames, List<List<Object>>[] listValues)
            throws DaoException {
        Query query = this.getSession().createQuery(queryString);
        for (int i = 0; paramValues != null && i < paramValues.length; i++) {
            query.setParameter(i, paramValues[i]);
        }
        for (int i = 0; listNames != null && i < listNames.length; i++) {
            query.setParameterList(listNames[i], listValues[i]);
        }
        Object obj = query.uniqueResult();
        long l = (Long) obj;
        return l;
    }

    public long findTotalBySql(String queryString, Object[] paramValues,
            String[] listNames, List<List<Object>>[] listValues)
            throws DaoException {
        Query query = this.getSession().createSQLQuery(queryString);
        for (int i = 0; paramValues != null && i < paramValues.length; i++) {
            query.setParameter(i, paramValues[i]);
        }
        for (int i = 0; listNames != null && i < listNames.length; i++) {
            query.setParameterList(listNames[i], listValues[i]);
        }
        Object obj = query.uniqueResult();
        long l = Long.parseLong(obj.toString());
        return l;
    }

    public void update(String queryString, Object[] paramValues,
            String[] listNames, List<List<Object>>[] listValues)
            throws DaoException {
        Query query = this.getSession().createQuery(queryString);
        for (int i = 0; paramValues != null && i < paramValues.length; i++) {
            query.setParameter(i, paramValues[i]);
        }
        for (int i = 0; listNames != null && i < listNames.length; i++) {
            query.setParameterList(listNames[i], listValues[i]);
        }
        query.executeUpdate();
    }

    public <T> List<T> findMaxCount(String hql, int max) throws DaoException {
        Query query = this.getSession().createQuery(hql);
        query.setFirstResult(0);
        query.setMaxResults(max);
        return query.list();
    }

    public String getMaxId(String objName, String objIdName, String preNum)
            throws DaoException {
        String hql = "select " + "obj." + objIdName + " from " + objName
                + " as obj where obj." + objIdName + " like ? "
                + " order by obj." + objIdName + " desc";
        List rst = this.getSession().createQuery(hql).setParameter(0,
                "%" + preNum + "%").list();
        if (rst != null && rst.size() > 0 && rst.get(0) != null) {
            return rst.get(0).toString();
        }
        else {
            return null;
        }
    }

}
