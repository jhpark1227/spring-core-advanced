package junhyeok.springcoreadvanced.app.p2.config;

import junhyeok.springcoreadvanced.app.p2.v1.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV1Config {
    @Bean
    public OrderController2V1 orderControllerV2_1(){
        return new OrderController2V1Impl(orderServiceV2_1());
    }

    @Bean
    public OrderService2V1 orderServiceV2_1(){
        return new OrderService2V1Impl(orderRepositoryV2_1());
    }

    @Bean
    public OrderRepository2V1 orderRepositoryV2_1(){
        return new OrderRepository2V1Impl();
    }
}
