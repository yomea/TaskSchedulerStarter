package com.xxx.task.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by wuzhenhong on 10/13/21 2:25 PM
 */
@Getter
@AllArgsConstructor
public enum TaskStatusEnum {

    ENABLE(1, "启动"),
    DISABLE(-1, "禁用");

    private Integer status;
    private String desc;
}
