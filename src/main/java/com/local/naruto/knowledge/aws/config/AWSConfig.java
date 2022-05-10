package com.local.naruto.knowledge.aws.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * config for aws
 */
@Configuration
@EnableDynamoDBRepositories(basePackages = "com.local.naruto.knowledge.aws")
public class AWSConfig {

    @Value("${spring.data.aws.access-key}")
    private String amazonAWSAccessKey;

    @Value("${spring.data.aws.secret-key}")
    private String amazonAWSSecretKey;

    /**
     * get AWSCredentialsProvider
     *
     * @return AWSCredentialsProvider
     */
    public AWSCredentialsProvider amazonAWSCredentialsProvider() {
        return new AWSStaticCredentialsProvider(amazonAWSCredentials());
    }

    /**
     * get DynamoDBMapperConfig
     *
     * @return DynamoDBMapperConfig
     */
    @Bean
    public DynamoDBMapperConfig dynamoDBMapperConfig() {
        return DynamoDBMapperConfig.DEFAULT;
    }

    /**
     * get DynamoDBMapper
     *
     * @param amazonDynamoDB amazonDynamoDB
     * @param config         config
     * @return DynamoDBMapper
     */
    @Bean
    public DynamoDBMapper dynamoDBMapper(AmazonDynamoDB amazonDynamoDB,
        DynamoDBMapperConfig config) {
        return new DynamoDBMapper(amazonDynamoDB, config);
    }

    /**
     * get AmazonDynamoDB
     *
     * @return AmazonDynamoDB
     */
    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
            .withCredentials(amazonAWSCredentialsProvider())
            .withRegion(Regions.US_WEST_1).build();
    }

    /**
     * get AWSCredentials
     *
     * @return AWSCredentials
     */
    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
    }
}
