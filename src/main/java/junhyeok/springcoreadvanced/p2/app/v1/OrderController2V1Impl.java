package junhyeok.springcoreadvanced.p2.app.v1;

public class OrderController2V1Impl implements OrderController2V1 {
    private final OrderService2V1 orderService;

    public OrderController2V1Impl(OrderService2V1 orderService) {
        this.orderService = orderService;
    }

    @Override
    public String request(String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }

    @Override
    public String noLog() {
        return "ok";
    }
}
