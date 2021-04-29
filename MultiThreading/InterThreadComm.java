import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class InterThreadComm {

    public static Queue<Integer> queue = new LinkedList<>();

    public static Scanner sc = new Scanner(System.in);

    class MyThread extends Thread{

        int total = 0;

        public void run(){
            synchronized(this){
                System.out.println("Child Thread starts calculation!");
            for(int i=1;i<=100;i++)
                total += i;
            
                System.out.println("Child giving notification call!");
                
                this.notify();
                
            }
        }
    }

    public static void callMethodToTest() throws InterruptedException{

        InterThreadComm inter = new InterThreadComm();

        MyThread thread = inter.new MyThread();
        thread.start();

        //Sleep for 10 seconds
        // If threads is sleeping it will not recieve any notification and will enter into 
        // DEAD LOCK
        //Thread.sleep(10000);
        
        // 1.   Calling SLEEP method when we are waiting for some updating is not recommeneded
        // As we don't know that how much time the thread will take to complete and we can 
        // waste some extra time waiting which would not be required
        // Thread.sleep();

        // 2.   Calling JOIN method is also not recommended because our required calculation
        // might be finished just after 20 lines and method might be containing 100000 lines.
        // If we join, then the MAIN thread will wait for the completion of whole of that method.
        // thread.join();
        synchronized(thread){
            System.out.println("Main thread trying to execute wait method!");
            //To avoid any kind of DEAD LOCK in case the thread didn't receive notification
            //It is recommended to use wait with timeout.
            thread.wait(10000);

            System.out.println("Main thread got notification from Child!");
        System.out.println("Total = " + thread.total);
        }

    }

    class ConsumerThread {

        public void consume() throws InterruptedException{
            synchronized(InterThreadComm.queue){

                if(InterThreadComm.queue.isEmpty())
                    InterThreadComm.queue.wait();
                else
                    while(InterThreadComm.queue.size()>0){
                        Integer num = InterThreadComm.queue.poll();
                        System.out.println("Number Popped : "+ num);
                    }
            }
        }
    }

    class ProducerThread {

        public void produce() throws InterruptedException{
            synchronized(InterThreadComm.queue){

                    while(true){
                        Integer num = sc.nextInt();

                        if(num == 0)
                            break;
                    }

                    InterThreadComm.queue.notify();

            }
        }
    }

    public static void callProducerConsumerTest(){

        InterThreadComm inter = new InterThreadComm();

        ProducerThread p = new ProducerThread();

        ConsumerThread c = new ConsumerThread();
    }

    public static void main(String[] args) throws InterruptedException{
        
        //Inter-Thread Communication can happen in one of the following ways:

        
        // To call any of these methods on a object must be the owner of the Thread, i.e. the thread should have the lock of that object
        // These methods can only be called in synchronized area


        //1. WAIT 
            // If thread t1 calls WAIT() method of an object, the thread immediately releases the lock of that
            // particular object and enter into WAITING STATE
            // wait() throws IE         - Until getting notification
            // wait(ms) throws IE       - Until the given time expires
            // wait(ms, ns) throws IE   - Until the given time expires

        //2. NOTIFY
            // If a thread calls NOTIFY method on any object, it releases the lock on that object.
            // May not be immediately

            //notify()

        //3. NOTIFY_ALL
            // If a thread calls NOTIFY_ALL method on any object, it will send notification

            //notifyAll()
        
    
        // AS SOON AS a thread gets notification then, it goes into ANOTHER WAITING STATE 
        // WHY ANOTHER WAITING STATE???
        // TO get the object lock.........

        //EXCEPT NOTIFY, NOTIFY ALL , WAIT , A thread does not releases any lock.

        //All these are present in the object class
        //These methods must be available for all the java Objects. Hence, it is present in the Object class


        callMethodToTest();

        callProducerConsumerTest();

    }
    
}
