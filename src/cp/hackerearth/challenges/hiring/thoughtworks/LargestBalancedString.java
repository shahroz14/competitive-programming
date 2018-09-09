package cp.hackerearth.challenges.hiring.thoughtworks;

import java.util.HashMap;
import java.util.Scanner;

public class LargestBalancedString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			String s = in.next();
			System.out.println(getMaxBalancedLength(s));
		}
		in.close();
	}

	public static int getMaxBalancedLength(String para) {
		
		int n = para.length();
		HashMap<Character, Integer> paraMap = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			char ch = para.charAt(i);
			if (!paraMap.containsKey(ch)) {
				paraMap.put(ch, 1);
			} else {
				paraMap.put(ch, paraMap.get(ch) + 1);
			}
		}
		
		int count = 0;
		count += Math.min(paraMap.containsKey('{') ? paraMap.get('{') : 0,
				paraMap.containsKey('}') ? paraMap.get('}') : 0);
		count += Math.min(paraMap.containsKey('[') ? paraMap.get('[') : 0,
				paraMap.containsKey(']') ? paraMap.get(']') : 0);
		count += Math.min(paraMap.containsKey('(') ? paraMap.get('(') : 0,
				paraMap.containsKey(')') ? paraMap.get(')') : 0);
		
		return 2*count;
	}

}
