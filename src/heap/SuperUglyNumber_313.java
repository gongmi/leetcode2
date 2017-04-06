package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SuperUglyNumber_313 {
	public int nthSuperUglyNumber(int n, int[] primes) {
//O( N*log(k) )
		// n[0] current value, n[1] current index, n[2] base value
//��һ���������� ��һλ��ŵ�ǰֵ �ڶ�λ�����һ��Ҫ�˵�ugly�����е�����index
//		����λ���factor ���� ����һֱ���ֲ��� ���� 2����Զ����2 3����Զ����3
//		�ڶ�λindexÿһ�ζ���һ ��ʾÿ�ζ�������һ��ugly�е���
//		�ͻ����ظ� ����˵ 2 3 5 ��
//		һ��ʼ�ǣ�2,1,2����3,1��3����5,1,5��
//		���У�2,1,2����  ��2*ugly[1]=4,1+1,2����   
//		    ��3,1��3����   ��3*ugly[1]=6,1+1,3����
//		  ��4,1+1,2�� ��  ��2*ugly[2]=6,2+1,2����
//		  ��5,1,5��   ��     ��5*ugly[1]=10,1+1,5����
//		6,1+1,3����
//		6,2+1,2����  
//		��ʵ����˵ ÿ����һ���� �����Ƕ������� �Ͱ��������Ӻ�ugly�����е��������� ����ÿ��ֻ��һ��
//		��index��������һ��Ӧ�ó����ĸ���
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((n1,n2)->( n1[0] - n2[0]));

		int[] ans = new int[n];
		ans[0] = 1;

		for (int i = 0; i < primes.length; i++) {
			pq.offer(new int[] { primes[i], 1, primes[i] });
		}

		for (int i = 1; i < n; i++) {
			int next = pq.peek()[0];
			ans[i] = next;
			while (pq.peek()[0] == next) { //�����ظ� ������Ϊ�˽���ظ����
				int[] cur = pq.poll();
				//ע�� ����Ž�ȥ��value��poll������value�޹أ����� ֻ��index��factor�йأ�
				cur[0] = cur[2] * ans[cur[1]];//ע�� ����Ž�ȥ��value��poll������value�޹أ����� ֻ��index��factor�йأ�
				cur[1] = cur[1] + 1;
				pq.offer(cur);
			}
		}

		return ans[n - 1];
	}
	//һ����˼��  O(kN) 
//	����ʵ���Ǽ�֬offer�ķ��� ֻ�����������������idx��val ����ֻ����������
	
	public int nthSuperUglyNumber1(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length]; //���������ʵ���Բ���Ҫ ��������еĻ����Է�ֹ�ظ���
        Arrays.fill(val, 1);

        int next = 1;
        for (int i = 0; i < n; i++) {
            ugly[i] = next;
            
            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                //skip duplicate and avoid extra multiplication
                if (val[j] == ugly[i]) val[j] = ugly[idx[j]++] * primes[j];
                //find next ugly number
                next = Math.min(next, val[j]);
            }
        }

        return ugly[n - 1];
    }
}
