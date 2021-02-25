package Master_DS_Algo;

public class FactorialOfNum {

    public static int printFactorialByIteration(int num){
        
        int fact = 1;
        for(int i=num;i>0;i--){
            fact = fact*i;
        }

        return fact;
    }

    //O(n)
    public static int printFactorialByRecursion(int num){

        if(num == 0 || num ==1)
            return 1;
        else
            return num * printFactorialByRecursion(num-1);

    }

    public static void main(String[] args) {
        
        int num = 5;

        System.out.println(printFactorialByIteration(num));
        System.out.println(printFactorialByRecursion(num));
    }
    
}
