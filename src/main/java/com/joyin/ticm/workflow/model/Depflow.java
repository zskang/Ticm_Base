package com.joyin.ticm.workflow.model;

import com.joyin.ticm.bean.DataForm;



/**
 * 用户实体对象
 * 
 * @author zjs
 * @version 1.0
 * @since Jul 20, 2013, 10:06:17 AM
 */

public class Depflow  extends DataForm {


    // Fields    

     /** {field's description} */
	 private static final long serialVersionUID = 1L;
	
	 private Long depid;
     private String depno;
     private Double depmoney;
     private Integer depdays;
     private Double deple;
     private String depuser;
     private String deprmark;


    // Constructors

    /** default constructor */
    public Depflow() {
    }

	/** minimal constructor */
    public Depflow(Long depid, String depno) {
        this.depid = depid;
        this.depno = depno;
    }
    
    /** full constructor */
    public Depflow(Long depid, String depno, Double depmoney, Integer depdays, Double deple, String depuser, String deprmark) {
        this.depid = depid;
        this.depno = depno;
        this.depmoney = depmoney;
        this.depdays = depdays;
        this.deple = deple;
        this.depuser = depuser;
        this.deprmark = deprmark;
    }

   
    // Property accessors

    public Long getDepid() {
        return this.depid;
    }
    
    public void setDepid(Long depid) {
        this.depid = depid;
    }

    public String getDepno() {
        return this.depno;
    }
    
    public void setDepno(String depno) {
        this.depno = depno;
    }

    public Double getDepmoney() {
        return this.depmoney;
    }
    
    public void setDepmoney(Double depmoney) {
        this.depmoney = depmoney;
    }

    public Integer getDepdays() {
        return this.depdays;
    }
    
    public void setDepdays(Integer depdays) {
        this.depdays = depdays;
    }

    public Double getDeple() {
        return this.deple;
    }
    
    public void setDeple(Double deple) {
        this.deple = deple;
    }

    public String getDepuser() {
        return this.depuser;
    }
    
    public void setDepuser(String depuser) {
        this.depuser = depuser;
    }

    public String getDeprmark() {
        return this.deprmark;
    }
    
    public void setDeprmark(String deprmark) {
        this.deprmark = deprmark;
    }
   








}