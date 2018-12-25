package com.spring.quartz.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author: 高铁墩
 * @Description:
 * @Date: Create in 20:56 2018/12/25
 */
public class JobWithDataMap implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
        String name = jobDataMap.get("name").toString();
        System.out.println("执行包含参数的任务，参数name:"+name);
    }
}
