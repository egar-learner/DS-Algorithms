package DynamicProgramming;



/* This program is to demonstrate and understand 0-1 KnapSack
 * METHOD - RECURSIVE
 * 
 *Specifically this is to get the maximum profit out of the knapsack 
 *Input  - Weight_Array of items
 *		 - Value corresponding to each array item
 *		 - Weight of the knapSack
 * 		 - Size of array(can be obtained without specifying from the input)
 *Output - Maximum profit which can be obtained with the given weight of the KnapSack
 * */
 
public class ZeroOneKnapSack {
	
	public static int wt[] = {1,2,3,4,5};
	public static int val[] = {2,3,4,5,6};
	public static int w = 7;
	
	public static int knapsack(int wt[], int val[], int w, int n) {
		
		// Base condition
		// Minimum possible input 
		if( n==0 || w==0 ) 
			return 0;
		
		// Choice Diagram 
		// Whether or not the current element has to be included or not? 
		if(wt[n-1] <=w)
			//This implies that the value has to be included,
			//Then we check that whether the value(current) + knapsack_val(already_calculated) > value(current)
			//And return the max of these 2 values in case of maximization of profit
			return val[n-1]+knapsack(wt,val,w-wt[n-1],n-1)>knapsack(wt,val,w,n-1)?
						val[n-1]+knapsack(wt,val,w-wt[n-1],n-1):
						knapsack(wt,val,w,n-1);
		else
			//This implies that the current element cannot be included in the knapsack and hence
			//cannot be considered to be added
			return knapsack(wt,val,w,n-1);
	}


	public static void main(String[] args) {
		
		System.out.println("hello");
		
		int maxProfit = knapsack(wt,val,w,wt.length);
		
		System.out.println("MaxProfit = "+ maxProfit);

	}

}
