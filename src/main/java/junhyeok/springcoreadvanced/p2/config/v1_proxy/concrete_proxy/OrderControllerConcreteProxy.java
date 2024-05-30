package junhyeok.springcoreadvanced.p2.config.v1_proxy.concrete_proxy;

import junhyeok.springcoreadvanced.p2.app.v2.OrderController2V2;
import junhyeok.springcoreadvanced.trace.TraceStatus;
import junhyeok.springcoreadvanced.trace.logtrace.LogTrace;

public class OrderControllerConcreteProxy extends OrderController2V2{
    private final OrderController2V2 target;
    private final LogTrace logTrace;

    public OrderControllerConcreteProxy(OrderController2V2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderController.request()");
            String result = target.request(itemId);
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return target.noLog();
    }
}
