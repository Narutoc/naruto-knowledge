package com.local.naruto.knowledge.config;

import java.io.IOException;
import java.util.Properties;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import javax.sql.DataSource;

@Configuration
public class QuartzConfig {

//    private Properties configQuartzProperties() throws IOException {
//        PropertiesFactoryBean bean = new PropertiesFactoryBean();
//        bean.setLocation(new ClassPathResource("config/quartz/quartzConfig.properties"));
//        bean.afterPropertiesSet();
//        return bean.getObject();
//    }
//
//    @Bean(name = "schedulerFactory")
//    public SchedulerFactoryBean schedulerFactory(Trigger... triggers) throws IOException {
//        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
//        scheduler.setQuartzProperties(configQuartzProperties());
//        scheduler.setOverwriteExistingJobs(true);
//        scheduler.setTriggers(triggers);
//        return scheduler;
//    }
}
