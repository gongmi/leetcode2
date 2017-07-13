package linkedList;

public class addTwoNumbers_2 {
//	top 用的迭代 关键在于 他巧妙地运用了sum ！！！
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode c1 = l1;
	        ListNode c2 = l2;
	        ListNode sentinel = new ListNode(0);
	        ListNode d = sentinel;
	        int sum = 0;
	        while (c1 != null || c2 != null) {
	            sum /= 10;
	            if (c1 != null) {
	                sum += c1.val;
	                c1 = c1.next;
	            }
	            if (c2 != null) {
	                sum += c2.val;
	                c2 = c2.next;
	            }
	            d.next = new ListNode(sum % 10);
	            d = d.next;
	        }
	        if (sum / 10 == 1)
	            d.next = new ListNode(1);
	        return sentinel.next;
	    }
//	 2017.07.09的答案 用的递归
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		return addTwoNumbers(l1, l2, 0);
	}

	private ListNode addTwoNumbers(ListNode l1, ListNode l2, int jinwei) {

		if (l1 == null && l2 == null) {
			return (jinwei == 1) ? new ListNode(1) : null;
		}
		int value = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + jinwei;
		ListNode node = new ListNode(value % 10);
		node.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value / 10);
		return node;
	}
}
