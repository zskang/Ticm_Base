package com.joyin.ticm.datadict.model;

import java.util.Date;

import com.joyin.ticm.bean.BaseBean;

/**
 * 参数字典
 * 
 * @author guojie
 * @version 1.0
 * @since 2013-7-28, 下午04:38:13
 */
public class DataDict extends BaseBean {
    /** {field's description} */
    private static final long serialVersionUID = 76230010L;
    private long seqno;
    private DataList dataList;
    private String clsno;
    private String itemcode;
    private Integer orderno;
    private String cnname;
    private String enname;
    private String remark;
    private String mntflag;
    private Date inserttime;
    private String insertuser;
    private Date lstmntdate;
    private String lstmntuser;
    private String effectflag;

    /** default constructor */
    public DataDict() {
    }

    /** minimal constructor */
    public DataDict(DataList dataList, String itemcode) {
        this.dataList = dataList;
        this.itemcode = itemcode;
    }

    /** full constructor */
    public DataDict(String clsno, String itemcode, Integer orderno,
            String cnname, String enname, String remark, String mntflag,
            Date inserttime, String insertuser, Date lstmntdate,
            String lstmntuser, String effectflag) {
        this.clsno = clsno;
        this.itemcode = itemcode;
        this.orderno = orderno;
        this.cnname = cnname;
        this.enname = enname;
        this.remark = remark;
        this.mntflag = mntflag;
        this.inserttime = inserttime;
        this.insertuser = insertuser;
        this.lstmntdate = lstmntdate;
        this.lstmntuser = lstmntuser;
        this.effectflag = effectflag;
    }

    public long getSeqno() {
        return this.seqno;
    }

    public void setSeqno(long seqno) {
        this.seqno = seqno;
    }

    public String getClsno() {
        return clsno;
    }

    public void setClsno(String clsno) {
        this.clsno = clsno;
    }

    public DataList getDataList() {
        return this.dataList;
    }

    public void setDataList(DataList dataList) {
        this.dataList = dataList;
    }

    public String getItemcode() {
        return this.itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public Integer getOrderno() {
        return this.orderno;
    }

    public void setOrderno(Integer orderno) {
        this.orderno = orderno;
    }

    public String getCnname() {
        return this.cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public String getEnname() {
        return this.enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMntflag() {
        return this.mntflag;
    }

    public void setMntflag(String mntflag) {
        this.mntflag = mntflag;
    }

    public Date getInserttime() {
        return this.inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    public String getInsertuser() {
        return this.insertuser;
    }

    public void setInsertuser(String insertuser) {
        this.insertuser = insertuser;
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
}