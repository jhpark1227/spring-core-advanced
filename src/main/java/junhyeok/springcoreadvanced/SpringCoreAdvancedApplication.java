package junhyeok.springcoreadvanced;

import junhyeok.springcoreadvanced.app.p2.config.ConcreteProxyConfig;
import junhyeok.springcoreadvanced.app.p2.config.InterfaceProxyConfig;
import junhyeok.springcoreadvanced.trace.LogTraceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({InterfaceProxyConfig.class, ConcreteProxyConfig.class, LogTraceConfig.class})
@SpringBootApplication(scanBasePackages = {"junhyeok.springcoreadvanced.app.p2.v3","junhyeok.springcoreadvanced.app.p1","junhyeok.springcoreadvanced.trace"})
public class SpringCoreAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreAdvancedApplication.class, args);
	}
}
