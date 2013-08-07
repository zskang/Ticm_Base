package com.joyin.ticm.role.service;

import java.util.List;

import com.joyin.ticm.page.Pager;
import com.joyin.ticm.role.model.Role;
import com.joyin.ticm.service.ServiceException;

/**
 * 角色业务逻辑接口类
 * 
 * @author jianghaitao
 * @version 1.0
 * @since 2013-7-22, 上午08:52:35
 */
public interface RoleService {
    /**
     * 添加角色
     * 
     * @param role
     * @throws ServiceException
     * @author jianghaitao
     */
    public void addRole(Role role) throws ServiceException;
    
    /**
     * 删除一个角色
     * 
     * @param role
     * @throws ServiceException
     * @author jianghaitao
     */
    public void deleteRole(Role role) throws ServiceException;

    /**
     * 修改角色
     * 
     * @param role
     * @throws ServiceException
     * @author jianghaitao
     */
    public void updateRole(Role role) throws ServiceException;

    /**
     * 根据角色Id查找角色
     * 
     * @param roles
     * @return
     * @author jianghaitao
     */
    public Role getRoleById(Role roles);

    /**
     * 删除多个角色
     * 
     * @param idList 角色Id列表，格式为"id1,id2,id3"
     * @throws ServiceException
     * @author jianghaitao
     */
    public void deleteRoles(String idList) throws ServiceException;

    /**
     * 获得角色列表用于绑定grid
     * 
     * @param role 角色对象
     * @param pager 页面对象
     * @param order 排序字段
     * @param direction 排序方式
     * @param isPage 
     * @return List<Role>
     * @author jianghaitao
     */
    public List<Role> getRoles(Role role, Pager pager, String order,
            String direction, Boolean isPage);

}
