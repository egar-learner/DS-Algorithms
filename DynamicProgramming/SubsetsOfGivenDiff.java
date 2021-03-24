package DynamicProgramming;


//This program is to find the number of subsets of a given difference
//input:	Array
//			difference of subsets

//Let's say a subset is S1, and second subset is S2
//		S1-S2 = difference(given)			eqn 1
//		S1+S2 = total sum of array			eqn 2
//		Adding eqn1 + eqn2 = 
//		2S1 = sum + difference
//		S1 = (sum + difference)/2

//So , we have reduced the whole problem into finding a subset of Sum = (sum+difference)/2


import java.util.Arrays;

public class SubsetsOfGivenDiff {
	
	static int wt[] = {1,2,3,4,5};
	//static int val[] = {2,3,4,5,6};
	static int len = wt.length;
	static int diff = 3;
	//static int W = 7;
	
	//static int t[][] = new int[len+1][W+1];
	
	
	public static void main(String[] args) {
		System.out.println("Number of subsets with given difference are "+numberOfSubsetsWithGivenDifference());
				
	}
	
	
	private static int numberOfSubsetsWithGivenDifference() {

		int returnNumOfSubsets = 0;
		int sum = 0;
		for (int i : wt) {
			sum += i;
		}

			int W = (sum + diff) / 2;
			
			System.out.println("Sum should be = " + W );

			int t[][] = new int[len + 1][W + 1];
			
			for (int i = 0; i < t.length; i++)
				Arrays.fill(t[i], 0);

			// Initialization

			for (int i = 0; i < t.length; i++)
				for (int j = 0; j < t[0].length; j++)
					if (j == 0)
						t[i][j] = 1;


			for (int i = 1; i < t.length; i++)
				for (int j = 1; j < t[0].length; j++) {

					// Checking if current weight is less the weight allowed at this step
					if (wt[i - 1] <= j) {
						// If we have the option to include the current value
						// then
						// value_selected = greatest_of(value(
						// without including current value, including current value+ previous highest)
						t[i][j] = t[i - 1][j] + t[i - 1][j - wt[i - 1]];
					} else {
						// Since we don't have the option to include current value we skip it.
						t[i][j] = t[i - 1][j];

					}
				}
			
			for (int i = 0; i < t.length; i++) {
				for (int j = 0; j < t[0].length; j++) {
					System.out.print(t[i][j]+"\t");
				}
				System.out.println();
			}

			System.out.println(returnNumOfSubsets=t[len][W]);
		return returnNumOfSubsets;
	}

}
