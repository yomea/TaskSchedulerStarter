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

    private String scheduleIp;

    private boolean retry;

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
