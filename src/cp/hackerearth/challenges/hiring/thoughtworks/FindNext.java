package cp.hackerearth.challenges.hiring.thoughtworks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class FindNext {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();

		int[] arr = new int[n];

		TreeSet<Integer> setNos = new TreeSet<>();
		TreeSet<Integer> set = new TreeSet<>();

		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
			setNos.add(arr[i]);
		}

		Arrays.sort(arr);
		preprocess(set, arr);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < q; i++)
			sb.append(queryNext(set, setNos, in.nextInt() + 1) + "\n");

		System.out.println(sb);

		in.close();
	}

	public static void preprocess(TreeSet<Integer> set, int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - arr[i - 1] > 1)
				set.add(arr[i - 1] + 1);
		}
		set.add(arr[arr.length - 1] + 1);
	}

	public static int queryNext(TreeSet<Integer> set, TreeSet<Integer> setNos, int x) {
		if (setNos.contains(x))
			x = set.ceiling(x);
		return x;
	}

}
