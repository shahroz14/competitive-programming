package cp.algorithms;

public class Array {
	
	static int[] arr;
	static long[] cumulativeSum;
	
	public static void setArray(int[] arr) {
		Array.arr = arr;
		cumulativeSum = new long[arr.length];
		calculateCumulativeSum();
	}
	
	private static void calculateCumulativeSum() {
		cumulativeSum[0] = arr[0]+0l;
		for(int i=1; i<arr.length; i++)
			cumulativeSum[i] = cumulativeSum[i-1] + arr[i];
	}
	
	public static long getSumInRange(int l, int r) {
		if(l==0) return cumulativeSum[r];
		return cumulativeSum[r] - cumulativeSum[l-1];
	}
	

}
