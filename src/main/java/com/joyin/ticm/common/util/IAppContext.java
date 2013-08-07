package com.joyin.ticm.common.util;

/**
 * Class interface the properties created for the application.
 * 
 * @author colin
 * @version 1.0
 * @since Jul 3, 2013, 11:40:48 AM
 */
public interface IAppContext {
    /**
     * Search for the property value associated with the property key and
     * converts the value to a boolean value
     * 
     * @param key
     *            the property key to search
     * @return <code>Boolean</code> object. If key does not exist, false
     *         Boolean is returned
     */
    Boolean getBooleanProperty(String key);

    /**
     * Search for the property value associated with the property key and
     * converts the value to a double value
     * 
     * @param key
     *            the property key to search
     * @return <code>Double</code> object if key exists, otherwise return null
     */
    Double getDoubleProperty(String key);

    /**
     * Search for the property value associated with the property key and
     * converts the value to a double value.
     * 
     * @param key
     *            the property key to search
     * @param defaultValue
     *            the default value to set if property not found
     * @return <code>Double</code> object if key exists, otherwise return
     *         default
     */
    Double getDoubleProperty(String key, Double defaultValue);

    /**
     * Search for the property value associated with the property key and
     * converts the value to a float value
     * 
     * @param key
     *            the property key to search
     * @return <code>Float</code> object if key exists, otherwise return null
     */
    Float getFloatProperty(String key);

    /**
     * Search for the property value associated with the property key and
     * converts the value to a float value
     * 
     * @param key
     *            the property key to search
     * @param defaultValue
     *            the default value to set if property not found
     * @return <code>Float</code> object if key exists, otherwise return
     *         default
     */
    Float getFloatProperty(String key, Float defaultValue);

    /**
     * Search for the property value associated with the property key and
     * converts the value to a integer value
     * 
     * @param key
     *            the property key to search
     * @return <code>Integer</code> object if key exists, otherwise return
     *         null
     */
    Integer getIntegerProperty(String key);

    /**
     * Search for the property value associated with the property key and
     * converts the value to a integer value
     * 
     * @param key
     *            the property key to search
     * @param defaultValue
     *            the default value to set if property not found
     * @return <code>Integer</code> object if key exists, otherwise return
     *         default
     */
    Integer getIntegerProperty(String key, Integer defaultValue);

    /**
     * Search for the property value associated with the property key and
     * converts the value to a Long value
     * 
     * @param key
     *            the property key to search
     * @return <code>Long</code> object if key exists, otherwise return null
     */
    Long getLongProperty(String key);

    /**
     * Search for the property value associated with the property key and
     * converts the value to a Long value
     * 
     * @param key
     *            the property key to search
     * @param defaultValue
     *            the default value to set if property not found
     * @return <code>Long</code> object if key exists, otherwise return
     *         default
     */
    Long getLongProperty(String key, Long defaultValue);

    /**
     * Search for the property value associated with the property key
     * 
     * @param key
     *            the property key to search
     * @return <code>String</code> object if key exists, otherwise return null
     */
    String getProperty(String key);

    /**
     * Search for the property value associated with the property key
     * 
     * @param key
     *            the property key to search
     * @param defaultValue
     *            the default value to set if property not found
     * @return <code>String</code> object if key exists, otherwise return null
     */
    String getProperty(String key, String defaultValue);

}
