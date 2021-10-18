package com.shinemo.task.ace;

import com.shinemo.Aace.context.AaceContext;
import com.shinemo.ace4j.protocol.AceMethod;
import com.shinemo.ace4j.protocol.MethodTarget;
import com.shinemo.ace4j.protocol.Out;
import com.shinemo.common.tools.result.ApiResult;
import com.shinemo.task.callback.AceTaskSchedulerCallback;
import com.shinemo.task.model.TaskContext;

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
