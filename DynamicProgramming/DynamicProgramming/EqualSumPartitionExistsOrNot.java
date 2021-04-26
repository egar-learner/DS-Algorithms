package DynamicProgramming;


//This program is to check that if all the elements of a set can be divided into 2 subsets of
//equal sum, if yes then it becomes the program
//to check whether a given sum's subset exists in the array or not
//Input: wt[] = Contains the weights of different weight
//		 W = weight of the subset we are seaching for
//Output: true/false depending on whether or not the subset sum = given weight exists or not

public class EqualSumPartitionExistsOrNot {
	
	static int wt[] = {1,5,11,5};
	//static int val[] = {2,3,4,5,6};
	static int len = wt.length;
	static int W = 7;
	
	static boolean t[][] = new boolean[len+1][W+1];
	
	
	public static void main(String[] args) {
		
		
		System.out.println("EqualSumPartition exists? " + equalSumPartitionOrNot());
				
	}


	private static boolean equalSumPartitionOrNot() {
		boolean returnVal = false;
		
		
		int sum = 0;
		int subsetSum = 0;
		boolean temp[][] ;
		
		//Calculating the sum of all the elements in the array
		for(int i: wt)
			sum+=i;
		
		//Checking if the sum is even, because only if it is even it can be divided into equal parts
		//as we are having integer values and not fractional values
		if(sum%2 != 0)
			//return false in case the sum is odd
			return returnVal;
		else {
			//here we get the value for our W which is the weight for which we need to get the
			//value that if it exists or not in any subset
			subsetSum = sum/2;
			temp = new boolean[len+1][subsetSum+1];
		}
		
		System.out.println(t[0][0]);
		System.out.println(t[3][4]);
		
		//The below code remains the same as we are trying to check whether the subset exists or not
		//for the new W obtained above
		
		//Initialization
		//Initializing all the values of first row and first column
		//First column - If a subset can be formed who's sum is 0
		//First row - If a subset can be formed with using no element who's sum of weights is equal
		//			  to the weight at the top of that column
		for(int i=0;i<t.length;i++)
			for(int j=0;j<t[0].length;j++)
				if(j==0)
					temp[i][j] = true;
		

		System.out.println(temp[0][0]);
		System.out.println(temp[3][4]);
		
		//Again 2 choices, whether to add that specific element to subset or not.
		//If yes, take the max or 2 values , 
		//Max of boolean will be TRUE if it is present in one of them
		for(int i = 1;i<temp.length;i++)
			for(int j = 1;j<temp[0].length;j++) {
				
				//Checking if current weight is less the weight allowed at this step
				if(wt[i-1]<=j) {
					//If we have the option to include the current value
					//then
					//value_selected =  greatest_of(value(
					//without including current value, including current value+ previous highest)
					temp[i][j] = temp[i-1][j] || temp[i-1][j-wt[i-1]];
				} else {
					//Since we don't have the option to include current value we skip it.
					temp[i][j] = temp[i-1][j];
					
				}
			}
		
		returnVal = temp[len][subsetSum];
		return returnVal;
	}

}

