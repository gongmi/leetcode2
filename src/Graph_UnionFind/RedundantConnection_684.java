package Graph_UnionFind;

public class RedundantConnection_684 {
	public int[] findRedundantConnection(int[][] edges) {
		int n = edges.length;
		int[] root = new int[n + 1];
		for (int i = 1; i <= n; i++)
			root[i] = i;
		for (int[] edge : edges) {
			int left = find(root, edge[0]);
			int right = find(root, edge[1]);
			if (left == right)
				return edge;
			root[left] = right;
		}
		return null;
	}

	private int find(int[] root, int i) {
		while (root[i] != i) {
			root[i] = root[root[i]];
			i = root[i];
		}
		return i;
	}
}
