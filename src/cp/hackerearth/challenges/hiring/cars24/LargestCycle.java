package cp.hackerearth.challenges.hiring.cars24;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class LargestCycle {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		List<List<Integer>> adjList = new ArrayList<>();
		int n = in.nextInt();

		for (int i = 1; i <= n + 1; i++)
			adjList.add(new ArrayList<>());

		for (int i = 0; i < n - 1; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			adjList.get(a).add(b);
			adjList.get(b).add(a);
		}

		int n1 = getFarthestNode(adjList, 1);
		System.out.println(n1 + " " + getFarthestNode(adjList, n1));

		in.close();
	}

	public static int getFarthestNode(List<List<Integer>> adjList, int x) {
		boolean[] vis = new boolean[adjList.size()];

		Queue<Integer> q = new LinkedList<>();
		q.add(x);

		int p = -1;
		while (!q.isEmpty()) {
			p = q.poll();
			vis[p] = true;
			List<Integer> ch = new ArrayList<>();
			for (Integer node : adjList.get(p)) {
				if(vis[node]) continue;
				ch.add(node);
			}
			q.addAll(ch);
		}

		return p;
	}

}