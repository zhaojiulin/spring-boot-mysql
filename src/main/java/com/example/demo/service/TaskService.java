package com.example.demo.service;

import com.example.demo.util.MyException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * TaskService
 *
 * @author zjl
 * @date 2018/12/20
 * Scheduled执行定时任务与cron表达式 自己网上搜
 */
public class TaskService {


    @Scheduled(fixedRate = 60000*5)
    @Transactional(rollbackFor = {Exception.class})
    public void TimedTask() throws MyException, IOException,Exception {

        System.out.println("timed task");
    }
}
