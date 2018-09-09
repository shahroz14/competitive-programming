package cp.hackerearth.challenges.hiring.apostek;

import java.util.Scanner;

public class SeatingArrangement {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Long n = in.nextLong();
		int k = in.nextInt();
		String s = in.next();
		int q = in.nextInt();
		arrangeSeats(s, k, n);
		for(int i=0; i<q; i++) {
			
		}
		in.close();
	}
	
	public static void arrangeSeats(String s, int k, long n) {
		int i = 0;
		long temp = n;
		while(i<k) {
			if(temp%2 == 0) {
				if (s.charAt(i) == 'L') temp = temp/2;
				else temp = temp/2 + 1;
			} else {
				temp = temp/2;
			}
			for(long j=temp; j<n; j+=temp) {
				
			}
		}
	}

}
