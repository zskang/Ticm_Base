package com.joyin.ticm.workflow.manager;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.history.HistoryProcessInstance;
import org.jbpm.api.history.HistoryTask;
import org.jbpm.api.model.ActivityCoordinates;
import org.jbpm.api.task.Task;

/**
 * 流程管理接口类
 * 
 * @author zjs
 * @version 1.0
 * @since 2013-7-25, 下午03:31:01
 */
public interface JbpmManager {

    public List<ProcessDefinition> getProcessDefinitions();

    // ///============部署流程=====================
    /**
     * 根据流程定义的Key进行XML部署=
     * 
     * @param flowKey
     * @return
     * @author zjs
     */
    public String deployByXml(String flowKey);

    /**
     * 根据流程定义文件部署流程
     * 
     * @param jpdlFilePath
     *            流程定义文件(jbpm/depleve.jpdl.xml)
     * @return
     * @author zjs
     */
    public String deployByJpdlFile(String jpdlFilePath);

    /**
     * 根据流程定义的Key进行ZIP部署
     * 
     * @param flowKey
     * @return
     * @author zjs
     */
    public String deployByZip(String flowKey);

    /**
     * 删除流程定义
     * 
     * @param id
     * @author zjs
     */
    public void undeploy(String id);

    // ///=================创建流程实例

    public String startByKey(String sKey, Map<String, Object> map, String linkId);

    /**
     * 创建实例并执行任务(主要用于申请中的提交)
     * 
     * @author zhangming
     * @param key
     *            流程中key
     * @param map
     *            map参数
     * @param userId
     *            申请人(session userId)
     * @linkId 业务主键
     * @return
     */
    public String startProcessTask(String key, Map<String, Object> map,
            String userId, String linkId);

    public List<ProcessInstance> getProcessInstances();

    /**
     * 根据角色名称获取任务列表
     * 
     * @param roleName
     *            角色名称
     * @return
     */
    public List<Task> getTasks(String roleName);

    public Map<String, Object> manager(String id);

    public Map<String, Object> boss(String id);

    public void complateByBoss(String id);

    public List<HistoryProcessInstance> getHistoryProcessInstances();

    /**
     * 根据实例ID获取 当前活动节点坐标
     * 
     * @param 实例ID
     * @return
     * @author zjs
     */
    public List<ActivityCoordinates> findActivityCoordinates(String id);

    /**
     * 查看流程图片数据流
     * 
     * @param id
     *            实例ID
     * @return
     * @author zjs
     */
    public InputStream findPicInputStream(String id);

    /**
     * 动态创建流转驳回
     * 
     * @param taskId
     *            任务ID
     * @author zhangming
     */
    public void rollback(String taskId);

    // /////////////======================执行任务===================================

    /**
     * 执行任务，并携带参数,携带提交意见
     * 
     * @param taskId
     * @param map
     * @param comment
     * @author zjs
     */
    public void completeTask(String taskId, Map<String, Object> map,
            String comment);

    /**
     * 将任务流转到指定名字的流程outcome中去，并携带参数,携带提交意见
     * 
     * @param taskId
     * @param outcome
     * @param map
     * @param comment
     * @author zjs
     */
    public void complateTask(String taskId, String outcome,
            Map<String, Object> map, String comment);

    /**
     * 根据用户获取历史已经完成的任务
     * 
     * @param username
     *            用户名
     * @return
     * @author zhangming
     */
    public List<HistoryTask> getHistoryTaskList(String username);

    /**
     * 根据流程实例ID 获取当前任务节点名称
     * 
     * @processId 流程实例ID
     * @return 返回当前任务节点名称
     * @author zhangming
     */
    public String getCurrectAcvitityName(String processId);

    /**
     * 根据流程实例ID，获取当前任务ID
     * 
     * @param processId
     *            流程实例ID
     * @return 任务ID
     * @author zhangming
     */
    public String getCurrectTaskId(String processId);

    /**
     * 根据任务Id 获取到流程实例ID
     * 
     * @param taskId
     *            任务ID
     * @return 流程实例Id
     * @author zhangming
     */
    public String getProcessId(String taskId);

    /**
     * 根据流程实例ID 获取KEY
     * 
     * @param processId
     *            流程ID
     * @return 流程实例KEY
     * @author zhangming
     */
    public String getProcessKey(String processId);

    /**
     * 根据任务id 获取节点名称
     * 
     * @param taskId
     *            任务ID
     * @return 节点名称
     * @author zhangming
     */
    public String getTaskName(String taskId);

    /**
     * 判断当前流程是否结束
     * 
     * @param processId
     *            流程实例ID
     * @return
     * @author zhangming
     */
    public boolean isProcessEnd(String processId);

}
