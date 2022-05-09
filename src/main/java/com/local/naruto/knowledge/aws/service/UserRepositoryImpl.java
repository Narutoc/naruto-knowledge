package com.local.naruto.knowledge.aws.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.local.naruto.knowledge.aws.entity.UserAwsInfo;
import com.local.naruto.knowledge.aws.repository.UserInfoAdditionRepository;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserInfoAdditionRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    @Override
    public List<UserAwsInfo> findUsersByGSI(String firstName) {
        HashMap<String, AttributeValue> eav = new HashMap<>();
        eav.put(":v1", new AttributeValue().withS(firstName));

        DynamoDBQueryExpression<UserAwsInfo> queryExpression = new DynamoDBQueryExpression<UserAwsInfo>()
            .withIndexName("firstName-lastName-index")
            .withConsistentRead(false)
            .withKeyConditionExpression("firstName = :v1")
            .withExpressionAttributeValues(eav);
        return dynamoDBMapper.query(UserAwsInfo.class, queryExpression);

    }
}
