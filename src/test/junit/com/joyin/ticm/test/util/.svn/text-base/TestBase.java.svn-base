package com.joyin.ticm.test.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.joyin.ticm.common.util.AppContext;

/**
 * 测试基类
 * 
 * @author colin
 * @version 1.0
 * @since Jul 17, 2013, 8:55:33 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "file:src/main/config/spring/applicationContext*.xml" })
public class TestBase {

	@Before
	public void setUp() throws Exception {
		Properties parms = new Properties();
		FileInputStream is = null;
		String keyFile = "src/main/config/key.properties";
		String sqlFile = "src/main/config/sql.properties";
		try {
			is = new FileInputStream(keyFile);
			parms.load(is);
			
			is = new FileInputStream(sqlFile);
            parms.load(is);

			AppContext.init(parms);
		}
		catch (FileNotFoundException fnfex) {
			String msg = "File not found on given path: " + keyFile;
			System.err.println(msg);
			throw new RuntimeException(msg);
		}
		catch (IOException ioex) {
			String msg = "I/O Error while processing properties..";
			System.err.println(msg + " : " + ioex);
		}
		catch (Exception e) {
			String msg = "An exception occurs";
			System.err.println(msg + " : " + e);
			e.printStackTrace();
		}
		finally {
			is.close();
		}
	}

}
