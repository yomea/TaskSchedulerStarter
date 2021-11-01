package com.xxx.task.context;

import com.xxx.task.model.MethodHolder;
import com.xxx.task.model.TaskContext;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuzhenhong on 10/11/21 2:19 PM
 */
public class TaskScheduleMetaContext {

    private static final Map<String, Map<String, MethodHolder>> API_SERVICE_NAME_MAP = new HashMap<>(16);

    public static final void registry(String apiServiceName, String methodName, Object bean, Method method) {

        Map<String, MethodHolder> methodNameMethodMap = API_SERVICE_NAME_MAP.get(apiServiceName);
        if(methodNameMethodMap == null) {

            methodNameMethodMap = new HashMap<>(16);

            API_SERVICE_NAME_MAP.put(apiServiceName, methodNameMethodMap);
        }

        Class<?> clzz = method.getReturnType();
        Class<?>[] argsType = method.getParameterTypes();
        boolean needTaskContext = false;
        if(argsType != null && argsType.length > 0) {
            needTaskContext = argsType[0].isAssignableFrom(TaskContext.class);
        }

        MethodHolder methodHolder = new MethodHolder();
        methodHolder.setBean(bean);
        methodHolder.setMethod(method);
        methodHolder.setReturnType(clzz);
        methodHolder.setNeedTaskContext(needTaskContext);
        methodNameMethodMap.put(methodName, methodHolder);
    }

    public static final MethodHolder get(String apiServiceName, String methodName) {

        Map<String, MethodHolder> methodNameMethodMap = API_SERVICE_NAME_MAP.get(apiServiceName);
        if(methodNameMethodMap != null) {
            MethodHolder methodHolder = methodNameMethodMap.get(methodName);
            return methodHolder;
        }
        return null;
    }
}
