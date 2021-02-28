package Master_DS_Algo;

import java.util.Arrays;
import java.util.List;

//Works really best and one of the top choices for nearly sorted data set
public class InsertionSort {

    public static void swap(int a, int b){
        a = a+b;
        b = (a-b);
        a = (a-b);
    }

    public static void insertionSort(){

        int[] arr = {4,2,7,1,8,3,5};
        for(int i: arr)
            System.out.print(i + ",");
        
        System.out.println("------------------------------------");
        for(int i = 0;i<arr.length;i++){
            int val = arr[i];
            int curr = i;
            while(curr>0 && arr[curr-1]>val){
                arr[curr] = arr[curr-1];
                curr = curr-1;
            }
            
            arr[curr] = val;

        }
        
        for(int i: arr)
            System.out.print(i + ",");
        
    }

    public static void main(String[] args) {
        
        insertionSort();

    }
    
}
