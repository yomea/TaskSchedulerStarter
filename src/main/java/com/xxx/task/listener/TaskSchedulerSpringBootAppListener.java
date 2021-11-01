package com.xxx.task.listener;

import com.xxx.common.tools.exception.ApiException;
import com.xxx.task.annotated.TaskScheduleMethod;
import com.xxx.task.annotated.TaskScheduleService;
import com.xxx.task.context.TaskScheduleMetaContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by wuzhenhong on 10/11/21 1:56 PM
 */
@Slf4j
public class TaskSchedulerSpringBootAppListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        try {
            if (event instanceof ContextRefreshedEvent) {

                ContextRefreshedEvent cre = (ContextRefreshedEvent) event;

                parseTaskService(cre.getApplicationContext());
            }
        } catch (Exception e) {
            log.error("解析任务处理服务失败！", e);
            throw new ApiException("解析任务处理服务失败！", e);
        }
    }

    private void parseTaskService(ApplicationContext context) throws Exception {

        Map<String, Object> beanNameMapBean = context.getBeansWithAnnotation(TaskScheduleService.class);

        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) context;

        try {
            for(Map.Entry<String, Object> entry : beanNameMapBean.entrySet()) {

                String name = entry.getKey();
                Object bean = entry.getValue();

                BeanDefinition definition = registry.getBeanDefinition(name);
                Class<?> beanClass = Class.forName(definition.getBeanClassName());
                Class<?>[] interfaces = beanClass.getInterfaces();

                for(Class<?> interf : interfaces) {

                    TaskScheduleService taskScheduleService = AnnotationUtils.findAnnotation(interf, TaskScheduleService.class);
                    if(taskScheduleService == null) {
                        continue;
                    }
                    //获取api服务名
                    String apiServiceName = taskScheduleService.apiServiceName();
                    Method[] methods = interf.getMethods();
                    for(Method method : methods) {
                        TaskScheduleMethod taskScheduleMethod = AnnotationUtils.findAnnotation(method, TaskScheduleMethod.class);
                        String methodName = method.getName();
                        if(taskScheduleMethod != null) {
                            methodName = taskScheduleMethod.name();
                        }

                        TaskScheduleMetaContext.registry(apiServiceName, methodName, bean, method);
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException", e);
            throw new ApiException("ClassNotFoundException", e);
        }

    }
}
