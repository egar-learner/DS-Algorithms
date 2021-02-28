package Master_DS_Algo;

import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    public static void bubbleSort(){

        int[] arr = {4,2,7,1,8,3,5};
        for(int i: arr)
            System.out.print(i + ",");
        
        System.out.println("------------------------------------");
        for(int i = 0;i<arr.length;i++)
            for(int j = 1;j<arr.length-i;j++){
                if(arr[j-1]>arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        
        for(int i: arr)
            System.out.print(i + ",");
        
    }

    public static void main(String[] args) {
        
        bubbleSort();

    }
    
}
