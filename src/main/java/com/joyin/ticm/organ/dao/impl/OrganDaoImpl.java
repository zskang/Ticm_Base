package com.joyin.ticm.organ.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.joyin.ticm.dao.impl.AbstractDao;
import com.joyin.ticm.organ.dao.OrganDao;
import com.joyin.ticm.organ.model.Organ;

@SuppressWarnings("unchecked")
public class OrganDaoImpl extends AbstractDao implements OrganDao {
    public static final String ORG_PARENTID = "bm02orgno";

    @Override
    public List findByOrgParentid(Object orgParentid) {
        return findByProperty(ORG_PARENTID, orgParentid);
    }

    @Override
    public List findByProperty(String propertyName, Object value) {
        // TODO Auto-generated method stub
        String queryString = "from Organ as model where model." + propertyName
                + "= ?";
        return getHibernateTemplate().find(queryString, value);
    }

    public Organ findById(String id) {
        try {
            Organ instance = (Organ) getHibernateTemplate().get("Organ", id);
            return instance;
        }
        catch (RuntimeException re) {
            throw re;
        }
    }

    public Organ findId(Class clazz, String id) {
        try {
            // String queryString = "from Organ  as o where o.bm02orgno="+id;
            return (Organ) getHibernateTemplate().get(clazz, id);
        }
        catch (RuntimeException re) {
            throw re;
        }
    }

    public List findAll() {
        try {
            String queryString = "from Organ";
            return getHibernateTemplate().find(queryString);
        }
        catch (RuntimeException re) {
            throw re;
        }
    }

    public List<Organ> getAllChildern(String orgPath) {

        try {
            if (orgPath != null && !"".equals(orgPath)) {
                String queryString = "from Organ as org where org.bm02totorg = ?";
                return getHibernateTemplate().find(queryString, orgPath);
            }
            else {
                return new ArrayList<Organ>();
            }
        }
        catch (RuntimeException re) {
            throw re;
        }
    }
}
