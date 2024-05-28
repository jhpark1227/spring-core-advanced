package junhyeok.springcoreadvanced.app.p1.v5;

import junhyeok.springcoreadvanced.trace.callback.TraceCallback;
import junhyeok.springcoreadvanced.trace.callback.TraceTemplate;
import junhyeok.springcoreadvanced.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController1V5 {
    private final OrderService1V5 orderService;
    private final TraceTemplate template;
    public OrderController1V5(OrderService1V5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/p1/v5/request")
    public String request(String itemId){
        return template.execute("OrderController.request()", new TraceCallback<>() {
            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        });
    }
}
