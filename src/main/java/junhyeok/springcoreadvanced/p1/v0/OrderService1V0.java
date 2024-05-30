package junhyeok.springcoreadvanced.p1.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService1V0 {
    private final OrderRepository1V0 orderRepository;

    public void orderItem(String itemId){
        orderRepository.save(itemId) ;
    }
}
