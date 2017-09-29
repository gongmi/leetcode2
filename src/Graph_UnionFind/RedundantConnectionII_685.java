package Graph_UnionFind;

public class RedundantConnectionII_685 {
	// 看了top答案之后的答案 其实可以合并两种情况

	public int[] findRedundantDirectedConnection(int[][] edges) {
		int n = edges.length;
		int[] parent = new int[n + 1];

		for (int[] edge : edges) {
			if (parent[edge[1]] != 0) { // 说明node edge[1]有两个parent
				Boolean oneGroup = check(edges, edge);
				if (oneGroup)
					return edge;
				else
					return new int[] { parent[edge[1]], edge[1] };
			}
			parent[edge[1]] = edge[0];
		}
		return findRedundantConnection(edges);
	}

	// 是否为1个group
	private boolean check(int[][] edges, int[] removedEdge) {
		int n = edges.length;
		int[] root = new int[n + 1];
		for (int i = 1; i <= n; i++)
			root[i] = i;
		for (int[] edge : edges) {
			if (edge[0] == removedEdge[0] && edge[1] == removedEdge[1])
				continue;
			int left = find(root, edge[0]);
			int right = find(root, edge[1]);
			if (left != right) {
				n--;
				root[left] = right;
			}
		}
		return n == 1;
	}

	private int[] findRedundantConnection(int[][] edges) {
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
