public class ThreadGroups {

    public static void main(String[] args) {

        // "main" - Thread group
        // Super parent of all the groups in java is "SYSTEM" group
        // "system" contain system level threads
        System.out.println("Parent group of all the threads = "+ Thread.currentThread().getThreadGroup().getParent().getName());
        //  "SYSTEM" THREAD GROUP ->
                // FINALIZER
                // ATTACH-LISTENER
                // REFERENCE-HANDLER
                // SIGNAL-DISPATCHER

                // -> "MAIN" THREAD GROUP
                        // MAIN THREAD
                        // THREAD-0
                        // THREAD-1
                        // THREAD-2


        
        // THREAD GROUP

        // Based on functionality, we can group threads into a single unit, i.e. ThreadGroup
        // ThreadGroups can contain sub-thread groups or multiple threads
        // To facilitate common operations easily

        // EVERY THREAD IN JAVA BELONG TO SOME "THREAD GROUP"

        Thread t1 = new Thread();

        System.out.println("Thread Group of t1 = "+ t1.getThreadGroup().getName());
        System.out.println("Thread Group of main thread = "+Thread.currentThread().getThreadGroup().getName());

    
        // Creation of Thread Group

        // ThreadGroup <group_name> = new ThreadGroup(String groupName);    By defauit it will become the child of the thread group whoes thread is executing it
        // ThreadGroup <group_name> = new ThreadGroup(ThreadGroup <parentThreadGroupName>, groupName)
        
    }
    
}
