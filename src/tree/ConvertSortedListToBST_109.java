package tree;

import linkedList.ListNode;

//二分法
public class ConvertSortedListToBST_109 {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return new TreeNode(head.val);
		ListNode f = head, s = head;
		f = f.next.next;// fast早走了一步 这样子找到的s是mid前一个 别人用一个preS指针来hold了前一个
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
