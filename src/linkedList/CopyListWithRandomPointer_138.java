package linkedList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};

// 我的第一版答案 有点慢 时间复杂度是O(n) 空间复杂度是o(n)
public class CopyListWithRandomPointer_138 {
	public RandomListNode copyRandomList(RandomListNode head) {
		HashMap<RandomListNode, List<RandomListNode>> map = new HashMap<>();

		if (head == null)
			return null;

		RandomListNode pointer1 = new RandomListNode(0);
		RandomListNode pointer2 = new RandomListNode(0);
		pointer1.next = head;
		RandomListNode head2 = null;
		while (pointer1.next != null) {
			pointer2.next = new RandomListNode(pointer1.next.label);

			if (pointer1.next == head)
				head2 = pointer2.next;

			RandomListNode tail = pointer1.next.random;
			if (tail != null) {
				if (!map.containsKey(tail))
					map.put(tail, new LinkedList<RandomListNode>());
				List<RandomListNode> heads = map.get(tail);
				heads.add(pointer2.next);
			}
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}

		pointer1 = head;
		pointer2 = head2;
		while (pointer1 != null) {
			List<RandomListNode> heads = map.getOrDefault(pointer1, null);
			if (heads != null) {
				for (RandomListNode h : heads) {
					h.random = pointer2;
				}
			}
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}
		return head2;
	}

	// top答案 hashmap是用来存放<oldnode,newnode>
	public RandomListNode copyRandomList2(RandomListNode head) {
		if (head == null)
			return null;

		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		// loop 1. copy all the nodes
		RandomListNode node = head;
		while (node != null) {
			map.put(node, new RandomListNode(node.label));
			node = node.next;
		}

		// loop 2. assign next and random pointers
		node = head;
		while (node != null) {
			map.get(node).next = map.get(node.next);
			map.get(node).random = map.get(node.random);
			node = node.next;
		}

		return map.get(head);
	}
}