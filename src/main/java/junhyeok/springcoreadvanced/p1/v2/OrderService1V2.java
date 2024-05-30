package junhyeok.springcoreadvanced.p1.v2;

import junhyeok.springcoreadvanced.trace.TraceId;
import junhyeok.springcoreadvanced.trace.TraceStatus;
import junhyeok.springcoreadvanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService1V2 {
    private final OrderRepository1V2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId){
        TraceStatus status = null;
        try{
            status = trace.beginSync(traceId, "OrderService.orderItem()");
            orderRepository.save(status.getTraceId(), itemId);
            trace.end(status);
        } catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }
}
