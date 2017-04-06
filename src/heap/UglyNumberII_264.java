package heap;

import java.util.PriorityQueue;

public class UglyNumberII_264 {
	public int nthUglyNumber(int n) {
//		��ʵ���PriorityQueue�����þ������������С���� �Ǹ�С���� ���൱�������� ���Բ���min��
	    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((n1,n2)->( n1[0] - n2[0]));
			int[] ans = new int[n];
			ans[0] = 1;
				pq.offer(new int[] { 2, 1, 2 });
				pq.offer(new int[] { 3, 1, 3 });
				pq.offer(new int[] { 5, 1, 5 });
			for (int i = 1; i < n; i++) {
				int next = pq.peek()[0];
				ans[i] = next;
				while (pq.peek()[0] == next) { //�����ظ�
					int[] cur = pq.poll();
					cur[0] = cur[2] * ans[cur[1]];
					cur[1] = cur[1] + 1;
					pq.offer(cur);
				}
			}
			return ans[n-1];
	    }
//�������������˼· ��������΢�ı���һ�� ������һ�ζ�ugly�ڵ�i��λ�ø�ֵ ��Ϊ��������val�������һ�����ֵ ���
//	����ϴ�û�б���������������value�Ϳ��Բ�������һ���� 
	public int GetUglyNumber_Solution(int index) {
		int[] ugly = new int[index];
		int index2 = 0;
		int index3 = 0;
		int index5 = 0;
		int val2 = 1;
		int val3 = 1;
		int val5 = 1;

		int next = 1;
		for (int i = 1; i < index; i++) {
			ugly[i] = next; 
			if (ugly[i] == val2)
				val2 = ugly[index2++] * 2;
			if (ugly[i] == val3)
				val3 = ugly[index3++] * 3;
			if (ugly[i] == val5)
				val5 = ugly[index5++] * 5;

			next = Math.min(next, Math.min(val5, Math.min(val2, val3)));
		}
		return ugly[index - 1];

	}
}
