package cp.hackerearth.challenges.hiring.byju;

import java.util.Scanner;

public class EqualDivision {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		
		for(int i=0;i<n; i++) {
			a[i] = in.nextInt();
			b[i] = in.nextInt();
		}
		
		System.out.println(getNoOfRevsionNeeded(a, b, n));
		
		in.close();
	}
	
	public static long getNoOfRevsionNeeded(int[] a, int[] b, int n) {
		
		long rev = 0;
		for(int i=n-1; i>=0; i--)
			rev += addToGetNextMultiple(a[i] + rev, b[i]);
		
		return rev;
		
	}
	
	public static long addToGetNextMultiple(long val, int mul) {
		if(val % mul == 0)
			return 0;
		return (((val / mul) + 1) * mul) - val;
	}

}
