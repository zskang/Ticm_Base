package com.joyin.ticm.common.util;


/**
 * 消息处理类
 * 
 * @author colin
 * @version 1.0
 * @since Jul 18, 2013, 10:15:25 AM
 */
public class MessageUtil {
    private static IAppContext context = AppContext.getInstance();

    /**
     * Message key value
     */
    public static interface Message {
        String SUCCESS = "ticm.message.success";
        String ERROR = "ticm.message.error";
        String MSG_LOGIN = "ticm.message.login";
    }

    /**
     * get Message from resource
     * 
     * @param messageCode
     *            message code
     * @return message
     */
    public static String getMessage(String messageCode) {
        return context.getProperty(messageCode);
    }
}
