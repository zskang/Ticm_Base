package com.joyin.ticm.userrole.model;

import com.joyin.ticm.bean.BaseBean;

/**
 * 
 * {description of method or object}
 * @author guojie
 * @version 1.0
 * @since 2013-7-26, 下午09:14:37
 */

public class UserRoleId extends BaseBean  {

	// Fields

	/** {field's description} */
	private static final long serialVersionUID = 7536926913590358595L;
	private Integer groupid;
	private String userid;
	private Integer roleid;

	// Constructors

	/** default constructor */
	public UserRoleId() {
	}

	/** full constructor */
	public UserRoleId(Integer groupid, String userid, Integer roleid) {
		this.groupid = groupid;
		this.userid = userid;
		this.roleid = roleid;
	}

	// Property accessors

	public Integer getGroupid() {
		return this.groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserRoleId))
			return false;
		UserRoleId castOther = (UserRoleId) other;

		return ((this.getGroupid() == castOther.getGroupid()) || (this
				.getGroupid() != null
				&& castOther.getGroupid() != null && this.getGroupid().equals(
				castOther.getGroupid())))
				&& ((this.getUserid() == castOther.getUserid()) || (this
						.getUserid() != null
						&& castOther.getUserid() != null && this.getUserid()
						.equals(castOther.getUserid())))
				&& ((this.getRoleid() == castOther.getRoleid()) || (this
						.getRoleid() != null
						&& castOther.getRoleid() != null && this.getRoleid()
						.equals(castOther.getRoleid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGroupid() == null ? 0 : this.getGroupid().hashCode());
		result = 37 * result
				+ (getUserid() == null ? 0 : this.getUserid().hashCode());
		result = 37 * result
				+ (getRoleid() == null ? 0 : this.getRoleid().hashCode());
		return result;
	}

}