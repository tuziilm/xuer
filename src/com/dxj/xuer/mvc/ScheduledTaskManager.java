package com.dxj.xuer.mvc;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * Author: <a href="tuziilm@163.com">Tuziilm</a>
 * Date: 15-12-2
 * Time: 上午11:56
 */
@Component("scheduledTaskManager")
public class ScheduledTaskManager {
//    /**
//     * cron表达式：* * * * * *（共6位，使用空格隔开，具体如下）
//     * cron表达式：*(秒0-59) *(分钟0-59) *(小时0-23) *(日期1-31) *(月份1-12或是JAN-DEC) *(星期1-7或是SUN-SAT)
//     */
//
//    /**
//     * 定时卡点计算 每隔5秒执行一次
//     */
//    @Scheduled(cron = "1/5 * * * * *")
//    public void autoCardCalculate() {
//        System.out.println("定时卡点计算... " + new Date());
//    }
//
//    /**
//     * 心跳更新。启动时执行一次，之后每隔1分钟执行一次
//     */
//    @Scheduled(fixedRate = 1000*60*1)
//    public void heartbeat() {
//        System.out.println("心跳更新... " + new Date());
//    }
//
//    /**
//     * 卡点持久化。启动时执行一次，之后每隔2分钟执行一次
//     */
//    @Scheduled(fixedRate = 1000*60*2)
//    public void persistRecord() {
//        System.out.println("卡点持久化... " + new Date());
//    }
}