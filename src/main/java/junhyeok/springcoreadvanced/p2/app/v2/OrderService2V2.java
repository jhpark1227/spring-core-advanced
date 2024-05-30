package junhyeok.springcoreadvanced.p2.app.v2;

public class OrderService2V2 {
    private final OrderRepository2V2 orderRepository;

    public OrderService2V2(OrderRepository2V2 orderRepository) {
        this.orderRepository = orderRepository;
    }
    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
