package com.spring.quartz.access;

import com.spring.quartz.service.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: 高铁墩
 * @Description:
 * @Date: Create in 1:52 2018/12/23
 */
@Order(1)
@Component
public class QuartzAccess implements ApplicationRunner {

    @Autowired
    private QuartzService quartzService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("SpringBoot启动成功");
        quartzService.startJobs();
    }

}
