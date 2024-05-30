package junhyeok.springcoreadvanced.p1.v3;

import junhyeok.springcoreadvanced.trace.logtrace.LogTrace;
import junhyeok.springcoreadvanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController1V3 {
    private final OrderService1V3 orderService;
    private final LogTrace trace;

    @GetMapping("/p1/v3/request")
    public String request(String itemId){
        TraceStatus status = null;
        try{
            status = trace.begin("OrderController.request()");
            orderService.orderItem(itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }
}
