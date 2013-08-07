package com.joyin.ticm.user.dao;

import java.io.Serializable;
import java.util.List;

import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.page.PageInfo;
import com.joyin.ticm.user.model.User;
import com.joyin.ticm.user.model.UserInfo;

/**
 * 用户模块 数据持久化接口类
 * 
 * @author colin
 * @version 1.0
 * @since Jul 16, 2013, 5:15:03 PM
 */
public interface UserDao {

	public PageInfo findPage(String queryString, int pageNo, int pageSize)
			throws DaoException;

	public long findTotal(String queryString) throws DaoException;

	public User getByUserID(Serializable id) throws DaoException;

	public Boolean delete(final List<String> userids) throws DaoException;

	public List<UserInfo> findPageBySql(String queryString,
			Object[] paramValues, int pageNo, int pageSize,boolean ispage) throws DaoException;
	
	public long findTotalBySql(String queryString, Object[] paramValues,boolean ispage)
			throws DaoException;
}
