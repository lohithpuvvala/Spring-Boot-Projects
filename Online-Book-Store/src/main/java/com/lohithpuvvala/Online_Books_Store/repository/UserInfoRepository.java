package com.lohithpuvvala.Online_Books_Store.repository;

import com.lohithpuvvala.Online_Books_Store.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserInfoRepository extends MongoRepository<UserInfo, String> {

    Optional<UserInfo> findByUsername(String userName);
}
