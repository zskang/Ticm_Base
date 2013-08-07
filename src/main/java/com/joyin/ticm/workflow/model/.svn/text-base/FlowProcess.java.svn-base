package com.joyin.ticm.workflow.model;
import java.sql.Timestamp;

/**
 * 业务与流程关联 Moedel层
 * @author zhangming
 */

public class FlowProcess implements java.io.Serializable {

    /**
     * COMMENT ON COLUMN TICM.SYS_FLOW_PROCESS.DBID IS '主键ID'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_PROCESS.LINKID IS '业务关联ID'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_PROCESS.MODULEID IS '模块ID'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_PROCESS.JBPM_PROCESSID IS '流程实例ID'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_PROCESS.FLOW_KEY IS '流程对应业务键值'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_PROCESS.TRAUSERID IS '流程发起人'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_PROCESS.SUBUSERID IS '流程任务操作人'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_PROCESS.CDATE IS '流程创建时间'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_PROCESS.TASK_ID IS '任务ID'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_PROCESS.TASK_STATE IS '任务状态( 1 活动，5完成)'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_PROCESS.STATE_NAME IS '任务状态名称'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_PROCESS.REMARK IS '复核审批意见'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_PROCESS.LSTMNTDATE IS '更新时间'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_PROCESS.LSTMNTUSER IS '更新人员'; COMMENT ON COLUMN
     * TICM.SYS_FLOW_PROCESS.EFFECTFLAG IS '有效标志(A新建,E有效,D删除)';
     */

    // Fields

    /** {field's description} */
    private static final long serialVersionUID = 1L;
    // Fields

    private Long dbid;
    private String linkid;
    private String moduleid;
    private String jbpmProcessid;
    private String flowKey;
    private String trauserid;
    private String subuserid;
    private Timestamp cdate;
    private Long taskId;
    private String taskState;
    private String stateName;
    private String remark;
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
    public FlowProcess() {
    }

    /** minimal constructor */
    public FlowProcess(String linkid, String jbpmProcessid, String flowKey,
            String trauserid, String subuserid) {
        this.linkid = linkid;
        this.jbpmProcessid = jbpmProcessid;
        this.flowKey = flowKey;
        this.trauserid = trauserid;
        this.subuserid = subuserid;
    }

    /** full constructor */
    public FlowProcess(String linkid, String moduleid, String jbpmProcessid,
            String flowKey, String trauserid, String subuserid,
            Timestamp cdate, Long taskId, String taskState, String stateName,
            String remark, Timestamp lstmntdate, String lstmntuser,
            String effectflag, String field1, String field2, String field3,
            String field4, String field5) {
        this.linkid = linkid;
        this.moduleid = moduleid;
        this.jbpmProcessid = jbpmProcessid;
        this.flowKey = flowKey;
        this.trauserid = trauserid;
        this.subuserid = subuserid;
        this.cdate = cdate;
        this.taskId = taskId;
        this.taskState = taskState;
        this.stateName = stateName;
        this.remark = remark;
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

    public Long getDbid() {
        return this.dbid;
    }

    public void setDbid(Long dbid) {
        this.dbid = dbid;
    }

    public String getLinkid() {
        return this.linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid;
    }

    public String getModuleid() {
        return this.moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid;
    }

    public String getJbpmProcessid() {
        return this.jbpmProcessid;
    }

    public void setJbpmProcessid(String jbpmProcessid) {
        this.jbpmProcessid = jbpmProcessid;
    }

    public String getFlowKey() {
        return this.flowKey;
    }

    public void setFlowKey(String flowKey) {
        this.flowKey = flowKey;
    }

    public String getTrauserid() {
        return this.trauserid;
    }

    public void setTrauserid(String trauserid) {
        this.trauserid = trauserid;
    }

    public String getSubuserid() {
        return this.subuserid;
    }

    public void setSubuserid(String subuserid) {
        this.subuserid = subuserid;
    }

    public Timestamp getCdate() {
        return this.cdate;
    }

    public void setCdate(Timestamp cdate) {
        this.cdate = cdate;
    }

    public Long getTaskId() {
        return this.taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskState() {
        return this.taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }

    public String getStateName() {
        return this.stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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