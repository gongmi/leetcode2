package tree;

import linkedList.ListNode;

//���ַ�
public class ConvertSortedListToBST_109 {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return new TreeNode(head.val);
		ListNode f = head, s = head;
		f = f.next.next;// fast������һ�� �������ҵ���s��midǰһ�� ������һ��preSָ����hold��ǰһ��
		while (f != null && f.next != null) {
			f = f.next.next;
			s = s.next;
		}
		ListNode mid = s.next;
		TreeNode root = new TreeNode(mid.val);
		s.next = null;
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(mid.next);
		return root;
	}

}
