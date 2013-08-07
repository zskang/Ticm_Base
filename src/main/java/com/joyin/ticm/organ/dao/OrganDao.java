package com.joyin.ticm.organ.dao;

import java.util.List;

import com.joyin.ticm.organ.model.Organ;

@SuppressWarnings("unchecked")
public interface OrganDao {
	public List findByOrgParentid(Object orgParentid);

	public List findByProperty(String propertyName, Object value);

	public Organ findById(String id);

	public List findAll();

	public Organ findId(Class clazz, String id);

	public List<Organ> getAllChildern(String orgPath);
}
