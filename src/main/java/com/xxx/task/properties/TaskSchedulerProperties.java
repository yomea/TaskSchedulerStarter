package com.xxx.task.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by wuzhenhong on 10/11/21 10:08 AM
 */
@ConfigurationProperties(prefix = "task.scheduler")
@Data
@NoArgsConstructor
public class TaskSchedulerProperties {

    /**
     * 应用名，在ace中，应用名就是 proxy
     */
    private String appServiceName;

    /**
     * 任务处理的线程池的核心线程数
     */
    private Integer taskDealCoreThreadNum;

    /**
     * 任务处理的线程池的最大线程数
     */
    private Integer taskDealMaxThreadNum;

    /**
     * 任务处理的线程池的最大队列大小
     */
    private Integer taskDealMaxQueueSize;
}


