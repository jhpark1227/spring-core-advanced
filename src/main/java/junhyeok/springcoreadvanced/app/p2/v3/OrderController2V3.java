package junhyeok.springcoreadvanced.app.p2.v3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController2V3 {
    private final OrderService2V3 orderService;

    public OrderController2V3(OrderService2V3 orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/p2/v3/request")
    public String request(@RequestParam("itemId") String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/p2/v3/no-log")
    public String noLog() {
        return "ok";
    }
}
