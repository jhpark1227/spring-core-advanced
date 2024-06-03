package junhyeok.springcoreadvanced.aop.order.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {
    @Pointcut("execution(* junhyeok.springcoreadvanced.aop.order..*(..))")
    public void allOrder(){} // pointcut signature

    //클래스 이름 패턴이 *Service
    @Pointcut("execution(* *..*Service.*(..))")
    public void allService(){}

    //allOrder && allService()
    @Pointcut("allOrder() && allService()")
    public void allOrderAndService(){}
}
