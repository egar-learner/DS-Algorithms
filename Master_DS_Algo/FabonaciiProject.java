package Master_DS_Algo;

public class FabonaciiProject {

	//O(2^n)
	//Has a exponential time as the input increases
	//Even bad then n^2
	public static int printFabonaci(int num) {
		//Base Condition 1
		if (num == 0) {
		return 0;
		}
		
		//Base Condition 2
		if (num == 1) {
		return 1;
		}

		//Recursive Call
		return printFabonaci(num-1)+printFabonaci(num-2);

		}



		public static void main(String[] args) throws Exception {

		//Number input from the user
		int num = 8;
		
		//For Handling the first 2 values in the fabonaci series as the starting values
		if (num <= 2)
		    if(num <1)
		        System.out.println("Invalid Input");
		else
		    if (num == 1)
		    System.out.println(0);
		else {
		    System.out.println(0);
		    System.out.println(1);
		}
		
		// Loop to print the number of fabonici values asked by the user if asked values are greater
		// than 2
		if (num > 2) {
		    int counter = 2;
		    System.out.println(0);
		    System.out.println(1);
		    while (num >counter) {
		        System.out.println(printFabonaci(counter));
		        counter += 1;
		    }
		}

		}

}
