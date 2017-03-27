package linkedList;
//递归！ 一般人想不到啊~
public class Merge2SortedLists_21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l2.next, l2);
			return l2;
		}
	}
}
