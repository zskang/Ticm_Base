package com.joyin.ticm.datadict.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.joyin.ticm.bean.BaseBean;

/**
 * 参数类列表
 * 
 * @author guojie
 * @version 1.0
 * @since 2013-7-28, 下午04:20:34
 */
public class DataList extends BaseBean {


    /** {field's description} */
    private static final long serialVersionUID = 76230011L;
    // Fields
    private String clsno;
    private String clsname;
    private String flag;
    private String tblname;
    private String mntflag;
    private Date lstmntdate;
    private String lstmntuser;
    private String effectflag;
    private Set<DataDict> dataDicts = new HashSet<DataDict>(0);

    // Constructors

    /** default constructor */
    public DataList() {
    }

    /** full constructor */
    public DataList(String clsname, String flag, String tblname,
            String mntflag, Date lstmntdate, String lstmntuser,
            String effectflag, Set<DataDict> dataDicts) {
        this.clsname = clsname;
        this.flag = flag;
        this.tblname = tblname;
        this.mntflag = mntflag;
        this.lstmntdate = lstmntdate;
        this.lstmntuser = lstmntuser;
        this.effectflag = effectflag;
        this.dataDicts = dataDicts;
    }

    // Property accessors

    public String getClsno() {
        return this.clsno;
    }

    public void setClsno(String clsno) {
        this.clsno = clsno;
    }

    public String getClsname() {
        return this.clsname;
    }

    public void setClsname(String clsname) {
        this.clsname = clsname;
    }

    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getTblname() {
        return this.tblname;
    }

    public void setTblname(String tblname) {
        this.tblname = tblname;
    }

    public String getMntflag() {
        return this.mntflag;
    }

    public void setMntflag(String mntflag) {
        this.mntflag = mntflag;
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

    public Set<DataDict> getDataDicts() {
        return this.dataDicts;
    }

    public void setDataDicts(Set<DataDict> dataDicts) {
        this.dataDicts = dataDicts;
    }

}