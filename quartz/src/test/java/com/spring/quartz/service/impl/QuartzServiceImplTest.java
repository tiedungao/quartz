package com.spring.quartz.service.impl;

import com.spring.quartz.service.QuartzService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.JobDataMap;
import org.quartz.JobKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 高铁墩
 * @Description:
 * @Date: Create in 10:03 2018/12/25
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class QuartzServiceImplTest {

    @Autowired
    private QuartzService quartzService;

    /**
     * 测试新增job的方法
     */
    @Test
    public void addJob() {
        quartzService.addJob("myTestJob", com.spring.quartz.job.MyTestJob.class,"/15 * * * * ? *");
    }

    /**
     * 测试新增时带参数的job的方法
     */
    @Test
    public void addJobAndData() {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("name","hello Siri");
        quartzService.addJobAndData("jobWithDataMap",com.spring.quartz.job.JobWithDataMap.class,"/15 * * * * ? *,",jobDataMap);
    }

    /**
     * 测试停止job的方法
     */
    @Test
    public void pauseJob() {
        quartzService.pauseJob("myTestJob",null);
    }

    /**
     * 测试让job恢复执行的方法
     */
    @Test
    public void resumeJob() {
        quartzService.resumeJob("myTestJob",null);
    }

    /**
     * 测试删除job的方法
     */
    @Test
    public void deleteJob() {
        quartzService.deleteJob("job1",null);
    }

    /**
     * 测试让所有job开始执行的方法
     */
    @Test
    public void startJobs() {
        quartzService.startJobs();
    }

    /**
     * 测试让所有job停止的方法
     */
    @Test
    public void shutdownJobs() {
        quartzService.shutdownJobs();
    }
}