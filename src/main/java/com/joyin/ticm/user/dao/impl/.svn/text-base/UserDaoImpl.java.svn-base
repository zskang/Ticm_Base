package com.joyin.ticm.user.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.dao.impl.AbstractDao;
import com.joyin.ticm.page.PageInfo;
import com.joyin.ticm.page.PageInfoImpl;
import com.joyin.ticm.user.dao.UserDao;
import com.joyin.ticm.user.model.User;
import com.joyin.ticm.user.model.UserInfo;

/**
 * 用户模块 数据持久化实现类
 * 
 * @author colin
 * @version 1.0
 * @since Jul 16, 2013, 5:15:03 PM
 */
public class UserDaoImpl extends AbstractDao implements UserDao {

	@SuppressWarnings("unchecked")
	public PageInfo findPage(String queryString, int pageNo, int pageSize)
			throws DaoException {
		Query query = this.getSession().createQuery(queryString);
		long sum = this.findTotal(queryString);
		int p = pageNo;
		if (pageNo * pageSize >= sum) {
			p = (int) ((sum + pageSize - 1) / pageSize);
		}
		if (pageNo < 1) {
			p = 1;
		}
		query.setFirstResult((p - 1) * pageSize);
		query.setMaxResults(pageSize);
		List list = query.list();
		PageInfo pageInfo = new PageInfoImpl(list, sum, pageSize, pageNo);
		return pageInfo;
	}

	public long findTotal(String queryString) throws DaoException {
		Query query = this.getSession().createQuery(
				"select count(*) " + queryString);
		Object obj = query.uniqueResult();
		long l = (Long) obj;
		return l;
	}

	/**
	 * 根据用户id获取用户信息
	 */
	public User getByUserID(Serializable id) throws DaoException {
		User instance = (User) this.getSession().get(User.class, id);
		return instance;
	}

	/**
	 * 批量删除 {method description}
	 * 
	 * @param userids
	 * @return
	 * @author guojie
	 */
	public Boolean delete(final List<String> userids) throws DaoException {
		return (Boolean) this.getHibernateTemplate().execute(
				new HibernateCallback<Object>() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Boolean isSuccess = false;
						User user = new User();
						try {
							for(int i=0 ; i<userids.size();i++){
								user = getByUserID(userids.get(i));
								session.delete(user);
								}
							isSuccess = true;
							
						}
						catch (Exception e) {
							isSuccess = false;
							e.printStackTrace();
						}
						return isSuccess;
					}
				});
	}

	/**
	 * {method description} 获取USERINFO联合查询的bean
	 * 
	 * @param <T>
	 * @param queryString
	 * @param paramValues
	 * @param listNames
	 * @param listValues
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws DaoException
	 * @author guojie
	 */
	@SuppressWarnings("unchecked")
	public List<UserInfo> findPageBySql(String queryString,
			Object[] paramValues, int pageNo, int pageSize, boolean ispage)
			throws DaoException {
		List<UserInfo> list = null;
		SQLQuery query = this.getSession().createSQLQuery(queryString);

		query.addEntity("user", User.class);
		query.addScalar("sexname", Hibernate.STRING);
		query.addScalar("lvlbname", Hibernate.STRING);
		query.addScalar("clsname", Hibernate.STRING);
		query.addScalar("statusname", Hibernate.STRING);
		query.addScalar("adminflagname", Hibernate.STRING);
		query.addScalar("tradname", Hibernate.STRING);
		query.addScalar("orgname", Hibernate.STRING);
		query.addScalar("ifsale", Hibernate.STRING);
		query.addScalar("orgtype", Hibernate.STRING);
		query.addScalar("bm02attr", Hibernate.STRING);

		query.setResultTransformer(Transformers.aliasToBean(UserInfo.class));

		for (int i = 0; paramValues != null && i < paramValues.length; i++) {
			query.setParameter(i, paramValues[i]);
		}
		if (ispage) {
			long sum = this.findTotalBySql("select count(*) from ("
					+ queryString + ")", paramValues, ispage);
			int p = pageNo;
			if (pageNo * pageSize >= sum) {
				p = (int) ((sum + pageSize - 1) / pageSize);
			}
			if (pageNo < 1) {
				p = 1;
			}
			query.setFirstResult((p - 1) * pageSize);
			query.setMaxResults(pageSize);
			list = query.list();
		}
		else {
			list = query.list();
		}

		return list;
	}

	/**
	 * 获取count(*)总数 {method description}
	 * 
	 * @param queryString
	 * @param paramValues
	 * @param listNames
	 * @param listValues
	 * @return
	 * @throws DaoException
	 * @author guojie
	 */
	public long findTotalBySql(String queryString, Object[] paramValues,
			boolean ispage) throws DaoException {
		
		SQLQuery query = this.getSession().createSQLQuery(queryString);
		for (int i = 0; paramValues != null && i < paramValues.length; i++) {
			query.setParameter(i, paramValues[i]);
		}
		Object obj = query.uniqueResult();
		long l = Long.parseLong(obj.toString());
		return l;
	}
}
