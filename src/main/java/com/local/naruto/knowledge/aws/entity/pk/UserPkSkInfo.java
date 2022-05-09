package com.local.naruto.knowledge.aws.entity.pk;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import java.io.Serializable;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class UserPkSkInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private String userName;
    private String userId;

    @DynamoDBHashKey
    public String getUserName() {
        return userName;
    }

    @DynamoDBRangeKey
    public String getUserId() {
        return userId;
    }
}
