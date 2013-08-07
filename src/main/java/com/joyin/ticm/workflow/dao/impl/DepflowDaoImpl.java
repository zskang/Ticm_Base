package com.joyin.ticm.workflow.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.JDBCException;

import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.dao.impl.AbstractDao;
import com.joyin.ticm.workflow.dao.DepflowDao;
import com.joyin.ticm.workflow.model.Depflow;

public class DepflowDaoImpl extends AbstractDao implements DepflowDao {

	@Override
	public void save(Depflow depleveInfo) throws DaoException{
		String methodName = "save";
		debug(methodName,"saving DepLeveInfo instance");
		try {
			getHibernateTemplate().save(depleveInfo);
			debug("save","save successful");
		} catch (JDBCException de) {
            error(methodName, "Error Delete Object By Id", de);
            throw new DaoException(DaoException.ERROR_GENERIC_JDBC_EXCEPTION,de);
        }
        catch (HibernateException ex) {
            error(methodName, "Error save or update object", ex);
            throw new DaoException(DaoException.ERROR_HIBERNATE, ex);
        }
	}

}
