package junhyeok.springcoreadvanced.p2.config;

import junhyeok.springcoreadvanced.p2.app.v1.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV1Config {
    @Bean
    public OrderController2V1 orderController2V1(){
        return new OrderController2V1Impl(orderService2V1());
    }

    @Bean
    public OrderService2V1 orderService2V1(){
        return new OrderService2V1Impl(orderRepository2V1());
    }

    @Bean
    public OrderRepository2V1 orderRepository2V1(){
        return new OrderRepository2V1Impl();
    }
}
