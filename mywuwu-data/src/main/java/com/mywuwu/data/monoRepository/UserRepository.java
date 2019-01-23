package com.mywuwu.data.monoRepository;


import com.mywuwu.data.monoModel.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 * @Auther: 梁乐乐
 * @Date: 2019/1/23 14:38
 * @Description: 获取mogo对象数据
 */
@Repository
public interface UserRepository extends MongoRepository<UserModel,String> {

    Optional<UserModel> findById(long id);
    UserModel findByNameAndPassword(String name, String password);
    UserModel findByName(String name);
    UserModel findByNameAndUserType(String name,int userType);
}
