package linkedList;

public class ReverseNodesKGroup_25 {
	// ��һ������reverseBetween ����
	// ��һ���ɾ��
	// ����top ��֮�� ���� ��ʵ��������reverseBetween��˼�� whileѭ��һ��
	// �������ȱ�����������ͳ�Ƴ�����ĳ���n��Ȼ��������ȴ��ڵ���k�����ǿ�ʼ�����ڵ㣬
	// ��k=2ʱ��ÿ������ֻ��Ҫ����һ�Σ�
	// ��k=3ʱ��ÿ����Ҫ����2�Σ�
	// ����i��1��ʼѭ����
	// ע�⽻��һ�κ����preָ�룬Ȼ��n�Լ�k��ֱ��n<kʱѭ������
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
