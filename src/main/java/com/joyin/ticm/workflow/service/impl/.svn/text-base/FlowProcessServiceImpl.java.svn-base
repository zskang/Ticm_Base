package com.joyin.ticm.workflow.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.joyin.ticm.bean.DataForm;
import com.joyin.ticm.dao.BaseDao;
import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.service.ServiceBase;
import com.joyin.ticm.service.ServiceException;
import com.joyin.ticm.workflow.dao.FlowProcessDao;
import com.joyin.ticm.workflow.dao.FlowTaskDao;
import com.joyin.ticm.workflow.manager.JbpmManager;
import com.joyin.ticm.workflow.model.FlowProcess;
import com.joyin.ticm.workflow.model.FlowTask;
import com.joyin.ticm.workflow.service.FlowProcessService;

/**
 * 业务与流程关联 逻辑接口实现类
 * 
 * @author zhangming
 * @version 1.0
 * @since 2013-7-29, 上午09:48:30
 */
@Service("flowProcessService")
public class FlowProcessServiceImpl extends ServiceBase implements
        FlowProcessService {

    @Resource
    private BaseDao baseDao;
    @Resource
    private FlowTaskDao flowTaskDao;
    @Resource
    private FlowProcessDao flowProcessDao;
    @Resource
    private JbpmManager jbpmManager;
    
    
    /**
     * 根据流程定义文件部署流程
     * 
     * @param jpdlFilePath
     *            流程定义文件(jbpm/depleve.jpdl.xml)
     * @return
     * @author zjs
     */
    @Override
    public String deployByJpdlFile(String jpdlFilePath) {
        return jbpmManager.deployByJpdlFile(jpdlFilePath);
    }

    /**
     * 根据key 创建流程实例，并添加业务与流程关联的数据(用于申请中的保存按钮操作)
     * 
     * @param key
     *            流程key(如果 债券自营交易 SECTYPE 使用常量)
     * @param map
     *            需要携带的流程参数。如果没有写成 null
     * @param object 业务对象（业务关联ID,经办人,当前操作模块ID）
     * @return 流程实例ID
     * @author zhangming
     */
    @Override
    public String startByKey(String key, Map<String, Object> map, Object object)
            throws ServiceException {
        String methodName = "startByKey";

        DataForm dataForm = (DataForm) object;

        // 业务关联ID
        String linkid = dataForm.getLinkid();

        info(methodName, "key: " + key + " linkId:" + linkid);

        // 创建实例
        String processId = jbpmManager.startByKey(key, map, linkid);

        try {
            // 先添加第一个任务数据
            addFlowProcess(dataForm, processId, "create");
        }
        catch (DaoException ex) {
            String message = "添加业务与流程关联数据错误";
            this.processException(methodName, message, "", ex);
        }
        return processId;
    }

    /**
     * 创建实例并执行任务(用于申请中的保存并提交操作)，并添加业务与流程关联的数据
     * 
     * @param key
     *            流程文件中的key
     * @param map
     *            需要携带的流程参数。如果没有写成 null
     * @object dataForm对象（业务关联ID,经办人,当前操作模块ID）
     * @return 流程实例ID
     * @author zhangming
     */
    @Override
    public String startProcessTask(String key, Map<String, Object> map,
            Object object) throws ServiceException {
        String methodName = "startProcessTask";
        DataForm dataForm = (DataForm) object;

        // 业务关联ID
        String linkId = dataForm.getLinkid();
        // 经办人
        String userId = dataForm.getTraUserid();
        // 提交人
        dataForm.setSubUserid(userId);

        info(methodName, "key: " + key + " linkId:" + linkId + " userId:"
                + userId);

        String processId = jbpmManager.startProcessTask(key, map, userId,
                linkId);
        try {
            // 先添加第一个任务数据
            addFlowProcess(dataForm, processId, "create");
            // 更新当前任务数据
            updateFlowProcess(dataForm, processId, "");

            // 添加下一个任务数据
            addFlowProcess(dataForm, processId, "add");
        }
        catch (DaoException ex) {
            String message = "更新或添加业务与流程关联数据错误";
            this.processException(methodName, message, "", ex);
        }
        return processId;
    }

    /**
     * 按流程顺序执行任务
     */
    @Override
    public void complateTask(String taskId, Map<String, Object> map,
            Object object) throws ServiceException {
        String methodName = "complateTask";
        DataForm dataForm = (DataForm) object;

        // 当前用户人
        String userId = dataForm.getLoginUserid();
        String comment = null;

        if (null != dataForm.getFlowRemark()) {
            comment = dataForm.getFlowRemark();
        }

        info(methodName, " taskId:" + taskId + " userId:" + userId);

        // 获取实例ID
        String processId = jbpmManager.getProcessId(taskId);

        jbpmManager.completeTask(taskId, map, comment);

        // 先更新数据，后添加一条数据
        try {
            updateFlowProcess(dataForm, processId, "");

            addFlowProcess(dataForm, processId, "add");
        }
        catch (DaoException ex) {
            String message = "更新或添加业务与流程关联数据错误";
            this.processException(methodName, message, "", ex);
        }
    }

    @Override
    public void complateTask(String taskId, String outcome,
            Map<String, Object> map, Object object) throws ServiceException {
        String methodName = "complateTask";

        DataForm dataForm = (DataForm) object;

        // 当前用户人
        String userId = dataForm.getLoginUserid();
        String comment = null;

        if (null != dataForm.getFlowRemark()) {
            comment = dataForm.getFlowRemark();
        }

        info(methodName, " taskId:" + taskId + " userId:" + userId);

        String processId = jbpmManager.getProcessId(taskId);

        jbpmManager.complateTask(taskId, outcome, map, comment);

        // 先更新数据，后添加一条数据
        try {
            updateFlowProcess(dataForm, processId, comment);
            addFlowProcess(dataForm, processId, "add");
        }
        catch (DaoException ex) {
            String message = "更新或添加业务与流程关联数据错误";
            this.processException(methodName, message, "", ex);
        }
    }

    /**
     * 执行任务 驳回
     * 
     * @param taskId
     *            当前任务ID
     * @param comment
     *            驳回意见
     * @param object
     *            业务对象
     * @throws ServiceException
     * @author zhangming
     */
    @Override
    public void rollBack(String taskId, Object object) throws ServiceException {

        String methodName = "rollBack";
        DataForm dataForm = (DataForm) object;
        String comment = dataForm.getFlowRemark();

        info(methodName, " [taskId]:" + taskId + " [comment]:" + comment);

        // 实例id
        String processId = jbpmManager.getProcessId(taskId);

        // 驳回操作名称
        String outcome = getRollBackProperties(taskId);

        jbpmManager.complateTask(taskId, outcome, null, comment);
        // 处理业务与流程管理的数据
        try {
            // 更新数据
            updateFlowProcess(dataForm, processId, comment);

            // 再添加数据
            addFlowProcess(dataForm, processId, "add");
        }
        catch (DaoException ex) {
            String message = "更新或添加业务与流程关联数据错误";
            this.processException(methodName, message, "", ex);
        }

    }

    // /=======================与业务关联的数据

    /**
     * 更新业务与流程表数据
     * 
     * @param object
     *            dataForm对象
     * @param processid
     *            流程实例ID
     * @param comment 审批意见
     * @author zhangming
     * @throws DaoException
     */
    private void updateFlowProcess(DataForm dataForm, String processId,
            String comment) throws DaoException {
        // DataForm dataForm = (DataForm) object;
        // 根据流程实例Id获取业务与实例关联表中的数据 以主键ID倒序排列 返回list
        List<FlowProcess> list = flowProcessDao.findByProperty(processId);
        if (list.size() == 0) {
            return;
        }
        FlowProcess flowInfo = list.get(0);// 第一个值表示需要更新的值

        flowInfo.setTaskState("2");// 任务状态为 完成任务
        flowInfo.setLstmntdate(new Timestamp(new Date().getTime()));// 更新时间
        flowInfo.setSubuserid(dataForm.getSubUserid());// 更新人

        flowInfo.setRemark(comment);// 审批意见
        baseDao.update(flowInfo);
    }

    /**
     * 添加业务与流程关联的数据
     * 
     * @param object
     *            dataForm对象
     * @param processid
     *            流程实例ID
     * @param type
     *            类型 是创建流程实例时添加(create) 执行任务添加(add)
     * @author zhangming
     * @throws DaoException
     */
    private void addFlowProcess(DataForm dataForm, String processid, String type)
            throws DaoException {
        String methodName = "addFlowProcess";
        // 如果是执行任务的时候添加数据。判断流程是否结束。如果为结束将不在添加数据，
        if (type.equals("add")) {
            boolean res = jbpmManager.isProcessEnd(processid);
            // 控制台输出
            info(methodName, processid + "流程是否结束：" + res);
            if (res) {
                return;
            }
        }
        String traUserid = "";// 经办人

        if (type.equals("create")) {
            traUserid = dataForm.getTraUserid();
            String modelId = dataForm.getOwnedModuleid();

            addFlowProcessData(dataForm, modelId, traUserid, processid);

        }
        else {
//            // 查找经办人
//            List<FlowProcess> list = flowProcessDao.findByProperty(
//                    "jbpmProcessid", processid);
//            if (list.size() != 0) {
//                traUserid = list.get(0).getTrauserid();
//            }
            traUserid = dataForm.getTraUserid();

            String taskName = jbpmManager.getCurrectAcvitityName(processid);
            String[] taskNames = taskName.split(",");
            for (int i = 0; i < taskNames.length; i++) {
                String modelId = getModelIdFlowTask(processid, taskNames[i]);
                if (modelId != "") {
                    addFlowProcessData(dataForm, modelId, traUserid, processid);
                }

            }

        }
    }

    /**
     * 添加FlowProcess表中的数据
     * @param dataForm 
     * @param modelId 模块ID
     * @param traUserid 经办人
     * @param processId 流程实例ID
     * @throws DaoException
     * @author zhangming
     */
    public void addFlowProcessData(DataForm dataForm, String modelId,
            String traUserid, String processId) throws DaoException {
        String methodName = "addFlowProcessData";
        info(methodName, "[modelId]:" + modelId + " [traUserid]:" + traUserid
                + " [processId]:" + processId);
        FlowProcess flowProcess = new FlowProcess();

        String subUserid = dataForm.getSubUserid();// 提交人

        String stateName = jbpmManager.getCurrectAcvitityName(processId);// 任务状态名称
        String taskId = jbpmManager.getCurrectTaskId(processId);// 获取任务ID
        String linkid = dataForm.getLinkid();
        flowProcess.setLinkid(linkid);
        flowProcess.setTrauserid(traUserid);
        flowProcess.setModuleid(modelId);
        flowProcess.setEffectflag("E");// 有效表示 有效
        flowProcess.setSubuserid(subUserid);
        flowProcess.setTaskId(Long.parseLong(taskId));
        flowProcess.setTaskState("1");// 任务状态为活动

        flowProcess.setStateName(stateName);
        flowProcess.setJbpmProcessid(processId);// 关联流程实例ID

        baseDao.save(flowProcess);
    }

    /**
     * 根据流程实例ID与节点名称 在FlowTask表获取模块ID
     * 
     * @param processId
     *            流程实例ID
     * @param taskName
     *            节点名称
     * @return modelID （模块ID）
     * @author zhangming
     * @throws DaoException
     */
    private String getModelIdFlowTask(String processId, String taskName)
            throws DaoException {

        String key = jbpmManager.getProcessKey(processId);
        List<FlowTask> list = flowTaskDao.findFlowTaskList(taskName, key);
        if (list.size() == 0) {
            return "";
        }
        else {
            return list.get(0).getModuleid();
        }
    }

    /**
     * 根据任务ID 在jbpm.properties 配置文件中rollback 驳回的名称
     * 
     * @param taskId
     *            任务ID
     * @return jbpm.properties配置文件中value字段。驳回名称
     * @author zhangming
     */
    private String getRollBackProperties(String taskId) {

        String taskName = jbpmManager.getTaskName(taskId);
        String processId = jbpmManager.getProcessId(taskId);
        String key = jbpmManager.getProcessKey(processId);
        String keyCode = key + "_" + taskName + "_rollback";

        return flowProcessDao.getJBPMValue(keyCode);
    }

}
