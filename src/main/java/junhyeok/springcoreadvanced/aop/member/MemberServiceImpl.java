package junhyeok.springcoreadvanced.aop.member;

import junhyeok.springcoreadvanced.aop.member.annotation.ClassAop;
import junhyeok.springcoreadvanced.aop.member.annotation.MethodAop;
import org.springframework.stereotype.Component;

@Component
@ClassAop
public class MemberServiceImpl implements MemberService {

    @Override
    @MethodAop("test value")
    public String hello(String param) {
        return "ok";
    }

    public String internal(String param){
        return "ok";
    }
}
