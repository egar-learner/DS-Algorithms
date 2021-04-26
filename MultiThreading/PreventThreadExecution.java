public class PreventThreadExecution {

    static Thread mainThread = null;

    class MyThread implements Runnable{ 

        public void run(){
            for(int i=0;i<10;i++){
                System.out.println("Child Thread Run method is executing !");

                /**try {
                    mainThread.join();
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException while joining with main");
                }**/
            }

        }
    }

    class MyThreadChild implements Runnable{ 

        public void run(){
            for(int i=0;i<10;i++){
                System.out.println("MyThreadChild: Child Thread Run method is executing !");
                Thread.yield();
            }

        }
    }

    static void callYieldMethodTest(){
        System.out.println("YIELD METHOD TEST STARTED!");
        //Since the child the is doing Thread.yeild(), i.e. the Child is doing Yield()
        //Main Thread will get the chance to finish first surely

        PreventThreadExecution pte = new PreventThreadExecution();

        MyThread myThreadRun = pte.new MyThread();
        Thread myThread = new Thread(myThreadRun);
        myThread.start();

        for(int i=0;i<10;i++){
            System.out.println("call Yeild Method : Main Thread is Executing here!");
        }
    }

    static void callJoinMethodTest() throws InterruptedException{
        System.out.println("JOIN METHOD TEST STARTED!");

        PreventThreadExecution pte = new PreventThreadExecution();

        MyThread myThreadRun = pte.new MyThread();
        Thread myThread = new Thread(myThreadRun);
        myThread.start();
        //join method throws    INTERRUPTED EXCEPTION , so the method must handle it and throw it else Compile time error
        //Compulsurily, the main Thread will wait for the COMPLETION OF CHILD THREAD to execute and finish
        //only after that MAIN THREAD will continue execution
        myThread.join();

        for(int i=0;i<10;i++){
            System.out.println("call Join Method : Main Thread is Executing here!");
        }
    }

    public static void callJoinToPauseChildThreadUntilMainCompletes() {

        System.out.println("JOINT TO PAUSE CHILD METHOD IS CALLED !");
        
        PreventThreadExecution pte = new PreventThreadExecution();

        MyThreadChild myThreadRun = pte.new MyThreadChild();
        Thread myThread = new Thread(myThreadRun);
        myThread.start();

        //myThread.join();
        // IF MAIN THREAD WAIT FOR CHILD EXECUTION TO FINISH
        // AND CHILD THREAD WAIT PARENT EXECUTION TO FINISH
        // THEN A CONDITION OF ""DEADLOCK WILL ARISE""
        // and no one will be able to finish

        for(int i=0;i<10;i++){
            System.out.println("Main Thread is Executing here!");
        }
    }

    public static void callSleepMethodTest() throws InterruptedException{
        System.out.println("SLEEP METHOD TEST STARTED!");

        for(int i=0;i<10;i++){  
            System.out.println("Sleeping method Called " + i);
            Thread.currentThread().sleep(2000);
        }
    }

    public static void callMainThreadInteruptChildThreadTest() {

        Runnable newRunnable = new Runnable(){
            @Override
            public void run(){
                try{
                for(int i = 0;i<10;i++){
                    System.out.println("Lazy thread : "+ i);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e){
                System.out.println("I am Lazy thread and I got Interrupted!!");
            }
            }
        };

        Thread newThread = new Thread(newRunnable);
        newThread.start();

        //Main Thread interrupts Child Thread
        newThread.interrupt();
    }

    public static void main(String[] args) throws InterruptedException{

        mainThread = Thread.currentThread();

        //Thread.currentThread().join();
        // Current Thread = Main Thread
        // Joins and waits for Main Thread to complete.
        // A deadlock arises.
        
        // 3 ways a Thread execution can be prevented/paused:
            //  YIELD()
                //Tells the Scheduler that it is ready to Pause execution to give chance to execute to 
                // all the remaining waiting thread of same or higher priority in the queue to get the
                // scheduler time.
                // After "YIELD" the thread will go in "READY/RUNNABLE" State.
                //      It depends on Scheduler that when the yeild thread will get the chance once again, 
                //      to continue its execution

                // Like some person having urgent call to make then person who is just taking like that for 
                // long hours can pause for few minutes and once the urgent call is done , he can again continue
                // its execution
            callYieldMethodTest();

            //  JOIN()
                //If a thread wants to wait until some other thread is completed, then join method is useful
                // eg t1 want to wait until t2 completes
                // then t1 THREAD has to call t2.join()
                // As soon as calls joins it goes into WAITING STATE and 
                // After t2 finishes then t1 can continue its execution

                //join()        - will wait until the other thread finishes its execution
                //join(ms)      - will wait for mentioned mili-seconds and then will start its execution if the other one doesn't finishes
                //join(ms,ns)   - will wait for ms and nano-seconds for completion of other thread, else will continue
                // THROWS INTERUPTED EXCEPTION
                // when joins the CURRENT THREAD goes to "WAITING STATE", once the other thread finishes execution
                // this thread comes to "RUNNABLE/READY STATE" and wait for scheduler time
            callJoinMethodTest();
            callJoinToPauseChildThreadUntilMainCompletes();

            //  SLEEP()
                //
                callSleepMethodTest();
                //sleep(ms)
                //sleep(ms, ns)
                //THROWS INTERRUPTED EXCEPTION      {Checked Exception}



            // How a thread can interupt another thread?
            //  INTERRUPT()
                // A thread can interrupt 'Sleeping Thread', or 'Waiting Thread'
                // A thread does not throw any exception if the Thread is not in waiting/Sleeping state
                
                //Interupt call will never be wasted, it's like a "SNAKE"
                // If the thread is not in waiting/sleeping state it will wait until it goes into 
                // sleeping or waiting state and will throw exception once, it goes into waiting or
                // sleeping state

                //NOTE : If the target thread never went into SLEEPING/WAITING state then this interupt call will be wasted
                

            callMainThreadInteruptChildThreadTest();



    }
    
}
