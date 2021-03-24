package DynamicProgramming;


//This program is to check whether a given sum's subset exists in the array or not
//Input: wt[] = Contains the weights of different weight
//		 W = weight of the subset we are seaching for
//Output: true/false depending on whether or not the subset sum = given weight exists or not

import java.util.Arrays;

public class SubsetSumExistsOrNot {
	
	static int wt[] = {1,2,3,4,5};
	//static int val[] = {2,3,4,5,6};
	static int len = wt.length;
	static int W = 7;
	
	static boolean t[][] = new boolean[len+1][W+1];
	
	
	public static void main(String[] args) {
		for(int i=0;i<t.length;i++)
			Arrays.fill(t[i], false);
		
		System.out.println(t[0][0]);
		System.out.println(t[3][4]);
		
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
		System.out.println(t[3][4]);
		
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
		
		System.out.println("Whether subSet sum exists for weight " + W + " "+ t[len][W]);
				
	}

}

