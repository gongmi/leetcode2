package Graph_UnionFind;

import java.util.*;
//�����Ҳ������ ʹ�õ�˼·Ҳ���������� ���ǲ�����ȫ����������
//the idea is to eat up all the leaves at the same time, until one/two leaves are left.
//���Ǳ�׼����������������� ���� ֻʹ���ڽӱ� ��Ϊ�����ڽӱ��൱��ֻ���������node�ĳ�
//����Ҫһ�������inDegree���� ����¼���node�����
//�������������ͼ ����Ӧ��ֱ��ʹ���ڽӱ���ɾ��node
//���� 1-2 ��������1ʱ 
//��Ϊ���ʹ��inDegree ��ȥ���ڽӱ� ��ô2���ڽӱ����滹������1 ����1��ʵ�Ѿ�������
//����������ֹͣ������while (n > 2)  ������Ҫ��ÿһlevel��Ҷ�ӽڵ����
//��ʵ����BFS ��TraversalLevelorder����Ҫÿһ���á��������� ���� Ҫ��һ�� num = queue.size();

public class MinimumHeightTrees_310 {
	public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
		if (n == 1)
			return Collections.singletonList(0); // ////////////////attentionע�����ָ߼��÷�~��������
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
			int count = leaves.size(); // ÿһ��Ҷ�ӽ��ĸ���
			n = n - leaves.size();
			while (count-- > 0) {
				int cur = leaves.poll();
				for (int child : adj[cur]) {// ���ڷŽ�ȥleaves�Ķ���Ҷ�ӽڵ� ����������
											// childֻ��һ�� ������
											// child=adj[cur].iterator().next();
					adj[child].remove(cur);
					if (adj[child].size() == 1)
						leaves.add(child);
				}
			}
		}
		return leaves;
	}

	// ��һ�泬ʱ ��Ϊ��ÿһ��node����Ϊroot��������depth ����Ӧ�úܶ��ظ��İ�
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

	// ��node��5000��ʱ ��TLE
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

	// ��node��1212��ʱ ��TLE
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
