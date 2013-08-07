package com.joyin.ticm.account.model;

import com.joyin.ticm.bean.DataForm;

// default package

/**
 * AccountId entity. @author MyEclipse Persistence Tools
 */

public class AccountId extends DataForm {

    // Fields

    /** {field's description} */
    private static final long serialVersionUID = 1L;
    private String bm02orgno;
    private String accounttype;

    // Constructors

    /** default constructor */
    public AccountId() {
    }

    /** full constructor */
    public AccountId(String bm02orgno, String accounttype) {
        this.bm02orgno = bm02orgno;
        this.accounttype = accounttype;
    }

    // Property accessors

    public String getBm02orgno() {
        return this.bm02orgno;
    }

    public void setBm02orgno(String bm02orgno) {
        this.bm02orgno = bm02orgno;
    }

    public String getAccounttype() {
        return this.accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof AccountId))
            return false;
        AccountId castOther = (AccountId) other;

        return ((this.getBm02orgno() == castOther.getBm02orgno()) || (this
                .getBm02orgno() != null
                && castOther.getBm02orgno() != null && this.getBm02orgno()
                .equals(castOther.getBm02orgno())))
                && ((this.getAccounttype() == castOther.getAccounttype()) || (this
                        .getAccounttype() != null
                        && castOther.getAccounttype() != null && this
                        .getAccounttype().equals(castOther.getAccounttype())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result
                + (getBm02orgno() == null ? 0 : this.getBm02orgno().hashCode());
        result = 37
                * result
                + (getAccounttype() == null ? 0 : this.getAccounttype()
                        .hashCode());
        return result;
    }

}