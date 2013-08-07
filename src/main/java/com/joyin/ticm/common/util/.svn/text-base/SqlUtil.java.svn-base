package com.joyin.ticm.common.util;

/**
 * sql语句处理 {description of method or object}
 * 
 * @author jackson
 * @version 1.0
 * @since 2013-7-28, 下午03:04:11
 */
public class SqlUtil {
    private static IAppContext context = AppContext.getInstance();

    /**
     * SQl key value
     */
    public static interface Sql {
        String SQLTEST = "sqltest";
    }

    /**
     * 流程配置文件
     * 
     * @author zhangming
     * @version 1.0
     * @since 2013-7-29, 下午05:06:59
     */
    public static interface Flow {
        final String FIND_BY_PROPERTY = "flow_process_findbyproperty";
    }
    
    /**
     * 约期存放sql语句配置文件
     * @author xusong
     * @version 1.0
     * @since 2013-7-30, 上午11:46:46
     */
    public static interface Dep {
        final String DEP_DEPOSIT_INIT = "dep_deposit_init";
    }

    /**
     * get unique sql from resource {method description}
     * 
     * @param sqlCode
     * @return sql
     * @author jackson
     */
    public static String getText(String keyValue) {
        return context.getProperty(keyValue);
    }

}
