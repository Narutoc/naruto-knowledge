package com.local.naruto.knowledge.job;

import org.springframework.stereotype.Component;

/**
 * job detail for quartz schedule
 */
@Component
public class QuartzJobDetail {

    public void executeJobDetail() {
        System.out.println("this is job detail");
    }
}
