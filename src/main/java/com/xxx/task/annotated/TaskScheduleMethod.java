package com.xxx.task.annotated;

import java.lang.annotation.*;

/**
 * Created by wuzhenhong on 10/11/21 10:12 AM
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface TaskScheduleMethod {

    /**
     * 方法名
     * @return
     */
    String name();
}
