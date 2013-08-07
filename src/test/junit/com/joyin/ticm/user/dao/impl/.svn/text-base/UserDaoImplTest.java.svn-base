package com.joyin.ticm.user.dao.impl;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.rolepermit.dao.RolePermitDao;
import com.joyin.ticm.test.util.TestBase;

/**
 * 基础DAO工具测试类
 * 
 * @author colin
 * @version 1.0
 * @since Jul 17, 2013, 9:02:35 AM
 */
public class UserDaoImplTest extends TestBase {

    @Resource
    private RolePermitDao rolePermitDao;
    

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testFindRolePermitByRoleId() throws DaoException {
        int count = rolePermitDao.findRolePermitByRoleId(136).size();
        System.out.println("count==" + count);
        Assert.assertTrue(true);
    }
    
    @Test
    public void testViewModuleTree() throws DaoException{
        int count = rolePermitDao.findRolePermitByRoleId(282).size();
        System.out.println("countsss==" + count);
        Assert.assertTrue(true);
    }
   
}
