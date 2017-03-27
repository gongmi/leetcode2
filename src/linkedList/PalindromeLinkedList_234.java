package linkedList;
//
public class PalindromeLinkedList_234 {
	public boolean isPalindrome(ListNode head) {
		ListNode left = head;
		ListNode right;
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		head = left;
		ListNode prev = null;
		ListNode middle = head;
		int lenhalf = (len / 2);

		while ((lenhalf--) > 0) {
			head = head.next;
			middle.next = prev;
			prev = middle;
			middle = head;
		}
		if (len % 2 == 0)
			right = middle;
		else
			right = middle.next;

		if (right == null)
			return true;

		else {
			while (right.val == prev.val) {
				right = right.next;
				prev = prev.next;
				if (prev == null)
					return true;

			}
			return false;
		}

	}
//	���˵Ĵ� 
//	������ָ�� һ����һ���� �ҵ����ĵ�
//	  1 -> 1 -> 2 -> 1 -> null 
//	  sf
//	  1 -> 1 -> 2 -> 1 -> null 
//              s          f
//    1 -> 1    null <- 2 <- 1           
//    h                      s
	
//    1 -> 1    null <- 2 <- 1             
//         h            s
//	�Ѻ�벿�ַ�ת �����ı���ԭ����list ��֪���ò�����
	
	public boolean isPalindrome2(ListNode head) {
	    ListNode fast = head, slow = head;
	    while (fast != null && fast.next != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    if (fast != null) { // ˵����������nodes: let right half smaller
	        slow = slow.next;
	    }
	    slow = ReverseLinkedList_206.reverseList(slow); 
	    fast = head;
	    
	    while (slow != null) {
	        if (fast.val != slow.val) {
	            return false;
	        }
	        fast = fast.next;
	        slow = slow.next;
	    }
	    return true;
	}

}
