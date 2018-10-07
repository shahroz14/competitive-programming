package cp.hackerrank.challenges.hiring.cars24;

import java.util.Scanner;

public class NumberFormation {

	public static final int MODULO = 720720;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = in.nextInt();

		int k = in.nextInt();
		System.out.println(getValidNumbersCount(arr, n, k));

		in.close();
	}

	public static int getValidNumbersCount(int[] arr, int n, int k) {

		if (k == 1)
			return n;

		int[][] dp = new int[k + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			if (arr[i - 1] == 0) dp[1][i] = dp[1][i - 1];
			else dp[1][i] = dp[1][i - 1] + 1;
		}

		for (int i = 2; i <= k; i++)
			for (int j = i; j <= n; j++) dp[i][j] = (dp[i][j - 1] + dp[i - 1][j - 1]) % MODULO;

		return dp[k][n];
	}

}
