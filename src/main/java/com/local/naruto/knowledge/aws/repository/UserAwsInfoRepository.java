package com.local.naruto.knowledge.aws.repository;

import com.local.naruto.knowledge.aws.entity.UserAwsInfo;
import java.util.List;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

/**
 * UserAwsInfoRepository
 */
@EnableScan
public interface UserAwsInfoRepository extends CrudRepository<UserAwsInfo, String>,
    UserInfoAdditionRepository {

    List<UserAwsInfo> findByLastName(String lastName);

    List<UserAwsInfo> findByFirstName(String firstName);
}
