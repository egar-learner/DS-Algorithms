import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.lang.model.util.ElementScanner6;

public class Problem1 {
    public static void swap(int i, int j, int[] arr){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t; 
    }

    public static void sortAndDoIt(int[] globalArr){

        int[] arr = new int[globalArr.length];
        for(int i=0;i<globalArr.length;i++)
            arr[i] = globalArr[i];

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;i<arr.length;i++){
                if(arr[i]>arr[j])
                    swap(i, j, arr);
            }
        }

        for(int m:arr){
            System.out.print(m);
        }
    }

    public static void hashMapCountCreateNewOneIteration(int[] globalArr){

        int[] arr = new int[globalArr.length];
        for(int i=0;i<globalArr.length;i++)
            arr[i] = globalArr[i];

        HashMap<Integer, Integer> hmap = new LinkedHashMap<>();
        hmap.put(0, 0);
        hmap.put(1, 0);
        hmap.put(2, 0);

        for(int i=0;i<arr.length;i++){
                    int count = hmap.get(arr[i]);
                    count++;
                    hmap.put(arr[i], count);
        }

        int k = 0;
        hmap.entrySet().stream().forEach(entry->{
            for(int i=0;i<entry.getValue();i++)
               System.out.print(entry.getKey());
        });
    }

    

    public static void main(String[] args) {
        int arr[] = {0,0,0,0,1,0};
                  
        for(int m:arr){
            System.out.print(m);
        }


        int i=0,j=arr.length-1;
        while(i<=j){
            boolean swapBool = false;
            if(arr[i]>1){
                swap(i, j, arr);
                swapBool = true; }
            if(arr[j]<1){
                swap(i,j, arr);
                swapBool = true;
            }
            if(swapBool){
                i++;j--;}
            else if(arr[i] <=1)
                i++;
        }

        System.out.println();

        for(int m:arr){
            System.out.print(m);
        }
        
    }
}
