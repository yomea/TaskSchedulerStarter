package com.shinemo.task.model;

import com.shinemo.task.enums.TimerTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuzhenhong on 10/12/21 5:23 PM
 */
@Getter
@Setter
public class TaskScheduleConf {

    /**
     * 请使用builder构建，屏蔽一下字段的赋值操作
     *
     * @see CronTimerTask
     * @see DelayTimerTask
     * @see FixDelayTimerTask
     * @see FixRateTimerTask
     * <p>
     * 定时器列表
     */
    private List<TimerTask> timerList = new ArrayList<>();

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private TaskScheduleConf taskScheduleConf = new TaskScheduleConf();

        public Builder addCronTimerTask(CronTimerTask cronTimerTask) {

            TimerTask timerTask = TimerTask.builder().timerType(TimerTypeEnum.CRON.getType()).cron(cronTimerTask.getCron())
                    .startDateTime(cronTimerTask.getStartDateTime()).endDateTime(cronTimerTask.getEndDateTime()).build();

            taskScheduleConf.timerList.add(timerTask);

            return this;
        }

        public Builder addCronTimerTask(List<CronTimerTask> cronTimerTaskList) {

            cronTimerTaskList.stream().forEach(cronTimerTask -> {
                addCronTimerTask(cronTimerTask);
            });

            return this;
        }

        public Builder addDelayTimerTask(DelayTimerTask delayTimerTask) {

            TimerTask timerTask = TimerTask.builder().timerType(TimerTypeEnum.DELAY_TRIGGER.getType()).delay(delayTimerTask.getDelay())
                    .build();

            taskScheduleConf.timerList.add(timerTask);

            return this;
        }

        public Builder addDelayTimerTask(List<DelayTimerTask> delayTimerTaskList) {

            delayTimerTaskList.stream().forEach(delayTimerTask -> {
                addDelayTimerTask(delayTimerTask);
            });

            return this;
        }

        public Builder addFixRateTimerTask(FixRateTimerTask fixRateTimerTask) {

            TimerTask timerTask = TimerTask.builder().timerType(TimerTypeEnum.FIX_RATE.getType()).initDelay(fixRateTimerTask.getInitDelay()).periodic(fixRateTimerTask.getPeriodic())
                    .startDateTime(fixRateTimerTask.getStartDateTime()).endDateTime(fixRateTimerTask.getEndDateTime()).build();

            taskScheduleConf.timerList.add(timerTask);

            return this;
        }

        public Builder addFixRateTimerTask(List<FixRateTimerTask> fixRateTimerTaskList) {

            fixRateTimerTaskList.stream().forEach(fixRateTimerTask -> {
                addFixRateTimerTask(fixRateTimerTask);
            });

            return this;
        }

        public Builder addFixDelayTimerTask(FixDelayTimerTask fixDelayTimerTask) {

            TimerTask timerTask = TimerTask.builder().initDelay(fixDelayTimerTask.getInitDelay()).timerType(TimerTypeEnum.FIX_DELAY.getType()).periodic(fixDelayTimerTask.getPeriodic())
                    .startDateTime(fixDelayTimerTask.getStartDateTime()).endDateTime(fixDelayTimerTask.getEndDateTime()).build();

            taskScheduleConf.timerList.add(timerTask);

            return this;
        }

        public Builder addFixDelayTimerTask(List<FixDelayTimerTask> fixDelayTimerTaskList) {

            fixDelayTimerTaskList.stream().forEach(fixDelayTimerTask -> {
                addFixDelayTimerTask(fixDelayTimerTask);
            });

            return this;
        }

        public TaskScheduleConf build() {
            return taskScheduleConf;
        }

    }
}
