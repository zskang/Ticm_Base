package com.joyin.ticm.role.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.joyin.ticm.common.util.CommonUtil;
import com.joyin.ticm.dao.BaseDao;
import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.page.Pager;
import com.joyin.ticm.role.dao.RoleDao;
import com.joyin.ticm.role.model.Role;
import com.joyin.ticm.role.service.RoleService;
import com.joyin.ticm.service.ServiceBase;
import com.joyin.ticm.service.ServiceException;

/**
 * 角色业务逻辑实现类
 * 
 * @author jianghaitao
 * @version 1.0
 * @since 2013-7-22, 上午08:54:12
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceBase implements RoleService {

    @Resource
    private BaseDao baseDao;
    
    @Resource
    private RoleDao roleDao;
    
    @Override
    public void addRole(Role role) throws ServiceException {
        // TODO Auto-generated method stub
        String method = "addRole";
        info(method, "roleName: " + role.getRolename());
        try {
            baseDao.saveOrUpdate(role);
        }
        catch (DaoException e) {
            error(method, "Error save role info",e);
            throw processException(method, e.getErrorCode(), role.getLoginUserid(), e);
        }
    }

    @Override
    public void deleteRole(Role role) throws ServiceException {
        // TODO Auto-generated method stub
        String method = "deleteRole";
        info(method, "roleid: " + role.getRoleid());
        try {
            baseDao.deleteById(Role.class, role.getRoleid());
        }
        catch (DaoException e) {
            error(method, "Error delete role info",e);
            throw processException(method, e.getErrorCode(), role.getLoginUserid(), e);
        }
    }

    @Override
    public void updateRole(Role role) throws ServiceException {
        // TODO Auto-generated method stub
        String method = "updateRole";
        info(method, "roleName: " + role.getRolename());
        try {
            baseDao.update(role);
        }
        catch (DaoException e) {
            error(method, "Error update role info", e);
            throw processException(method, e.getErrorCode(), role.getLoginUserid(), e);
        }
    }

    @Override
    public void deleteRoles(String idList) throws ServiceException {
        // TODO Auto-generated method stub
        String method = "deleteRoles";
        //根据","拆分字符串
        String[] roleIdList = idList.split(",");
        info(method, "roleSize：" + roleIdList.length);
        for (int i = 0; i < roleIdList.length; i++) {
            Role role = new Role();
            role.setRoleid(Integer.valueOf(roleIdList[i]));
            deleteRole(role);
        }
    }

    @Override
    public Role getRoleById(Role role) {
        // TODO Auto-generated method stub
        String method = "getRoleById";
        Role roleResult = new Role();
        info(method, "roleid：" + role.getRoleid());
        roleResult = roleDao.getRoleById(Role.class, role.getRoleid());
        return roleResult;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> getRoles(Role role, Pager pager, String order,
            String direction, Boolean isPage) {
        // TODO Auto-generated method stub
        List<Object> params = new ArrayList<Object>();
        String hql = "from Role as r where 1=1 ";

        if (role != null) {
            if (CommonUtil.isNotEmpty(role.getRolename())) {
                hql += " and r.rolename like ? ";
                params.add("%" + role.getRolename() + "%");
            }
        }

        // 排序
        if (CommonUtil.isEmpty(order)) {
            order = "r.roleid";
        }
        else {
            order = "r." + order;
        }
        if (CommonUtil.isNotEmpty(direction)) {
            direction = "desc";
        }
        hql += " order by " + order + " " + direction;

        List<Role> list = null;
        try {
            list = baseDao.findByPage(hql, params.toArray(),
                    (pager.getPageNo() - 1) * pager.getPageSize(), pager
                            .getPageSize(), isPage);
        }
        catch (DaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

}
