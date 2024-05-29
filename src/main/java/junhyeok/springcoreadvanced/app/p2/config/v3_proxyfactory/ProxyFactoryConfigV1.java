package junhyeok.springcoreadvanced.app.p2.config.v3_proxyfactory;

import junhyeok.springcoreadvanced.app.p2.config.v3_proxyfactory.advice.LogTraceAdvice;
import junhyeok.springcoreadvanced.app.p2.v1.*;
import junhyeok.springcoreadvanced.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ProxyFactoryConfigV1 {
    @Bean
    OrderRepository2V1 orderRepository2V1(LogTrace logTrace){
        OrderRepository2V1 target = new OrderRepository2V1Impl();
        ProxyFactory factory = new ProxyFactory(target);
        factory.addAdvisor(getAdvisor(logTrace));
        OrderRepository2V1 proxy = (OrderRepository2V1) factory.getProxy();
        log.info("ProxyFactory proxy={}, target={}", proxy.getClass(), target.getClass());

        return proxy;
    }

    @Bean
    OrderService2V1 orderService2V1(LogTrace logTrace){
        OrderService2V1 target = new OrderService2V1Impl(orderRepository2V1(logTrace));
        ProxyFactory factory = new ProxyFactory(target);
        factory.addAdvisor(getAdvisor(logTrace));
        OrderService2V1 proxy = (OrderService2V1) factory.getProxy();
        log.info("ProxyFactory proxy={}, target={}", proxy.getClass(), target.getClass());

        return proxy;
    }

    @Bean
    OrderController2V1 orderController2V1(LogTrace logTrace){
        OrderController2V1 target = new OrderController2V1Impl(orderService2V1(logTrace));
        ProxyFactory factory = new ProxyFactory(target);
        factory.addAdvisor(getAdvisor(logTrace));
        OrderController2V1 proxy = (OrderController2V1) factory.getProxy();
        log.info("ProxyFactory proxy={}, target={}", proxy.getClass(), target.getClass());

        return proxy;
    }

    private Advisor getAdvisor(LogTrace logTrace){
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");
        LogTraceAdvice advice = new LogTraceAdvice(logTrace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }
}
