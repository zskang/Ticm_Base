package com.joyin.ticm.role.dao.impl;


import com.joyin.ticm.dao.impl.AbstractDao;
import com.joyin.ticm.role.dao.RoleDao;
import com.joyin.ticm.role.model.Role;

/**
 * 角色模块数据持久化实现类
 * 
 * @author jianghaitao
 * @version 1.0
 * @since 2013-7-22, 上午08:56:21
 */
public class RoleDaoImpl extends AbstractDao implements RoleDao  {

    
    @SuppressWarnings("unchecked")
    @Override
    public Role getRoleById(Class clazz, Integer id) {
        // TODO Auto-generated method stub
        Role role = new Role();
        Object obj = this.getHibernateTemplate().get(clazz, id);
        role = (Role)obj;
        return role;
    }

}
