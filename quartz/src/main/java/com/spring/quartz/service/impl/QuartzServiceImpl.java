package com.spring.quartz.service.impl;

import com.spring.quartz.service.QuartzService;
import com.spring.quartz.utils.SchedulerUtils;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @Author: 高铁墩
 * @Description:
 * @Date: Create in 17:50 2018/12/23
 */
@Service
public class QuartzServiceImpl implements QuartzService {
    private static final Logger log = LoggerFactory.getLogger(QuartzServiceImpl.class);

    //默认任务组名称
    public static final String DEFAULT_JOB_GROUP_NAME = "defaultJobGroup";
    //默认触发器组名称
    public static final String DEFAULT_TRIGGER_GROUP_NAME = "defaultTriggerGroup";
    //默认触发器名称
    public static final String DEFAULT_TRIGGER_NAME = "defaultTriggerName";

    private static Scheduler scheduler = SchedulerUtils.getScheduler();

    public void addJob(String jobName, Class<? extends Job> cls, String cronExpression){
        //定义JobDetail
        JobDetail jobDetail = newJob(cls).requestRecovery(true)
                .withIdentity(jobName,DEFAULT_JOB_GROUP_NAME)
                .build();
        //定义Trigger
        Trigger cronTrigger = newTrigger().withIdentity(jobName+"Trigger",DEFAULT_TRIGGER_GROUP_NAME)
                .startNow()
                .withSchedule(cronSchedule(cronExpression)
                        .withMisfireHandlingInstructionFireAndProceed())
                .forJob(jobDetail)
                .build();

        try {
            scheduler.scheduleJob(jobDetail,cronTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
            log.info("执行方法-addJob-时发生异常，异常信息为:"+e.getMessage());
        }

    }

    public void addJobAndData(String jobName,Class<? extends Job> cls,String cronExpression, Object dataObj){

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put(jobName,dataObj);

        //定义JobDetail
        JobDetail jobDetail = newJob(cls).requestRecovery(true)
                .setJobData(jobDataMap)
                .withIdentity(jobName,DEFAULT_JOB_GROUP_NAME)
                .build();

        //定义Trigger
        Trigger cronTrigger = newTrigger().withIdentity(DEFAULT_TRIGGER_NAME,DEFAULT_TRIGGER_GROUP_NAME)
                .startNow()
                .withSchedule(cronSchedule(cronExpression)
                        .withMisfireHandlingInstructionFireAndProceed())
                .forJob(jobDetail)
                .build();

        Scheduler scheduler = SchedulerUtils.getScheduler();

        try {
            scheduler.scheduleJob(jobDetail,cronTrigger);
        } catch (SchedulerException e) {
            log.info("执行方法-addJobAndData-时发生异常，异常信息为:"+e.getMessage());
            e.printStackTrace();
        }
    }

    public void pauseJob(String jobName,String triggerGroupName) throws RuntimeException {
        try {
            if(null == triggerGroupName)
                scheduler.pauseTrigger(new TriggerKey(jobName+"Trigger",DEFAULT_TRIGGER_GROUP_NAME));
            else
                scheduler.pauseTrigger(new TriggerKey(jobName+"Trigger",triggerGroupName));
        } catch (SchedulerException e) {
            e.printStackTrace();
            log.info("执行方法-pauseJob-时发生异常，异常信息为:"+e.getMessage());
            throw new RuntimeException("在调用方法-pauseJob-停止任务"+jobName+"时发生异常,异常信息为:"+e.getMessage());
        }
    }

    public void resumeJob(String jobName,String triggerGroupName){
        try {
            if(null == triggerGroupName)
                scheduler.resumeTrigger(new TriggerKey(jobName+"Trigger",DEFAULT_TRIGGER_GROUP_NAME));
            else
                scheduler.resumeTrigger(new TriggerKey(jobName+"Trigger",triggerGroupName));
        } catch (SchedulerException e) {
            e.printStackTrace();
            log.info("执行方法-resumeJob-时发生异常，异常信息为:"+e.getMessage());
            throw new RuntimeException("在调用方法-resumeJob-恢复任务"+jobName+"时发生异常,异常信息为:"+e.getMessage());
        }
    }

    public void deleteJob(String jobName,String jobGroupName){
        try{
            if(null == jobGroupName)
                scheduler.deleteJob(JobKey.jobKey(jobName,DEFAULT_JOB_GROUP_NAME));
            else
                scheduler.deleteJob(JobKey.jobKey(jobName,jobGroupName));
        } catch (SchedulerException e) {
            e.printStackTrace();
            log.info("执行方法deleteJob时发生异常，异常信息为:"+e.getMessage());
            throw new RuntimeException("在调用方法-deleteJob-删除任务"+jobName+"时发生异常,异常信息为:"+e.getMessage());
        }
    }

    public void startJobs(){
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
            log.info("执行方法-startJobs-时发生异常，异常信息为:"+e.getMessage());
            throw new RuntimeException("在调用方法-startJobs-启动任务时发生异常,异常信息为:"+e.getMessage());
        }
    }

    public void shutdownJobs(){
        try {
            scheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
            log.info("执行方法-shutdownJobs-时发生异常，异常信息为:"+e.getMessage());
            throw new RuntimeException("在调用方法-shutdownJobs-停止任务时发生异常,异常信息为:"+e.getMessage());
        }
    }

}
