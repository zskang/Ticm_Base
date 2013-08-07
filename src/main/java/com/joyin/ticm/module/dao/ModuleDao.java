package com.joyin.ticm.module.dao;

import java.util.List;

import com.joyin.ticm.module.model.Module;

/**
 * 模块数据持久化接口类
 * 
 * @author jianghaitao
 * @version 1.0
 * @since 2013-7-26, 下午08:20:45
 */
public interface ModuleDao {
    /**
     * 根据上级模块的id查找所有下级模块列表
     * 
     * @param moduleid
     * @return List<Module>
     * @author jianghaitao
     */
    public List<Module> getChildern(String moduleid);
    /**
     * 根据模块id查找模块对象
     * 
     * @param moduleid
     * @return Module
     * @author jianghaitao
     */
    public Module findById(String moduleid);
    
}
