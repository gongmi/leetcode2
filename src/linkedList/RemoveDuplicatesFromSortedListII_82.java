package linkedList;

public class RemoveDuplicatesFromSortedListII_82 {
	public ListNode deleteDuplicates2(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode left = dummy;

		while (head != null) {
			// 用while循环 来找出所有重复的
			while (head.next != null && head.next.val == head.val) {
				head = head.next;
			}
			// 如果曾经进入过循环
			if (left.next != head) {
				left.next = head.next;
			} else { // 如果曾经没有进入过循环
				left = head;
			}
			head = left.next;

		}
		return dummy.next;
	}

	// 这是83. Remove Duplicates from Sorted List
	public ListNode deleteDuplicates(ListNode head) {

		ListNode h = head;
		ListNode n = null;
		while (h != null && h.next != null) {
			n = h.next;
			// 用while循环 来找出所有重复的
			while (n != null && n.val == h.val) {
				n = n.next;
			}
			h.next = n;
			h = h.next;
		}
		return head;
	}
}
