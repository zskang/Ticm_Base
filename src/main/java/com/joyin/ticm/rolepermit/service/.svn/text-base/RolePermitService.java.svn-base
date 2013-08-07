package com.joyin.ticm.rolepermit.service;

import java.util.List;

import com.joyin.ticm.rolepermit.model.RolePermit;
import com.joyin.ticm.service.ServiceException;

/**
 * 角色权限业务逻辑接口类 
 * @author jianghaitao
 * @version 1.0
 * @since 2013-7-25, 下午03:51:31
 */
public interface RolePermitService {

    /**
     * 添加角色权限
     * 
     * @param rolePermit
     * @author jianghaitao
     * @throws ServiceException 
     */
    public void addRolePermit(RolePermit rolePermit) throws ServiceException;
    
    /**
     * 根据角色权限id删除角色权限对象
     * 
     * @param rolePermit
     * @author jianghaitao
     * @throws ServiceException 
     */
    public void deleteRolePermitById(RolePermit rolePermit) throws ServiceException;
    
    /**
     * 根据角色id删除角色权限对象
     * 
     * @param roleid
     * @author jianghaitao
     * @throws ServiceException 
     */
    public void deleteRolePermitByRoleId(Integer roleid) throws ServiceException;
    
    /**
     * 根据角色id查找角色权限对象列表
     * 
     * @param roleid
     * @return List<RolePermit>
     * @author jianghaitao
     * @throws ServiceException 
     */
    public List<RolePermit> findRolePermitByRoleId(Integer roleid) throws ServiceException;
}
