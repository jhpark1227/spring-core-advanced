package junhyeok.springcoreadvanced.p2.config.v1_proxy.concrete_proxy;

import junhyeok.springcoreadvanced.p2.app.v2.OrderRepository2V2;
import junhyeok.springcoreadvanced.trace.TraceStatus;
import junhyeok.springcoreadvanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryConcreteProxy extends OrderRepository2V2 {
    private final OrderRepository2V2 target;
    private final LogTrace logTrace;

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderRepository.request()");
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e){
            logTrace.exception(status, e);
            throw e;
        }
    }
}
