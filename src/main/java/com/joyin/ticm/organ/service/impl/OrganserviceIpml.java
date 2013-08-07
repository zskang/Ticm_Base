package com.joyin.ticm.organ.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.joyin.ticm.bean.TreeNode;
import com.joyin.ticm.common.util.CommonUtil;
import com.joyin.ticm.dao.BaseDao;
import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.organ.dao.OrganDao;
import com.joyin.ticm.organ.model.Organ;
import com.joyin.ticm.organ.service.Organservice;
import com.joyin.ticm.page.Pager;
import com.joyin.ticm.service.ServiceBase;
import com.joyin.ticm.service.ServiceException;

@Service("organservice")
public class OrganserviceIpml extends ServiceBase implements Organservice {
	@Resource
	private BaseDao baseDao;
	@Resource
	private OrganDao organDao;

	@SuppressWarnings("unchecked")
	public List<Organ> getOrgans(Organ organ, Pager pager, String order,
			String direction, Boolean isPage, String userid)
			throws ServiceException {
		String methodName = "";
		List<Object> params = new ArrayList<Object>();
		String hql = "from Oragn as o where 1=1 and o.bm02orgno='" + userid
				+ "'";

		if (organ != null) {
			if (CommonUtil.isNotEmpty(organ.getBm02snam1())) {
				hql += " and  o.bm02snam1 like ? ";
				params.add("%" + organ.getBm02snam1() + "%");
			}
		}

		// 排序
		if (CommonUtil.isEmpty(order)) {
			order = "o.bm02snam1";
		} else {
			order = "o." + order;
		}
		if (CommonUtil.isNotEmpty(direction)) {
			direction = "desc";
		}
		hql += " order by " + order + " " + direction;

		List<Organ> list = new ArrayList<Organ>();
		try {
			list = baseDao.findByPage(hql, params.toArray(),
					(pager.getPageNo() - 1) * pager.getPageSize(), pager
							.getPageSize(), isPage);
		} catch (DaoException e) {
			throw processException(methodName, "Error save oragn info",organ.getLoginUserid(),e);
		}
		return list;
	}

	@Override
	public TreeNode convert(Organ organ) {
		TreeNode node = new TreeNode();
		node.setChecked(false);
		node.setChkDisabled(false);
		node.setClick("getfindid('" + organ.getBm02orgno() + "')");
		node.setClickExpand(false);
		List<Organ> childern = this.getChildern(organ.getBm02totorg());
		if (!(childern == null || childern.size() == 0)) {
			node.setDrag(false);
		} else {
			node.setDrag(true);
		}
		node.setIconClose("");
		node.setIconOpen("");
		node.setId(organ.getBm02orgno());
		node.setName(organ.getBm02snam1() + "(" + organ.getBm02orgno() + ")");
		node.setParentId(organ.getBm02totorg());
		node.setOldParentId("");
		if(organ.getBm02orgno().equals("01000")){
		node.setOpen(true);
		}else{
		    node.setOpen(false);
		}
		node.setDesc("");
		node.setManager("");
		node.setPhone("");
		node.setExisted(true);

		return node;
	}

	@SuppressWarnings("unchecked")
	public List<Organ> getChildern(String bm02orgno) {
		// TODO Auto-generated method stub
		return organDao.findByOrgParentid(bm02orgno);
	}

	public Organ getOranizationById(String id) {
		return organDao.findById(id);
	}

	public Organ getOraniById(String id) {
		return organDao.findId(Organ.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Organ> getAllOrganization() {

		return organDao.findAll();
	}

	public List<Organ> getAllChildern(String orgPath) {
		return this.organDao.getAllChildern(orgPath);
	}

    @Override
    public void saveOrUpdate(Organ oragn) throws ServiceException {
        // TODO Auto-generated method stub
  

            String methodName = "saveOrUpdate";
            info(methodName, "username");
            try {
                baseDao.saveOrUpdate(oragn);
            }
            catch (DaoException ex) {
                String message = "保存或更新用户信息错误";
                  throw processException(methodName, message, oragn.getLoginUserid(), ex);
            }
        }
    
    
        
    public void save(Organ  oragn) throws ServiceException {
        String methodName = "save";
     
        try {
            baseDao.save(oragn);
        }
        catch (DaoException ex) {
            String message = "保存用户信息错误";
              throw processException(methodName, message, oragn.getLoginUserid(), ex);
        }
    }

}
