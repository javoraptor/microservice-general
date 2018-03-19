package com.aws.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aws.domain.User;

@Transactional
@Service
public interface UserMongoRepository extends MongoRepository<User, String> {
    User findByName(String name);
}