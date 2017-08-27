package linkedList;

public class RemoveNthFromEndList {
	// fast先走 n步
	// 但是要注意特殊情况 比如说删除的是head结点
	// 所以需要一个holder来放在head前面
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode preHead = new ListNode(0);
		preHead.next = head;

		ListNode fast = preHead, slow = preHead;
		while (n-- > 0) {
			fast = fast.next;
		}
		while (fast != null && fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return preHead.next;
	}
}
