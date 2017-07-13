package linkedList;

import java.util.Deque;
import java.util.LinkedList;

public class addTwoNumbersII_445 {
	// �Ҹ���addTwoNumbers_2��top�� ��˼·�����������
	// �ȷŽ�stack�� ��addTwoNumbers_2������
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
	// ����������� �����������int
	// �����������ѭ���оͰ���һ�ε�node ��new������
	// ��ô��һ��ѭ��ֻ��Ҫ��value
	// �п�����һ�ε�node�����ò��� ������󷵻ص�ֵ Ҫ�ж�һ��
	// ��������
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
