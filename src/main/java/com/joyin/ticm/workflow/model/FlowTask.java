package com.joyin.ticm.workflow.model;

import java.sql.Timestamp;

public class FlowTask implements java.io.Serializable {

    /** {field's description} */
    private static final long serialVersionUID = 1L;

    /**
     * COMMENT ON COLUMN TICM.SYS_FLOW_TASK.DBID IS '主键ID'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_TASK.MODULEID IS '模块ID'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_TASK.FLOW_KEY IS '流程对应业务键值'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_TASK.TASK_NAME IS '任务名称'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_TASK.TASK_ORDER IS '任务排序'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_TASK.LSTMNTDATE IS '更新时间'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_TASK.LSTMNTUSER IS '更新人员'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_TASK.EFFECTFLAG IS '有效标志(A新建,E有效,D删除)';
     */
    private Integer dbid;
    private String moduleid;
    private String flowKey;
    private String taskName;
    private Integer taskOrder;
    private Timestamp lstmntdate;
    private String lstmntuser;
    private String effectflag;
    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;

    // Constructors

    /** default constructor */
    public FlowTask() {
    }

    /** minimal constructor */
    public FlowTask(String flowKey) {
        this.flowKey = flowKey;
    }

    /** full constructor */
    public FlowTask(String moduleid, String flowKey, String taskName,
            Integer taskOrder, Timestamp lstmntdate, String lstmntuser,
            String effectflag, String field1, String field2, String field3,
            String field4, String field5) {
        this.moduleid = moduleid;
        this.flowKey = flowKey;
        this.taskName = taskName;
        this.taskOrder = taskOrder;
        this.lstmntdate = lstmntdate;
        this.lstmntuser = lstmntuser;
        this.effectflag = effectflag;
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
    }

    // Property accessors

    public Integer getDbid() {
        return this.dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getModuleid() {
        return this.moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid;
    }

    public String getFlowKey() {
        return this.flowKey;
    }

    public void setFlowKey(String flowKey) {
        this.flowKey = flowKey;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTaskOrder() {
        return this.taskOrder;
    }

    public void setTaskOrder(Integer taskOrder) {
        this.taskOrder = taskOrder;
    }

    public Timestamp getLstmntdate() {
        return this.lstmntdate;
    }

    public void setLstmntdate(Timestamp lstmntdate) {
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

    public String getField1() {
        return this.field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return this.field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return this.field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return this.field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return this.field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

}
