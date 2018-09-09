package cp.hackerearth.challenges.hiring.apostek;

import java.util.Scanner;

public class EasyQueries {

	static int[] left;
	static int[] right;
	static int[] arr;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int q = in.nextInt();
		arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = in.nextByte();

		getLeftArray(arr, n);
		getRightArray(arr, n);
		
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < q; i++)
			res.append(ansQuery(in.nextInt(), in.nextInt()));
		
		System.out.println(res);
		in.close();
	}

	public static String ansQuery(int qType, int index) {
		String res = "";
		switch (qType) {
		case 0:
			res = query0(index);
			break;

		default:
			query1(index);
			break;
		}
		return res;
	}

	public static String query0(int index) {
		return left[index] + " " + right[index] + "\n";
	}

	public static void query1(int index) {
		arr[index] = 1;
		for (int i = index-1; i >= 0; i--) {
			right[i] = index;
			if(arr[i] == 1) break;
		}
		for (int i = index+1; i < arr.length; i++) {
			left[i] = index;
			if(arr[i] == 1) break;
		}
	}

	public static void getLeftArray(int[] arr, int n) {
		left = new int[n];
		left[0] = -1;
		for (int i = 1; i < n; i++) {
			left[i] = arr[i - 1] == 1 ? i - 1 : left[i - 1];
		}
	}

	public static void getRightArray(int[] arr, int n) {
		right = new int[n];
		right[n - 1] = -1;
		for (int i = n - 2; i >= 0; i--) {
			right[i] = arr[i + 1] == 1 ? i + 1 : right[i + 1];
		}
	}

}
