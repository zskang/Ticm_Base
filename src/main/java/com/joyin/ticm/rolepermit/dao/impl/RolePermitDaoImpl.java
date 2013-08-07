package com.joyin.ticm.rolepermit.dao.impl;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.dao.impl.AbstractDao;
import com.joyin.ticm.rolepermit.dao.RolePermitDao;
import com.joyin.ticm.rolepermit.model.RolePermit;

/**
 * 角色权限数据持久化实现类
 * @author jianghaitao
 * @version 1.0
 * @since 2013-7-25, 下午03:50:24
 */
@Service("rolePermitDao")
public class RolePermitDaoImpl extends AbstractDao implements RolePermitDao {

    @Override
    public void deleteRolePermitByRoleId(Integer roleid) throws DaoException {
        // TODO Auto-generated method stub
        String method = "deleteRolePermitByRoleId";
        String sql = "delete from RolePermit where roleid = ?";
        try {
            Query query = this.getSession().createQuery(sql);
            query.setParameter(0, roleid);
            query.executeUpdate();
        }
        catch (JDBCException de) {
            error(method, "Error Delete Object By Id", de);
            throw new DaoException(DaoException.ERROR_GENERIC_JDBC_EXCEPTION,
                    de);
        }
        catch (HibernateException ex) {
            error(method, "Error save or update object", ex);
            throw new DaoException(DaoException.ERROR_HIBERNATE, ex);
        }
        
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<RolePermit> findRolePermitByRoleId(Integer roleid) throws DaoException {
        // TODO Auto-generated method stub
        String method = "findRolePermitByRoleId";
        List<RolePermit> rolePermitList = null;
        String sql = "from RolePermit where roleid = ?";
        try {
            rolePermitList = this.getHibernateTemplate().find(sql , roleid);
        }
        catch (JDBCException de) {
            error(method, "Error Delete Object By Id", de);
            throw new DaoException(DaoException.ERROR_GENERIC_JDBC_EXCEPTION,
                    de);
        }
        catch (HibernateException ex) {
            error(method, "Error save or update object", ex);
            throw new DaoException(DaoException.ERROR_HIBERNATE, ex);
        }
        return rolePermitList;
    }

}
