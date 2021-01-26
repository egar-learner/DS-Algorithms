import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
	
	//This function is used to search an element if it is present in the list or not
	// with the help of binary search
	// Binary search is one of the fastest algorithms to search an element in the list
	// O(logn) worst time taken is this
	// Parameters -> Sorted List of Integers, An Integer to be searched for
	public static int binarySearch(List<Integer> li, Integer ele) {

		int pos = -1;
		int low = 0;
		int high = li.size() - 1;

		int mid = (low + high) / 2;
		
		int iterCount = 0;

		while (low <= high) {
			iterCount += 1;
			if (li.get(mid) == ele) {
				pos = mid;
				break;
			} else if (li.get(mid) < ele) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
			mid = (low + high) / 2;
		}
		
		//Prints the number of iterations used to find the element in the list
		// Or to get to the conclusion that the element is not present in the list
		System.out.println("Array size "+ li.size() + " Number of iterations taken = " + iterCount);
		
		return pos;
	}

	public static void main(String[] args) {

		List<Integer> arr = new ArrayList<>();
		
		//Adding 5 elements to the list
		arr.add(3);
		arr.add(5);
		arr.add(7);
		arr.add(8);
		arr.add(11);
//		arr.add(11);
		
		Integer eleSearch = 8;
		
		//Calling binary Search
		int pos = binarySearch(arr, eleSearch);
		
		if ( pos != -1 )
			System.out.println("Element found in the list "+arr+ " at " + (pos+1));
		else
			System.out.println("Element "+ eleSearch+" not found in the list");
		
		
	}

}
