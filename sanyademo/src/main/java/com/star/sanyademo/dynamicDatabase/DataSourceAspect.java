package com.star.sanyademo.dynamicDatabase;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author StarC
 * @Date 2021/11/22 19:25
 * @Description:
 */
@Component
@Slf4j
@Aspect
@Order(-1)
public class DataSourceAspect {

    @Pointcut("@within(com.star.sanyademo.dynamicDatabase.DataSources) || @annotation(com.star.sanyademo.dynamicDatabase.DataSources)")
    public void pointCut(){

    }

    @Before("pointCut() && @annotation(dataSources)")
    public void doBefore(DataSources dataSources){
        log.info("选择数据源---"+dataSources.value().getDbName());
        DataSourceContextHolder.setDataSource(dataSources.value().getDbName());
    }

    @After("pointCut()")
    public void doAfter(){
        DataSourceContextHolder.clear();
    }
}
