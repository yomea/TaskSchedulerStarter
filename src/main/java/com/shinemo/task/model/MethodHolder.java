package com.shinemo.task.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;

/**
 * Created by wuzhenhong on 10/11/21 2:26 PM
 */
@Data
@NoArgsConstructor
public class MethodHolder {

    private Object bean;
    private boolean needTaskContext;
    private Method method;
    private Class<?> returnType;
}
