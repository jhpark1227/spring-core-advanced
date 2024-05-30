package junhyeok.springcoreadvanced.p2.config.v4_postprocessor;

import junhyeok.springcoreadvanced.p2.config.AppV1Config;
import junhyeok.springcoreadvanced.p2.config.AppV2Config;
import junhyeok.springcoreadvanced.p2.config.v3_proxyfactory.advice.LogTraceAdvice;
import junhyeok.springcoreadvanced.p2.config.v4_postprocessor.postprocessor.PackageLogTracePostProcessor;
import junhyeok.springcoreadvanced.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j
@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class BeanPostProcessorConfig {
    @Bean
    PackageLogTracePostProcessor packageLogTracePostProcessor(LogTrace logTrace){
        return new PackageLogTracePostProcessor("junhyeok.springcoreadvanced.p2.app", getAdvisor(logTrace));
    }

    private Advisor getAdvisor(LogTrace logTrace){
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");
        LogTraceAdvice advice = new LogTraceAdvice(logTrace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }
}
