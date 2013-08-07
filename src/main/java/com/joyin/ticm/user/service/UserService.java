package com.joyin.ticm.user.service;

import java.util.List;

import com.joyin.ticm.page.Pager;
import com.joyin.ticm.service.ServiceException;
import com.joyin.ticm.user.model.User;
import com.joyin.ticm.user.model.UserInfo;

/**
 * 用户模块 业务逻辑接口类
 * 
 * @author colin
 * @version 1.0
 * @since Jul 16, 2013, 5:15:03 PM
 */
public interface UserService {

	public void saveOrUpdate(User user) throws ServiceException;

	public void save(User user) throws ServiceException;

	public void deleteUser(User user) throws ServiceException;

	public List<User> findAll(String loginUserid) throws ServiceException;

	public List<UserInfo> getUsers(UserInfo userInfo, Pager pager,
			String order, String direction, boolean isPage)
			throws ServiceException;

	public User getUser(String userid, String loginUserid)
			throws ServiceException;

	public Boolean deleteAllUser(final List<String> userids, String loginUserid)
			throws ServiceException;
	
	public long getTotalUser(UserInfo userinfo, Pager pager,
			String order, String direction, boolean isPage)
			throws ServiceException ;
	
	public boolean resetUserPwd(String userid,String password,String userLoginId)throws ServiceException ;
}
