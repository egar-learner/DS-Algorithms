package DynamicProgramming;

import java.util.Arrays;

public class LongestPallindrome {

    public static void main(String[] args) {
        
        int maxCount = 0;
        int[] arr = {100,75,65,45,43,42};
        int[] count = new int[arr.length];

        Arrays.fill(count, 0);

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]<arr[j])
                    count[j]=count[i]>count[j]+1?count[i]:count[j]+1;
                if(maxCount<count[j])
                    maxCount = count[j];
            }
        }

        for(int k=0;k<count.length;k++){
            System.out.print(count[k]);
        }

        System.out.println("Longest Common Subsequence = "+ (maxCount>1?maxCount:(maxCount+1)));

    }
    
}
