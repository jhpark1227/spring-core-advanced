package junhyeok.springcoreadvanced.p2.app.v1;

import org.springframework.web.bind.annotation.*;

@RestController //스프링은 @Controller 또는 @RequestMapping 이 있어야 스프링 컨트롤러로 인식
public interface OrderController2V1 {
    @GetMapping("/p2/v1/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/p2/v1/no-log")
    String noLog();
}
