package junhyeok.springcoreadvanced.p2.config.v1_proxy.concrete_proxy;

import junhyeok.springcoreadvanced.p2.app.v2.OrderController2V2;
import junhyeok.springcoreadvanced.p2.app.v2.OrderRepository2V2;
import junhyeok.springcoreadvanced.p2.app.v2.OrderService2V2;
import junhyeok.springcoreadvanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {
    @Bean
    public OrderController2V2 orderController2V2(LogTrace logTrace){
        OrderController2V2 controllerImpl = new OrderController2V2(orderService2V2(logTrace));
        return new OrderControllerConcreteProxy(controllerImpl, logTrace);
    }
    @Bean
    public OrderService2V2 orderService2V2(LogTrace logTrace){
        OrderService2V2 serviceImpl = new OrderService2V2(orderRepository2V2(logTrace));
        return new OrderServiceConcreteProxy(serviceImpl, logTrace);
    }

    @Bean
    public OrderRepository2V2 orderRepository2V2(LogTrace logTrace){
        OrderRepository2V2 repositoryImpl = new OrderRepository2V2();
        return new OrderRepositoryConcreteProxy(repositoryImpl, logTrace);
    }
}
