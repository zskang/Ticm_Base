package com.joyin.ticm.rolepermit.dao;

import java.util.List;

import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.rolepermit.model.RolePermit;

/**
 * 角色权限数据持久化接口类
 * @author jianghaitao
 * @version 1.0
 * @since 2013-7-25, 下午03:48:32
 */
public interface RolePermitDao {

    /**
     * 根据角色id删除所有角色权限信息
     * 
     * @param role
     * @author jianghaitao
     * @throws DaoException 
     */
    public void deleteRolePermitByRoleId(Integer roleid) throws DaoException;
    
    /**
     * 根据角色id查找所有角色权限信息
     * 
     * @param roleid
     * @return List<RolePermit>
     * @author jianghaitao
     * @throws DaoException 
     */
    public List<RolePermit> findRolePermitByRoleId(Integer roleid) throws DaoException;
}
