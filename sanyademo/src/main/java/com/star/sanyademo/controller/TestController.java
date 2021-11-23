package com.star.sanyademo.controller;

import com.star.sanyademo.entity.db1.UserEntity;
import com.star.sanyademo.entity.db2.TypeDto;
import com.star.sanyademo.entity.db2.TypeEntity;
import com.star.sanyademo.service.TypeService;
import com.star.sanyademo.service.UserService;
import com.star.sanyademo.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author StarC
 * @Date 2021/11/23 15:26
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    UserService userService;
    @Autowired
    TypeService typeService;

    @GetMapping("/getuser")
    public String getUsers(){
        List<UserEntity> users = userService.getUsers();
        System.out.println(users);
        return "success";
    }

    @GetMapping("/gettype")
    public String gettype(){
        List<TypeEntity> type = typeService.getType();
        List<TypeDto> typeDtos = typeService.selectList();
        List<UserEntity> users = userService.getUsers();
        List<TypeDto> typeDtos1 = typeService.selectList();
        System.out.println("type:"+typeDtos);
        System.out.println("users:"+users);
        System.out.println("type:"+typeDtos1);
        return "success";
    }

    @PostMapping("/transaction")
    public  String transaction(){
        TypeEntity typeEntity = new TypeEntity();
        UserEntity userEntity = new UserEntity();
        typeEntity.setTypepid("123");
        typeEntity.setOrderNum(12);
        typeEntity.setTypecode("123");
        typeEntity.setTypegroupid("123");
        typeEntity.setTypename("123");
        typeEntity.setTypepid("123");
        typeEntity.setCreateDate(new Date());
        typeEntity.setCreateName("star");
        typeEntity.setId("123");
        typeService.saveType(typeEntity);

       userEntity.setId("123");
        userEntity.setUsername("lily");
        userEntity.setPassword("123");
        userService.saveUser(userEntity);
        return "success";
    }
}
