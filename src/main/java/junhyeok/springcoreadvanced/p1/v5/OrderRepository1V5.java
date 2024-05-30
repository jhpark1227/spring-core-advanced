package junhyeok.springcoreadvanced.p1.v5;

import junhyeok.springcoreadvanced.trace.callback.TraceTemplate;
import junhyeok.springcoreadvanced.trace.logtrace.LogTrace;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository1V5 {
    private final TraceTemplate template;

    public OrderRepository1V5(LogTrace logTrace) {
        this.template = new TraceTemplate(logTrace);
    }

    public void save(String itemId){
        template.execute("OrderRepository.save()",() -> {
            if(itemId.equals("ex")){
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);
            return null;
        });
    }

    private void sleep(int millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
