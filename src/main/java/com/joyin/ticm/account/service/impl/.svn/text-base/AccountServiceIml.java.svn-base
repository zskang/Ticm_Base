package com.joyin.ticm.account.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.joyin.ticm.account.model.Account;
import com.joyin.ticm.account.service.AccountService;
import com.joyin.ticm.common.util.CommonUtil;
import com.joyin.ticm.dao.BaseDao;
import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.page.Pager;
import com.joyin.ticm.service.ServiceBase;
import com.joyin.ticm.service.ServiceException;

@Service("accountService")
public class AccountServiceIml extends ServiceBase implements AccountService {
    @Resource
    private BaseDao baseDao;

    @SuppressWarnings("unchecked")
    public List<Account> getOrgans(Account acount, Pager pager, String order,
            String direction, Boolean isPage, String userid)
            throws ServiceException {
        String methodName = "";

        List<Object> params = new ArrayList<Object>();
        String hql = "from Account as o where 1=1 and o.id.bm02orgno='"
                + userid + "'";

        if (acount != null) {
            if (CommonUtil.isNotEmpty(acount.getAccountname())) {
                hql += " and  o.id.bm02orgno like ? ";
                params.add("%" + acount.getAccountname() + "%");
            }
        }

        // 排序
        if (CommonUtil.isEmpty(order)) {
            order = "o.accountname";
        }
        else {
            order = "o." + order;
        }
        if (CommonUtil.isNotEmpty(direction)) {
            direction = "desc";
        }
        hql += " order by " + order + " " + direction;

        List<Account> list = new ArrayList<Account>();
        try {
            list = baseDao.findByPage(hql, params.toArray(),
                    (pager.getPageNo() - 1) * pager.getPageSize(), pager
                            .getPageSize(), isPage);
        }
        catch (DaoException e) {
            throw processException(methodName, "Error save ACCOUNT info",
                    acount.getLoginUserid(), e);
        }
        return list;
    }

}
