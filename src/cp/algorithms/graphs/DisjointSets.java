package cp.algorithms.graphs;

import java.util.stream.IntStream;

public class DisjointSets {

	Node[] nodes;
	int size;

	public DisjointSets(int size) {
		this.size = size;
		nodes = new Node[size+1];
		fillNodes();
	}
	
	static class Node {
		int data;
		Node parent;
		int rank;

		Node() {

		}

		Node(int data) {
			this.data = data;
		}
		
	}

	public void union(int a, int b) {
		Node rootA = findRoot(nodes[a]);
		Node rootB = findRoot(nodes[b]);
		if (rootA.rank >= rootB.rank) {
			if (rootA.rank == rootB.rank)
				rootA.rank++;
			rootB.parent = rootA;
		} else {
			rootA.parent = rootB;
		}
	}

	public boolean find(int a, int b) {
		return findRoot(nodes[a]) == findRoot(nodes[b]);
	}

	private Node findRoot(Node node) {
		if (node.parent == node)
			return node;
		Node root = findRoot(node.parent);
		node.parent = root;
		node.rank = 0;
		return root;
	}

	private void fillNodes() {
		IntStream.rangeClosed(0, size).forEach(i -> {
			Node node = new Node(i);
			node.parent = node;
			node.rank = 0;
			nodes[i] = node;
		});
	}
	
	public static void main(String[] args) {
		DisjointSets sets = new DisjointSets(7);
		sets.union(1, 2);
		sets.union(2, 3);
		sets.union(3, 7);
		sets.union(6, 7);
		sets.union(5, 6);

		System.out.println(sets.find(1, 3));
		System.out.println(sets.find(1, 4));
	}

}
