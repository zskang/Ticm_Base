package com.joyin.ticm.user.model;

import com.joyin.ticm.bean.DataForm;
/**
 * 用户管理页面显示的UserInfo bean
 * {description of method or object}
 * @author guojie
 * @version 1.0
 * @since 2013-7-28, 上午10:59:39
 */
public class UserInfo extends DataForm {

	/** {field's description} */
	private static final long serialVersionUID = 76010110L;

	
	// Fields
	private User user;
	private String sexname;
	private String lvlbname;
	private String clsname;
	private String statusname;
	private String adminflagname;
	private String tradname;
	private String	orgname;
	private String ifsale;
	private String orgtype;
	private String bm02attr;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSexname() {
		return sexname;
	}
	public void setSexname(String sexname) {
		this.sexname = sexname;
	}
	public String getLvlbname() {
		return lvlbname;
	}
	public void setLvlbname(String lvlbname) {
		this.lvlbname = lvlbname;
	}
	public String getClsname() {
		return clsname;
	}
	public void setClsname(String clsname) {
		this.clsname = clsname;
	}
	public String getStatusname() {
		return statusname;
	}
	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}
	public String getAdminflagname() {
		return adminflagname;
	}
	public void setAdminflagname(String adminflagname) {
		this.adminflagname = adminflagname;
	}
	public String getTradname() {
		return tradname;
	}
	public void setTradname(String tradname) {
		this.tradname = tradname;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getIfsale() {
		return ifsale;
	}
	public void setIfsale(String ifsale) {
		this.ifsale = ifsale;
	}
	public String getOrgtype() {
		return orgtype;
	}
	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}
	public String getBm02attr() {
		return bm02attr;
	}
	public void setBm02attr(String bm02attr) {
		this.bm02attr = bm02attr;
	}
}
