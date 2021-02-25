//This program is for unbounded KnapSack where need to find the 
//Maximum number of ways in which we can create the total sum given to us

//Input : coins array   --> weight's available array
//      : Sum       -->   Weight

//We can consider this problem similar to no of ways in which a given subset can be formed

//EXACTLY SAME TO THE UNBOUNDED KNAPSACK GENERAL PROBLEM

import java.util.*;

public class UnBoundedKnapSackMaximumNoOfSubset {
    
    public static int[] coin = {1,2,3};

    public static int sum = 6;

    public static void main(String[] args){

        int[][] t = new int[coin.length+1][sum+1];

        for (int i=0;i<t.length;i++)
            Arrays.fill(t[0], -1);

        for (int i=0;i<t.length;i++)
            for(int j=0;j<t[0].length;j++)
                if(j==0)
                    t[i][j] = 0;
        
        List<Integer> coins = new ArrayList<>();
        for (int i=1;i<t.length;i++)
            for(int j=1;j<t[0].length;j++){
                
                ///t[i-1][j-wt[i-1]]    ===>   t[i][j-wt[i-1]]
                if(coin[i-1]<=j){
                    if(coin[i-1]+t[i][j-coin[i-1]] > t[i-1][j]){
                        t[i][j] = coin[i-1]+t[i][j-coin[i-1]];
                        coins.add(coin[i-1]);
                     } else {
                         t[i][j] = t[i-1][j];
                     }
                } else{
                    t[i][j] = t[i-1][j];
                }
            }

        System.out.println("Maximum value of knapsack with weight = "+sum+" is "+ t[coin.length][sum]);

        System.out.println("Weights included");
        for(Integer i: coins){
            System.out.print(i+"\t");
        }
    }

}
