package com.star.sanyademo.service;

import com.star.sanyademo.entity.db2.TypeDto;
import com.star.sanyademo.entity.db2.TypeEntity;

import java.util.List;

/**
 * @Author StarC
 * @Date 2021/11/23 15:49
 * @Description:
 */
public interface TypeService {

    List<TypeEntity> getType();
    List<TypeDto> selectList();
    Boolean saveType(TypeEntity entity);
}
