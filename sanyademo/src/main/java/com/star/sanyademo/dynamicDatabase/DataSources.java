package com.star.sanyademo.dynamicDatabase;



import java.lang.annotation.*;

/**
 * @Author StarC
 * @Date 2021/11/22 19:43
 * @Description:
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSources {

    DataSourceEnum value() default DataSourceEnum.DB1;
}
