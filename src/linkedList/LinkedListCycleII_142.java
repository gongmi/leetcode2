package linkedList;

public class LinkedListCycleII_142 {
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				while (head != slow) {
					head = head.next;
					slow = slow.next;
				}

				return slow;
			}
		}
		return null;

	}
}
