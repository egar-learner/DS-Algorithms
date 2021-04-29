public class SynchronizedBlock {

    class Display {

        public void printMsg(String msg) throws InterruptedException{

            //Synchronized Block
            //synchronized(this){       CURRENT OBJECT LEVEL LOCK
            synchronized(Display.class){
                for(int i=0;i<10;i++){
                    System.out.print("Good Morning : ");
                    Thread.sleep(2000);
                    System.out.println(msg);

                }
            }
        }
    }

    class MyThread extends Thread {

        Display d;
        String name;

        MyThread(Display d,String name){
            this.d = d;
            this.name = name;
        }

        public void run(){
            try {
                d.printMsg(name);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception is thrown!");
            }
        }
    }

    public static void callSynchronizedBlock(){

        System.out.println("Sync method with same objects");

        SynchronizedBlock sync = new SynchronizedBlock();
        Display d = sync.new Display();
        MyThread thread = sync.new MyThread(d, "Manish");
        MyThread thread2 = sync.new MyThread(d, "Ram");
        thread.start();
        thread2.start();
    
    }

    public static void callSynchronizedBlockWithTwoObject(){

        System.out.println("Sync method with same objects");

        SynchronizedBlock sync = new SynchronizedBlock();
        Display d = sync.new Display();
        Display d1 = sync.new Display();
        MyThread thread = sync.new MyThread(d, "Manish");
        MyThread thread2 = sync.new MyThread(d1, "Ram");
        thread.start();
        thread2.start();
    
    }
    
    public static void main(String[] args) {

        // NOTE: LOCK IS NOT AVAILABLE FOR PRIMITIVE DATA TYPES
        // EXCEPTION: UNEXPECTED TYPE FOUND : INT , REQUIRED REFERENCE
        
        //SYNCHRONIZED BLOCK

        // method(){
        //
        //  10k lines of code
        // 
        //  synchronized(this)          Thread requesting lock of current object
        //  {
        //      Only synchronize these lines of code
        //  }
        //
        //}

        //If there are just few lines of codes which require to be synchronized then only those lines 
        //must be declared as synchronized and not the whole method
        //It improves waiting time of the thread and improves the performance as a whole

        //In Synchronization block we can get the lock of the object in the following ways :
        //  1. CURRENT OBJECT
                // synchronized(this)
        //  2. ANY OBJECT
                // synchronized(object_instance)
        //  3. CURRENT CLASS
                // synchronized(ClassName.class)

        //callSynchronizedBlock();

        callSynchronizedBlockWithTwoObject();

    }
}
