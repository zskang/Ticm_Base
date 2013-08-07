package com.joyin.ticm.workflow.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.joyin.ticm.dao.BaseDao;
import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.service.ServiceBase;
import com.joyin.ticm.service.ServiceException;
import com.joyin.ticm.workflow.manager.JbpmManager;
import com.joyin.ticm.workflow.manager.JbpmManagerImpl.JbpmConstant;
import com.joyin.ticm.workflow.model.Depflow;
import com.joyin.ticm.workflow.service.DepflowService;

/**
 * 
 * 流程测试实现
 * @author Administrator
 * @version 1.0
 * @since 2013-7-25, 下午03:52:37
 */
@Service("depflowService")
public class DepflowServiceImp extends ServiceBase implements DepflowService {

	@Resource
	private BaseDao baseDao;
	//@Resource
	//private JBPMUtil jBPMUtil;
	@Resource
	private JbpmManager jbpmManager;

	//@Resource
	//private ProcessEngine processEngine;

	public void addSave(Depflow depleveInfo) throws ServiceException {
		// TODO Auto-generated method stub
		String methodName = "addSave";
		info(methodName, "depno: " + depleveInfo.getDepno());

		try {
			baseDao.save(depleveInfo);
		}
		catch (DaoException ex) {
			error(methodName, "Error save user info", ex);
			throw processException(methodName,"Error save user info",depleveInfo.getLoginUserid(), ex);
		}

		//System.out.println("processEngine: " + processEngine);
		//jBPMUtil = new JBPMUtil();
		// 部署流程 
		//String deploy = jBPMUtil.deployNew(TableType.Dep);
		String deploy =  jbpmManager.deployByXml(JbpmConstant.jbmp_test_key);
		
		System.out.println(deploy);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", depleveInfo.getDepuser());
		map.put("money", depleveInfo.getDepmoney());
		
		// 实例化流程
		//String processID = jBPMUtil.startPIById(TableType.Dep, map);
		String processID = jbpmManager.startByKey("depleveTest", map,"");
		System.out.println(processID);
	}

}
