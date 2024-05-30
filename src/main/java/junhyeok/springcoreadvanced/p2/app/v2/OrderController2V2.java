package junhyeok.springcoreadvanced.p2.app.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController2V2 {
    private final OrderService2V2 orderService;

    public OrderController2V2(OrderService2V2 orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/p2/v2/request")
    public String request(@RequestParam("itemId") String itemId) {
        orderService.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/p2/v2/no-log")
    public String noLog() {
        return "ok";
    }
}
