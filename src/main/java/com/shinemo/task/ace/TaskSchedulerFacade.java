package com.shinemo.task.ace;

import com.shinemo.ace4j.protocol.AceService;
import com.shinemo.ace4j.protocol.Codec;
import com.shinemo.common.tools.result.ApiResult;
import com.shinemo.task.model.TimerTaskRequest;

/**
 * Created by wuzhenhong on 10/12/21 5:13 PM
 */
@AceService(proxy = "TaskScheduler$TaskSchedulerFacade", interfaceName = "TaskSchedulerFacade", codec = Codec.ACE_PLUS)
public interface TaskSchedulerFacade {

    /**
     * 返回任务ID
     * @param timerTaskRequest
     * @return
     */
    ApiResult<Long> submitTimerTask(TimerTaskRequest timerTaskRequest);

    /**
     * 删除任务
     * @param taskId
     * @return
     */
    ApiResult timerTaskDel(Long taskId);

    /**
     * 禁止某定时任务
     * @param taskId
     * @return
     */
    ApiResult<Void> disableTask(Long taskId);

    /**
     * 启动某定时任务
     * @param taskId
     * @return
     */
    ApiResult<Void> enableTask(Long taskId);

    /**
     * 立即调用某任务
     * @param taskId
     * @return
     */
    ApiResult<Void> execTaskImmediately(Long taskId);
}
