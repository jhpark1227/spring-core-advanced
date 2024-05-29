package junhyeok.springcoreadvanced.app.p2.config.v3_proxyfactory;

import junhyeok.springcoreadvanced.app.p2.config.v3_proxyfactory.advice.LogTraceAdvice;
import junhyeok.springcoreadvanced.app.p2.v1.*;
import junhyeok.springcoreadvanced.app.p2.v2.OrderController2V2;
import junhyeok.springcoreadvanced.app.p2.v2.OrderRepository2V2;
import junhyeok.springcoreadvanced.app.p2.v2.OrderService2V2;
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
public class ProxyFactoryConfigV2 {
    @Bean
    OrderRepository2V2 orderRepository2V2(LogTrace logTrace){
        OrderRepository2V2 target = new OrderRepository2V2();
        ProxyFactory factory = new ProxyFactory(target);
        factory.addAdvisor(getAdvisor(logTrace));
        OrderRepository2V2 proxy = (OrderRepository2V2) factory.getProxy();
        log.info("ProxyFactory proxy={}, target={}", proxy.getClass(), target.getClass());

        return proxy;
    }

    @Bean
    OrderService2V2 orderService2V2(LogTrace logTrace){
        OrderService2V2 target = new OrderService2V2(orderRepository2V2(logTrace));
        ProxyFactory factory = new ProxyFactory(target);
        factory.addAdvisor(getAdvisor(logTrace));
        OrderService2V2 proxy = (OrderService2V2) factory.getProxy();
        log.info("ProxyFactory proxy={}, target={}", proxy.getClass(), target.getClass());

        return proxy;
    }

    @Bean
    OrderController2V2 orderController2V2(LogTrace logTrace){
        OrderController2V2 target = new OrderController2V2(orderService2V2(logTrace));
        ProxyFactory factory = new ProxyFactory(target);
        factory.addAdvisor(getAdvisor(logTrace));
        OrderController2V2 proxy = (OrderController2V2) factory.getProxy();
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
