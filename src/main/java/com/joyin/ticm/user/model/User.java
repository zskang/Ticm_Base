package com.joyin.ticm.user.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.joyin.ticm.bean.DataForm;

/**
 * 用户实体对象
 * 
 * @author colin
 * @version 1.0
 * @since Jul 20, 2013, 10:06:17 AM
 */
@SuppressWarnings("unchecked")
public class User extends DataForm {
	/** {field's description} */
	private static final long serialVersionUID = 76230001L;

	// Fields
	private String userid;
	private String tm01orgno;
	private String tm01dep;
	private String username;
	private String tm01styp;
	private String tm01ind;
	private String tm01class;
	private String tm01lvlf;
	private String tm01cflg;
	private String tm01oprflg;
	private String tm01crdctl;
	private String tm01crdsts;
	private String tm01lsttyp;
	private String tm01icno;
	private String tm015sgnon;
	private String tm01mflg;
	private String tm01lvlb;
	private Date tm01edte;
	private Date tm01stdt;
	private Date tm01sttm;
	private String tm01pwd;
	private Date tm01edt;
	private String tm01pos;
	private String tm01nampn;
	private String tm01sex;
	private String tm01tmpsts;
	private String tm01cusmng;
	private String tm01idno;
	private String tm01payacc;
	private String tm01icac;
	private String tm01bsts;
	private String password;
	private Integer status;
	private String trad;
	private String adminflag;
	private String effectflag;
	private Date lstmntdate;
	private String lstmntuser;
	private Set sysUserroles = new HashSet();

	// Constructors
	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String tm01orgno) {
		this.tm01orgno = tm01orgno;
	}

	/** full constructor */
	public User(String tm01orgno, String tm01dep, String username,
			String tm01styp, String tm01ind, String tm01class, String tm01lvlf,
			String tm01cflg, String tm01oprflg, String tm01crdctl,
			String tm01crdsts, String tm01lsttyp, String tm01icno,
			String tm015sgnon, String tm01mflg, String tm01lvlb, Date tm01edte,
			Date tm01stdt, Date tm01sttm, String tm01pwd, Date tm01edt,
			String tm01pos, String tm01nampn, String tm01sex,
			String tm01tmpsts, String tm01cusmng, String tm01idno,
			String tm01payacc, String tm01icac, String tm01bsts,
			String password, Integer status, String trad, String adminflag,
			String effectflag, Date lstmntdate, String lstmntuser,
			Set sysUserroles) {
		this.tm01orgno = tm01orgno;
		this.tm01dep = tm01dep;
		this.username = username;
		this.tm01styp = tm01styp;
		this.tm01ind = tm01ind;
		this.tm01class = tm01class;
		this.tm01lvlf = tm01lvlf;
		this.tm01cflg = tm01cflg;
		this.tm01oprflg = tm01oprflg;
		this.tm01crdctl = tm01crdctl;
		this.tm01crdsts = tm01crdsts;
		this.tm01lsttyp = tm01lsttyp;
		this.tm01icno = tm01icno;
		this.tm015sgnon = tm015sgnon;
		this.tm01mflg = tm01mflg;
		this.tm01lvlb = tm01lvlb;
		this.tm01edte = tm01edte;
		this.tm01stdt = tm01stdt;
		this.tm01sttm = tm01sttm;
		this.tm01pwd = tm01pwd;
		this.tm01edt = tm01edt;
		this.tm01pos = tm01pos;
		this.tm01nampn = tm01nampn;
		this.tm01sex = tm01sex;
		this.tm01tmpsts = tm01tmpsts;
		this.tm01cusmng = tm01cusmng;
		this.tm01idno = tm01idno;
		this.tm01payacc = tm01payacc;
		this.tm01icac = tm01icac;
		this.tm01bsts = tm01bsts;
		this.password = password;
		this.status = status;
		this.trad = trad;
		this.adminflag = adminflag;
		this.effectflag = effectflag;
		this.lstmntdate = lstmntdate;
		this.lstmntuser = lstmntuser;
		this.sysUserroles = sysUserroles;
	}

	// Property accessors
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTm01orgno() {
		return this.tm01orgno;
	}

	public void setTm01orgno(String tm01orgno) {
		this.tm01orgno = tm01orgno;
	}

	public String getTm01dep() {
		return this.tm01dep;
	}

	public void setTm01dep(String tm01dep) {
		this.tm01dep = tm01dep;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTm01styp() {
		return this.tm01styp;
	}

	public void setTm01styp(String tm01styp) {
		this.tm01styp = tm01styp;
	}

	public String getTm01ind() {
		return this.tm01ind;
	}

	public void setTm01ind(String tm01ind) {
		this.tm01ind = tm01ind;
	}

	public String getTm01class() {
		return this.tm01class;
	}

	public void setTm01class(String tm01class) {
		this.tm01class = tm01class;
	}

	public String getTm01lvlf() {
		return this.tm01lvlf;
	}

	public void setTm01lvlf(String tm01lvlf) {
		this.tm01lvlf = tm01lvlf;
	}

	public String getTm01cflg() {
		return this.tm01cflg;
	}

	public void setTm01cflg(String tm01cflg) {
		this.tm01cflg = tm01cflg;
	}

	public String getTm01oprflg() {
		return this.tm01oprflg;
	}

	public void setTm01oprflg(String tm01oprflg) {
		this.tm01oprflg = tm01oprflg;
	}

	public String getTm01crdctl() {
		return this.tm01crdctl;
	}

	public void setTm01crdctl(String tm01crdctl) {
		this.tm01crdctl = tm01crdctl;
	}

	public String getTm01crdsts() {
		return this.tm01crdsts;
	}

	public void setTm01crdsts(String tm01crdsts) {
		this.tm01crdsts = tm01crdsts;
	}

	public String getTm01lsttyp() {
		return this.tm01lsttyp;
	}

	public void setTm01lsttyp(String tm01lsttyp) {
		this.tm01lsttyp = tm01lsttyp;
	}

	public String getTm01icno() {
		return this.tm01icno;
	}

	public void setTm01icno(String tm01icno) {
		this.tm01icno = tm01icno;
	}

	public String getTm015sgnon() {
		return this.tm015sgnon;
	}

	public void setTm015sgnon(String tm015sgnon) {
		this.tm015sgnon = tm015sgnon;
	}

	public String getTm01mflg() {
		return this.tm01mflg;
	}

	public void setTm01mflg(String tm01mflg) {
		this.tm01mflg = tm01mflg;
	}

	public String getTm01lvlb() {
		return this.tm01lvlb;
	}

	public void setTm01lvlb(String tm01lvlb) {
		this.tm01lvlb = tm01lvlb;
	}

	public Date getTm01edte() {
		return this.tm01edte;
	}

	public void setTm01edte(Date tm01edte) {
		this.tm01edte = tm01edte;
	}

	public Date getTm01stdt() {
		return this.tm01stdt;
	}

	public void setTm01stdt(Date tm01stdt) {
		this.tm01stdt = tm01stdt;
	}

	public Date getTm01sttm() {
		return this.tm01sttm;
	}

	public void setTm01sttm(Date tm01sttm) {
		this.tm01sttm = tm01sttm;
	}

	public String getTm01pwd() {
		return this.tm01pwd;
	}

	public void setTm01pwd(String tm01pwd) {
		this.tm01pwd = tm01pwd;
	}

	public Date getTm01edt() {
		return this.tm01edt;
	}

	public void setTm01edt(Date tm01edt) {
		this.tm01edt = tm01edt;
	}

	public String getTm01pos() {
		return this.tm01pos;
	}

	public void setTm01pos(String tm01pos) {
		this.tm01pos = tm01pos;
	}

	public String getTm01nampn() {
		return this.tm01nampn;
	}

	public void setTm01nampn(String tm01nampn) {
		this.tm01nampn = tm01nampn;
	}

	public String getTm01sex() {
		return this.tm01sex;
	}

	public void setTm01sex(String tm01sex) {
		this.tm01sex = tm01sex;
	}

	public String getTm01tmpsts() {
		return this.tm01tmpsts;
	}

	public void setTm01tmpsts(String tm01tmpsts) {
		this.tm01tmpsts = tm01tmpsts;
	}

	public String getTm01cusmng() {
		return this.tm01cusmng;
	}

	public void setTm01cusmng(String tm01cusmng) {
		this.tm01cusmng = tm01cusmng;
	}

	public String getTm01idno() {
		return this.tm01idno;
	}

	public void setTm01idno(String tm01idno) {
		this.tm01idno = tm01idno;
	}

	public String getTm01payacc() {
		return this.tm01payacc;
	}

	public void setTm01payacc(String tm01payacc) {
		this.tm01payacc = tm01payacc;
	}

	public String getTm01icac() {
		return this.tm01icac;
	}

	public void setTm01icac(String tm01icac) {
		this.tm01icac = tm01icac;
	}

	public String getTm01bsts() {
		return this.tm01bsts;
	}

	public void setTm01bsts(String tm01bsts) {
		this.tm01bsts = tm01bsts;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTrad() {
		return this.trad;
	}

	public void setTrad(String trad) {
		this.trad = trad;
	}

	public String getAdminflag() {
		return this.adminflag;
	}

	public void setAdminflag(String adminflag) {
		this.adminflag = adminflag;
	}

	public String getEffectflag() {
		return this.effectflag;
	}

	public void setEffectflag(String effectflag) {
		this.effectflag = effectflag;
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

	public Set getSysUserroles() {
		return this.sysUserroles;
	}

	public void setSysUserroles(Set sysUserroles) {
		this.sysUserroles = sysUserroles;
	}


}