package cp.hackerearth.practice.codemonk;

import java.util.Scanner;

public class MonkVisitsCoderland {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0; i<t; i++) {
			int n = in.nextInt();
			long[] c = new long[n];
			long[] l = new long[n];
			for(int j=0; j<n; j++) c[j] = in.nextInt();
			for(int j=0; j<n; j++) l[j] = in.nextInt();
			System.out.println(getMinCostForCoderland(n, c, l));
		}
		in.close();
	}
	
	public static long getMinCostForCoderland(int n, long[] c, long[] l) {
		long cost = c[0]*l[0] + 0l;
		for(int i=1; i<n; i++) {
			if(c[i] > c[i-1]) c[i] = c[i-1];
			cost += c[i] * l[i];
		}
		return cost;
	}

}
