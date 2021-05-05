import java.util.TreeMap;
import java.util.TreeSet;

public class Test {

    final class Student {
        final int roll;
        final String name;
        Student(int rollno, String name){
            this.roll = rollno;
            this.name = name;
        }

        public int getRoll(){
            return this.roll;
        }

        public String getName(){
            return this.name;
        }
    }

    /*enum fruits implements Comparable{
        apple(120),
        Kiwi(60),
        Banana(20),
        Orange(80);

        private int price;

        private fruits(int pr){
            this.price = pr;
        }

        public int compareTo(Object ob){
            
        }

    } */

    interface TestInterface {
        int test_Variable = 10;
    }

    public static void main(String[] args) {
        Test t = new Test();

        Student s1 = t.new Student(5, "Student1");
        Student s2 = t.new Student(6, "Student2");

        int rollNo = s1.getRoll();
        System.out.println(rollNo);
        rollNo = 10;
        System.out.println(s1.getRoll());
        System.out.println(rollNo);

        int _xyz =5;
        
        TreeSet<Integer> treeSet = new TreeSet<>();
        y:
        if(treeSet.size()>0)
            System.out.println("size greater than 0");

        treeSet.add(5);
        treeSet.add(11);
        treeSet.add(7);
        treeSet.add(9);
        x:
        for(int i=0;i<10;i++)
            if(i==1)
                break x;
            else 
                System.out.println("i value = "+ i);

        System.out.println(treeSet.headSet(9).size());
    }
    
}
