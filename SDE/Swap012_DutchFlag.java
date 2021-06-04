import java.util.ArrayList;
import java.util.List;

import javax.lang.model.util.ElementScanner6;

public class Swap012_DutchFlag {

    /**
     * Problem: Sort an array consisting of 0, 1, 2 with constant space complexity
     * Time complexity, single pass of O(N)
     */

     public static void main(String[] args) {
         
        //Input
        int[] arr = {1,2,0,1,1,0,1,0};

        List<Integer> a = new ArrayList<>();


        // 3 - pointers 
        // 1st pointer -> to maintain 0s, 
        // 2nd pointer -> to iterate over
        // 3rd pointer -> to maintain 2s
        int low = 0,mid = 0, high = arr.length-1;


        //Check input array
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+ "\t");   
            
        System.out.println();

        // Iterate over the array
        for(;mid<=high;){

            if(arr[mid] == 0){
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
            } else if(arr[mid] == 2){
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            } else
                mid++;

        }


        // Altered array after completion
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+ "\t");   
     }
    
}
