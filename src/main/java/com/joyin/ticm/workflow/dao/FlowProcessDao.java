package com.joyin.ticm.workflow.dao;

import java.util.List;

import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.workflow.model.FlowProcess;

public interface FlowProcessDao {
    /**
     * 查找指定的数据
     * @param propertyName 
     * @param value
     * @return
     * @author zhangming
     */
    public List<FlowProcess> findByProperty(String processId) throws DaoException;
    
    /**
     * 根据key 在jbpm.properties配置文件中找到value
     * @param keyCode
     * @return
     * @author zhangming
     */
    public String getJBPMValue(String keyCode);
}
