package com.shinemo.task.callback;

import com.shinemo.Aace.context.AaceContext;
import com.shinemo.ace4j.protocol.AceCallback;
import com.shinemo.ace4j.protocol.codec.AceResponse;
import com.shinemo.common.tools.result.ApiResult;

/**
 * Created by wuzhenhong on 10/12/21 11:44 AM
 */
public interface TaskSchedulerCallback extends AceCallback {

    @Override
    default void onResponse(AceResponse response) {
        //当前实现的 ace 版本没有用，它直接反射的是下面的 onResponse 方法
//        onResponse(response.getStatusCode(), null);
    }

    void onResponse(int retCode, Long taskId, AaceContext aaceContext);
}
