package com.joyin.ticm.workflow.dao;

import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.workflow.model.Depflow;


public interface DepflowDao {

	public void save(Depflow  depleveInfo) throws DaoException;
}
