package com.dxj.xuer.mvc;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * Author: <a href="tuziilm@163.com">Tuziilm</a>
 * Date: 15-12-2
 * Time: ����11:56
 */
@Component("scheduledTaskManager")
public class ScheduledTaskManager {
//    /**
//     * cron���ʽ��* * * * * *����6λ��ʹ�ÿո�������������£�
//     * cron���ʽ��*(��0-59) *(����0-59) *(Сʱ0-23) *(����1-31) *(�·�1-12����JAN-DEC) *(����1-7����SUN-SAT)
//     */
//
//    /**
//     * ��ʱ������� ÿ��5��ִ��һ��
//     */
//    @Scheduled(cron = "1/5 * * * * *")
//    public void autoCardCalculate() {
//        System.out.println("��ʱ�������... " + new Date());
//    }
//
//    /**
//     * �������¡�����ʱִ��һ�Σ�֮��ÿ��1����ִ��һ��
//     */
//    @Scheduled(fixedRate = 1000*60*1)
//    public void heartbeat() {
//        System.out.println("��������... " + new Date());
//    }
//
//    /**
//     * ����־û�������ʱִ��һ�Σ�֮��ÿ��2����ִ��һ��
//     */
//    @Scheduled(fixedRate = 1000*60*2)
//    public void persistRecord() {
//        System.out.println("����־û�... " + new Date());
//    }
}