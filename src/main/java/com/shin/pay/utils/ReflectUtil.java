package com.shin.pay.utils;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author shiliang.gao
 * @since 2015-11-20
 */
public class ReflectUtil {
    private static final String SETTER_METHOD_PREFIX = "set";
    private static final String GETTER_METHOD_PREFIX = "get";
    private static final int ZERO = 0;
    private static final int FIRST = 1;

    static Map<String, Class> baseClassMap = Maps.newHashMap();

    static {
        baseClassMap.put("boolean", java.lang.Boolean.class);
        baseClassMap.put("int", java.lang.Integer.class);
        baseClassMap.put("long", java.lang.Long.class);
        baseClassMap.put("char", java.lang.Character.class);
        baseClassMap.put("float", java.lang.Float.class);
        baseClassMap.put("byte", java.lang.Byte.class);
        baseClassMap.put("short", java.lang.Short.class);
        baseClassMap.put("double", java.lang.Double.class);
    }

    /**
     * 执行目标对象的methodName方法
     */
    public static Object executeMethod(Object target, String methodName) {
        return executeMethod(target, methodName, null, null);
    }

    public static Object executeMethod(Object object, String methodName,
                                       Object[] paramValue, Class[] paramType) {
        if (paramType == null) {
            paramType = new Class[ZERO];
        }
        return invokeMethod(object, methodName, paramValue, paramType);
    }


    /**
     * 获取目标对象的methodName方法，方法的参数类型为paramType
     */
    public static Method getMethod(Object object, String methodName, Class[] paramType) {
        if (paramType == null) {
            paramType = new Class[ZERO];
        }
        Method[] methods = object.getClass().getMethods();
        for (int index = 0; index < methods.length; index++) {
            Method method = methods[index];
            if (methodNameIsEquals(method, methodName) && methodParamTypeIsEquals(method, paramType)) {
                return method;
            }
        }
        return null;
    }


    /**
     * 执行get方法
     */
    public static Object executeGetterMehtodByField(Object object, String fieldName, Class[] paramType) {
        if (paramType == null) {
            paramType = new Class[ZERO];
        }
        return executeGetterMehtodByField(object, fieldName, paramType, null);
    }

    /**
     * 执行set方法
     */
    public static Object executeSetterMethodByField(Object object, String fieldName, Object[] paramValue, Class[] paramType) {
        Preconditions.checkNotNull(object, "arguments object");
        Preconditions.checkNotNull(fieldName, "arguments fieldName");
        String methodName = getMethodName(fieldName, SETTER_METHOD_PREFIX);
        return invokeMethod(object, methodName, paramValue, paramType);
    }


    private static Object executeGetterMehtodByField(Object object, String fieldName, Class[] paramType, Object[] paramValue) {
        Preconditions.checkNotNull(object, "arguments object");
        Preconditions.checkNotNull(fieldName, "arguments fieldName");
        String methodName = getMethodName(fieldName, GETTER_METHOD_PREFIX);
        return invokeMethod(object, methodName, paramValue, paramType);
    }

    private static String getMethodName(String fieldName, String methodPrefix) {
        String firstChar = fieldName.substring(ZERO, FIRST);
        String leftChar = fieldName.substring(FIRST);
        return methodPrefix + firstChar.toUpperCase() + leftChar;

    }

    private static boolean methodNameIsEquals(Method method, String methodName) {
        return method.getName().equals(methodName);
    }

    private static boolean methodParamTypeIsEquals(Method method, Class[] paramTypes) {
        Class[] parTypes = method.getParameterTypes();
        if (parTypes == null && paramTypes == null) {
            return true;
        }
        if (parTypes.length != paramTypes.length) {
            return false;
        }
        for (int index = 0; index < parTypes.length; index++) {
            Class paramTypeTemp = paramTypes[index];
            Class parTypeTemp = parTypes[index];
            if (!paramTypeTemp.equals(parTypeTemp)) {
                return false;
            }
        }
        return true;
    }

    private static Object invokeMethod(Object object, String methodName,
                                       Object[] paramValue, Class[] paramType) {
        Method method = null;
        method = getMethod(object, methodName, paramType);
        if (method != null) {
            try {
                return method.invoke(object, paramValue);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;

    }


}
