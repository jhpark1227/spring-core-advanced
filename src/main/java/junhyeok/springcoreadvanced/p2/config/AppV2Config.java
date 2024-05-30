package junhyeok.springcoreadvanced.p2.config;

import junhyeok.springcoreadvanced.p2.app.v2.OrderController2V2;
import junhyeok.springcoreadvanced.p2.app.v2.OrderRepository2V2;
import junhyeok.springcoreadvanced.p2.app.v2.OrderService2V2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV2Config {
    @Bean
    public OrderController2V2 orderController2V2(){
        return new OrderController2V2(orderService2V2());
    }

    @Bean
    public OrderService2V2 orderService2V2(){
        return new OrderService2V2(orderRepository2V2());
    }

    @Bean
    public OrderRepository2V2 orderRepository2V2(){
        return new OrderRepository2V2();
    }
}
