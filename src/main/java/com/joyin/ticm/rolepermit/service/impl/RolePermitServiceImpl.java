package com.joyin.ticm.rolepermit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.joyin.ticm.dao.BaseDao;
import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.rolepermit.dao.RolePermitDao;
import com.joyin.ticm.rolepermit.model.RolePermit;
import com.joyin.ticm.rolepermit.service.RolePermitService;
import com.joyin.ticm.service.ServiceBase;
import com.joyin.ticm.service.ServiceException;

/**
 * 角色权限业务逻辑实现类
 * @author jianghaitao
 * @version 1.0
 * @since 2013-7-25, 下午03:54:19
 */
@Service("rolePermitService")
public class RolePermitServiceImpl extends ServiceBase implements
        RolePermitService {

    @Resource
    private BaseDao baseDao;
    
    @Resource
    private RolePermitDao rolePermitDao;
    
    @Override
    public void addRolePermit(RolePermit rolePermit) throws ServiceException {
        // TODO Auto-generated method stub
        String method = "addRolePermit";
        info(method, "roleid" + rolePermit.getRole().getRoleid() + " ,moduleid"
                + rolePermit.getModule().getModuleid());
        try {
            baseDao.saveOrUpdate(rolePermit);
        }
        catch (DaoException e) {
            // TODO Auto-generated catch block
            throw processException(method, "Error save rolePermit", rolePermit.getLoginUserid(), e);
        }
    }

    @Override
    public void deleteRolePermitById(RolePermit rolePermit) throws ServiceException {
        // TODO Auto-generated method stub
        String method = "deleteRolePermitById";
        info(method, "roleId" + rolePermit.getId());
        try {
            baseDao.deleteById(RolePermit.class, rolePermit.getId());
        }
        catch (DaoException e) {
            // TODO Auto-generated catch block
            throw processException(method, "Error delete rolePermit", rolePermit.getLoginUserid(), e);
        }
    }

    @Override
    public void deleteRolePermitByRoleId(Integer roleid) throws ServiceException {
        // TODO Auto-generated method stub
        String method = "deleteRolePermitByRoleId";
        info(method, "roleId" + roleid);
        try {
            rolePermitDao.deleteRolePermitByRoleId(roleid);
        }
        catch (DaoException e) {
            // TODO Auto-generated catch block
            throw processException(method, "Error delete rolePermit by roleid", "userid", e);
        }
    }

    @Override
    public List<RolePermit> findRolePermitByRoleId(Integer roleid) throws ServiceException {
        // TODO Auto-generated method stub
        String method = "findRolePermitByRoleId";
        List<RolePermit> rolePermitList = null;
        info(method, "roleid" + roleid);
        try {
            rolePermitList = rolePermitDao.findRolePermitByRoleId(roleid);
        }
        catch (DaoException e) {
            // TODO Auto-generated catch block
            throw processException(method, "Error find rolePermit by roleid", "userid", e);
        }
        return rolePermitList;
    }

}
