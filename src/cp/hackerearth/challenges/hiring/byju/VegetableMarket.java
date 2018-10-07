package cp.hackerearth.challenges.hiring.byju;

import java.util.Arrays;
import java.util.Scanner;

public class VegetableMarket {

	static long[] arr;
	static long[] cs;
	static int n;
	static long min = Long.MAX_VALUE;
	static long max = Long.MIN_VALUE;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		arr = new long[n];
		cs = new long[n];

		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
		}

		Arrays.sort(arr);
		cs[0] = arr[0];
		for (int i = 1; i < n; i++)
			cs[i] = cs[i - 1] + arr[i];

		int q = in.nextInt();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < q; i++)
			sb.append(getMinimumQuantity(in.nextLong()) + "\n");

		System.out.println(sb);
		in.close();

	}

	public static long getMinimumQuantity(long query) {
		if (query > getQuantityAt(n - 1, 0, n))
			return -1;
		if (query <= arr.length)
			return 1;
		return binQuantity(arr, query);
	}

	public static long binaryFloor(long e) {

		long lo = 0;
		long hi = arr.length;

		while (lo + 1 < hi) {
			long mid = (lo + hi) / 2;
			if (arr[(int) mid] < e)
				lo = mid;
			else
				hi = mid;
		}

		return e < arr[(int) hi] ? e < arr[(int) lo] ? lo - 1 : lo : hi;
	}

	public static long binQuantity(long[] arr, long e) {

		long lo = 1;
		long hi = max;

		while (lo + 1 < hi) {
			long mid = (lo + hi) / 2;
			if (getQuantityAt(binaryFloor(mid), (int) mid, n) < e)
				lo = mid;
			else
				hi = mid;
		}

		long qhi = getQuantityAt(binaryFloor(hi), (int) hi, n);
		long qlo = getQuantityAt(binaryFloor(lo), (int) lo, n);

		if (e <= qhi) {
			if (e == qhi || e > qlo)
				return hi;
			if (e <= qlo)
				return e == qlo ? lo : lo-1;
		}
		
		return getQuantityAt(binaryFloor(hi+1), (int) (hi+1), n) < e ? hi+1 : -1;

	}

	public static long getQuantityAt(long index, int mul, int n) {
		if (index < 0)
			return mul * n;
		return cs[(int) index] + (mul * (n - 1 - index));
	}

}
