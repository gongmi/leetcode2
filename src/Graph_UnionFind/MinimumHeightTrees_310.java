package Graph_UnionFind;

import java.util.*;
//这道题也很巧妙 使用的思路也是拓扑排序 但是不是完全的拓扑排序
//the idea is to eat up all the leaves at the same time, until one/two leaves are left.
//但是标准的拓扑排序是有向的 不能 只使用邻接表 因为有向邻接表相当于只表明了这个node的出
//所以要一个额外的inDegree数组 来记录这个node的入度
//这个由于是无向图 所以应该直接使用邻接表来删除node
//比如 1-2 在我消掉1时 
//因为如果使用inDegree 不去动邻接表 那么2的邻接表里面还包含了1 可是1其实已经消掉了
//而且这道题的停止条件是while (n > 2)  所以需要算每一level的叶子节点个数
//其实就是BFS 的TraversalLevelorder并且要每一层用【】包起来 所以 要算一下 num = queue.size();

public class MinimumHeightTrees_310 {
	public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
		if (n == 1)
			return Collections.singletonList(0); // ////////////////attention注意这种高级用法~！！！！
		HashSet<Integer>[] adj = new HashSet[n];
		for (int i = 0; i < n; i++)
			adj[i] = new HashSet<Integer>();
		for (int[] edge : edges) {
			adj[edge[0]].add(edge[1]);
			adj[edge[1]].add(edge[0]);
		}
		LinkedList<Integer> leaves = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (adj[i].size() == 1)
				leaves.offer(i);
		}
		while (n > 2) {
			int count = leaves.size(); // 每一层叶子结点的个数
			n = n - leaves.size();
			while (count-- > 0) {
				int cur = leaves.poll();
				for (int child : adj[cur]) {// 由于放进去leaves的都是叶子节点 因此这个结点的
											// child只有一个 可以用
											// child=adj[cur].iterator().next();
					adj[child].remove(cur);
					if (adj[child].size() == 1)
						leaves.add(child);
				}
			}
		}
		return leaves;
	}

	// 第一版超时 因为我每一个node都作为root来算它的depth 这样应该很多重复的吧
	List<Integer>[] adj;

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		adj = new LinkedList[n];
		for (int i = 0; i < n; i++)
			adj[i] = new LinkedList<Integer>();
		for (int[] edge : edges) {
			adj[edge[0]].add(edge[1]);
			adj[edge[1]].add(edge[0]);
		}
		int min = n;
		int[] depth = new int[n];

		for (int i = 0; i < n; i++) {

			depth[i] = depth(-1, i);
			min = Math.min(min, depth[i]);
		}

		List<Integer> res = new LinkedList<Integer>();
		for (int i = 0; i < n; i++)
			if (depth[i] == min)
				res.add(i);

		return res;
	}

	// 当node有5000个时 就TLE
	private int depth(int parent, int i) {
		if (adj[i].size() == 1 && adj[i].get(0) == parent)
			return 0;
		int res = 0;
		for (int child : adj[i]) {
			if (child != parent)
				res = Math.max(res, depth(i, child));
		}
		res++;
		return res;
	}

	// 当node有1212个时 就TLE
	private int depth(int i) {
		HashSet<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(i);
		int level = 0;
		while (!queue.isEmpty()) {
			int count = queue.size();
			level++;
			while (count-- > 0) {
				int cur = queue.poll();
				visited.add(cur);
				for (int child : adj[cur]) {
					if (!visited.contains(child))
						queue.offer(child);
				}
			}
		}
		return level;
	}
}
