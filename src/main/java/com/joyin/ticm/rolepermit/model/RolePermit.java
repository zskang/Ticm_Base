package com.joyin.ticm.rolepermit.model;

// default package

import java.util.Date;

import com.joyin.ticm.bean.DataForm;
import com.joyin.ticm.module.model.Module;
import com.joyin.ticm.role.model.Role;

/**
 * RolePermit entity. @author MyEclipse Persistence Tools
 */

public class RolePermit extends DataForm {

    // Fields

    /** {field's description} */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Module module;
    private Role role;
    private Integer procid;
    private String lstmntuser;
    private Date lstmntdate;

    // Constructors

    /** default constructor */
    public RolePermit() {
    }

    /** minimal constructor */
    public RolePermit(Module module, Role role) {
        this.module = module;
        this.role = role;
    }

    /** full constructor */
    public RolePermit(Module module, Role role, Integer procid,
            String lstmntuser, Date lstmntdate) {
        this.module = module;
        this.role = role;
        this.procid = procid;
        this.lstmntuser = lstmntuser;
        this.lstmntdate = lstmntdate;
    }

    // Property accessors

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Module getModule() {
        return this.module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getProcid() {
        return this.procid;
    }

    public void setProcid(Integer procid) {
        this.procid = procid;
    }

    public String getLstmntuser() {
        return this.lstmntuser;
    }

    public void setLstmntuser(String lstmntuser) {
        this.lstmntuser = lstmntuser;
    }

    public Date getLstmntdate() {
        return this.lstmntdate;
    }

    public void setLstmntdate(Date lstmntdate) {
        this.lstmntdate = lstmntdate;
    }

}