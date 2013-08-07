package com.joyin.ticm.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.joyin.ticm.common.util.CommonUtil;
import com.joyin.ticm.dao.BaseDao;
import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.page.Pager;
import com.joyin.ticm.service.ServiceBase;
import com.joyin.ticm.service.ServiceException;
import com.joyin.ticm.user.dao.UserDao;
import com.joyin.ticm.user.model.User;
import com.joyin.ticm.user.model.UserInfo;
import com.joyin.ticm.user.service.UserService;

/**
 * 用户模块 业务逻辑实现类
 * 
 * @author guojie
 * @version 1.0
 * @since Jul 16, 2013, 5:15:03 PM
 */
@Service("userService")
public class UserServiceImp extends ServiceBase implements UserService {

	@Resource
	private BaseDao baseDao;
	@Resource
	private UserDao userDao;

	public void saveOrUpdate(User user) throws ServiceException {

		String methodName = "saveOrUpdate";
		info(methodName, "username: " + user.getUsername());
		try {
			baseDao.update(user);
		}
		catch (DaoException ex) {
			String message = "保存或更新用户信息错误";
			throw processException(methodName, message, user.getLoginUserid(),
					ex);
		}
	}

	public void save(User user) throws ServiceException {
		String methodName = "save";
		try {
			baseDao.save(user);
		}
		catch (DaoException ex) {
			String message = "保存用户信息错误";
			throw processException(methodName, message, user.getLoginUserid(),
					ex);
		}
	}

	public void deleteUser(User user) throws ServiceException {
		String methodName = "deleteUser";
		info("deleteUser", "username: " + user.getUsername());
		try {
			baseDao.deleteById(User.class, user.getUserid());
		}
		catch (DaoException ex) {
			String message = "删除用户信息错误";
			throw processException(methodName, message, user.getLoginUserid(),
					ex);

		}
	}

	public List<User> findAll(String loginUserid) throws ServiceException {
		String methodName = "findAll";
		try {
			return baseDao.findAll("from User");
		}
		catch (DaoException ex) {
			String message = "查询全部用户信息错误";
			throw processException(methodName, message, loginUserid, ex);
		}
	}

	public List<UserInfo> getUsers(UserInfo userinfo, Pager pager,
			String order, String direction, boolean isPage)
			throws ServiceException {
		String methodName = "";
		info(methodName, "param[user]: " + userinfo + ", param[pager]:" + pager
				+ ", param[order]:" + order + ", param[direction]:" + direction
				+ ", param[isPage]:" + isPage);
		List<Object> params = new ArrayList<Object>();

		String queryString = "select user.* ,T1.CNNAME AS sexname,T2.CNNAME AS lvlbname,T3.CNNAME AS clsname,"
				+ "T4.CNNAME AS statusname,T5.CNNAME AS adminflagname,T6.CNNAME AS tradname,ORG.BM02SNAM1 "
				+ "as orgname,ORG.IFSALE as ifsale,ORG.ORGTYPE as orgtype,ORG.BM02ATTR as bm02attr"
				+ " from SYS_USERS  user LEFT JOIN STTC_DATADICT T1 ON (user.TM01SEX = T1.ITEMCODE AND T1.CLSNO='TMSEX')"
				+ "LEFT JOIN STTC_DATADICT T2 ON (user.TM01LVLF = T2.ITEMCODE AND T2.CLSNO='TMLVLF') "
				+ "LEFT JOIN STTC_DATADICT T3 ON (user.TM01CLASS = T3.ITEMCODE AND T3.CLSNO='TMCLS')"
				+ "LEFT JOIN STTC_DATADICT T4 ON (user.STATUS = T4.ITEMCODE AND T4.CLSNO='STATUS')"
				+ "LEFT JOIN STTC_DATADICT T5 ON (user.ADMINFLAG = T5.ITEMCODE AND T5.CLSNO='ADMINFLAG')"
				+ "LEFT JOIN STTC_DATADICT T6 ON (user.TRAD = T6.ITEMCODE AND T6.CLSNO='ADMINFLAG')"
				+ "LEFT JOIN SYS_ORGAN ORG ON (user.TM01ORGNO = ORG.BM02ORGNO) where 1=1 and  "
				+ "ORG.BM02ORGNO = user.TM01ORGNO and user.EFFECTFLAG='A' ";

		if (userinfo != null) {
			if (CommonUtil.isNotEmpty(userinfo.getUser().getUserid())) {
				queryString += " and user.userid like ? ";
				params.add("%" + userinfo.getUser().getUserid() + "%");
			}
			if (CommonUtil.isNotEmpty(userinfo.getUser().getUsername())) {
				queryString += " and user.username like ? ";
				params.add("%" + userinfo.getUser().getUsername() + "%");
			}
			if (CommonUtil.isNotEmpty(userinfo.getUser().getTm01orgno())) {
				queryString += " and user.tm01orgno like ? ";
				params.add("%" + userinfo.getUser().getTm01orgno() + "%");
				// }else if(!userinfo.getLoginOrgid().equals("01100")){
				// queryString += " and user.tm01orgno like ? ";
				// params.add("%" + userinfo.getLoginOrgid() + "%");
			}
			if (CommonUtil.isNotEmpty(userinfo.getUser().getStatus())) {
				queryString += " and user.status = ?";
				params.add((Integer) userinfo.getUser().getStatus());
			}
		}

		// 排序
		if (CommonUtil.isEmpty(order)) {
			order = "user.userid";
		}
		else {
			order = "user." + order;
		}
		if (CommonUtil.isNotEmpty(direction)) {
			direction = "desc";
		}
		queryString += " order by " + order + " " + direction;

		List<UserInfo> list = new ArrayList<UserInfo>();
		try {
			// list = baseDao.findByPage(queryString, params.toArray(),
			// pager.getPageNo(),pager.getPageSize(),true);

			list = userDao.findPageBySql(queryString, params.toArray(), pager
					.getPageNo(), pager.getPageSize(), isPage);
		}
		catch (DaoException e) {
			String message = "查询分页用户信息错误";
			throw processException(methodName, message, userinfo.getUser()
					.getLoginUserid(), e);
		}

		return list;
	}
	
	public User getUser(String userid, String loginUserid)
			throws ServiceException {
		String methodName = "getUser";
		User user = null;
		try {
			user = userDao.getByUserID(userid);
		}
		catch (DaoException e) {
			String message = "查询特定用户信息错误";
			throw processException(methodName, message, loginUserid, e);
		}
		return user;
	}

	public Boolean deleteAllUser(final List<String> userids, String loginUserid)
			throws ServiceException {
		String methodName = "deleteAllUser";
		Boolean result = false;
		try {
			result = userDao.delete(userids);
		}
		catch (DaoException e) {
			String message = "批量删除用户信息错误";
			throw processException(methodName, message, loginUserid, e);
		}
		return result;
	}

	/**
	 * 获取用户总数 {method description}
	 * 
	 * @param userinfo
	 * @param pager
	 * @param order
	 * @param direction
	 * @param isPage
	 * @return
	 * @throws ServiceException
	 * @author guojie
	 */

	public long getTotalUser(UserInfo userinfo, Pager pager, String order,
			String direction, boolean isPage) throws ServiceException {
		String methodName = "getTotalUser";
		info(methodName, "param[user]: " + userinfo + ", param[pager]:" + pager
				+ ", param[order]:" + order + ", param[direction]:" + direction
				+ ", param[isPage]:" + isPage);
		List<Object> params = new ArrayList<Object>();
		String queryString = "select user.* ,T1.CNNAME AS sexname,T2.CNNAME AS lvlbname,T3.CNNAME AS clsname,"
				+ "T4.CNNAME AS statusname,T5.CNNAME AS adminflagname,T6.CNNAME AS tradname,ORG.BM02SNAM1 "
				+ "as orgname,ORG.IFSALE as ifsale,ORG.ORGTYPE as orgtype,ORG.BM02ATTR as bm02attr"
				+ " from SYS_USERS  user LEFT JOIN STTC_DATADICT T1 ON (user.TM01SEX = T1.ITEMCODE AND T1.CLSNO='TMSEX')"
				+ "LEFT JOIN STTC_DATADICT T2 ON (user.TM01LVLF = T2.ITEMCODE AND T2.CLSNO='TMLVLF') "
				+ "LEFT JOIN STTC_DATADICT T3 ON (user.TM01CLASS = T3.ITEMCODE AND T3.CLSNO='TMCLS')"
				+ "LEFT JOIN STTC_DATADICT T4 ON (user.STATUS = T4.ITEMCODE AND T4.CLSNO='STATUS')"
				+ "LEFT JOIN STTC_DATADICT T5 ON (user.ADMINFLAG = T5.ITEMCODE AND T5.CLSNO='ADMINFLAG')"
				+ "LEFT JOIN STTC_DATADICT T6 ON (user.TRAD = T6.ITEMCODE AND T6.CLSNO='ADMINFLAG')"
				+ "LEFT JOIN SYS_ORGAN ORG ON (user.TM01ORGNO = ORG.BM02ORGNO) where 1=1 and  "
				+ "ORG.BM02ORGNO = user.TM01ORGNO and user.EFFECTFLAG='A' ";

		if (userinfo != null) {
			if (CommonUtil.isNotEmpty(userinfo.getUser().getUserid())) {
				queryString += " and user.userid like ? ";
				params.add("%" + userinfo.getUser().getUserid() + "%");
			}
			if (CommonUtil.isNotEmpty(userinfo.getUser().getUsername())) {
				queryString += " and user.username like ? ";
				params.add("%" + userinfo.getUser().getUsername() + "%");
			}
			if (CommonUtil.isNotEmpty(userinfo.getUser().getTm01orgno())) {
				queryString += " and user.tm01orgno like ? ";
				params.add("%" + userinfo.getUser().getTm01orgno() + "%");
				// }else if(!userinfo.getLoginOrgid().equals("")){
				// queryString += " and user.tm01orgno like ? ";
				// params.add("%" + userinfo.getLoginOrgid() + "%");
			}
			if (CommonUtil.isNotEmpty(userinfo.getUser().getStatus())) {
				queryString += " and user.status = ?";
				params.add((Integer) userinfo.getUser().getStatus());
			}
		}

		// 排序
		if (CommonUtil.isEmpty(order)) {
			order = "user.userid";
		}
		else {
			order = "user." + order;
		}
		if (CommonUtil.isNotEmpty(direction)) {
			direction = "desc";
		}
		queryString += " order by " + order + " " + direction;

		long l = 0;
		try {
			l = userDao.findTotalBySql("select count(*) from (" + queryString
					+ ")", params.toArray(), isPage);
		}
		catch (DaoException e) {
			String message = "查询用户总数信息错误";
			throw processException(methodName, message, userinfo.getUser()
					.getLoginUserid(), e);
		}
		return l;
	}

	public boolean resetUserPwd(String userid, String password,
			String loginUserId) throws ServiceException {
		String methodName = "resetUserPwd";
		boolean result = false;
		User user = new User();
		try {
			user = userDao.getByUserID(userid);
			user.setPassword(password);
			baseDao.save(user);
			result = true;

		}
		catch (DaoException e) {
			String message = "重置用户密码错误";
			result = false;
			throw processException(methodName, message, loginUserId, e);
		}
		return result;
	}
}
