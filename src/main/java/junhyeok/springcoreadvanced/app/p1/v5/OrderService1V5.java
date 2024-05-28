package junhyeok.springcoreadvanced.app.p1.v5;

import junhyeok.springcoreadvanced.trace.callback.TraceCallback;
import junhyeok.springcoreadvanced.trace.callback.TraceTemplate;
import junhyeok.springcoreadvanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
public class OrderService1V5 {
    private final OrderRepository1V5 orderRepository;
    private final TraceTemplate template;
    public OrderService1V5(OrderRepository1V5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId){
        template.execute("OrderService.orderItem()", new TraceCallback<>() {
            @Override
            public Void call() {
                orderRepository.save(itemId);
                return null;
            }
        });
    }
}
