package cp.hackerrank.practice.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Abbreviation {

	static String s;
	static String p;
	static int dp[][];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			s = in.next();
			p = in.next();
			dp = new int[s.length()][p.length()];
			for(int j=0; j<s.length(); j++)
				Arrays.fill(dp[j], -1);
			if(canConvert(0, 0)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		in.close();
	}

	public static boolean canConvert(int i, int j) {
		if (i >= s.length())
			return j >= p.length();
		else if (j >= p.length())
			return isInLowercase(s.substring(i));
		if(dp[i][j] != -1)
			return dp[i][j] == 1 ? true : false;
		boolean ans;
		if (Character.isUpperCase(s.charAt(i)) && s.charAt(i) != p.charAt(j))
			ans = false;
		else if (Character.isUpperCase(s.charAt(i)) && s.charAt(i) == p.charAt(j))
			ans = canConvert(i+1, j+1);
		else if (compare(s.charAt(i), p.charAt(j)))
			ans = canConvert(i+1, j+1) || canConvert(i+1, j);
		else
			ans = canConvert(i+1, j);
		dp[i][j] = ans ? 1 : 0;
		return ans;
	}
	
	public static boolean compare(char c1, char c2) {
		return (c1+"").compareToIgnoreCase(c2+"") == 0;
	}
	
	public static boolean isInLowercase(String s) {
		for(int i=0; i<s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) return false; 
		}
		return true;
	}

}
