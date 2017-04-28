package linkedList;

public class ReverseNodesKGroup_25 {
	// 第一版利用reverseBetween 方法
	// 第一版答案删了
	// 看了top 答案之后 发现 其实就是利用reverseBetween的思想 while循环一下
	// 我们首先遍历整个链表，统计出链表的长度n，然后如果长度大于等于k，我们开始交换节点，
	// 当k=2时，每段我们只需要交换一次，
	// 当k=3时，每段需要交换2次，
	// 所以i从1开始循环，
	// 注意交换一段后更新pre指针，然后n自减k，直到n<k时循环结束
	public ListNode reverseKGroup2(ListNode head, int k) {
		int n = 0;
		for (ListNode i = head; i != null; n++, i = i.next)
			;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode start = null, then = null;
		while (k <= n) {
			start = pre.next;
			then = start.next;
			for (int i = 1; i < k; i++) {
				start.next = then.next;
				then.next = pre.next;
				pre.next = then;
				then = start.next;
			}
			pre = start;
			n -= k;
		}
		return dummy.next;
	}
}
