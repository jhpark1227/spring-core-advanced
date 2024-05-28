package junhyeok.springcoreadvanced.app.p2.config.v1_proxy.interface_proxy;

import junhyeok.springcoreadvanced.app.p2.v1.*;
import junhyeok.springcoreadvanced.app.p2.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import junhyeok.springcoreadvanced.app.p2.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import junhyeok.springcoreadvanced.app.p2.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import junhyeok.springcoreadvanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {
    @Bean
    public OrderController2V1 orderControllerV2_1(LogTrace logTrace){
        OrderController2V1 controllerImpl = new OrderController2V1Impl(orderServiceV2_1(logTrace));
        return new OrderControllerInterfaceProxy(controllerImpl, logTrace);
    }
    @Bean
    public OrderService2V1 orderServiceV2_1(LogTrace logTrace){
        OrderService2V1 serviceImpl = new OrderService2V1Impl(orderRepositoryV2_1(logTrace));
        return new OrderServiceInterfaceProxy(serviceImpl, logTrace);
    }

    @Bean
    public OrderRepository2V1 orderRepositoryV2_1(LogTrace logTrace){
        OrderRepository2V1 repositoryImpl = new OrderRepository2V1Impl();
        return new OrderRepositoryInterfaceProxy(repositoryImpl, logTrace);
    }
}
