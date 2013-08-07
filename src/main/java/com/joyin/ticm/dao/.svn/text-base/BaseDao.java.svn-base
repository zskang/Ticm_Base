package com.joyin.ticm.dao;

import java.util.List;

/**
 * 基本DAO操作接口类.
 * 
 * @author colin
 * @version 1.0
 * @since Jul 18, 2013, 10:16:38 AM
 */
@SuppressWarnings("unchecked")
public interface BaseDao {

    /**
     * 保存
     * 
     * @param object
     *            持久化对象
     */
    public void save(Object object) throws DaoException;

    /**
     * 修改
     * 
     * @param o
     *            要更新的对象
     */
    public void update(Object o) throws DaoException;

    /**
     * 保存或修改
     * 
     * @param o
     *            持久化对象
     * @throws DaoException
     */
    public void saveOrUpdate(Object o) throws DaoException;

    /**
     * 删除指定id的对象
     * 
     * @param clazz
     *            实例的Class对象
     * @param id
     *            实例的ID
     */
    public void deleteById(Class clazz, Integer id) throws DaoException;

    /**
     * 删除指定id的对象
     * 
     * @param clazz
     *            实例的Class对象
     * @param id
     *            实例的ID
     */
    public void deleteById(Class clazz, String id) throws DaoException;

    /**
     * 根据给定参数查找对象
     * 
     * @param className
     *            对象的类名称（不带包名）
     * @param paramNames
     *            参数名称
     * @param params
     *            参数的值
     * @return <T> T
     */
    public <T> T findUniqueByParams(String queryString, Object[] paramValues)
            throws DaoException;

    /**
     * 根据给定参数查找对象
     * 
     * @param className
     *            对象的类名称（不带包名）
     * @param paramNames
     *            参数名称
     * @param params
     *            参数的值
     * @return
     */
    public <T> List<T> findByParams(String queryString, Object[] paramValues)
            throws DaoException;

    /**
     * 使用HQL语句进行分页查询操作
     * 
     * @param hql
     *            查询HQL语句
     * @param values
     *            如果HQL有多个参数需要传人，则values就是传人的参数数组
     * @param offset
     *            第一条记录的索引
     * @param pageSize
     *            每页需要显示的记录数
     * @param isPage
     *            判断是否需要分页
     * @return 当前页的所有记录
     */
    public List findByPage(final String hql, final Object[] values,
            final int offset, final int pageSize, final Boolean isPage)
            throws DaoException;

    public <T> List<T> findPageBySql(String queryString, Object[] paramValues,
            String[] listNames, List<List<Object>>[] listValues, int pageNo,
            int pageSize) throws DaoException;

    public <T> List<T> findAllByParameters_new(String queryString,
            Object[] paramValues) throws DaoException;

    public <T> List<T> findAll(String queryString) throws DaoException;

    public long findTotal(String queryString, Object[] paramValues,
            String[] listNames, List<List<Object>>[] listValues)
            throws DaoException;

    public void update(String queryString, Object[] paramValues,
            String[] listNames, List<List<Object>>[] listValues)
            throws DaoException;

    public <T> List<T> findPage(String queryString, String queryString2,
            Object[] paramValues, String[] listNames,
            List<List<Object>>[] listValues, int pageNo, int pageSize)
            throws DaoException;

    public <T> List<T> findMaxCount(String hql, int max) throws DaoException;

    /**
     * 获取各业务最大编号
     * 
     * @param obj
     * @return
     * @throws DaoException
     * @author xusong
     */
    public String getMaxId(String objName, String objIdName, String preNum)
            throws DaoException;
}
