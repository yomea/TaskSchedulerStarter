package com.xxx.task.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 定时器类型
 * Created by wuzhenhong on 10/9/21 10:22 AM
 */
@Getter
@AllArgsConstructor
public enum TimerTypeEnum {

    //1:cron, 2: 固定定时，3:固定延时，4:一次延时，
    CRON(1, "cron"),
    FIX_RATE(2, "固定定时"),
    FIX_DELAY(3, "固定延时"),
    DELAY_TRIGGER(4, "一次延时");


    private Integer type;

    private String desc;
}
