public class DeadLockAndStarvation {

    public static A a;
    public static B b;

    class A{
        
        public synchronized void doSomethingA(B b) throws InterruptedException{
            System.out.println("Called A's doSomething method");
            Thread.sleep(5000);
            for(int i=0;i<10;i++){
                System.out.println("This is the first method of A!");
            }
            System.out.println("Trying to call last method of B");
            b.lastMethodB();
        }

        public synchronized void lastMethodA(){

            System.out.println("This is the last method of A!");
            
        }
    }

    class B{

        public synchronized void doSomethingB(A a) throws InterruptedException{
            Thread.sleep(5000);
            for(int i=0;i<10;i++){
                System.out.println("This is the first method of B!");
            }
            System.out.println("Trying to call A's last method");
            a.lastMethodA();
        }

        public synchronized void lastMethodB(){
            System.out.println("This is the last method of B!");
        }
    }

    public static void main(String[] args) {

        //Program entered into deadlock condition cannot be recovered
        //Problem occured due to "synchronized" keyword
        //One of the prevention technique to overcome deadlock method is to use synchronized keyword correctly

        //STARTVATION

        // A long waiting time, where the wait is long but definitely ends after some time
        // eg. Low priority thread has to wait until all the high priority threads are finished execution
        
        DeadLockAndStarvation dead = new DeadLockAndStarvation();
        a = dead.new A();
        b = dead.new B();



        Thread t1 = new Thread(()->{
            try {
                a.doSomethingA(b);
            } catch (InterruptedException e) {
                System.out.println("Exception happened!");
            }
        });

        t1.start();

        Thread t2 = new Thread(()->{
            try {
                b.doSomethingB(a);
            } catch (InterruptedException e) {
                System.out.println("Exception happened!");
            }
        });

        t2.start();

    }
    
}
