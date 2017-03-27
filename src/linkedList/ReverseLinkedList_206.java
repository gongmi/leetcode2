package linkedList;

// prev  midd->next->..->
// prev<-midd  next->..->

public class ReverseLinkedList_206 {
	public static ListNode reverseList(ListNode head) {
		ListNode prev = null, next = head, midd = head;
		while (next != null) {
			next = next.next;
			midd.next = prev;
			prev = midd;
			midd = next;
		}

		return prev;

	}
}
