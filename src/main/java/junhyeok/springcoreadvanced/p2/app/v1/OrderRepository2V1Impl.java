package junhyeok.springcoreadvanced.p2.app.v1;

public class OrderRepository2V1Impl implements OrderRepository2V1 {
    @Override
    public void save(String itemId) {
        if(itemId.equals("ex")){
            throw new IllegalStateException("예외 발생!");
        }
        sleep(1000);
    }

    private void sleep(int millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
