package com.local.naruto.knowledge.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * job detail for quartz schedule
 */
@Component
@EnableScheduling
public class QuartzJobDetailSample extends QuartzJobBean {

    public void executeJobDetail() {
        System.out.println("this is job detail");
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        executeJobDetail();
    }
}
