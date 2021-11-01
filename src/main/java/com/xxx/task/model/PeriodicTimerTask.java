package com.xxx.task.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by wuzhenhong on 10/15/21 10:37 AM
 */
@Data
@NoArgsConstructor
public class PeriodicTimerTask {

    /**
     * 初始延时时间，一般不填
     */
    protected long initDelay;
    /**
     * 循环延时
     */
    protected long periodic;

    /**
     * 该定时器启动的开始时间，目前只支持 cron
     */
    protected Date startDateTime;

    /**
     * 该定时器关闭的结束时间，目前只支持cron
     */
    protected Date endDateTime;

    /**
     * @see com.xxx.task.enums.TaskStatusEnum
     */
    protected Integer status;
}
