
import java.util.Arrays;

/* This program is to demonstrate and understand 0-1 KnapSack
 * METHOD - MEMOIZATION
 * Also known as TOP-DOWN APPROACH
 * Remembering the previously calculated result and using it instead of calculating it again
 * 
 *Specifically this is to get the maximum profit out of the knapsack 
 *Input  - Weight_Array of items
 *		 - Value corresponding to each array item
 *		 - Weight of the knapSack
 * 		 - Size of array(can be obtained without specifying from the input)
 *Output - Maximum profit which can be obtained with the given weight of the KnapSack
 * */
 
public class ZeroOneKnapSackMemo {
	
	public static int wt[] = {1,2,3,4,5};
	public static int val[] = {2,3,4,5,6};
	public static int w = 7;
	public static int[][] t = new int[wt.length+1][w+1];
	
	public static int knapsack(int wt[], int val[], int w, int n) {
		
		// Base condition
		// Minimum possible input 
		if( n==0 || w==0 ) 
			return 0;
		
		//Check if the result has been calculated earlier ? If yes return the same and don't calculate again
		//Also store the result before making any new recursive call
		if(t[n][w] != -1)
			return t[n][w];
		
		// Choice Diagram 
		// Whether or not the current element has to be included or not? 
		if(wt[n-1] <=w)
			//This implies that the value has to be included,
			//Then we check that whether the value(current) + knapsack_val(already_calculated) > value(current)
			//And return the max of these 2 values in case of maximization of profit
			return t[n][w]=val[n-1]+knapsack(wt,val,w-wt[n-1],n-1)>knapsack(wt,val,w,n-1)?
						val[n-1]+knapsack(wt,val,w-wt[n-1],n-1):
						knapsack(wt,val,w,n-1);
		else
			//This implies that the current element cannot be included in the knapsack and hence
			//cannot be considered to be added
			return t[n][w]=knapsack(wt,val,w,n-1);
	}


	public static void main(String[] args) {
		
		System.out.println("hello");
		
		//This is to intialize all the members of the multi-dimensional array to some specific
		//value -1 in this case
		for (int i = 0;i<wt.length+1;i++)
			//Why we are using loop here is because Arrays.fill expects a single dimensional array
			//If we pass a 2-D or multi-dimensional array to it, it treats it as a Jagged Array
			//Jagged array is a array of arrays such that member arrays can be of different sizes. 
			Arrays.fill(t[i], -1);
		
		System.out.println(t[3][3]);
		
		int maxProfit = knapsack(wt,val,w,wt.length);
		
		System.out.println("MaxProfit = "+ maxProfit);

	}

}
