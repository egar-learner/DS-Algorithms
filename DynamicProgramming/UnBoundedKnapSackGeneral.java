package DynamicProgramming;

//This program is for unbounded KnapSack where an element can be selected any number of times
//Or where the element repeatition is allowed

import java.util.*;

public class UnBoundedKnapSackGeneral {
    
    public static int[] wt = {1,2,3,4,5};
    public static int[] val = {2,3,4,5,6};

    public static int W = 15;

    public static void main(String[] args){

        int[][] t = new int[wt.length+1][W+1];

        for (int i=0;i<t.length;i++)
            Arrays.fill(t[0], -1);

        for (int i=0;i<t.length;i++)
            for(int j=0;j<t[0].length;j++)
                if(i==0||j==0)
                    t[i][j] = 0;
        
        List<Integer> weights = new ArrayList<>();
        for (int i=1;i<t.length;i++)
            for(int j=1;j<t[0].length;j++){
                
                ///t[i-1][j-wt[i-1]]    ===>   t[i][j-wt[i-1]]
                if(wt[i-1]<=j){
                    if(val[i-1]+t[i][j-wt[i-1]] > t[i-1][j]){
                        t[i][j] = val[i-1]+t[i][j-wt[i-1]];
                        weights.add(wt[i-1]);
                     } else {
                         t[i][j] = t[i-1][j];
                     }
                } else{
                    t[i][j] = t[i-1][j];
                }
            }

        System.out.println("Maximum value of knapsack with weight = "+W+" is "+ t[wt.length][W]);

        System.out.println("Weights included");
        for(Integer i: weights){
            System.out.print(i+"\t");
        }
    }

}
