package com.shinemo.task.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * cron定时任务
 * Created by wuzhenhong on 10/15/21 10:25 AM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CronTimerTask {

    /**
     * cron表达式
     */
    private String cron;

    /**
     * 该定时器启动的开始时间，目前只支持 cron
     */
    private Date startDateTime;

    /**
     * 该定时器关闭的结束时间，目前只支持cron
     */
    private Date endDateTime;

    /**
     * @see com.shinemo.task.enums.TaskStatusEnum
     */
    private Integer status;
}
