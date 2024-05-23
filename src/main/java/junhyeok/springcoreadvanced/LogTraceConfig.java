package junhyeok.springcoreadvanced;

import junhyeok.springcoreadvanced.trace.logtrace.LogTrace;
import junhyeok.springcoreadvanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {
    @Bean
    LogTrace logTrace(){
        return new ThreadLocalLogTrace();
    }
}
