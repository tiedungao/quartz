package com.spring.quartz.utils;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: 高铁墩
 * @Description:
 * @Date: Create in 11:39 2018/12/21
 */
@Component
public class SchedulerUtils {
    private  static final Logger log = LoggerFactory.getLogger(SchedulerUtils.class);
    private static Scheduler scheduler = null;

    public static Scheduler getScheduler(){
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            scheduler =  schedulerFactory.getScheduler();
        } catch (SchedulerException e) {
            log.error("创建Scheduler发生异常",e.getStackTrace());
        }
        return scheduler;
    }

}
