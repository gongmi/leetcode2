package linkedList;

//一开始用的merge这个函数 超时了 因为一直递归 栈溢出了
public class ReorderList_143 {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return;
		ListNode fast = head;
		ListNode slow = head;
		fast = fast.next.next;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode rightStart = null;
		if (fast == null) {
			rightStart = slow.next;
			slow.next = null;
		} else if (fast.next == null) {
			rightStart = slow.next.next;
			slow.next.next = null;
		}
		rightStart = reverse(rightStart);
		ListNode l1 = head;
		ListNode l2 = rightStart;
		ListNode l1next = head.next;
		ListNode l2next = rightStart.next;
		while (l1 != null && l2 != null) {
			l1next = l1.next;
			l2next = l2.next;
			l1.next = l2;
			l2.next = l1next;
			l1 = l1next;
			l2 = l2next;
		}
	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode next = null;
		while (head != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode l1hold = l1.next;
		l1.next = l2;
		l2.next = merge(l1hold, l2.next);
		return l1;
	}
}
