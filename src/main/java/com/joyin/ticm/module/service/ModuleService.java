package com.joyin.ticm.module.service;

import java.util.List;

import com.joyin.ticm.bean.TreeNode;
import com.joyin.ticm.module.model.Module;
import com.joyin.ticm.workflow.model.FlowTask;

/**
 * 模块业务逻辑接口类
 * 
 * @author jianghaitao
 * @version 1.0
 * @since 2013-7-26, 下午08:21:56
 */
public interface ModuleService {
    /**
     * 根据模块id查找模块对象
     * 
     * @param moduleid
     * @return Module
     * @author jianghaitao
     */
    public Module findByid(String moduleid);
    
    /**
     * 查找所有模块列表
     * 
     * @return List<Module>
     * @author jianghaitao
     */
    public List<Module> findAll();
    
    /**
     * 把模块对象转化为树节点
     * 
     * @param module 模块对象
     * @param flowTask 流程节点对象
     * @param isChecked 树节点是否选中
     * @param isOpen 树是否展开
     * @param isDisable 选择框是否可用
     * @return
     * @author jianghaitao
     */
    public TreeNode convert(Module module, FlowTask flowTask, boolean isChecked, boolean isOpen, boolean isDisable);
}
