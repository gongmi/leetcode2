package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SuperUglyNumber_313 {
	public int nthSuperUglyNumber(int n, int[] primes) {
		// n[0] current value, n[1] current index, n[2] base value
		//用一个数组来存 第一位存放当前值 第二位存放下一次要乘的ugly数组中的数的index
//		第三位存放factor 因子 因子一直保持不变 
//		第二位每一次都加一 相当于当前poll出来的数 把factor拿出来 乘遍ugly[] 的数
//		就会有重复 比如说 2 3 5 嘛
//		一开始是（2,1,2）（3,1，3）（5,1,5）
//		会有（2*ugly[1],1+1,2）（2*ugly[2],2+1,2）（2*ugly[3],3+1,2）
//		会有（3*ugly[1],1+1,3）（3*ugly[2],2+1,3）（3*ugly[3],3+1,3）
//		ugly[] =[1,2,3,4,5,]
//		但是这样并不快 55ms  理论上O( log(k)N )
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((n1,n2)->( n1[0] - n2[0]));

		int[] ans = new int[n];
		ans[0] = 1;

		for (int i = 0; i < primes.length; i++) {
			pq.offer(new int[] { primes[i], 1, primes[i] });
		}

		for (int i = 1; i < n; i++) {
			int next = pq.peek()[0];
			ans[i] = next;
			while (pq.peek()[0] == next) {
				int[] cur = pq.poll();
				cur[0] = cur[2] * ans[cur[1]];
				cur[1] = cur[1] + 1;
				pq.offer(cur);
			}
		}

		return ans[n - 1];
	}
	//一样的思想  O(kN)
	public int nthSuperUglyNumber1(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length];
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
