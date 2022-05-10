package com.local.naruto.knowledge.aws.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.local.naruto.knowledge.aws.entity.pk.UserPkSkInfo;
import javax.persistence.Id;
import lombok.Data;

/**
 * user info
 */
@Data
@DynamoDBTable(tableName = "tbl_dynamodb_info")
public class UserAwsInfo {

    @Id
    private UserPkSkInfo userPkSkInfo;
    private String firstName;
    private String lastName;

    public UserAwsInfo() {
        userPkSkInfo = new UserPkSkInfo();
    }

    @DynamoDBIgnore
    public UserPkSkInfo getUserPkSkInfo() {
        return userPkSkInfo;
    }

    @DynamoDBAutoGeneratedKey
    @DynamoDBHashKey(attributeName = "userName")
    public String getUserName() {
        return userPkSkInfo != null ? userPkSkInfo.getUserName() : null;
    }

    public void setUserName(String userName) {
        userPkSkInfo.setUserName(userName);
    }

    @DynamoDBRangeKey(attributeName = "userId")
    public String getUserId() {
        return userPkSkInfo.getUserId() != null ? userPkSkInfo.getUserId() : null;
    }

    public void setUserId(String userId) {
        userPkSkInfo.setUserId(userId);
    }

    @DynamoDBIndexHashKey(globalSecondaryIndexName = "firstName-lastName-index", attributeName = "firstName")
    public String getFirstName() {
        return firstName;
    }

    @DynamoDBIndexRangeKey(globalSecondaryIndexName = "firstName-lastName-index", attributeName = "lastName")
    public String getLastName() {
        return lastName;
    }
}
