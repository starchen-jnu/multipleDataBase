package com.star.sanyademo.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.star.sanyademo.dynamicDatabase.DataSourceEnum;
import com.star.sanyademo.dynamicDatabase.DataSources;
import com.star.sanyademo.entity.db1.UserEntity;
import com.star.sanyademo.entity.db2.TypeDto;
import com.star.sanyademo.entity.db2.TypeEntity;
import com.star.sanyademo.mapper.db1.UserMapper;
import com.star.sanyademo.mapper.db2.TypeMapper;
import com.star.sanyademo.service.TypeService;
import com.star.sanyademo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author StarC
 * @Date 2021/11/23 15:50
 * @Description:
 */
@Service
public class TypeServiceImple extends ServiceImpl<TypeMapper, TypeEntity> implements TypeService {



    @Override
    @DataSources(DataSourceEnum.DB2)
    public List<TypeEntity> getType(){
        return super.list();
    }

    @Override
    @DataSources(DataSourceEnum.DB2)
    public List<TypeDto> selectList(){
        return baseMapper.selectList();
    }

    @Override
    @DataSources(DataSourceEnum.DB2)
    public Boolean saveType(TypeEntity entity) {
      return super.saveOrUpdate(entity);
    }
}
