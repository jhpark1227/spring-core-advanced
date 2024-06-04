package junhyeok.springcoreadvanced.aop.exam;

import junhyeok.springcoreadvanced.aop.exam.annotation.Retry;
import junhyeok.springcoreadvanced.aop.exam.annotation.Trace;
import org.springframework.stereotype.Repository;

@Repository
public class ExamRepository {
    private static int seq = 0;

    /**
     *  다섯 번에 한 번은 실패하는 요청
     */
    @Trace
    @Retry
    public String save(String itemId){
        seq++;
        if(seq % 5 == 0){
            throw new IllegalStateException("예외 발생");
        }
        return "ok";
    }
}
