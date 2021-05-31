import java.util.Date;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

 

public class ExecutorServiceDemo {

  public void execDemo(final ExecutorService exec) {

    for (int i = 0; i < 5; i++) {

      Runnable task = new Runnable() {

        @Override

        public void run() {

          try {

            System.out.println("Started " + 

              Thread.currentThread() + " at "

                + new Date());

 

            Thread.sleep(1000);

 

            System.out.println("Exiting " + 

              Thread.currentThread() + " at "

                + new Date());

          } catch (InterruptedException e) {

            e.printStackTrace();

          }

        }

      };

      exec.execute(task);

    }

 

    System.out.println("Before calling shutdown. Is shutdown="

        + exec.isShutdown());

    exec.shutdown();

    System.out.println("After calling shutdown. Is shutdown="

        + exec.isShutdown());

  }

 

  public static void main(String[] args) {

    ExecutorServiceDemo eD = new ExecutorServiceDemo();

    eD.execDemo(Executors.newFixedThreadPool(2));

  }

}