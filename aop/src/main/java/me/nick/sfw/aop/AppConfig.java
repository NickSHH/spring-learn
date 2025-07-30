package me.nick.sfw.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan("me.nick.sfw.aop")
@Configuration
@EnableAspectJAutoProxy
@EnableAsync
public class AppConfig {

}
