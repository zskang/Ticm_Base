package com.joyin.ticm.workflow.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;

import com.joyin.ticm.dao.BaseDao;
import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.dao.impl.AbstractDao;
import com.joyin.ticm.workflow.dao.FlowTaskDao;
import com.joyin.ticm.workflow.model.FlowTask;

public class FlowTaskDaoImpl extends AbstractDao implements FlowTaskDao {

    @Resource
    private BaseDao baseDao;
    
    @SuppressWarnings("unchecked")
    @Override
    public List<FlowTask> findFlowTaskList(String taskName, String flowKey)
            throws DaoException {
        String methodName = "findByProperty";
        info(methodName, "param[taskName]:" + taskName + ",param[flowKey]:"
                + flowKey);
        String hql = "from FlowTask where taskName='" + taskName
                + "' and flowKey='" + flowKey + "' and effectflag='E'";
        Query query = this.getSession().createQuery(hql);
        List<FlowTask> list = query.list();
        return list;
    }

    @Override
    public List<FlowTask> getAllFlowTask() {
        // TODO Auto-generated method stub
        info("getAllFlowTaskDao", " aasd");
        //String sql = "select distinct moduleid,task_name,dbid,task_order from SYS_FLOW_TASK  where effectflag = 'E' ORDER BY TASK_ORDER";
        List<FlowTask> flowTaskList = new ArrayList<FlowTask>();
        //flowTaskList = this.getSession().createSQLQuery(sql).list();
        try {
            flowTaskList = baseDao.findAll("from FlowTask");
        }
        catch (DaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        info("getAllFlowTaskDao", "" + flowTaskList.size() + "sssss"
                + flowTaskList.get(0).getModuleid());
        return flowTaskList;
    }
}
