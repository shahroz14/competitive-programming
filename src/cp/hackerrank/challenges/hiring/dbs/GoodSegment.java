package cp.hackerrank.challenges.hiring.dbs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GoodSegment {

	public static void main(String[] args) {
		
		System.out.println(goodSegmentLength(Arrays.asList( 8, 6, 20, 12), 1, 30));
	}

	public static int goodSegmentLength(List<Integer> badNumbers, int l, int r) {

		List<Integer> filteredList = badNumbers.stream().filter(i -> i <= r && i >= l).collect(Collectors.toList());
		Collections.sort(filteredList);

		int n = filteredList.size();
		int maxLength = filteredList.get(0) - l;

		for (int i = 1; i < n; i++)
			maxLength = Math.max(maxLength, filteredList.get(i) - filteredList.get(i - 1) - 1);

		maxLength = Math.max(maxLength, r - filteredList.get(n - 1));

		return maxLength;
	}

}
