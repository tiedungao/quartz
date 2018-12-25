package com.spring.quartz.service;

import com.spring.quartz.utils.SchedulerUtils;
import org.quartz.*;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @Author: 高铁墩
 * @Description:
 * @Date: Create in 9:56 2018/12/25
 */
public interface QuartzService {

    public void addJob(String jobName, Class<? extends Job> cls, String cronExpression);


    public void addJobAndData(String jobName,Class<? extends Job> cls,String cronExpression, Object dataObj);

    public void pauseJob(String jobName,String triggerGroupName);

    public void resumeJob(String jobName,String triggerGroupName);

    public void deleteJob(String jobName,String jobGroupName);

    public void startJobs();

    public void shutdownJobs();

}
