package com.joyin.ticm.module.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.joyin.ticm.bean.TreeNode;
import com.joyin.ticm.dao.BaseDao;
import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.module.dao.ModuleDao;
import com.joyin.ticm.module.model.Module;
import com.joyin.ticm.module.service.ModuleService;
import com.joyin.ticm.service.ServiceBase;
import com.joyin.ticm.workflow.model.FlowTask;

/**
 * 模块业务逻辑实现类
 * 
 * @author jianghaitao
 * @version 1.0
 * @since 2013-7-26, 下午08:22:12
 */
@Service("moduleService")
public class ModuleServiceImpl extends ServiceBase implements ModuleService {

    @Resource
    private BaseDao baseDao;
    @Resource
    private ModuleDao moduleDao;

    @Override
    public List<Module> findAll() {
        // TODO Auto-generated method stub
        List<Module> moduleList = null;
        try {
            moduleList = baseDao.findAll("from Module where WORKFLOWFLAG = 'Y' and (ISRUN <> '0' or ISRUN is NULL) ORDER BY MODULEORDER");
        }
        catch (DaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return moduleList;
    }

    @Override
    public TreeNode convert(Module module ,FlowTask flowTask, boolean isChecked , boolean isOpen , boolean isDisable) {
        // TODO Auto-generated method stub        
        TreeNode node = new TreeNode();
        node.setChecked(isChecked);
        List<Module> childern = this.moduleDao
                .getChildern(module.getModuleid());
        if (!(childern == null || childern.size() == 0)) {
            node.setDrag(false);
        }
        else {
            node.setDrag(true);
        }
        if(flowTask != null){
            node.setId(module.getModuleid()+"-"+flowTask.getDbid());
            node.setName(flowTask.getTaskName());
        }else{
            node.setId(module.getModuleid());
            node.setName(module.getModulename());
        }        
        node.setParentId(module.getFumoduleid());
        node.setOpen(isOpen);
        node.setExisted(true);
        node.setChkDisabled(isDisable);

        return node;
    }

    @Override
    public Module findByid(String moduleid) {
        // TODO Auto-generated method stub
        return moduleDao.findById(moduleid);
    }

}
