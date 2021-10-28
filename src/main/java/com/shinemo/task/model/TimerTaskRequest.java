package com.shinemo.task.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by wuzhenhong on 10/12/21 5:23 PM
 */
@Getter
@Setter
public class TimerTaskRequest {

    /**
     * 任务定义配置
     */
    private TaskInfoConf taskInfoConf;

    /**
     * 任务对应的定时配置
     */
    private TaskScheduleConf taskScheduleConf;

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {

        private TimerTaskRequest request = new TimerTaskRequest();
        private TaskInfoConf.Builder taskInfoConfBuilder = TaskInfoConf.builder();
        private TaskScheduleConf.Builder taskScheduleConfBuilder = TaskScheduleConf.builder();


        /*public Builder taskId(Long taskId) {
            taskInfoConfBuilder.taskId(taskId);
            return this;
        }*/

        public Builder taskName(String taskName) {
            taskInfoConfBuilder.taskName(taskName);
            return this;
        }

        public Builder timeout(Long timeout) {
            taskInfoConfBuilder.timeout(timeout);
            return this;
        }

        public Builder appServiceName(String appServiceName) {
            taskInfoConfBuilder.appServiceName(appServiceName);
            return this;
        }

        public Builder apiServiceName(String apiServiceName) {
            taskInfoConfBuilder.apiServiceName(apiServiceName);
            return this;
        }

        public Builder apiMethodName(String apiMethodName) {
            taskInfoConfBuilder.apiMethodName(apiMethodName);
            return this;
        }


        public Builder taskDefStatus(Integer status) {
            taskInfoConfBuilder.status(status);
            return this;
        }

        /**
         * 暂时还没有完善，服务down机，可能导致子任务未被调度
         * @param taskInfoConf
         * @return
         */
        @Deprecated
        public Builder subTask(TaskInfoConf taskInfoConf) {
            taskInfoConfBuilder.subTask(taskInfoConf);
            return this;
        }


        public Builder addCronTimerTask(CronTimerTask cronTimerTask) {

            taskScheduleConfBuilder.addCronTimerTask(cronTimerTask);

            return this;
        }

        public Builder addCronTimerTask(List<CronTimerTask> cronTimerTaskList) {

            taskScheduleConfBuilder.addCronTimerTask(cronTimerTaskList);

            return this;
        }

        public Builder addDelayTimerTask(DelayTimerTask delayTimerTask) {

            taskScheduleConfBuilder.addDelayTimerTask(delayTimerTask);

            return this;
        }

        public Builder addDelayTimerTask(List<DelayTimerTask> delayTimerTaskList) {

            taskScheduleConfBuilder.addDelayTimerTask(delayTimerTaskList);

            return this;
        }

        public Builder addFixRateTimerTask(FixRateTimerTask fixRateTimerTask) {

            taskScheduleConfBuilder.addFixRateTimerTask(fixRateTimerTask);

            return this;
        }

        public Builder addFixRateTimerTask(List<FixRateTimerTask> fixRateTimerTaskList) {

            taskScheduleConfBuilder.addFixRateTimerTask(fixRateTimerTaskList);

            return this;
        }

        public Builder addFixDelayTimerTask(FixDelayTimerTask fixDelayTimerTask) {

            taskScheduleConfBuilder.addFixDelayTimerTask(fixDelayTimerTask);

            return this;
        }

        public Builder addFixDelayTimerTask(List<FixDelayTimerTask> fixDelayTimerTaskList) {

            taskScheduleConfBuilder.addFixDelayTimerTask(fixDelayTimerTaskList);

            return this;
        }

        public TimerTaskRequest build() {

            request.taskInfoConf = taskInfoConfBuilder.build();
            request.taskScheduleConf = taskScheduleConfBuilder.build();

            return request;
        }

    }

}
