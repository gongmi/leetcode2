package linkedList;

import java.util.Deque;
import java.util.LinkedList;

public class addTwoNumbersII_445 {
	// 我根据addTwoNumbers_2的top答案 的思路想出来的做法
	// 先放进stack中 和addTwoNumbers_2相似了
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Deque<ListNode> stack1 = new LinkedList<>();
		Deque<ListNode> stack2 = new LinkedList<>();
		while (l1 != null) {
			stack1.push(l1);
			l1 = l1.next;
		}
		while (l2 != null) {
			stack2.push(l2);
			l2 = l2.next;
		}
		int sum = 0;
		ListNode next = null;
		while (true) {
			sum /= 10;
			if (stack1.isEmpty() && stack2.isEmpty() && sum == 0) {
				break;
			}
			if (!stack1.isEmpty()) {
				sum += stack1.pop().val;
			}
			if (!stack2.isEmpty()) {
				sum += stack2.pop().val;
			}

			ListNode node = new ListNode(sum % 10);
			node.next = next;
			next = node;
		}

		return next;
	}

	// top
	// 看起来差不多嘛 但是他存的是int
	// 而且他在这此循环中就把下一次的node 给new出来了
	// 那么下一次循环只需要改value
	// 有可能下一次的node根本用不上 所以最后返回的值 要判断一下
	// 真是厉害
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		Deque<Integer> s1 = new LinkedList<>();
		Deque<Integer> s2 = new LinkedList<>();

		while (l1 != null) {
			s1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			s2.push(l2.val);
			l2 = l2.next;
		}

		int sum = 0;
		ListNode list = new ListNode(0);
		while (!s1.isEmpty() || !s2.isEmpty()) {
			if (!s1.isEmpty())
				sum += s1.pop();
			if (!s2.isEmpty())
				sum += s2.pop();
			list.val = sum % 10;
			ListNode head = new ListNode(sum / 10);
			head.next = list;
			list = head;
			sum /= 10;
		}

		return list.val == 0 ? list.next : list;
	}
}
