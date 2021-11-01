package com.xxx.task.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by wuzhenhong on 10/12/21 5:26 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimerTask {

    /**
     * @see com.xxx.task.enums.TimerTypeEnum
     */
    private Integer timerType;

    /**
     * cron表达式
     */
    private String cron;

    /**
     * 延时时间
     */
    private long delay;

    /**
     * 初始延时时间，一般不填
     */
    private long initDelay;
    /**
     * 循环延时
     */
    private long periodic;

    /**
     * 该定时器启动的开始时间，目前只支持 cron
     */
    private Date startDateTime;

    /**
     * 该定时器关闭的结束时间，目前只支持cron
     */
    private Date endDateTime;

    /**
     * @see com.xxx.task.enums.TaskStatusEnum
     */
    private Integer status;
}
