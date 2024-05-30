package junhyeok.springcoreadvanced.p1.v1;

import junhyeok.springcoreadvanced.trace.TraceStatus;
import junhyeok.springcoreadvanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService1V1 {
    private final OrderRepository1V1 orderRepository;
    private final HelloTraceV1 trace;

    public void orderItem(String itemId){
        TraceStatus status = null;
        try{
            status = trace.begin("OrderService.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }
}
