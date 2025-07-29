package me.nick.sfw.circular_dependency;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan("me.nick.sfw.circular_dependency")
@Configuration
@EnableAspectJAutoProxy
@EnableAsync
public class AppConfig {

}
