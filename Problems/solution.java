import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class solution {

    public static Scanner sc = new Scanner(System.in);

    static List<Integer> arr = new ArrayList<>();
    
    public static void takeInput(){

        int num = sc.nextInt();

        while(num>0){
            int saveInput = sc.nextInt();
            arr.add(saveInput);
            num--;
        }
    }

    public static void printNestedSquares(){

        arr.stream().forEach(currInput->{
            
            int rowCol = currInput==1? 2: (currInput-1)*4 + 2;
            int squareSum = rowCol-1;
            //To save the square starting point and number of points it has to print for this square in all directions
            //To maintain the order so that first values comes first in checking
            Map<Integer,Integer> printSquare = new LinkedHashMap<>();
            List<Integer> intList = new LinkedList<>();
            Map<Integer,Integer> hideSquare = new HashMap<>();
            
            //We have total 3 squares in case of input = 2
            // All we have to do is to hide 1 square
            // where are these squares?
            // at every i==j, there is square if i< row/2

            for(int i=0;i<rowCol;i++){
                for(int j=0;j<rowCol;j++){
                    boolean lastVal = true;

                    if(i==j && i%2==0 && i<rowCol/2) {
                        printSquare.put(i, squareSum);
                        squareSum -=2;
                    }else if(i==j && i%2 != 0 && i<rowCol/2){
                        printSquare.put(i, squareSum);
                        squareSum -=2;
                        lastVal = false;
                    }else{

                        lastVal = false;

                        for(Entry<Integer, Integer> entry: printSquare.entrySet()){
                            if(j>=entry.getKey()&& j<=entry.getKey()+entry.getValue() &&
                            i>=entry.getKey()&& i<=entry.getKey()+entry.getValue())
                                lastVal = entry.getKey()%2==0?true:false;
                            }
                    }

                    if(lastVal)
                        System.out.print("*"+ " ");
                    else
                        System.out.print(" "+ " ");

                    
                }
                    
                System.out.println();
            }
        });
    }

    public static void main(String[] args) {
        
        //1. Taking the input from the user
        takeInput();

        //2. Print nested squares
        printNestedSquares();

    }
    
}
