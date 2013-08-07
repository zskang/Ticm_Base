package com.joyin.ticm.common.util.logger;

import java.text.MessageFormat;

/**
 * Formatter class containing formatting rules
 * 
 * @author colin
 * @version 1.0
 * @since Jul 3, 2013, 11:40:48 AM
 */
public class Formatter implements IFormatter {

    public Formatter() {
        msgFormat = new MessageFormat("<< {0} >> {1}");
        msgMethodFormat = new MessageFormat("<< {0} >> {1} : {2}");
        msgAuditFormat = new MessageFormat("{0} {1} {2} {3} {4} {5} {6}");
    }

    public void setMsgFormat(MessageFormat format) {
        msgFormat = format;
    }

    public void setMsgMethodFormat(MessageFormat format) {
        msgMethodFormat = format;
    }

    public String format(String id, String msg) {
        return msgFormat.format(((Object) (new Object[] { id, msg })));
    }

    protected String format(String id, String method, String msg) {
        return msgMethodFormat
                .format(((Object) (new Object[] { id, method, msg })));
    }

    protected String format(String entity, String userId, String timestamp,
            String action, String before, String after, String result) {
        return msgAuditFormat.format((Object) (new Object[] { entity, userId,
                timestamp, action, before, after, result }));

    }

    private MessageFormat msgFormat;
    private MessageFormat msgMethodFormat;
    private MessageFormat msgAuditFormat;
}
