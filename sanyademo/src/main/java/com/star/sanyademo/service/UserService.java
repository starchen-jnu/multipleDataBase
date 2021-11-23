package com.star.sanyademo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.star.sanyademo.entity.db1.UserEntity;
import org.apache.catalina.User;

import java.util.List;

/**
 * @Author StarC
 * @Date 2021/11/23 15:27
 * @Description:
 */
public interface UserService extends IService<UserEntity> {
    List<UserEntity> getUsers();
    Boolean saveUser(UserEntity user);
}
