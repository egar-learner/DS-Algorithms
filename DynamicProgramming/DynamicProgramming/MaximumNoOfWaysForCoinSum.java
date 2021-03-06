package DynamicProgramming;



import java.util.Arrays;

public class MaximumNoOfWaysForCoinSum {




	//This program is to check whether a given sum's subset exists in the array or not 
	//If present how many ways we can get the sum even by repeating items
	//If exist then we print how many subsets are present who's sum is equal to the given sum
	//Input: wt[] = Contains Coins of different denomination
//			 W = Sum of coins
	//Output: true/false depending on whether or not the subset sum = given weight exists or not
		
		static int wt[] = {1,2,3};
		//static int val[] = {2,3,4,5,6};
		static int len = wt.length;
		static int W = 5;
		
		static int t[][] = new int[len+1][W+1];
		
		
		public static void main(String[] args) {
			for(int i=0;i<t.length;i++)
				Arrays.fill(t[i], 0);
			
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
						t[i][j] = 1;
			

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
						t[i][j] = t[i-1][j] + t[i][j-wt[i-1]];
					} else {
						//Since we don't have the option to include current value we skip it.
						t[i][j] = t[i-1][j];
						
					}
				}
			
			for(int i = 1;i<t.length;i++) {
				for(int j = 1;j<t[0].length;j++) {
					System.out.print(t[i][j] +" ");
				}
				System.out.println();
			}
			
			System.out.println("Whether subSet sum exists for weight " + W + " is = "+ t[len][W]);
					
		}

}
