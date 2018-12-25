package com.spring.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: 高铁墩
 * @Description:
 * @Date: Create in 11:20 2018/12/21
 */
public class MyJob implements Job {

    private static final Logger log = LoggerFactory.getLogger(MyJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("执行我的调度任务");
    }
}
