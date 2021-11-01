package com.xxx.task.ace;

import com.xxx.Aace.context.AaceContext;
import com.xxx.ace4j.protocol.AceMethod;
import com.xxx.ace4j.protocol.MethodTarget;
import com.xxx.common.tools.result.ApiResult;
import com.xxx.task.callback.AceTaskSchedulerCallback;
import com.xxx.task.model.TaskContext;

/**
 * Created by wuzhenhong on 10/11/21 10:26 AM
 */
public interface TaskSchedulerWorker {

    /**
     * 回调函数客户端返回值必须是 boolean
     * @param taskContext
     * @param callback
     * @param aaceContext
     * @return
     */
    @AceMethod(target = MethodTarget.CLIENT)
    default boolean asyncDealTask(TaskContext taskContext, AceTaskSchedulerCallback callback, AaceContext aaceContext) {

        return true;
    }

    ApiResult<Long> asyncDealTask(TaskContext taskContext);
}
