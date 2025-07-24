package me.nick.sfw;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan("me.nick.sfw")
@EnableTransactionManagement
@Configuration //使 jdbcTemplate 和 transactionManager使用同一个datasourcew。如果缺少，则userService.test()事务将失效
public class AppConfig {

    @Bean
    public OrderService orderService1() {
        return new OrderService();
    }

    @Bean
    public OrderService orderService2() {
        return new OrderService();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
         DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
         transactionManager.setDataSource(dataSource());
         return transactionManager;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://172.19.0.41:3306/test_db");
        dataSource.setUsername("seauprad");
        dataSource.setPassword("admin123");
        return dataSource;
    }
}
