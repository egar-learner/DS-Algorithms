package Master_DS_Algo;

import java.util.Arrays;
import java.util.List;

//Select a pivot, say the last element of our array
// get it at the right position 
// say all elements to left of it should be less than it and all elements to the right
public class QuickSort {

    public static void swap(int a, int b){
        a = a+b;
        b = (a-b);
        a = (a-b);
    }

    public static void quickSort(int[] arr, int start, int end){

        if(start<end){
            int pIndex = partition(arr, start, end);
            quickSort(arr, start, pIndex-1);
            quickSort(arr, pIndex+1, arr.length-1);
        }
        
        
    }

    public static int partition(int[] arr, int start, int end){

        int pivot = arr[end];
        int curr = start;
        System.out.println("start partition");
        
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" "+ pivot);
            if(arr[i] <= pivot){
                System.out.println(arr[curr]+" "+ arr[i]);
                swap(arr[curr], arr[i]);
                System.out.println(arr[curr]+" "+ arr[i]);
                curr++;
            }
        }
        swap(arr[end-1],arr[curr]);

        return curr;

    }

    public static void main(String[] args) {
        int[] arr = {4,2,7,1,8,3,5};

        for(int i: arr)
            System.out.print(i+",");

        quickSort(arr, 0, arr.length-1);

        System.out.println("--------------------------");

        for(int i: arr)
            System.out.print(i+",");
    }
    
}
