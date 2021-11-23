package com.star.sanyademo.entity.db2;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author StarC
 * @Date 2021/11/23 15:19
 * @Description:
 */
@Data
@Entity(name = "t_s_type")
@TableName("t_s_type")
public class TypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;

    private String typecode;

    private String typename;

    private String typepid;

    private String typegroupid;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "create_name")
    private String createName;
    @Column(name = "order_num")
    private int orderNum;






}
