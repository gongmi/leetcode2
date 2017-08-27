package linkedList;

public class RemoveNthFromEndList {
	// fast���� n��
	// ����Ҫע��������� ����˵ɾ������head���
	// ������Ҫһ��holder������headǰ��
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
