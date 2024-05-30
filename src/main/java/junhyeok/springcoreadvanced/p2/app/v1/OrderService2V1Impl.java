package junhyeok.springcoreadvanced.p2.app.v1;

public class OrderService2V1Impl implements OrderService2V1 {
    private final OrderRepository2V1 orderRepository;

    public OrderService2V1Impl(OrderRepository2V1 orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
