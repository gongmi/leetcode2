package linkedList;

public class SortList_148 {
	// ��mergeSort ����������ʽ
	// ʱ��nlogn �ռ�1 Ϊʲô��1 �� ��Ϊ���õĵݹ���merge
	// ������������ŵ�Ҫnewһ���µ�������װ

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode f = head, s = head;
		f = f.next.next;  //fast ����һ�� ���� s��λ�þ���mid��ǰһ��λ��
		while (f != null && f.next != null) {
			f = f.next.next;
			s = s.next;
		}

		ListNode l2 = sortList(s.next); //s.next����mid
		s.next = null; // break the linked list
		return Merge2SortedLists_21.mergeTwoLists(sortList(head), l2);

	}

	// ��quickSort ֵ��������ʽ ����ʱ��ܲ� ��Ϊ�����������ʱ�� quicksort���˻���O(n^2)
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
