package com.local.naruto.knowledge.config;

import com.local.naruto.knowledge.job.QuartzJobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

/**
 * config schedule detail
 */
@Configuration
public class ScheduleConfiguration {

//    @Bean(name = "quzrtzJobDetail")
//    public MethodInvokingJobDetailFactoryBean jobDetail(QuartzJobDetail jobDetail) {
//        MethodInvokingJobDetailFactoryBean job = new MethodInvokingJobDetailFactoryBean();
//        job.setName("quzrtzJobDetail");
//        job.setGroup("sample");
//        job.setTargetObject(jobDetail);
//        job.setConcurrent(true);
//        job.setTargetMethod("executeJobDetail");
//        return job;
//    }
//
//    @Bean(name = "quartzTrigger")
//    public CronTriggerFactoryBean jobTrigger(
//        @Qualifier("quzrtzJobDetail") MethodInvokingJobDetailFactoryBean quzrtzJobDetail) {
//        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
//        trigger.setJobDetail(quzrtzJobDetail.getObject());
//        trigger.setCronExpression("0/10 * * * * ?");
//        trigger.setName("quartzTrigger");
//        return trigger;
//    }
}
