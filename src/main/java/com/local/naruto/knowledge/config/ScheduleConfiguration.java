package com.local.naruto.knowledge.config;

import com.local.naruto.knowledge.job.QuartzJobDetailSample;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

/**
 * config schedule detail
 */
@Configuration
public class ScheduleConfiguration {

    @Bean(name = "quartzJobDetail")
    public JobDetailFactoryBean quartzJobDetail(QuartzJobDetailSample jobDetail) {
        JobDetailFactoryBean job = new JobDetailFactoryBean();
        job.setName("quartzJobDetail");
        job.setGroup("sample");
        job.setJobClass(QuartzJobDetailSample.class);
        job.setDurability(true);
        job.setDescription("定时任务示例");
        return job;
    }

    @Bean(name = "quartzTrigger")
    public CronTriggerFactoryBean jobTrigger(
        @Qualifier("quartzJobDetail") JobDetailFactoryBean quartzJobDetail) {
        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
        trigger.setJobDetail(quartzJobDetail.getObject());
        trigger.setCronExpression("0/10 * * * * ?");
        trigger.setName("quartzTrigger");
        return trigger;
    }
}
