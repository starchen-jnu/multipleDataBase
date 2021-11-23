package com.star.sanyademo.entity.db1;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.*;

/**
 * @Author StarC
 * @Date 2021/11/23 15:15
 * @Description:
 */
@Data
@Entity(name = "user")
@TableName(value = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;

    private String username;

    private String password;
}
