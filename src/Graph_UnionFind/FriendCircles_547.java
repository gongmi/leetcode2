package Graph_UnionFind;

//这道题 乍一眼看起来和NumberOfIslands_200很像
//但是不一样 这道题是图有多少个连通分量 根据邻接矩阵 adjacency matrix来做DFS
//与大话数据结构p240的 用matrix来DFS类似 只是加了一句count++

public class FriendCircles_547 {
	private int n;
	private boolean[] visited;

	public int findCircleNum(int[][] M) {
		int count = 0;
		n = M.length;
		if (n == 0)
			return 0;
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				DFS(M, i);
				++count;
			}
		}
		int i=3;
		return count;
	}

	private void DFS(int[][] M, int i) {
		if (!visited[i]) {
			visited[i] = true;
			for (int j = 0; j < n; j++)
				if (M[i][j] == 1)
					DFS(M, j);

		}

	}

	// 法2 union find
	public int findCircleNum2(int[][] M) {
		int n = M.length;
		if (n == 0)
			return 0;
		int res = n;
		int[] roots = new int[n];
		for (int i = 0; i < n; i++)
			roots[i] = i;
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (M[i][j] == 1) {
					int root1 = find(roots, i);
					int root2 = find(roots, j);
//					System.out.println(i+" :"+root1+","+j+" :"+root2);
					if (root1 != root2) {
						res--;
						roots[root1] = root2;
					}
				}
		return res;
	}

	private int find(int[] roots, int id) {
		while (roots[id] != id) {
			roots[id] = roots[roots[id]];
			id = roots[id];
		}
		return id;
	}
}
