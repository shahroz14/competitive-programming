package cp.algorithms.graphs;

import java.util.stream.IntStream;

public class DisjointSets {
	
	int[] arr;
	int size;
	
	public DisjointSets(int size) {
		this.size = size;
		arr = new int[size];
		fillArray();
	}
	
	public DisjointSets(int[] arr) {
		this.arr = arr;
		this.size = arr.length;
		fillArray();
	}
	
	public void union(int a, int b) {
		int rootA = findRoot(a);
		int rootB = findRoot(b);
		arr[rootA] = rootB;
	}
	
	public boolean find(int a, int b) {
		return findRoot(a) == findRoot(b);
	}
	
	public int findRoot(int x) {
		while(arr[x] != x) {
			x = arr[x];
		}
		return x;
	}
	
	private void fillArray() {
		IntStream.range(0, size).forEach(i -> arr[i] = i);
	}
	
}
