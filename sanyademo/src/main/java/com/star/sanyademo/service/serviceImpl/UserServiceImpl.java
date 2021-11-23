package com.star.sanyademo.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.star.sanyademo.dynamicDatabase.DataSources;
import com.star.sanyademo.entity.db1.UserEntity;
import com.star.sanyademo.mapper.db1.UserMapper;
import com.star.sanyademo.service.UserService;
import lombok.Data;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author StarC
 * @Date 2021/11/23 15:28
 * @Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Override
    public List<UserEntity> getUsers(){
        return super.list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveUser(UserEntity user) {
       return super.saveOrUpdate(user);
    }
}
