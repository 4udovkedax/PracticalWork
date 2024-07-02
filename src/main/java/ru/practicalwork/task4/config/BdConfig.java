package ru.practicalwork.task4.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.sql.DataSource;

@Configuration
@EnableAspectJAutoProxy
//@EnableJpaRepositories
//@EnableTransactionManagement
public class BdConfig {
    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                //.driverClassName("org.hibernate.dialect.PostgreSQLDialect")
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5432/postgres")
                .username("postgres")
                .password("new_pasword")
                .build();
    }
}
