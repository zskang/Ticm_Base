package com.joyin.ticm.dao.impl;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.joyin.ticm.dao.BaseDao;
import com.joyin.ticm.dao.DaoException;
import com.joyin.ticm.test.util.TestBase;
import com.joyin.ticm.user.model.User;

/**
 * 基础DAO工具测试类
 * 
 * @author colin
 * @version 1.0
 * @since Jul 17, 2013, 9:02:35 AM
 */
public class BaseDaoImplTest extends TestBase {

    @Resource
    private BaseDao baseDao;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        // baseDao = (BaseDaoImpl) ctx.getBean("baseDao");
    }

    @Test
    public void testAdd() throws DaoException {
        User user = new User();
        user.setUsername("user1");
        user.setPassword("1");
        baseDao.save(user);
        Assert.assertTrue(true);
    }

    @Test
    public void testFindAll() throws DaoException {
        int count = baseDao.findAll("from User").size();
        System.out.println("count==" + count);
        Assert.assertTrue(true);
    }
    
    
}
