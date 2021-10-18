package com.shinemo.task.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuzhenhong on 10/12/21 5:23 PM
 */
@Getter
@Setter
public class TaskInfoConf {

    /**
     * 任务id，如果是更新，那么此字段不能为空，否则认为是新增
     */
    private Long taskId;
    /**
     * 任务名
     */
    private String taskName;
    /**
     * 该任务执行超时时间
     */
    private Long timeout;
    /**
     * worker所在服务名，调度中心通过该名字从注册中心获取机器地址
     */
    private String appServiceName;
    /**
     * 任务处理的接口名
     */
    private String apiServiceName;
    /**
     * 具体任务方法名，目前简单方法名映射，暂不支持重载
     */
    private String apiMethodName;

    /**
     * @see com.shinemo.task.enums.TaskStatusEnum
     * 是否启动，1:启动，-1:禁用
     */
    private Integer status;

    /**
     * 暂时还没有完善，服务down机，可能导致子任务未被调度
     * 子任务配置
     */
    @Deprecated
    private List<TaskInfoConf> subTaskList = new ArrayList<>();

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private TaskInfoConf taskInfoConf = new TaskInfoConf();

        public Builder taskId(Long taskId) {
            taskInfoConf.taskId = taskId;
            return this;
        }

        public Builder taskName(String taskName) {
            taskInfoConf.taskName = taskName;
            return this;
        }

        public Builder timeout(Long timeout) {
            taskInfoConf.timeout = timeout;
            return this;
        }

        public Builder appServiceName(String appServiceName) {
            taskInfoConf.appServiceName = appServiceName;
            return this;
        }

        public Builder apiServiceName(String apiServiceName) {
            taskInfoConf.apiServiceName = apiServiceName;
            return this;
        }

        public Builder apiMethodName(String apiMethodName) {
            taskInfoConf.apiMethodName = apiMethodName;
            return this;
        }


        public Builder status(Integer status) {
            taskInfoConf.status = status;
            return this;
        }

        /**
         * 暂时还没有完善，服务down机，可能导致子任务未被调度
         * @param taskInfoConf
         * @return
         */
        @Deprecated
        public Builder subTask(TaskInfoConf taskInfoConf) {
            taskInfoConf.subTaskList.add(taskInfoConf);
            return this;
        }

        public TaskInfoConf build() {
            return taskInfoConf;
        }
    }
}
