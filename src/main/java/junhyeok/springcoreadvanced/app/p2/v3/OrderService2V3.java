package junhyeok.springcoreadvanced.app.p2.v3;

import org.springframework.stereotype.Service;

@Service
public class OrderService2V3 {
    private final OrderRepository2V3 orderRepository;

    public OrderService2V3(OrderRepository2V3 orderRepository) {
        this.orderRepository = orderRepository;
    }
    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
