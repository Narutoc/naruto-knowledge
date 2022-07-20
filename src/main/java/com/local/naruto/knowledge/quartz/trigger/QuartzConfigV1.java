package com.local.naruto.knowledge.quartz.trigger;

import com.local.naruto.knowledge.quartz.job.TestCornJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * config for quartz
 */
@Configuration
public class QuartzConfigV1 {

    @Bean
    public JobDetail demoJobDetail() {
        return JobBuilder.newJob(TestCornJob.class).storeDurably().build();
    }

    @Bean
    public Trigger Trigger() {
        return TriggerBuilder.newTrigger()
            .forJob(demoJobDetail())
            .startNow()
            .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
            .build();
    }
}
