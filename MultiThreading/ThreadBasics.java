public class ThreadBasics {

    public static void main(String[] args) {

        ThreadBasics tb = new ThreadBasics();
        
        //Multi-Threading : 
        //Process of executing multiple threads simultaneously

        //Advantages:
            //1. Threads independently executes for does not stop user process
            //2. Saves time, as parallel execution
            //3. Doesn't affect other threads

        //Creation of Thread in Java
            //1. By extending Thread Class
            MyThread myThread = tb.new MyThread();
            myThread.start();

            //2. By implementing Runnable Interface
            Runnable runnableOfThread = new Runnable(){
                public void run(){
                    System.out.println("My Runnable Thread is executing !");
                }
            };
            Thread myRunThread = new Thread(runnableOfThread);
            myRunThread.start();

            MyThreadWithRunnable myThreadWithRunnable = tb.new MyThreadWithRunnable();
            Thread myRunnable = new Thread(myThreadWithRunnable);
            myRunnable.start();

        //Thread Scheduler
        //Scheduler managing the runtime and order of the threads, 
        //Implementation differs from JVM to JVM and order of execution is unpredictable

        //IMPRTANT EXAMPLE 
        //See the THREAD like a 'CAR'   
        // you need 2 things to run a CAR
        // 1. You need to "start" 
        // 2. You need to "run" the car to reach at some point

        //So, we must always override, run method to tell what to do , where to go when started
        //And, start method , to actually start the journey

        //start(){
        //  1. Register this thread with Thread Scheduler
        //  2. Perform other mandatory activities
        //  3. Invoke run();
        //}


        //Some defaultly available functions :
        // Thread Name      -GET/SET
        // Thread Priority  -GET/SET
        //  Default Thread Priority : 5
        //  NOTE : Threads will inherit their priority from their parent
        //  DEFAULT PARENT OF ALL THREADS - "MAIN THREAD!"


        System.out.println("Thread Name Default : " + myThread.getName());
        myThread.setName("Thread Name Changed!");
        System.out.println("Changed Thread Name "+myThread.getName());
        System.out.println("Thread Priority : " + myThread.getPriority());
        myThread.setPriority(7);
        System.out.println("Thread Priority Changed : "+myThread.getPriority());
        
        System.out.println("Thread Group Name : "+ myThread.getThreadGroup());


        //ONCE THE THREAD LIFECYCLE IS STARTED , WE CANNOT RESTART IT's LIFECYCLE
        //  EXCEPTION : ILLEGAL THREAD STATE EXCEPTION




    }

    class MyThread extends Thread {

        @Override
        public void run(){
            System.out.println("Thread has started running !");
        }
    }

    class MyThreadWithRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread has started from class implementing Runnable Interface!");
            
        }
    }
    
}
