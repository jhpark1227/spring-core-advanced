package junhyeok.springcoreadvanced.p1.v3;

import junhyeok.springcoreadvanced.trace.logtrace.LogTrace;
import junhyeok.springcoreadvanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepository1V3 {
    private final LogTrace trace;

    public void save(String itemId){

        TraceStatus status = null;
        try{
            status = trace.begin("OrderRepository.save()");
            if(itemId.equals("ex")){
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);
            trace.end(status);
        } catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }

    private void sleep(int millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
