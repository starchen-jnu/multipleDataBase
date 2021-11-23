package com.star.sanyademo.mapper.db2;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.star.sanyademo.entity.db2.TypeDto;
import com.star.sanyademo.entity.db2.TypeEntity;

import java.util.List;

/**
 * @Author StarC
 * @Date 2021/11/23 15:25
 * @Description:
 */
public interface TypeMapper extends BaseMapper<TypeEntity> {

    List<TypeDto> selectList();
}
