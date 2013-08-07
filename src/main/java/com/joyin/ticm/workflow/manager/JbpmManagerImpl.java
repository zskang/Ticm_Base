package com.joyin.ticm.workflow.manager;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipInputStream;
import java.lang.reflect.Field;

import javax.annotation.Resource;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.HistoryService;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;
import org.jbpm.api.history.HistoryProcessInstance;
import org.jbpm.api.history.HistoryTask;
import org.jbpm.api.model.ActivityCoordinates;
import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.model.ActivityImpl;
import org.jbpm.pvm.internal.model.ExecutionImpl;
import org.jbpm.pvm.internal.model.ProcessDefinitionImpl;
import org.jbpm.pvm.internal.model.TransitionImpl;
import org.springframework.stereotype.Service;

import com.joyin.ticm.service.ServiceBase;

/**
 * 流程管理实现
 * 
 * @author zjs
 * @version 1.0
 * @since 2013-7-25, 下午03:31:01
 */
@Service("jbpmManager")
public class JbpmManagerImpl extends ServiceBase implements JbpmManager {

    // private ProcessEngine processEngine;
    @Resource
    private RepositoryService repositoryService;
    @Resource
    private ExecutionService executionService;
    @Resource
    private HistoryService historyService;
    @Resource
    private TaskService taskService;

    // private IdentityService identityService;

    /**
     * 流程定义文件列表
     */
    public static interface JbpmConstant {
        // 测试流程文件
        final String jbmp_test_key = "jbpmtest";
        final String jbmp_jbpmtest_file_0 = "jbpm/depleve.jpdl.xml";// xml file
        final String jbmp_jbpmtest_file_1 = "jbpm/depleve.zip"; // zip file
        final String jbmp_jbpmtest_file_2 = "jbpm/depleve.png";// png file
    }

    /**
     * 获取流程定义文件
     * 
     * @param flowKey
     *            流程Key
     * @param iType
     *            0 xml文件 1 zip文件
     * @return
     * @author zjs
     */
    public String getJbpmDesignFile(String flowKey, int iType) {
        String filePath = null;

        String sFieldName = "jbmp_" + flowKey + "_file_"
                + String.valueOf(iType);

        try {
            Field field = JbpmConstant.class.getField(sFieldName);
            filePath = field.get(null).toString();
        }
        catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return filePath;
    }

    /**
     * 部署流程
     */
    @Override
    public String deployByXml(String flowKey) {
        String methodName = "deployByXml";
        info(methodName, "flowKey: " + flowKey);

        // 获取文件路径
        String filePath = null;
        filePath = getJbpmDesignFile(flowKey, 0);

        String did = repositoryService.createDeployment()
                .addResourceFromClasspath(filePath).addResourceFromClasspath(
                        getJbpmDesignFile(flowKey, 2)).deploy();

        debug("deployid: ", did);
        return did;
    }

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
        String methodName = "deployByJpdlFile";
        info(methodName, "jpdlFilePath: " + jpdlFilePath);

        // 获取png文件路径
        String pngFilePath = null;
        pngFilePath = jpdlFilePath.replaceAll(".jpdl.xml", ".png");

        //部署流程
        String did = repositoryService.createDeployment()
                .addResourceFromClasspath(jpdlFilePath)
                .addResourceFromClasspath(pngFilePath).deploy();

        debug("deployid: ", did);
        return did;
    }

    /**
     * 部署流程
     */
    @Override
    public String deployByZip(String flowKey) {
        String methodName = "deployByZip";
        info(methodName, "flowKey: " + flowKey);

        // 获取文件路径
        String filePath = null;
        filePath = getJbpmDesignFile(flowKey, 1);

        ZipInputStream zis = new ZipInputStream(this.getClass()
                .getResourceAsStream(filePath));
        String did = repositoryService.createDeployment()
                .addResourcesFromZipInputStream(zis).deploy();

        debug("deployid: ", did);
        return did;
    }

    /**
     * 删除流程部署 根据流程ID
     */
    @Override
    public void undeploy(String id) {
        repositoryService.deleteDeploymentCascade(id);
    }

    /**
     * 创建流程实例 同时将业务主键存入表中
     */
    @Override
    public String startByKey(String sKey, Map<String, Object> map, String linkId) {
        if (map == null) {
            return executionService.startProcessInstanceByKey(sKey, linkId)
                    .getId();
        }
        else {
            return executionService
                    .startProcessInstanceByKey(sKey, map, linkId).getId();
        }
    }

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
    @Override
    public String startProcessTask(String key, Map<String, Object> map,
            String userId, String linkId) {

        String processId = startByKey(key, map, linkId);

        // 查询活动任务
        List<Task> list = taskService.createTaskQuery().assignee(userId)
                .executionId(processId).list();

        // 提交任务
        if (list.size() > 0) {
            for (Task task : list) {
                taskService.completeTask(task.getId());
            }
        }
        return processId;
    }

    /**
     * 将任务流转到指定名字的流程outcome中去，并携带参数,携带提交意见
     * 
     * @param taskId
     * @param outcome
     * @param map
     * @param comment
     * @author Administrator
     */
    @Override
    public void completeTask(String taskId, Map<String, Object> map,
            String comment) {
        if (map != null) {
            taskService.setVariables(taskId, map);// 参数
        }

        if (null != comment) {
            taskService.addTaskComment(taskId, comment);// 保存意见
        }
        taskService.completeTask(taskId); // 执行任务并调转到指定的任务
    }

    /**
     * 将任务流转到指定名字的流程outcome中去，并携带参数
     * 
     * @param taskId
     * @param outcome
     * @param map
     * @author Administrator
     */
    @Override
    public void complateTask(String taskId, String outcome,
            Map<String, Object> map, String comment) {
        if (map != null) {
            taskService.setVariables(taskId, map);
        }
        if (comment != null) {
            taskService.addTaskComment(taskId, comment);
        }
        taskService.completeTask(taskId, outcome); // 执行任务并调转到指定的任务
    }

    @Override
    public void rollback(String taskId) {
        /** 开启环境 不影响事务 只会对本次流转有效 */
        // EnvironmentImpl envImpl = ((EnvironmentFactory) processEngine)
        // .openEnvironment();

        /** 任务 */

        Task task = taskService.getTask(taskId);
        /** 要去的节点名 */
        String activityName = "leave";
        /** 获取流转实例对象 */
        ExecutionImpl e = (ExecutionImpl) executionService
                .findExecutionById(task.getExecutionId());
        /** 根据流转对象获取当前流转所在的节点 */
        ActivityImpl activity = e.getActivity();
        /** 通过节点获取该节点所对应的流转实例 */
        ProcessDefinitionImpl processDefinitionImpl = activity
                .getProcessDefinition();
        /** 根据节点名查找出目标的节点 */
        ActivityImpl destActivityImpl = processDefinitionImpl
                .findActivity(activityName);
        /** 根据当前节点创建一个流转 */
        TransitionImpl transactionImpl = activity.createOutgoingTransition();
        /** 设置该流转的当前节点 */
        transactionImpl.setSource(activity);
        /** 设置该流转的目标节点 */
        transactionImpl.setDestination(destActivityImpl);
        /** 为该流转起名 */
        transactionImpl.setName("temp");

        /** 关闭这个环境已保证事务正常 */
        // envImpl.close();

        /** 将该任务提交当这个流转中去 */
        taskService.completeTask(task.getId(), transactionImpl.getName());
    }

    /**
     * 获取所有流程定义
     */
    @Override
    public List<ProcessDefinition> getProcessDefinitions() {
        return repositoryService.createProcessDefinitionQuery().list();
    }

    public List<ProcessInstance> getProcessInstances() {
        return executionService.createProcessInstanceQuery().list();
    }

    public List<Task> getTasks(String roleName) {
        return taskService.findPersonalTasks(roleName);
    }

    public Map<String, Object> manager(String id) {
        Task task = taskService.getTask(id);
        String taskId = task.getId();
        Set<String> strSet = new HashSet<String>();
        strSet.add("owner");
        strSet.add("day");
        strSet.add("reason");
        strSet.add("name");

        return taskService.getVariables(taskId, strSet);
    }

    public Map<String, Object> boss(String id) {
        Task task = taskService.getTask(id);
        String taskId = task.getId();
        Set<String> strSet = new HashSet<String>();
        strSet.add("owner");
        strSet.add("day");
        strSet.add("reason");
        strSet.add("name");
        strSet.add("age");
        strSet.add("address");
        return taskService.getVariables(taskId, strSet);
    }

    public List<HistoryProcessInstance> getHistoryProcessInstances() {
        return historyService.createHistoryProcessInstanceQuery().list();
        // return historyService.createHistoryDetailQuery().list();
    }

    /**
     * 根据实例ID获取 当前活动节点坐标
     * 
     * @param 实例ID
     * @return
     * @author zjs
     */
    @Override
    public List<ActivityCoordinates> findActivityCoordinates(String id) {
        ProcessInstance processInstance = executionService
                .findProcessInstanceById(id);
        List<ActivityCoordinates> actyList = new ArrayList<ActivityCoordinates>();
        Set<String> activityNames = processInstance.findActiveActivityNames();

        for (String activityName : activityNames) {

            actyList.add(repositoryService.getActivityCoordinates(
                    processInstance.getProcessDefinitionId(), activityName));
        }
        System.out.println("actyList:  " + actyList.size());
        // return repositoryService.getActivityCoordinates(processInstance
        // .getProcessDefinitionId(), activityNames.iterator().next());
        return actyList;
    }

    /**
     * 根据实例ID获取 流程图片文件流
     * 
     * @param 实例ID
     * @return
     * @author zjs
     */
    @Override
    public InputStream findPicInputStream(String id) {
        ProcessInstance processInstance = executionService
                .findProcessInstanceById(id);
        String processDefinitionId = processInstance.getProcessDefinitionId();
        ProcessDefinition processDefinition = repositoryService
                .createProcessDefinitionQuery().processDefinitionId(
                        processDefinitionId).uniqueResult();

        System.out.println("processDefinition:  " + processDefinition);
        System.out.println("DeploymentId:  "
                + processDefinition.getDeploymentId());

        return repositoryService.getResourceAsStream(processDefinition
                .getDeploymentId(), "jbpm/depleve.png");
    }

    public void complateByBoss(String id) {
        taskService.completeTask(id);
    }

    @Override
    public List<HistoryTask> getHistoryTaskList(String username) {
        List<HistoryTask> list = new ArrayList<HistoryTask>();
        List<HistoryTask> listTask = historyService.createHistoryTaskQuery()
                .assignee(username).list();
        for (HistoryTask task : listTask) {
            if (task.getState() != null) {
                // 过滤没有完成的任务
                if (task.getState().equals("completed")) {
                    list.add(task);
                }
            }
        }
        return list;
    }

    @Override
    public String getCurrectAcvitityName(String processId) {
        String taskName = executionService.createProcessInstanceQuery()
                .processInstanceId(processId).uniqueResult()
                .findActiveActivityNames().toString();
        return taskName;
    }

    @Override
    public String getCurrectTaskId(String processId) {
        List<Task> list = taskService.createTaskQuery().executionId(
                "de.SIM40001").list();
        String taskID = "";
        if (list.size() > 0) {
            for (Task task : list) {
                taskID = task.getId();
            }
        }

        return taskID;
    }

    @Override
    public String getProcessId(String taskId) {
        return taskService.getTask(taskId).getExecutionId();
    }

    @Override
    public String getProcessKey(String processId) {
        // TODO Auto-generated method stub
        return processId.substring(0, processId.indexOf("."));
    }

    @Override
    public String getTaskName(String taskId) {
        return taskService.getTask(taskId).getActivityName();
    }

    @Override
    public boolean isProcessEnd(String processId) {
        boolean res = false;
        List<HistoryProcessInstance> list = historyService
                .createHistoryProcessInstanceQuery().list();
        for (HistoryProcessInstance h : list) {
            if (h.getProcessInstanceId().equals(processId)) {
                if (h.getState().equals("ended")) {
                    res = true;
                    break;
                }
                else {
                    res = false;
                }
            }
            else {
                res = false;
            }
        }

        return res;
    }

}
