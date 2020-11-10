package com.lmlx.app.system.config.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    
    
    @Bean(name = "baseDataSource")
    @Qualifier("baseDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.base")
    public DataSource baseDatasource() {
        return new DruidDataSource();
    }

    @Bean(name = "baseJdbcTemplate")
    public JdbcTemplate baseJdbcTemplate(@Qualifier("baseDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    @Bean(name = "baseNamedJdbcTemplate")
    public NamedParameterJdbcTemplate baseNameJdbcTemplate(@Qualifier("baseDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean(name = "baseTransaction")
    public PlatformTransactionManager baseTransaction(@Qualifier("baseDataSource") DataSource dataSource)  {
        return new DataSourceTransactionManager(dataSource);
    }
}
