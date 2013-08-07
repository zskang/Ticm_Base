package com.joyin.ticm.user.service.impl;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.joyin.ticm.common.util.DateUtils;
import com.joyin.ticm.module.service.ModuleService;
import com.joyin.ticm.role.model.Role;
import com.joyin.ticm.role.service.RoleService;
import com.joyin.ticm.rolepermit.service.RolePermitService;
import com.joyin.ticm.test.util.TestBase;
import com.joyin.ticm.workflow.service.FlowTaskService;

public class UserServiceImpTest extends TestBase {

    
    @Resource
    private RolePermitService rolePermitServic;
    
    @Resource
    private FlowTaskService flowTaskService;
    
    @Resource
    private ModuleService moduleService;
    
    @Resource
    private RoleService roleService;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    
    
    @Test
    public void testViewModuleTree() throws Exception {
        int count = rolePermitServic.findRolePermitByRoleId(282).size();
        System.out.println("countsss==" + count);
        Assert.assertTrue(true);
    }
    
    @Test
    public void testFindAll() throws Exception {
        int count = flowTaskService.getAllFlowTask().size();
        System.out.println("countsss==" + count);
        Assert.assertTrue(true);
    }
    
    @Test
    public void testFindAllFlow() throws Exception {
        int count = moduleService.findAll().size();
        System.out.println("countsttt==" + count);
        Assert.assertTrue(true);
    }
    
    @Test
    public void testAddRole() throws Exception {
        Role role = new Role();
        role.setRolename("new modulerole");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        role.setLstmntdate(sdf.parse(DateUtils.getSysDate()));
        role.setDescription("sssss");
        role.setEffectflag("A");
        roleService.addRole(role);
        System.out.println(role);
        Assert.assertTrue(true);
    }
}
