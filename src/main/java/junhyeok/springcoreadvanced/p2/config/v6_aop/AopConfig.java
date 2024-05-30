package junhyeok.springcoreadvanced.p2.config.v6_aop;

import junhyeok.springcoreadvanced.p2.config.AppV1Config;
import junhyeok.springcoreadvanced.p2.config.AppV2Config;
import junhyeok.springcoreadvanced.p2.config.v6_aop.aspect.LogTraceAspect;
import junhyeok.springcoreadvanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class AopConfig {
    @Bean
    public LogTraceAspect logTraceAspect(LogTrace logTrace){
        return new LogTraceAspect(logTrace);
    }
}
