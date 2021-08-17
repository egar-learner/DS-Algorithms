import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'maximumToys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY prices
     *  2. INTEGER k
     */

    public static int maximumToys(List<Integer> prices, int k) {
    
        int[][] t = new int[prices.size()+1][prices.size()+1];
        
        for(int i=0;i<t.length;i++)
            for(int j=0;j<t.length;j++)
                if(i==0||j==0)
                    t[i][j] = 0;
                 
        
        for(int i=1;i<t.length;i++)
            for(int j=1;j<t.length;j++)
                if(prices.get(j-1)<=k){
                    t[i][j] = (prices.get(j-1) + t[i-1][j]) <= k ?  
                            t[i-1][j]+1 : t[i-1][j];
                } else
                    t[i][j] = t[i-1][j];
        
        for(int i = 0;i<t.length;i++){
            for(int j=0;j<t.length;j++)
                System.out.print(t[i][j]+"\t"); 
            System.out.println();
        }
                    
        return t[prices.size()][prices.size()];
    }

}

public class NewProblem {
    public static void main(String[] args) throws IOException {
        
        List<Integer> prices = new ArrayList<>();
        prices.add(1);
        prices.add(12);
        prices.add(5);
        prices.add(111);
        prices.add(200);
        prices.add(1000);
        prices.add(10);

        int result = Result.maximumToys(prices, 50);

        System.out.println("Result = " + result);
    }
}
