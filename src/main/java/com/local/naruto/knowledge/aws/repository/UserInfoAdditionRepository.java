package com.local.naruto.knowledge.aws.repository;

import com.local.naruto.knowledge.aws.entity.UserAwsInfo;
import java.util.List;

public interface UserInfoAdditionRepository {

    List<UserAwsInfo> findUsersByGSI(String firstName);
}
