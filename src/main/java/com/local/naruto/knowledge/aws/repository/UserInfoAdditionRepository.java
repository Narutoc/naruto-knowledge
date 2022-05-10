package com.local.naruto.knowledge.aws.repository;

import com.local.naruto.knowledge.aws.entity.UserAwsInfo;
import java.util.List;

/**
 * self definition method for user
 */
public interface UserInfoAdditionRepository {

    List<UserAwsInfo> findUsersByGSI(String firstName);
}
