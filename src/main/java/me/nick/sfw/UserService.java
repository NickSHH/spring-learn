package me.nick.sfw;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.PostConstruct;

@Component
public class UserService implements InitializingBean, DisposableBean, SmartInitializingSingleton{

    private Amdin admin;

    private OrderService orderService;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserService userService;

    public UserService(Amdin admin, @Qualifier("orderService2") OrderService orderService, JdbcTemplate jdbcTemplate) {
        this.admin = admin;
        this.orderService = orderService;
        this.jdbcTemplate = jdbcTemplate;
        System.out.println("orderService in UserService: " + orderService);
    }

    public void a () {
        System.out.println("step in UserService a");
    }

    @PostConstruct
    public void b() {
        admin.setName("nick");
        System.out.println("PostConstruct Annotation");
    }

    /***
     * AbstractAutowireCapableBeanFactory - initializeBean - invokeInitMethods- ((InitializingBean)bean).afterPropertiesSet();
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(admin.getName());

    }

    // @Transactional
    // public void test() {
    //     jdbcTemplate.execute("INSERT INTO tenant (name, description, created_time, updated_time) VALUES ('test2', 'test2', '2025-07-22 11:30:30', '2025-07-22 11:30:33');");
    //     test2();//propagation失效，因为执行test2()的不是代理对象，所以事务没有成功
    //     //userService.test2();  Existing transaction found for transaction marked with propagation 'never'
    // }

    // @Transactional (propagation = Propagation.NEVER)
    // public void test2() {
    //     jdbcTemplate.execute("INSERT INTO tenant (name, description, created_time, updated_time) VALUES ('test3', 'test3', '2025-07-22 12:30:30', '2025-07-22 12:30:33');");
    // }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destory userService bean");
    }

    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("after singletons instantiated...");
    }
}
