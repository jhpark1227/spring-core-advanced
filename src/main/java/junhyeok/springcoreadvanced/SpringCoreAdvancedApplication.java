package junhyeok.springcoreadvanced;

import junhyeok.springcoreadvanced.app.p2.config.v1_proxy.concrete_proxy.ConcreteProxyConfig;
import junhyeok.springcoreadvanced.app.p2.config.v1_proxy.interface_proxy.InterfaceProxyConfig;
import junhyeok.springcoreadvanced.app.p2.config.v2_dynamicproxy.DynamicProxyBasicConfig;
import junhyeok.springcoreadvanced.app.p2.config.v2_dynamicproxy.DynamicProxyFilterConfig;
import junhyeok.springcoreadvanced.app.p2.config.v3_proxyfactory.ProxyFactoryConfigV1;
import junhyeok.springcoreadvanced.app.p2.config.v3_proxyfactory.ProxyFactoryConfigV2;
import junhyeok.springcoreadvanced.trace.LogTraceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

//컴포넌트 스캔 대상을 scanBasePackages 로 제한했기 때문에 @Import 를 사용하여 강제로 스프링 빈으로 등록
//@Import({InterfaceProxyConfig.class, ConcreteProxyConfig.class})
//@Import({DynamicProxyFilterConfig.class})
@Import({ProxyFactoryConfigV1.class, ProxyFactoryConfigV2.class})
@SpringBootApplication(scanBasePackages = {"junhyeok.springcoreadvanced.app.p2.v3","junhyeok.springcoreadvanced.app.p1","junhyeok.springcoreadvanced.trace"})
public class SpringCoreAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreAdvancedApplication.class, args);
	}
}
