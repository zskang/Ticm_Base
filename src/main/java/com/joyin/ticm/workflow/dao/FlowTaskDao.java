package com.joyin.ticm.workflow.dao;

import java.util.List;

import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.workflow.model.FlowTask;


/**
 * 业务模块与流程任务关联数据。DAO接口
 * @author zhangming
 * @version 1.0
 * @since 2013-7-31, 下午04:10:11
 */
public interface FlowTaskDao {
    /**
     * 根据指定的任务名称与flowKey
     * @param propertyName
     * @param value
     * @return
     * @author zhangming
     */
    public List<FlowTask> findFlowTaskList(String taskName,String flowKey)  throws DaoException;
    
    /**
     * 查找所有的流程任务对象
     * 
     * @return List<FlowTask>
     * @author jianghaitao
     */
    public List<FlowTask> getAllFlowTask();
}
