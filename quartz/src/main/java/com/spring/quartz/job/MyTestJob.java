package com.spring.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author: 高铁墩
 * @Description:
 * @Date: Create in 10:06 2018/12/25
 */
public class MyTestJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("执行我的测试方法");
    }
}
