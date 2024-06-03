package junhyeok.springcoreadvanced;

import junhyeok.springcoreadvanced.p2.config.v6_aop.AopConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//컴포넌트 스캔 대상을 scanBasePackages 로 제한했기 때문에 @Import 를 사용하여 강제로 스프링 빈으로 등록
//@Import({InterfaceProxyConfig.class, ConcreteProxyConfig.class})
//@Import({DynamicProxyFilterConfig.class})
//@Import({ProxyFactoryConfigV1.class, ProxyFactoryConfigV2.class})
//@Import(BeanPostProcessorConfig.class)
//@Import(AutoProxyConfig.class)
@Import(AopConfig.class)
@SpringBootApplication(scanBasePackages = {
		"junhyeok.springcoreadvanced.p1",
		"junhyeok.springcoreadvanced.trace",
		"junhyeok.springcoreadvanced.p2.app.v3",
		"junhyeok.springcoreadvanced.aop"
})
public class SpringCoreAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreAdvancedApplication.class, args);
	}
}
