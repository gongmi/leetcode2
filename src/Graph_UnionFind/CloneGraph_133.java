package Graph_UnionFind;

import java.util.*;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

// 使用CopyListWithRandomPointer_138的思路 一把过哦
// 用queue bfs来遍历 其实dfs也差不多呀 就是用一种方式来遍历这个图而已嘛
// 使用hash来表明visited 因为这个题要处理node之间的neihbor关系 所以要用hash
public class CloneGraph_133 {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

		if (node == null)
			return null;
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		queue.offer(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.poll();
			if (!map.containsKey(cur)) { // 我这是queue里面会有重复的 poll出来之后判断重没重复
				map.put(cur, new UndirectedGraphNode(cur.label));
				for (UndirectedGraphNode neighbor : cur.neighbors) {
					queue.offer(neighbor);
				}
			}
		}
		for (UndirectedGraphNode oldNode : map.keySet()) {
			UndirectedGraphNode newNode = map.get(oldNode);
			for (UndirectedGraphNode oldNeighbor : oldNode.neighbors) {
				newNode.neighbors.add(map.get(oldNeighbor));
			}
		}
		return map.get(node);
	}

	// Nodes are labeled uniquely.
	// 所以可以用label 来表明node
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
		HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();

		if (node == null)
			return null;
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		queue.offer(node);
		map.put(node.label, new UndirectedGraphNode(node.label));

		while (!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.poll();
			for (UndirectedGraphNode neighbor : cur.neighbors) {
				if (!map.containsKey(neighbor.label)) {// 我这是queue就不会有重复的
					map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
					queue.offer(neighbor);
				}
				map.get(cur.label).neighbors.add(map.get(neighbor.label));// 并且在new当前node时就把他的邻居加上
			}
		}
		return map.get(node.label);
	}
}
