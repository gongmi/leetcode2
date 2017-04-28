package Graph_UnionFind;

import java.util.*;
//Given n nodes labeled from 0 to n - 1 
//and a list of undirected edges (each edge is a pair of nodes), 
//find the number of connected components in an undirected graph.
//Example 1:
//     0          3
//     |          |
//     1 --- 2    4
//Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
//
//Example 2:
//     0           4
//     |           |
//     1 --- 2 --- 3
//Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

//这道题让我们求无向图中连通区域的个数 与FriendCircles_547相似 只不过这道题不是matrix
//而是自己构造邻接链表Adjacency List来做。
//与大话数据结构p241的 用matrix来DFS类似 只是加了一句res++
public class ConnectedComponents_323 {
	boolean[] visited;

	public int countComponents(int n, int[][] edges) {
		visited = new boolean[n];
		HashMap<Integer, List<Integer>> adj = new HashMap<>();
		for (int i = 0; i < n; i++)
			adj.put(i, new LinkedList<Integer>());
		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}
		int res = 0;
		for (int i = 0; i < n; i++)
			if (!visited[i]) {
				DFS(adj, i);
				res++;
			}
		return res;
	}

	private void DFS(HashMap<Integer, List<Integer>> adj, int i) {
		visited[i] = true;
		for (int j : adj.get(i))
			if (!visited[j])
				DFS(adj, j);
	}

	// 法2 union find
	public int countComponents2(int n, int[][] edges) {
		int[] roots = new int[n];
		for (int i = 0; i < n; i++)
			roots[i] = i;

		for (int[] e : edges) {
			int root1 = find(roots, e[0]);
			int root2 = find(roots, e[1]);
			if (root1 != root2) {
				roots[root1] = root2; // union
				n--;
			}
		}
		return n;
	}

	public int find(int[] roots, int id) {
		while (roots[id] != id) {
			roots[id] = roots[roots[id]]; // path compression
			id = roots[id];
		}
		return id;
	}
}
