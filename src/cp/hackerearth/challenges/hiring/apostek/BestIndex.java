package cp.hackerearth.challenges.hiring.apostek;

import java.util.Scanner;

import cp.algorithms.Array;

public class BestIndex {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++)
			arr[i] = in.nextInt();
		
		Array.setArray(arr);
		
		System.out.println(getBestSum(n));
		in.close();
	}
	
	public static long getBestSum(int n) {
		Long maxSum = Long.MIN_VALUE; 
		for(int i=0; i<n; i++) {
			Long sum = 0l;
			int st = i;
			int len = 1;
			while(st + len <= n) {
				sum += Array.getSumInRange(st, st+len-1);
				st += len; 
				len++;
			}
			maxSum = Long.max(maxSum, sum);
		}
		return maxSum;
	}

}
