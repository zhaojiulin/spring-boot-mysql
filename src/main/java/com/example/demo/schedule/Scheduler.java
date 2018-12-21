package com.example.demo.schedule;

import com.example.demo.util.MyException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * Scheduler
 * 定时任务
 * @author zjl
 * @date 2018/12/20
 * Scheduled执行定时任务与cron表达式
 */
public class Scheduler {


    @Scheduled(fixedRate = 60000*5)
    @Transactional(rollbackFor = {Exception.class})
    public void TimedTask() throws MyException, IOException,Exception {
        System.out.println("timed task");
    }
}
