package junhyeok.springcoreadvanced.p1.v4;

import junhyeok.springcoreadvanced.trace.logtrace.LogTrace;
import junhyeok.springcoreadvanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController1V4 {
    private final OrderService1V4 orderService;
    private final LogTrace trace;

    @GetMapping("/p1/v4/request")
    public String request(String itemId){
        AbstractTemplate<String> template = new AbstractTemplate<>(trace) {
            @Override
            protected String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        };
        return template.execute("OrderController.request()");
    }
}
