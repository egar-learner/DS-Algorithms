package DynamicProgramming;

public class StaticSlidingWindow {

    static int[] arr = {5,2,3,1,1,6,5,2,4}; //Array for which 
    static int k = 3;   //Sliding window size

    public static void main(String[] args) {
        
        int i=0,j=0,max=0;
        int lastCal = 0;
        
        while(j<arr.length){
            int localMax = lastCal;
            while(j-i<=k-1){
                localMax += arr[j++];
            }
            
            if(i>0)
                localMax -= arr[i-1];
            max = max<localMax?localMax:max;
            lastCal = localMax;
            i++;
            System.out.println("i = " + i + " j = " + j + " localMax = " + localMax + " max " + max);
        }

        System.out.println(max);
    }
    
}
