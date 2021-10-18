package com.shinemo.task.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Created by wuzhenhong on 10/11/21 10:57 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskContext {

    /**
     * 任务id
     */
    private Long taskId;

    /**
     * 该任务当前执行实例id
     */
    private Long taskExecInsId;

    /**
     * 调度该任务的机器ip
     */
    private String scheduleIp;

    /**
     * 当前调度是否是重试调度
     */
    private boolean retry;

    /**
     * 该任务的所在服务
     */
    private String appServiceName;

    /**
     * 任务接口名
     */
    private String apiServiceName;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 扩展参数
     */
    private Map<String, Object> extParams;
}
