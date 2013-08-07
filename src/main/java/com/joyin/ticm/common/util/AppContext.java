package com.joyin.ticm.common.util;

import java.util.Properties;

/**
 * Class encapsulating the properties created for the application.
 * 
 * @author colin
 * @version 1.0
 * @since Jul 3, 2013, 11:40:48 AM
 */
public class AppContext implements IAppContext {
    /**
     * Singleton instance
     */
    private static AppContext INSTANCE = null;

    /**
     * Properties read from file
     */
    private Properties appCtx;

    /**
     * Creates a new AppContext object.
     * 
     * @param props
     *            the properties read from file
     */
    private AppContext(Properties props) {
        appCtx = props;
    }

    /**
     * Gets a singleton instance
     * 
     * @return IAppContext
     */
    public static IAppContext getInstance() {
        return INSTANCE;
    }

    /**
     * Initialize with the set of properties defined. If this is called again,
     * the properties are added to it
     * 
     * @param props
     *            the set of properties read from file
     */
    public static void init(Properties props) {
        if (INSTANCE == null) {
            INSTANCE = new AppContext(props);
        }
        else {
            INSTANCE.appCtx.putAll(props);
            INSTANCE = new AppContext(INSTANCE.appCtx);
        }
    }

    /**
     * Release resources used
     */
    public static void release() {
        INSTANCE.clear();
        INSTANCE = null;
    }

    public Boolean getBooleanProperty(String key) {
        return (getProperty(key) != null) ? Boolean.valueOf(getProperty(key))
                : Boolean.FALSE;
    }

    public Double getDoubleProperty(String key) {
        return (getProperty(key) != null) ? new Double(getProperty(key)) : null;
    }

    public Double getDoubleProperty(String key, Double defaultValue) {
        return (getProperty(key) != null) ? new Double(getProperty(key))
                : defaultValue;
    }

    public Float getFloatProperty(String key) {
        return (getProperty(key) != null) ? new Float(getProperty(key)) : null;
    }

    public Float getFloatProperty(String key, Float defaultValue) {
        return (getProperty(key) != null) ? new Float(getProperty(key))
                : defaultValue;
    }

    public Integer getIntegerProperty(String key) {
        return (getProperty(key) != null) ? new Integer(getProperty(key))
                : null;
    }

    public Integer getIntegerProperty(String key, Integer defaultValue) {
        return (getProperty(key) != null) ? new Integer(getProperty(key))
                : defaultValue;
    }

    public Long getLongProperty(String key) {
        return (getProperty(key) != null) ? new Long(getProperty(key)) : null;
    }

    public Long getLongProperty(String key, Long defaultValue) {
        return (getProperty(key) != null) ? new Long(getProperty(key))
                : defaultValue;
    }

    public String getProperty(String key) {
        return (String) this.appCtx.get(key);
    }

    public String getProperty(String key, String defaultValue) {
        return (getProperty(key) != null) ? getProperty(key) : defaultValue;
    }

    /**
     * Resets the properties
     */
    private void clear() {
        appCtx.clear();
        appCtx = null;
    }
}
