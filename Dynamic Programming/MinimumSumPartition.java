
//This program is to check what is the minimum difference of 2 subsets including all the elements 
//W in this case is not the input from the User , rather can be considered as the sum of all the
//elements
//in the array
//Input: wt[] = Contains the weights of different weight
//		 W = weight of the subset containing all the elements or sum of all elements
//Output: true/false depending on whether or not the subset sum = given weight exists or not

import java.util.Arrays;

public class MinimumSumPartition {
	
	static int wt[] = {1,2,7};
	//static int val[] = {2,3,4,5,6};
	static int len = wt.length;
	static int W = 10;
	
	static boolean t[][] = new boolean[len+1][W+1];
	
	
	public static void main(String[] args) {
		for (boolean[] element : t)
            Arrays.fill(element, false);
		
		System.out.println(t[0][0]);
		
		//Initialization
		//Initializing all the values of first row and first column
		//First column - If a subset can be formed whoes sum is 0
		//First row - If a subset can be formed with using no element who's sum of weights is equal
		//			  to the weight at the top of that column
		for(int i=0;i<t.length;i++)
			for(int j=0;j<t[0].length;j++)
				if(j==0)
					t[i][j] = true;
		

		System.out.println(t[0][0]);
		
		//Again 2 choices, whether to add that specific element to subset or not.
		//If yes, take the max or 2 values , 
		//Max of boolean will be TRUE if it is present in one of them
		for(int i = 1;i<t.length;i++)
			for(int j = 1;j<t[0].length;j++) {
				
				//Checking if current weight is less the weight allowed at this step
				if(wt[i-1]<=j) {
					//If we have the option to include the current value
					//then
					//value_selected =  greatest_of(value(
					//without including current value, including current value+ previous highest)
					t[i][j] = t[i-1][j] || t[i-1][j-wt[i-1]];
				} else {
					//Since we don't have the option to include current value we skip it.
					t[i][j] = t[i-1][j];
					
				}
			}
		
		for(int i = 0;i<t.length;i++) {
			for(int j = 0;j<t[0].length;j++) {
				System.out.print(t[i][j] + "\t");
			}
		System.out.println();
		}
	
		
		
			int[] canBeSubset = new int[t[0].length/2];
			for(int j = 1,i=t.length-1;j<t[0].length/2;j++) {
				if(t[i][j])
					canBeSubset[j-1] = j;
				else
					canBeSubset[j-1] = 0;
			}
			int minDifBtSetsInclAllEle = 999;
			for (int i = 0;i<canBeSubset.length;i++) {
				if(canBeSubset[i] != 0 && minDifBtSetsInclAllEle>(W-2*canBeSubset[i]))
					minDifBtSetsInclAllEle = W-2*canBeSubset[i];
			}
			System.out.println(minDifBtSetsInclAllEle);
		
		System.out.println("Whether subSet sum exists for weight " + W + " "+ t[len][W]);
				
	}

}

