package junhyeok.springcoreadvanced.app.p2.config;

import junhyeok.springcoreadvanced.app.p2.v2.OrderController2V2;
import junhyeok.springcoreadvanced.app.p2.v2.OrderRepository2V2;
import junhyeok.springcoreadvanced.app.p2.v2.OrderService2V2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV2Config {
    @Bean
    public OrderController2V2 orderControllerV2_2(){
        return new OrderController2V2(orderServiceV2_2());
    }

    @Bean
    public OrderService2V2 orderServiceV2_2(){
        return new OrderService2V2(orderRepositoryV2_2());
    }

    @Bean
    public OrderRepository2V2 orderRepositoryV2_2(){
        return new OrderRepository2V2();
    }
}
