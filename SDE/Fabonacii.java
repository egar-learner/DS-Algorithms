public class Fabonacii {

    public static void printUsingFor(int n){
        if(n==0){
            System.out.println("Invalid length");
        } 
        if(n==2 || n>2){
            System.out.println("0\n1");
        } else if(n==1 || n>1){
            System.out.println("0");
        } 
        if(n>2){
            int start = 0;
            for(int cur=1, count=2;count<n;count++){
                int temp = start + cur;
                System.out.println(temp);
                start = cur;
                cur = temp;
            }
        }
    }

    public static int printUsingRec(int n){
        if(n==0 || n==1){
            return n;
        }    
    
        return printUsingRec(n-1) + printUsingRec(n-2);
    }

    //0,1,1,2,3,5,8

    public static void main(String[] args) {
        int num = 4;
        System.out.println("Using Iteration!!");
        printUsingFor(num);
        System.out.println("Using Recursion!!");
        printFabUsingRec(num);
    }

    private static void printFabUsingRec(int num) {
        if(num>1){
            System.out.println("0");
            for(int count = 1;count<num;count++){
                System.out.println(printUsingRec(count));
            }
        } else if(num<=0)
            System.out.println("Invalid Input!");
        else 
            System.out.println("0");
    }
    
}
