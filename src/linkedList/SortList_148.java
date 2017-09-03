package linkedList;

public class SortList_148 {
	// 用mergeSort 链表交换的形式
	// 时间nlogn 空间1 为什么是1 呢 因为它用的递归来merge
	// 而正常用数组放的要new一个新的数组来装

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode f = head, s = head;
		f = f.next.next; // fast 先走一步 这样 s的位置就是mid的前一个位置
		while (f != null && f.next != null) {
			f = f.next.next;
			s = s.next;
		}

		ListNode l2 = sortList(s.next); // s.next才是mid
		s.next = null; // break the linked list
		return Merge2SortedLists_21.mergeTwoLists(sortList(head), l2);

	}

	// 用quickSort 值交换的形式 但是时间很差 因为当输入有序的时候 quicksort会退化成O(n^2)
	public ListNode sortList2(ListNode head) {
		QuickSort(head, null);
		return head;
	}

	private void QuickSort(ListNode begin, ListNode end) {
		if (begin != end) {
			ListNode pivot = partition(begin, end);
			QuickSort(begin, pivot);
			QuickSort(pivot.next, end);
		}
	}

	// 就是把所有小于pivot放在左边 大于pivot放在右边
	// 但是不能用左右指针 因为是单向链表
	// 所以用的是 见笔记！！！！
	// 此处有点像 86. Partition List 但是86是不能改变相对位置 即稳定的

	private ListNode partition(ListNode begin, ListNode end) {
		int pivot = begin.val;
		ListNode p = begin;
		ListNode q = p.next;
		while (q != end) {
			if (q.val < pivot) {
				p = p.next;
				swap(p, q);
			}
			q = q.next;
		}
		swap(p, begin);
		return p;

	}

	private void swap(ListNode p, ListNode q) {
		int temp = p.val;
		p.val = q.val;
		q.val = temp;
	}
}
