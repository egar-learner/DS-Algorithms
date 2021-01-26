
import java.util.Arrays;

/* This program is to demonstrate and understand 0-1 KnapSack
 * METHOD - MEMOIZATION
 * Remembering the previously calculated result and using it instead of calculating it again
 * 
 *Specifically this is to get the maximum profit out of the knapsack 
 *Input  - Weight_Array of items
 *		 - Value corresponding to each array item
 *		 - Weight of the knapSack
 * 		 - Size of array(can be obtained without specifying from the input)
 *Output - Maximum profit which can be obtained with the given weight of the KnapSack
 * */
 
public class ZeroOneKnapSackBottomUp {
	
	public static int wt[] = {1,2,3,4,5};
	public static int val[] = {2,3,4,5,6};
	public static int w = 7;
	public static int[][] t = new int[wt.length+1][w+1];
	
	public static void initializeArray(int t[][]) {
		
		for(int i=0;i<t.length;i++)
			for(int j=0;j<t[0].length;j++)
				if(i==0||j==0)
					t[i][j]=0;
	}


	public static void main(String[] args) {
		
		System.out.println("hello");
		
		for (int i = 0;i<wt.length+1;i++)
			//Why we are using loop here is because Arrays.fill expects a single dimensional array
			//If we pass a 2-D or multi-dimensional array to it, it treats it as a Jagged Array
			//Jagged array is a array of arrays such that member arrays can be of different sizes. 
			Arrays.fill(t[i], -1);
		
		//To initialize the values,
		//1. If no items included what would be the max weight
		//2. If weight is 0 then which all items we should include in our knapsack
		initializeArray(t);
		
		//For testing some random values whether or not it is initialized properly
		System.out.println(t[3][3]);
		System.out.println(t[0][1]);
		
		
		//Bottom -up code begins here
		//Both the indexes we are starting from 1 as we have already decided upon the 0th index in initialization
		
		//NOTE : i -> Basically, Symbolizes the element number
		//     : j -> Whereas, j is actual weight in out array t[][]
		for(int i=1;i<t.length;i++)
			for(int j=1;j<t[0].length;j++) {
				//wt[i-1]<j
				//meaning,, weight of current element < weight of knapsack at that point in the calculation
				// j is the weight itself and not just the index
				if(wt[i-1]<=j)
					t[i][j]=val[i-1]+t[i-1][j-wt[i-1]]>t[i-1][j]?
							val[i-1]+t[i-1][j-wt[i-1]]:
							t[i-1][j];
				else
					t[i][j] = t[i-1][j];
						
			}
		
		System.out.println("MaxProfit = "+ t[wt.length][w]);

	}

}
