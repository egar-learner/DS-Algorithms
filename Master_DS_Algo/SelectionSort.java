package Master_DS_Algo;

import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    public static void bubbleSort(){

        int[] arr = {4,2,7,1,8,3,5};
        for(int i: arr)
            System.out.print(i + ",");
        
        System.out.println("------------------------------------");
        for(int i = 0;i<arr.length;i++){
            int min = arr[i];
            int jVal = -1;
            for(int j = 1;j<arr.length;j++){
                if(min>arr[j]){
                    min = arr[j];
                    jVal = j;
                }
            }
            
            int temp = arr[jVal];
            arr[jVal] = arr[i];
            arr[i] = temp;

        }
        
        for(int i: arr)
            System.out.print(i + ",");
        
    }

    public static void main(String[] args) {
        
        bubbleSort();

    }
    
}
