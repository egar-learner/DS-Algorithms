import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LatchDownExample implements Runnable{

    private CountDownLatch latch;

    private int id;

    public LatchDownExample(int id, CountDownLatch latch){
        this.latch = latch;
        this.id = id;
    }

    public static void main(String[] args) {
        
        CountDownLatch latch = new CountDownLatch(5);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i=0;i<7;i++){
            executor.execute(new LatchDownExample(i, latch));
        }
        

        try {
            latch.await();
            System.out.println("all process completed" + latch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println();
    }

    @Override
    public void run(){

        System.out.println("Starting : "+ id);

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.out.println(" Exception happened : "+e.getMessage());
        }

        latch.countDown();
        
    }
    
}
