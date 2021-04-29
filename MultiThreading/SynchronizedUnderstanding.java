

public class SynchronizedUnderstanding {

    class DisplayNumberCharacter {

        public synchronized void displayCharacter() throws InterruptedException{
            for(int i=65;i<75;i++){
                System.out.println(String.valueOf(i));
                Thread.sleep(1000);
            }
        }

        public synchronized void displayNumbers() throws InterruptedException{
            for(int i=0;i<10;i++){
                System.out.println(i);
                Thread.sleep(1000);
            }
        }
    }

    class CallDisplayChar extends Thread{

        DisplayNumberCharacter d;

        CallDisplayChar(DisplayNumberCharacter d){
            this.d = d;
        }

        public void run(){
            try {
                d.displayCharacter();
            } catch (InterruptedException e) {
                System.out.println("Display Thread has been interupted !");
            }
        }

    }

    class CallDisplayNumber extends Thread{

        DisplayNumberCharacter d;

        CallDisplayNumber(DisplayNumberCharacter d){
            this.d = d;
        }

        public void run(){
            try {
                d.displayNumbers();
            } catch (InterruptedException e) {
                System.out.println("Display Thread has been interupted !");
            }
        }

    }

    class Display {

        public synchronized void printMsg(String msg) throws InterruptedException{

            for(int i=0;i<10;i++){
                System.out.print("Good Morning : ");
                Thread.sleep(2000);
                System.out.println(msg);

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

    static class DisplayClassLock {

        //The method printMessage cannot be declared static; static methods can only 
        //be declared in a static or top level type

        public static synchronized void printMsg(String msg) throws InterruptedException{

            for(int i=0;i<10;i++){
                System.out.print("Good Morning : ");
                Thread.sleep(2000);
                System.out.println(msg);

            }
        }
    }

    class MyThreadClass extends Thread {

        DisplayClassLock d;
        String name;

        MyThreadClass(DisplayClassLock d,String name){
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


    public static void callSynchronizedMethodToTest(){

        System.out.println("Sync method with same objects");

        SynchronizedUnderstanding sync = new SynchronizedUnderstanding();
        Display d = sync.new Display();
        MyThread thread = sync.new MyThread(d, "Manish");
        MyThread thread2 = sync.new MyThread(d, "Ram");
        thread.start();
        thread2.start();
    
    }

    public static void callSyncMethodWorkingWithDifferentObjects(){

        System.out.println("Sync method with different objects");

        SynchronizedUnderstanding sync = new SynchronizedUnderstanding();
        Display d = sync.new Display();
        Display d1 = sync.new Display();
        MyThread thread = sync.new MyThread(d, "Manish");
        MyThread thread2 = sync.new MyThread(d1, "Ram");
        thread.start();
        thread2.start();
    }

    public static void callStaticSyncMethodWithDifferentObjects(){

        System.out.println("Static Sync method with different objects");

        SynchronizedUnderstanding sync = new SynchronizedUnderstanding();
        DisplayClassLock d = new DisplayClassLock();
        DisplayClassLock d1 = new DisplayClassLock();
        MyThreadClass thread = sync.new MyThreadClass(d, "Manish");
        MyThreadClass thread2 = sync.new MyThreadClass(d1, "Ram");
        thread.start();
        thread2.start();
    }

    public static void displayNumberCharactersOfSameObject(){

        System.out.println("Static Sync method with different objects");

        SynchronizedUnderstanding sync = new SynchronizedUnderstanding();
        DisplayNumberCharacter d = sync.new DisplayNumberCharacter();

        CallDisplayChar thread = sync.new CallDisplayChar(d);
        CallDisplayNumber thread2 = sync.new CallDisplayNumber(d);

        thread.start();
        thread2.start();
    }

    public static void main(String[] args) {

        
        //SYNCHRONIZED modifier is only application for "methods" and "blocks" 
        //If a thread wants to execute any synchronized method of any object
        // First, It has to get the "OBJECT LEVEL LOCK"
        // JVM takes care for aquiring and releasing lock

        // Object level locks only blocks only for synchronized methods, but the non synchronized methods
        // keeps executing like normal
        
        //ADVANTAGES : 
        //  1. To overcome data inconsistency problems
                //If multiple threads are trying to access the same java object there may be data
                // inconistency problem
                //ONLY ONE THREAD IS ALLOWED TO EXECUTE AT A TIME ON THE METHOD OR BlOCK ON THE GIVEN OBJECT
        //  2. 

        //DISADVANTAGES :
        // 1. It increases waiting time of threads and may create completion time of threads

        //COMMENT DOWN ALL METHODS EXCEPT 1 TO UNDERSTAND CLEARLY

        callSynchronizedMethodToTest();

        callSyncMethodWorkingWithDifferentObjects();

        //Class Level lock when operating on static synchronized methods
        // To execute a "STATIC SYNCHRONIZED METHOD" then thread requires class level lock
        // Once, Thread gets the lock it executes and then releases the lock
        callStaticSyncMethodWithDifferentObjects();

        //NOTE : CLASS LEVEL LOCK and OBJECT LEVEL LOCKS are different
        // If a Thread has aquired the CLASS LEVEL LOCK other synchronized methods are allowed to execute
        // As they require OBJECT LEVEL LOCK

        displayNumberCharactersOfSameObject();

    }
    
}
