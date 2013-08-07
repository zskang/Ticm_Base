package com.joyin.ticm.workflow.service;

import java.util.Map;

import com.joyin.ticm.service.ServiceException;

/**
 * 业务与流程关联 逻辑接口
 * 
 * @author zhangming
 * @version 1.0
 * @since 2013-7-29, 上午09:44:35
 */
public interface FlowProcessService {
    
    // ===========================部署流程
    /**
     * 根据流程定义文件部署流程
     * 
     * @param jpdlFilePath
     *            流程定义文件(jbpm/depleve.jpdl.xml)
     * @return
     * @author zjs
     */
    public String deployByJpdlFile(String jpdlFilePath);

    // ===========================创建流程实例

    /**
     * 根据key 创建流程实例，并添加业务与流程关联的数据(用于申请中的保存按钮操作)
     * 
     * @param key
     *            流程文件key
     * @param map
     *            需要携带的流程参数。如果没有写成 null
     * @param object dataForm对象
     * @return 流程实例ID
     * @author zhangming
     */
    public String startByKey(String key, Map<String, Object> map, Object object)
            throws ServiceException;

    /**
     * 创建实例并执行任务(用于申请中的提交操作)，并添加业务与流程关联的数据
     * 
     * @param key
     *            流程文件中的key
     * @param map
     *            需要携带的流程参数。如果没有写成 null
     * @param object dataForm对象
     * @return 流程实例ID
     * @author zhangming
     */
    public String startProcessTask(String key, Map<String, Object> map,
            Object object) throws ServiceException;

    // =======================执行任务

    /**
     * 执行任务 并携带参数 ，并携带意见
     * 
     * @param taskId
     *            任务ID
     * @param map
     *            map参数，如果没有使用null
     * @param object dataForm对象
     * @author zhangming
     */
    public void complateTask(String taskId, Map<String, Object> map,
            Object object) throws ServiceException;

    /**
     * 将任务流转到指定名字的流程outcome中去，并携带参数 ，并携带意见
     * 
     * @param taskId
     *            任务ID
     * @param outcome
     *            指定节点名称
     * @param comment
     *            意见
     * @param object dataForm对象
     * @author zhangming
     */
    public void complateTask(String taskId, String outcome,
            Map<String, Object> map, Object object) throws ServiceException;

    /**
     * 执行任务 驳回
     * 
     * @param taskId
     *            当前任务ID
     * @param object
     *            dataForm 对象
     * @throws ServiceException
     * @author zhangming
     */
    public void rollBack(String taskId, Object object) throws ServiceException;

}
