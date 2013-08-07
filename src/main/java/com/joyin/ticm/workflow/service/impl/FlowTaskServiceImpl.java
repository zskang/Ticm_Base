package com.joyin.ticm.workflow.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.joyin.ticm.service.ServiceBase;
import com.joyin.ticm.workflow.dao.FlowTaskDao;
import com.joyin.ticm.workflow.model.FlowTask;
import com.joyin.ticm.workflow.service.FlowTaskService;

/**
 * 流程节点业务逻辑实现类
 * 
 * @author jianghaitao
 * @version 1.0
 * @since 2013-7-30, 下午08:03:33
 */
@Service("flowTaskService")
public class FlowTaskServiceImpl extends ServiceBase implements FlowTaskService {

    @Resource
    private FlowTaskDao flowTaskDao;
    
    @Override
    public List<FlowTask> getAllFlowTask() {
        // TODO Auto-generated method stub
        List<FlowTask> flowTaskList = null;
        flowTaskList = flowTaskDao.getAllFlowTask();
        info("flowservice", ""+flowTaskList.size()+"sssss"+flowTaskList.get(0).getModuleid());
        return flowTaskList;
    }

}
