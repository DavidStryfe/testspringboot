package com.happyforce.repository;

import com.happyforce.objetos.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<UserMongo, String> {

    public List<UserMongo> findUsers();

}