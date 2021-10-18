package com.shinemo.task.callback;

import com.shinemo.Aace.context.AaceContext;

/**
 * 注意，当前版本的 ace 回调方法只能是下面这个样子的，参数要么是 int 要么就是 AceResult 类型的
 * Created by wuzhenhong on 10/13/21 5:23 PM
 */
public interface AceTaskSchedulerCallback extends TaskSchedulerCallback {

    @Override
    void onResponse(int retCode, Long taskId, AaceContext aaceContext);
}
