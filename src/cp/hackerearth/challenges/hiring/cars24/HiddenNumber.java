package cp.hackerearth.challenges.hiring.cars24;

import java.util.Arrays;
import java.util.Scanner;

public class HiddenNumber {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		
		for (int j = 0; j < t; j++) {
			int n = in.nextInt();
			long[] arr = new long[n];

			for (int i = 0; i < n; i++)
				arr[i] = in.nextInt();

			long sum = Arrays.stream(arr).sum();

			if (sum % n == 0) System.out.println(sum / n);
			else System.out.println(-1);
		}

		in.close();
	}

}
