package junhyeok.springcoreadvanced.app.p2.config.v1_proxy.concrete_proxy;

import junhyeok.springcoreadvanced.app.p2.v2.OrderService2V2;
import junhyeok.springcoreadvanced.trace.TraceStatus;
import junhyeok.springcoreadvanced.trace.logtrace.LogTrace;

public class OrderServiceConcreteProxy extends OrderService2V2 {
    private final OrderService2V2 target;
    private final LogTrace logTrace;

    public OrderServiceConcreteProxy(OrderService2V2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderService.request()");
            target.orderItem(itemId);
            logTrace.end(status);
        } catch (Exception e){
            logTrace.exception(status, e);
            throw e;
        }
    }
}
