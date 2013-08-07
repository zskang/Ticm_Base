package com.joyin.ticm.workflow.dao.impl;

import java.util.List;

import org.hibernate.Query;
import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.dao.impl.AbstractDao;
import com.joyin.ticm.workflow.dao.FlowProcessDao;
import com.joyin.ticm.workflow.model.FlowProcess;

/**
 * 业务与流程关联 DAO层
 * 
 * @author zhangming
 * @version 1.0
 * @since 2013-7-29, 上午09:40:21
 */
public class FlowProcessDaoImpl extends AbstractDao implements FlowProcessDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<FlowProcess> findByProperty(String  processId)
            throws DaoException {
        String methodName = "findByProperty";
        info(methodName, "param[processId]:" + processId);
        // System.out.println(SqlUtil.Flow.FIND_BY_PROPERTY);
        String flowQuery = "from FlowProcess where jbpmProcessid='"
                + processId + "'";
        Query query = this.getSession().createQuery(flowQuery);

        // query.setParameter(0, propertyName);
        // query.setParameter(1, value);

        info(methodName, "查询语句：" + flowQuery);
        return query.list();
    }

    @Override
    public String getJBPMValue(String keyCode) {
        String methodName = "getJBPMValue";
        info(methodName, "param[keyCode]:" + keyCode);
        String value = getSQLOrHQLText(keyCode);
        info(methodName, "param[value]:" + value);
        return value;
    }

}
