package com.happyforce.repository;

import com.happyforce.objetos.UserMongo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface UserRepository extends MongoRepository<UserMongo, String> {

    UserMongo findBy_id(ObjectId _id);

    /*public List<UserMongo> findUsers();

    public boolean insertUser(UserMongo userMongo);*/

}