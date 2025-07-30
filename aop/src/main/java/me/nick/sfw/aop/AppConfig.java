package me.nick.sfw.aop;
import me.nick.sfw.aop.service.OrderService;
import me.nick.sfw.aop.service.UserService;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import me.nick.sfw.aop.advice.NickBeforeAdvice;

@ComponentScan("me.nick.sfw.aop")
@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public ProxyFactoryBean userService() {
        UserService userService = new UserService();
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.addAdvice(new NickBeforeAdvice());
        proxyFactoryBean.setTarget(userService);
        return proxyFactoryBean;
    }

    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setBeanNames("userSe*");
        beanNameAutoProxyCreator.setInterceptorNames("nickAroundAdvice");
        return beanNameAutoProxyCreator;
    }

}
