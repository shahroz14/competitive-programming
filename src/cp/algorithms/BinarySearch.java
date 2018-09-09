package cp.algorithms;

public class BinarySearch {

	public static void main(String[] args) {
		int[] att = { 2, 4, 6, 7, 11 };
		System.out.println(binarySearchUtil(att, 0, att.length - 1, -28, SearchStrategy.CEIL));
	}
	
	public static int binarySearch(int[] arr, int lo, int hi, int e) {
		return binarySearchUtil(arr, lo, hi, e, SearchStrategy.MATCH);
	}

	public static int binarySearchUtil(int[] arr, int lo, int hi, int e, SearchStrategy strategy) {
		while (lo + 1 < hi) {
			int mid = (lo + hi) / 2;
			if (arr[mid] < e)
				lo = mid;
			else
				hi = mid;
		}
		int index = -1;
		switch (strategy) {
		case FLOOR:
			index = e < arr[hi] ? e < arr[lo] ? lo-1 : lo : hi;
			break;
		case CEIL:
			index = e < arr[lo] ? lo : e <= arr[hi] ? hi : hi == arr.length-1 ? -1 : hi+1; 
			break;
		default:
			index = arr[lo] == e ? lo : arr[hi] == e ? hi : -1;
 			break;
		}
		return index;
	}

	static enum SearchStrategy {
		FLOOR, CEIL, MATCH
	}

}
