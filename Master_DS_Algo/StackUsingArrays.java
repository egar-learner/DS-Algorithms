package Master_DS_Algo;

import java.util.Arrays;

public class StackUsingArrays {

    static int currentTop = -1;

    public static int[] stack = new int[50];

    StackUsingArrays(){
        Arrays.fill(stack, -1);
    }

    public static void push(int ele){
        stack[++currentTop] = ele;
    }

    public static int pop(){
        if(currentTop <= -1)
            return -1;
        int retEle = stack[currentTop];
        stack[currentTop--] = -1;
        return retEle;
    }

    public static int peek(){
        System.out.println("Current top = " + currentTop);
        if(currentTop>=0)
            return stack[currentTop];
        return -1;
    }

    public static void main(String[] args) {

        StackUsingArrays stackUsingArrays = new StackUsingArrays();

        //Push operations in stack
        stackUsingArrays.push(3);
        stackUsingArrays.push(7);
        stackUsingArrays.push(2);

        for(int i: stackUsingArrays.stack)
            if(i != -1)
                System.out.println(i);

        System.out.println("Element removed = " + stackUsingArrays.pop());
        System.out.println("Element removed = " + stackUsingArrays.pop());
        System.out.println("Element removed = " + stackUsingArrays.pop());
        System.out.println("Element removed = " + stackUsingArrays.pop());

        stackUsingArrays.push(9);
        stackUsingArrays.push(11);

        for(int i: stackUsingArrays.stack)
            if(i != -1)
                System.out.println(i);

        System.out.println("Element on top = " + stackUsingArrays.peek());
        System.out.println("Element on top = " + stackUsingArrays.peek());
        
    }
    
}
