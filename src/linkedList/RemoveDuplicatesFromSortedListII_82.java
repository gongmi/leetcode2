package linkedList;

public class RemoveDuplicatesFromSortedListII_82 {
	public ListNode deleteDuplicates2(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode left = dummy;

		while (head != null) {
			// ��whileѭ�� ���ҳ������ظ���
			while (head.next != null && head.next.val == head.val) {
				head = head.next;
			}
			// ������������ѭ��
			if (left.next != head) {
				left.next = head.next;
			} else { // �������û�н����ѭ��
				left = head;
			}
			head = left.next;

		}
		return dummy.next;
	}

	// ����83. Remove Duplicates from Sorted List
	public ListNode deleteDuplicates(ListNode head) {

		ListNode h = head;
		ListNode n = null;
		while (h != null && h.next != null) {
			n = h.next;
			// ��whileѭ�� ���ҳ������ظ���
			while (n != null && n.val == h.val) {
				n = n.next;
			}
			h.next = n;
			h = h.next;
		}
		return head;
	}
}
