package me.nick.sfw.aop.advisor;

import org.aopalliance.aop.Advice;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

import me.nick.sfw.aop.advice.NickBeforeAdvice;
import me.nick.sfw.aop.service.UserService;

public class NickPointcutAdvisor implements PointcutAdvisor {

    @Override
    public Advice getAdvice() {
        return new NickBeforeAdvice();
    }

    @Override
    public Pointcut getPointcut() {
        return new Pointcut() {

            @Override
            public ClassFilter getClassFilter() {
                return new ClassFilter() {

                    @Override
                    public boolean matches(Class<?> clazz) {
                        return clazz.equals(UserService.class);
                    }
                    
                };
            }

            @Override
            public MethodMatcher getMethodMatcher() {
                return MethodMatcher.TRUE;
            }
            
        };
    }

}
