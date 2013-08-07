package com.joyin.ticm.organ.service;

import java.util.List;
import com.joyin.ticm.bean.TreeNode;
import com.joyin.ticm.organ.model.Organ;
import com.joyin.ticm.page.Pager;
import com.joyin.ticm.service.ServiceException;

public interface Organservice {
	public List<Organ> getOrgans(Organ organ, Pager pager, String order,
			String direction, Boolean isPage, String usseid)
			throws ServiceException;

	public TreeNode convert(Organ organ);

	public List<Organ> getAllChildern(String orgPath);

	public Organ getOranizationById(String id);

	public List<Organ> getAllOrganization();

	public Organ getOraniById(String id);
	public void saveOrUpdate(Organ oragn) throws ServiceException;
	 public void save(Organ oragn) throws ServiceException ;
}
