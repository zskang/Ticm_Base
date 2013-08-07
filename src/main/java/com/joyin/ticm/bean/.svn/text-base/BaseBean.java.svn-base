package com.joyin.ticm.bean;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * A base class for Info objects. It also has a {@link #get(Object)} method, for
 * Velocity.
 * <p>
 * This class contains static methods to deep-clone any Object (see
 * {@link #deepClone(Object)}), normally-clone any Object (see
 * {@link #clone(Object)}), inspect their public fields as a Map (see
 * {@link #toMap(Object)}), and assign new values to their public fields based
 * on a Map (see {@link #assignFieldValues(Map,Object)}). It also contains
 * static methods to clone values in a Map (see {@link #cloneValuesInMap(Map)})
 * and to perform a field-by-field copy from an Object to another (see
 * {@link #copyObject(Object,Object)}). The latter method works even if the
 * Objects are of different types, and will only copy values for the fields that
 * are common. In addition, this class contains static utility methods to decode
 * an enumeration, by listing the names of static final fields that are set to a
 * given value (see {@link #decodeEnum(Object,Class)}).
 * <p>
 * Subclasses of this class are typically data classes containing only public
 * fields and a constructor. They can be cloned (see {@link #clone()}), viewed
 * as a Map (see {@link #toMap()}), or have their values copied to another
 * Object (see {@link #copyTo(Object)}). The toMap() method can be overridden
 * to hide some of the public fields from being copied by the copyObject and
 * copyTo methods, but this does not affect deep-cloning done by the clone
 * methods. B
 * <p>
 * The subclasses also support the standard toString(), equals() and hashCode()
 * methods. These are based on the toMap() method, and values that the toMap()
 * method chooses to return must not change while the object is being used as an
 * index to a data structure, for example, as a key in a map.
 * <p>
 * Note that when an array is cloned, its String representation changes. This
 * causes the equals() method to return false when comparing a subclass with its
 * clone, if that subclass has array fields that are not null.
 * <p>
 * Definition of deep-copying may be vague because it may not be possible to
 * access the innermost level, but in general, attempts are made to access and
 * clone as many fields as possible.
 * 
 * @author colin
 * @version 1
 * @since Jul 3, 2013, 11:40:48 AM
 */
public class BaseBean implements Cloneable, Serializable {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 76010000L;

    /**
     * Deep-clones an object by deserializing.
     * 
     * @param source the object to deep-clone
     * @return Object A deep-clone of the object, or null if deep-cloning fails.
     */
    public static Object deepClone(Object source) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(source);
            oos.reset();
            ObjectInputStream ois = null;
            Object obj = null;
            try {
                ois = new ObjectInputStream(new ByteArrayInputStream(baos
                        .toByteArray()));
                obj = ois.readObject();
            }
            catch (IOException ex) {
                return null;
            }
            catch (ClassNotFoundException ex) {
                return null;
            }
            finally {
                if (ois != null) // parasoft-suppress BD.PB.CC "False positive as ois may be null when exception is thrown."
                {
                    ois.close();
                }
            }
            return obj;
        }
        catch (IOException ex) {
            return null;
        }
    }

    /**
     * Tries to clone an object. Cloning with the clone method (if the object
     * implements Cloneable) and by deserializing are attempted.
     * 
     * @param source the object to clone
     * @return Object A clone of the object, or null if cloning fails.
     */
    public static Object clone(Object source) {
        try {
            if (Cloneable.class.isAssignableFrom(source.getClass())) {
                return source.getClass().getMethod("clone", (Class[]) null)
                        .invoke(source, (Object[]) null);
            }
        }
        catch (NoSuchMethodException ex) {
        }
        catch (InvocationTargetException ex) {
        }
        catch (IllegalAccessException ex) {
        }

        return deepClone(source);
    }

    /**
     * Does a <b>deep</b> clone of this Info object.
     * 
     * @return Object A deep clone of this Info object, or null if cloning
     *         fails.
     */
    public Object clone() {
        return deepClone(this);
    }

    /**
     * Returns values of public fields of a Class as a Map.
     * 
     * @param source The class to inspect
     * @return Map
     */

    public static Map<Object, Object> toMap(Class<?> source) {
        // for 1.4
        // Map map = new LinkedHashMap();
        Map<Object, Object> map = new TreeMap<Object, Object>();

        /***********************************************************************
         * // NEW CODE
         **********************************************************************/
        map = new LinkedHashMap<Object, Object>();

        /***********************************************************************
         * // OLD CODE try{ // if running on java 1.4 or higher, use
         * LinkedHashMap map = ( Map )
         * Class.forName("java.util.LinkedHashMap").newInstance(); } catch (
         * InstantiationException e ){ } catch ( IllegalAccessException e ){ }
         * catch ( ClassNotFoundException e ){ }
         **********************************************************************/

        try {
            Field[] f = source.getFields();
            for (int i = 0; i < f.length; ++i) {
                if (Modifier.isTransient(f[i].getModifiers())) {
                    continue;
                }

                map.put(f[i].getName(), f[i].get(null));
            }
        }
        catch (IllegalArgumentException e) {
        }
        catch (IllegalAccessException e) {
        }

        return map;
    }

    /**
     * Returns values of public fields of an Object as a Map.
     * 
     * @param source The object to inspect
     * @return Map
     */

    public static Map<String, Object> toMap(Object source) {
        // for 1.4
        // Map map = new LinkedHashMap();
        // Map<String, Object> map = new TreeMap<String, Object>();

        // map = ( Map<Object,Object> )
        // Class.forName("java.util.LinkedHashMap").newInstance();
        Map<String, Object> map = new LinkedHashMap<String, Object>();

        try {
            Field[] f = source.getClass().getFields();
            for (int i = 0; i < f.length; ++i) {
                if (Modifier.isTransient(f[i].getModifiers())) {
                    continue;
                }

                map.put(f[i].getName(), f[i].get(source));
            }
        }
        catch (IllegalArgumentException e) {
        }
        catch (IllegalAccessException e) {
        }

        return map;
    }

    /**
     * Returns values of public fields of this Info object as a Map. Subclasses
     * can override this to exclude some fields, by applying
     * .keySet().retainAll(list) on super.toMap().
     * 
     * @return Map
     */

    public Map<String, Object> toMap() {
        return toMap(this);
    }

    /**
     * Returns values of all delcared fields including public, protected,
     * default (package) access, and private fields, but excludes inherited
     * fields, of an Object as a Map.
     * 
     * @param source The object to inspect
     * @return Map
     */
    private static final Map<String, Object> _toMap(Object source) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();

        try {
            Field[] f = source.getClass().getDeclaredFields();
            for (int i = 0; i < f.length; ++i) {
                if (Modifier.isTransient(f[i].getModifiers())) {
                    continue;
                }
                if (Modifier.isPrivate(f[i].getModifiers())) {
                    f[i].setAccessible(true);
                }
                /* Added to allow printing for protected fields */
                if (Modifier.isProtected(f[i].getModifiers())) {
                    f[i].setAccessible(true);
                }

                map.put(f[i].getName(), f[i].get(source));
            }
        }
        catch (IllegalArgumentException e) {
        }
        catch (IllegalAccessException e) {
        }

        return map;
    }

    /**
     * Returns values of all declared fields of this Info object as a Map.
     * Subclasses can override this to exclude some fields, by applying
     * .keySet().retainAll(list) on super.toMap(). To be used by toString(),
     * equals() and hashCode() only
     * 
     * @return Map
     */
    private final Map<String, Object> _toMap() {
        return _toMap(this);
    }

    /**
     * Replaces as many values in a Map to their clones as possible.
     * 
     * @param map the map whose values will be cloned
     */

    public static void cloneValuesInMap(Map<String, Object> map) {
        for (Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator(); it
                .hasNext();) {
            Map.Entry<String, Object> me = it.next();
            Object theClone = clone(me.getValue());
            if (theClone != null) {
                me.setValue(theClone);
            }
        }
    }

    /**
     * Assigns field values from Map. The keys should be field names, and the
     * values should be appropriately wrapped for primitive types. If copies of
     * the values are needed, use {@link #cloneValuesInMap}.
     * 
     * @param values the Map containing the values
     * @param target the Object to assign field values to
     */

    public static void assignFieldValues(Map<String, Object> values,
            Object target) {
        Class<?> ic = target.getClass();
        for (Iterator<Map.Entry<String, Object>> it = values.entrySet()
                .iterator(); it.hasNext();) {
            try {
                Map.Entry<String, Object> me = it.next();
                ic.getField(me.getKey().toString()).set(target, me.getValue());
            }
            catch (IllegalArgumentException e) {

            }
            catch (SecurityException e) {

            }
            catch (IllegalAccessException e) {

            }
            catch (NoSuchFieldException e) {

            }

        }
    }

    /**
     * Deep-copies public fields from an Object to another. If the source Object
     * is an Info object, the fields returned by its toMap() are copied.
     * 
     * @param source the source Object, typically an Info
     * @param target the Object to modify, typically another Info of the same
     *            type
     */

    public static void copyObject(Object source, Object target) {
        Map<String, Object> map;

        map = ((BaseBean) source).toMap();

        cloneValuesInMap(map);
        assignFieldValues(map, target);

    }

    /**
     * Copies values of fields returned by toMap() to another Info object. This
     * is the same as copyObject(this, target).
     * 
     * @param target the Object to modify, typically another Info of the same
     *            type
     */
    public void copyTo(Object target) {
        copyObject(this, target);
    }

    /**
     * Returns values of public fields of this Info object as a String.
     * 
     * @return String
     */
    public String toString() {
        return _toMap().toString();
    }

    /**
     * Checks if this.toMap() and (Info)obj.toMap() are equal.
     * 
     * @param obj an object to compare to, which must be an Info object
     * @return boolean true iff the two Maps are equal
     * @throws ClassCastException if obj is not an Info object
     * @throws NullPointerException if obj is null
     */
    //public boolean equals(Object obj) {
        //return _toMap().equals(((BaseBean) obj)._toMap());
    //}

    /**
     * Returns this.toMap().hashCode()
     * 
     * @return int a hash code consistent with equals
     */
    //public int hashCode() {
        //return _toMap().hashCode();
    //}

    /**
     * Decodes an enum.
     * 
     * @param value the value to decode, appropriately wrapped in an Object
     * @param clazz the class with static final values
     * @return List of possible matches
     */

    public static List<String> decodeEnum(Object value, Class<?> clazz) {
        List<String> l = new ArrayList<String>();
        try {
            Field[] f = clazz.getFields();
            for (int i = 0; i < f.length; ++i) {
                try {
                    if (Modifier.isFinal(f[i].getModifiers())
                            && value.equals(f[i].get(null))) {
                        l.add(f[i].getName());
                    }
                }
                catch (Exception e) {
                }
            }
        }
        catch (Exception e) {
        }
        return l;
    }

    /**
     * Decodes an int enum.
     * 
     * @param value the int value to decode
     * @param clazz the class with static final values
     * @return List of possible matches
     */

    public static List<String> decodeEnum(int value, Class<?> clazz) {
        return decodeEnum(new Integer(value), clazz);
    }

    /**
     * Explains an enum.
     * 
     * @param value the value to decode, appropriately wrapped in an Object
     * @param clazz the class with static final values
     * @return String
     */

    public static String explainEnum(Object value, Class<?> clazz) {
        List<String> l = decodeEnum(value, clazz);
        if (l.isEmpty()) {
            return value + "";
        }
        return value + " " + l;
    }

    /**
     * Explains an int enum.
     * 
     * @param value the int value to decode
     * @param clazz the class with static final values
     * @return String
     */

    public static String explainEnum(int value, Class<?> clazz) {
        return explainEnum(new Integer(value), clazz);
    }

    /**
     * Gets the value of a field. Returns null if no such field. This method is
     * used by Velocity to allow reading $someInfo.field.
     * 
     * @param key key whose associated value is to be returned.
     * @return Object the value to which this map maps the specified key, or
     *         null if the map contains no mapping for this key.
     */
    public Object get(Object key) {
        try {
            return getClass().getField(key.toString()).get(this);
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * forbid to serialize object for security.
     * 
     * @param out the out
     * @throws java.io.IOException *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private final void writeObject(ObjectOutputStream out)
            throws java.io.IOException {
        throw new java.io.IOException("Object cannot be serialized");
    }

    /**
     * forbid not to deserialize object for security.
     * 
     * @param in the in
     * @throws java.io.IOException *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private final void readObject(ObjectInputStream in)
            throws java.io.IOException {
        throw new java.io.IOException("Class cannot be deserialized");
    }

}
