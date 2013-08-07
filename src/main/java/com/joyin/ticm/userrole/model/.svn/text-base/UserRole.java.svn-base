package com.joyin.ticm.userrole.model;
import java.util.Date;

import com.joyin.ticm.bean.BaseBean;
import com.joyin.ticm.role.model.Role;
import com.joyin.ticm.user.model.User;

/**
 * {description of method or object}
 * 
 * @author guojie
 * @version 1.0
 * @since 2013-7-26, 下午09:11:53
 */

public class UserRole extends BaseBean {

	// Fields

	/** {field's description} */
	private static final long serialVersionUID = -2039713271097182209L;
	private UserRoleId id;
	private User user;
	private Role role;
	private Date lstmntdate;
	private String lstmntuser;

	// Constructors

	/** default constructor */
	public UserRole() {
	}

	/** minimal constructor */
	public UserRole(UserRoleId id, User user, Role role) {
		this.id = id;
		this.user = user;
		this.role = role;
	}

	/** full constructor */
	public UserRole(UserRoleId id, User user, Role role, Date lstmntdate,
			String lstmntuser) {
		this.id = id;
		this.user = user;
		this.role = role;
		this.lstmntdate = lstmntdate;
		this.lstmntuser = lstmntuser;
	}

	// Property accessors

	public UserRoleId getId() {
		return this.id;
	}

	public void setId(UserRoleId id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getLstmntdate() {
		return this.lstmntdate;
	}

	public void setLstmntdate(Date lstmntdate) {
		this.lstmntdate = lstmntdate;
	}

	public String getLstmntuser() {
		return this.lstmntuser;
	}

	public void setLstmntuser(String lstmntuser) {
		this.lstmntuser = lstmntuser;
	}
	

}