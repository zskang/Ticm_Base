package com.joyin.ticm.module.dao.impl;

import java.util.List;

import com.joyin.ticm.dao.impl.AbstractDao;
import com.joyin.ticm.module.dao.ModuleDao;
import com.joyin.ticm.module.model.Module;

/**
 * 模块数据持久化实现类
 * 
 * @author jianghaitao
 * @version 1.0
 * @since 2013-7-26, 下午08:20:13
 */
@SuppressWarnings("unchecked")
public class ModuleDaoImpl extends AbstractDao implements ModuleDao {

    @Override
    public List<Module> getChildern(String moduleid) {
        // TODO Auto-generated method stub
        try {
            String queryString = "from Module as m where m.fumoduleid= ?";
            return getHibernateTemplate().find(queryString, moduleid);
        } catch (RuntimeException re) {
            //log.error("find by property name failed", re);
            throw re;
        }

    }

    @Override
    public Module findById(String moduleid) {
        // TODO Auto-generated method stub
        try {
            String queryString = "from Module as m where m.moduleid = ?";
            Module module = (Module) getHibernateTemplate().find(queryString,moduleid);
            return module;
        }
        catch (RuntimeException e) {
            // TODO: handle exception
            throw e;
        }
    }

}
