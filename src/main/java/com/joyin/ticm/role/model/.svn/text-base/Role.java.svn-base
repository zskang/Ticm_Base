package com.joyin.ticm.role.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.joyin.ticm.bean.DataForm;

/**
 * 角色实体类
 * 
 * @author jianghaitao
 * @version 1.0
 * @since 2013-7-22, 上午08:53:31
 */
@SuppressWarnings("unchecked")
public class Role extends DataForm {

    // Fields

    /** {field's description} */
    private static final long serialVersionUID = 1L;
    private Integer roleid;
    private String rolename;
    private String description;
    private Date lstmntdate;
    private String lstmntuser;
    private String effectflag;
    private String orgid;
    private Set sysRolepermits = new HashSet(0);
    private Set sysUserroles = new HashSet(0);

    // Constructors

    /** default constructor */
    public Role() {
    }

    /** minimal constructor */
    public Role(String rolename) {
        this.rolename = rolename;
    }

    /** full constructor */
    public Role(String rolename, String description, Date lstmntdate,
            String lstmntuser, String effectflag, String orgid,
            Set sysRolepermits, Set sysUserroles) {
        this.rolename = rolename;
        this.description = description;
        this.lstmntdate = lstmntdate;
        this.lstmntuser = lstmntuser;
        this.effectflag = effectflag;
        this.orgid = orgid;
        this.sysRolepermits = sysRolepermits;
        this.sysUserroles = sysUserroles;
    }

    // Property accessors

    public Integer getRoleid() {
        return this.roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return this.rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getEffectflag() {
        return this.effectflag;
    }

    public void setEffectflag(String effectflag) {
        this.effectflag = effectflag;
    }

    public String getOrgid() {
        return this.orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public Set getSysRolepermits() {
        return this.sysRolepermits;
    }

    public void setSysRolepermits(Set sysRolepermits) {
        this.sysRolepermits = sysRolepermits;
    }

    public Set getSysUserroles() {
        return this.sysUserroles;
    }

    public void setSysUserroles(Set sysUserroles) {
        this.sysUserroles = sysUserroles;
    }

}