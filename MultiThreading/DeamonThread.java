public class DeamonThread {

    //GREEN THREAD MODEL : Thread which is maintained completely by JVM without taking underlying OS support.
    //NATIVE OS MODEL    : Thread which is implemented by JVM taking native OS support.

    //  t.stop()
        //Immediately stops the execution of the thread

    // t.suspend()
        //Suspends the execution of the thread , does not kill it but suspend the execution further
    // t.resume()
        //Resuming the execution of the thread, 

    class DeamonThreadClass extends Thread {

        public void run(){
            for(int i=0;i<10;i++){
                System.out.println("Child thread executing ! "+ i);
                try {
                    this.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Interupted Exception");
                }
            }
        }
    }

    public static void main(String[] args) {
        
        // DEAMON THREADS
        // Threads which are executing in the background are called "DEAMON THREADS"
            // GARBAGE COLLECTOR
            // SIGNAL DISPATCHER
            // ATTACH LISTENER

        // isDeamon()
        // setDeamon(true/place)
            // Can only be set before starting of the thread
            // If tried after the thread lifecycle has started, then we get IllegalThreadState Exception

        // "MAIN THREAD" can never be DEAMON THREAD
        // Rest of the threads takes their default status from parent

        // Whenever last "NON-DEAMON" THREAD is terminated.
        // ALL , DEAMON THREADS are terminated irrespective of their state.

        //Deamon Threads are just to support Non Deamon Threads

        DeamonThread d = new DeamonThread();

        DeamonThreadClass dThreadClass = d.new DeamonThreadClass();
        dThreadClass.setDaemon(true);

        dThreadClass.start();
        
        System.out.println("Main Thread is finishing executing!");

        //This states that as soon as the last Non Daemon Thread finishes execution, 
        //then, automatically all the deamon threads also stops/terminates their execution

    }
    
}
