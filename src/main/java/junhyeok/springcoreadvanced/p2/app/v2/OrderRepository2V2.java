package junhyeok.springcoreadvanced.p2.app.v2;

public class OrderRepository2V2 {
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
