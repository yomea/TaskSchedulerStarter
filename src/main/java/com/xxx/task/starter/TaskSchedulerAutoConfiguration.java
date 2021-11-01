package com.xxx.task.starter;

import com.xxx.ace4j.protocol.Codec;
import com.xxx.ace4j.spring.AaceConsumerBean;
import com.xxx.ace4j.spring.AaceProviderBean;
import com.xxx.ace4j.spring.AceProperties;
import com.xxx.task.ace.TaskSchedulerFacade;
import com.xxx.task.ace.TaskSchedulerWorker;
import com.xxx.task.ace.impl.TaskSchedulerWorkerImpl;
import com.xxx.task.constant.TaskScheduleConstant;
import com.xxx.task.properties.TaskSchedulerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

/**
 * Created by wuzhenhong on 10/11/21 10:02 AM
 */
@Configuration
@EnableConfigurationProperties(TaskSchedulerProperties.class)
@ConditionalOnProperty(prefix = "task.scheduler", name = "enable", havingValue = "true", matchIfMissing = false)
public class TaskSchedulerAutoConfiguration {

    private static final int NCPUS = Runtime.getRuntime().availableProcessors() << 3;

    @Autowired
    private TaskSchedulerProperties taskSchedulerProperties;

    /**
     * @see com.xxx.ace4j.server.AaceServiceHandler
     * @return
     */
    @Bean(initMethod = "init")
    public AaceProviderBean<TaskSchedulerWorker> taskSchedulerWorker() {

        String appServiceName = taskSchedulerProperties.getAppServiceName();
        if(StringUtils.isEmpty(appServiceName)) {
            throw new RuntimeException("启用定时任务调度时，task.scheduler.appServiceName 的属性不能为空");
        }

        AaceProviderBean<TaskSchedulerWorker> workerAaceProviderBean = new AaceProviderBean();
        workerAaceProviderBean.setInterfaceName(TaskScheduleConstant.WORKER_INTERFACE_NAME);
        workerAaceProviderBean.setProxy(TaskScheduleConstant.WORKER_PROXY_NAME + taskSchedulerProperties.getAppServiceName());
        workerAaceProviderBean.setCodec(Codec.ACE_PLUS);
        workerAaceProviderBean.setInterfaceClass(TaskSchedulerWorker.class);
        workerAaceProviderBean.setService(new TaskSchedulerWorkerImpl());
        //在没有设置方法级别的线程池时，优先使用自定义线程池
//        workerAaceProviderBean.setExecutor();
        //设置方法级别的线程池
//        workerAaceProviderBean.setThreadPoolConfigs();

        Integer coreThreadNum = taskSchedulerProperties.getTaskDealCoreThreadNum();
        Integer maxThreadNum = taskSchedulerProperties.getTaskDealMaxThreadNum();
        Integer maxQueueSize = taskSchedulerProperties.getTaskDealMaxQueueSize();

        //在没有设置自定义线程池时，将查看当前参数是否设置，如果设置，那么将会使用次参数设置处理该接口方法的默认线程池大小，如果这个也没有设置那么将使用全局线程池
        workerAaceProviderBean.setCoreThreadNum(coreThreadNum == null ? NCPUS : coreThreadNum);
        workerAaceProviderBean.setMaxThreadNum(maxThreadNum == null ? NCPUS : maxThreadNum);
        //设置线程池队列长度，最大队列长度十万
        workerAaceProviderBean.setMaxQueueSize(maxQueueSize == null ? 10_0000 : maxQueueSize);

        return workerAaceProviderBean;
    }

    @Bean(initMethod = "init")
    public AaceConsumerBean<TaskSchedulerFacade> taskSchedulerFacade(Environment env) {

        AaceConsumerBean aaceConsumerBean = new AaceConsumerBean();
        aaceConsumerBean.setInterfaceName("TaskSchedulerFacade");
        aaceConsumerBean.setCodec(Codec.ACE_PLUS);
        aaceConsumerBean.setUri(AceProperties.getCenterUri(env));
        aaceConsumerBean.setInterfaceClass(TaskSchedulerFacade.class);
        aaceConsumerBean.setProxy("TaskScheduler$TaskSchedulerFacade");

        return aaceConsumerBean;
    }
}
