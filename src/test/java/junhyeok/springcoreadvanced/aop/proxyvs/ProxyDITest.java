package junhyeok.springcoreadvanced.aop.proxyvs;

import junhyeok.springcoreadvanced.aop.member.MemberService;
import junhyeok.springcoreadvanced.aop.member.MemberServiceImpl;
import junhyeok.springcoreadvanced.aop.proxyvs.code.ProxyDIAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
//@SpringBootTest(properties = {"spring.aop.proxy-target-class=false"})
//JDK 동적 프록시, DI 예외 발생 - 인터페이스가 존재하는 경우 인터페이스를 구현하기 때문에 Impl 에 의존성 주입 불가
@SpringBootTest(properties = {"spring.aop.proxy-target-class=true"}) //CGLIB 프록시, 성공
@Import(ProxyDIAspect.class)
public class ProxyDITest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberServiceImpl memberServiceImpl;

    @Test
    void go(){
        log.info("memberService class={}", memberService.getClass());
        log.info("memberServiceImpl class={}", memberServiceImpl.getClass());
        memberService.hello("hello");
    }
}
