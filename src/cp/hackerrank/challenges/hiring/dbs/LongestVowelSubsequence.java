package cp.hackerrank.challenges.hiring.dbs;

import java.util.HashMap;

public class LongestVowelSubsequence {

	public static void main(String[] args) {
		System.out.println(getLength("aaaaaeeeeeiiiiiooooouuuuu"));
	}

	public static int getLength(String s) {

		HashMap<Character, Integer> map = new HashMap<>();
		map.put('a', 0);
		map.put('e', 1);
		map.put('i', 2);
		map.put('o', 3);
		map.put('u', 4);

		int n = s.length();
		int[][] dp = new int[n][5];
		dp[0][map.get(s.charAt(0))] = 1;

		for (int i = 1; i < n; i++) {
			int ch = map.get(s.charAt(i));
			for (int j = 0; j < 5; j++) {
				if (ch == j)
					dp[i][j] = j == 0 ? dp[i - 1][j] + 1 : Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + 1;
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 5; i++)
			max = Math.max(dp[n - 1][i], max);

		return max;
	}

}
