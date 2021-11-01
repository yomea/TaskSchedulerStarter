package com.xxx.task.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 延时任务
 * Created by wuzhenhong on 10/15/21 10:26 AM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DelayTimerTask {

    /**
     * 延时时间
     */
    private long delay;

    /**
     * @see com.xxx.task.enums.TaskStatusEnum
     */
    private Integer status;
}
