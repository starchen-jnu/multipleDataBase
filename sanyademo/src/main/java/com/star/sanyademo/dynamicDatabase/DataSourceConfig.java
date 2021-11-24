package com.star.sanyademo.dynamicDatabase;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/***
 *
 * @ClassName: DataSourceConfig
 * @Description: 数据源配置文件
 * @author: wzl
 * @date: 2019年12月9日 下午5:43:24
 *
 */
@Configuration
public class DataSourceConfig {


    @Bean(name = "db1DataSource")
    @Qualifier("db1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource primaryDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "db2DataSource")
    @Qualifier("db2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource sqlServerDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "db3DataSource")
    @Qualifier("db3DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.db3")
    public DataSource rdsMysqlDataSource() {
        return new DruidDataSource();
    }

//    @Bean(name = "db4DataSource")
//    @Qualifier("db3、4DataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.db4")
//    public DataSource ultimateMysqlDataSource() {
//        return new DruidDataSource();
//    }

    /**
     * 动态转换数据库,使用注解切换@DataSources(DataSourceEnum.DB1)，默认db1数据源
     * @param db1
     * @param db2
     * @param db3
     * @return
     */
    @Bean
    @Primary
    public DataSource multipleDataSource(@Qualifier("db1DataSource") DataSource db1, @Qualifier("db2DataSource") DataSource db2, @Qualifier("db3DataSource") DataSource db3) {
        MultipleDataSource multipleDataSource = new MultipleDataSource();
        Map< Object, Object > targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceEnum.DB1.getDbName(), db1);
        targetDataSources.put(DataSourceEnum.DB2.getDbName(), db2);
        targetDataSources.put(DataSourceEnum.DB3.getDbName(), db3);
        //添加数据源
        multipleDataSource.setTargetDataSources(targetDataSources);
        //设置默认数据源
        multipleDataSource.setDefaultTargetDataSource(db1);
        return multipleDataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(multipleDataSource(primaryDataSource(),sqlServerDataSource(),rdsMysqlDataSource()));
       //多数据源，一定要添加，要不然找不到xml;
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*/*Mapper.xml"));

        MybatisConfiguration configuration = new MybatisConfiguration();
        //configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        sqlSessionFactory.setConfiguration(configuration);
        sqlSessionFactory.setPlugins(new Interceptor[]{ //PerformanceInterceptor(),OptimisticLockerInterceptor()
                paginationInterceptor() //添加分页功能
        });
        //sqlSessionFactory.setGlobalConfig(globalConfiguration());
        return sqlSessionFactory.getObject();
    }
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }


}
