package junhyeok.springcoreadvanced.proxy.pureproxy.concreteProxy;

import junhyeok.springcoreadvanced.proxy.pureproxy.concreteProxy.code.ConcreteClient;
import junhyeok.springcoreadvanced.proxy.pureproxy.concreteProxy.code.ConcreteLogic;
import junhyeok.springcoreadvanced.proxy.pureproxy.concreteProxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {
    @Test
    void noProxy(){
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient concreteClient = new ConcreteClient(concreteLogic);
        concreteClient.execute();
    }

    @Test
    void addProxy(){
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient concreteClient = new ConcreteClient(timeProxy);
        concreteClient.execute();
    }
}
