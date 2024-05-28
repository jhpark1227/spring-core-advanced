package junhyeok.springcoreadvanced.app.p2.config.v2_dynamicproxy;

import junhyeok.springcoreadvanced.app.p2.config.v2_dynamicproxy.handler.LogTraceBasicHandler;
import junhyeok.springcoreadvanced.app.p2.config.v2_dynamicproxy.handler.LogTraceFilterHandler;
import junhyeok.springcoreadvanced.app.p2.v1.*;
import junhyeok.springcoreadvanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class DynamicProxyFilterConfig {
    private static final String[] PATTERNS = {"request*", "order*", "save*"};
    @Bean
    public OrderController2V1 orderController2V1(LogTrace logTrace){
        OrderController2V1 orderController2V1 = new OrderController2V1Impl(orderService2V1(logTrace));

        OrderController2V1 proxy = (OrderController2V1) Proxy.newProxyInstance(
                OrderController2V1.class.getClassLoader(),
                new Class[]{OrderController2V1.class},
                new LogTraceFilterHandler(orderController2V1, logTrace, PATTERNS)
        );

        return proxy;
    }

    @Bean
    public OrderService2V1 orderService2V1(LogTrace logTrace){
        OrderService2V1 orderService2V1 = new OrderService2V1Impl(orderRepository2V1(logTrace));

        OrderService2V1 proxy = (OrderService2V1) Proxy.newProxyInstance(
                OrderService2V1.class.getClassLoader(),
                new Class[]{OrderService2V1.class},
                new LogTraceFilterHandler(orderService2V1, logTrace, PATTERNS)
        );

        return proxy;
    }

    @Bean
    public OrderRepository2V1 orderRepository2V1(LogTrace logTrace){
        OrderRepository2V1 orderRepository2V1 = new OrderRepository2V1Impl();

        OrderRepository2V1 proxy = (OrderRepository2V1) Proxy.newProxyInstance(
                OrderRepository2V1.class.getClassLoader(),
                new Class[]{OrderRepository2V1.class},
                new LogTraceFilterHandler(orderRepository2V1, logTrace, PATTERNS)
        );

        return proxy;
    }
}
