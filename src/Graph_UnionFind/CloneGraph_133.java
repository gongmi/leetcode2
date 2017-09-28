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

// ʹ��CopyListWithRandomPointer_138��˼· һ�ѹ�Ŷ
// ��queue bfs������ ��ʵdfsҲ���ѽ ������һ�ַ�ʽ���������ͼ������
// ʹ��hash������visited ��Ϊ�����Ҫ����node֮���neihbor��ϵ ����Ҫ��hash
public class CloneGraph_133 {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

		if (node == null)
			return null;
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		queue.offer(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode cur = queue.poll();
			if (!map.containsKey(cur)) { // ������queue��������ظ��� poll����֮���ж���û�ظ�
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
	// ���Կ�����label ������node
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
				if (!map.containsKey(neighbor.label)) {// ������queue�Ͳ������ظ���
					map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
					queue.offer(neighbor);
				}
				map.get(cur.label).neighbors.add(map.get(neighbor.label));// ������new��ǰnodeʱ�Ͱ������ھӼ���
			}
		}
		return map.get(node.label);
	}
}
