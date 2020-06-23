package com.rtst.dhjc.task;

import com.rtst.dhjc.service.serviceImpl.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * 功能模块(定时任务，统计日月年电能能耗值)
 *
 * @Author white Liu
 * @Date 2020/6/17 10:12
 * @Version 1.0
 */
@Component
@Configuration
public class EnergyTask {
    @Autowired
    DataServiceImpl dataService;
    @Scheduled(cron="30 59 23 * * ?")
    public void energyDay(){
        dataService.energyDay();
    }
    @Scheduled(cron = "30 59 23 28-31 * ?")//每月最后一天执行
    public void energyMonth(){
        final Calendar c = Calendar.getInstance();
        if (c.get(Calendar.DATE) == c.getActualMaximum(Calendar.DATE)) {
            //是最后一天
            dataService.energyMonth();
        }else{
            System.out.println("今天不是本月最后一天");
        }
    }
    @Scheduled(cron = "30 59 23 31 12 ?")
    public void energyYear(){
        dataService.energyYear();
    }
}
