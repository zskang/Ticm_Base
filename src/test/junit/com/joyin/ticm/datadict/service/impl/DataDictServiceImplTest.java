package com.joyin.ticm.datadict.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.joyin.ticm.datadict.model.DataDict;
import com.joyin.ticm.datadict.model.DataList;
import com.joyin.ticm.datadict.service.DataDictService;
import com.joyin.ticm.test.util.TestBase;

/**
 * 参数字典与类列表 业务操作实现测试类
 * 
 * @author colin
 * @version 1.0
 * @since Jul 31, 2013, 7:56:51 PM
 */
public class DataDictServiceImplTest extends TestBase {
    @Resource
    private DataDictService dataDictService;

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testGetDataDicts() throws Exception {
        List<DataDict> list1 = dataDictService.getDataDicts();
        System.out.println("DataDict count1==" + list1.size());
        List<DataDict> list2 = dataDictService.getDataDicts();
        System.out.println("DataDict count2==" + list2.size());
        Assert.assertTrue(true);
    }

    @Test
    public void testGetDataLists() throws Exception {
        List<DataList> list1 = dataDictService.getDataLists();
        System.out.println("DataList count1==" + list1.size());
        List<DataList> list2 = dataDictService.getDataLists();
        System.out.println("DataList count2==" + list2.size());
        Assert.assertTrue(true);
    }
}