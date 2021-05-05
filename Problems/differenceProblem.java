import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class differenceProblem {

    static Scanner sc = new Scanner(System.in);

    class Student{
        int roll;
        int marks;
        Student(int r, int m){
            this.roll = r;
            this.marks = m;
        }
    }

    class P{

        void walk(){
            System.out.println("Walking from P");
        }
        void run(){
            System.out.println("Running from P");
            walk();
        }
    }

    class C extends P{
        
        void walk(){
            System.out.println("Walking from C");
            super.walk();
        }

        void run(){
            System.out.println("Running from C");
            super.run();
        }

        void checkCMethod(){
            System.out.println("Check C method is getting called!");
        }
    }

    class MyThread {

        public synchronized void m1() throws InterruptedException{
            System.out.println("m1 is running!");
            Thread.sleep(5000);
            System.out.println("m1 finished sleeping");
        }

    }




    public static void main(String[] args) throws InterruptedException {

        differenceProblem dp = new differenceProblem();

        MyThread ob1 = dp.new MyThread();
        MyThread ob2 = dp.new MyThread();

        ob1.m1();
        ob2.m1();

        C cRef = dp.new C();
        cRef.run();

        System.out.println("Child Object below");
        P cObj = dp.new C();
        cObj.run();


        //Getting Input
        List<Integer> input = new ArrayList<>();
        HashMap<Integer, Integer> pairs = new HashMap<>();
        List<Student> studs = new ArrayList<>();

        studs.add(dp.new Student(5, 20));
        studs.add(dp.new Student(2, 30));
        studs.add(dp.new Student(3, 40));
        studs.add(dp.new Student(4, 50));
        studs.add(dp.new Student(1, 60));

        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);

        studs.stream()
            .filter(s->s.roll%2!=0)
                .map(s->s.roll*s.roll)
                    .forEach(s->System.out.println("Student roll no became "+s));

        input.stream().filter(i->i%2!=0).map(i->i*i).forEach(System.out::println);

        int diff = 2;

        for(int i=0;i<input.size();i++)
            for(int j=i+1;j<input.size();j++)
                if(Math.abs(input.get(i)-input.get(j))==diff)
                    pairs.put(input.get(i), input.get(j));

        
        pairs.entrySet().stream().forEach(e->System.out.println("Key = "+e.getKey()+ " Value = "+ e.getValue()));

        
    }
    
}
