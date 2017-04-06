package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SuperUglyNumber_313 {
	public int nthSuperUglyNumber(int n, int[] primes) {
//O( N*log(k) )
		// n[0] current value, n[1] current index, n[2] base value
//用一个数组来存 第一位存放当前值 第二位存放下一次要乘的ugly数组中的数的index
//		第三位存放factor 因子 因子一直保持不变 ！！ 2的永远乘以2 3的永远乘以3
//		第二位index每一次都加一 表示每次都乘以下一个ugly中的数
//		就会有重复 比如说 2 3 5 嘛
//		一开始是（2,1,2）（3,1，3）（5,1,5）
//		会有（2,1,2）出  （2*ugly[1]=4,1+1,2）进   
//		    （3,1，3）出   （3*ugly[1]=6,1+1,3）进
//		  （4,1+1,2） 出  （2*ugly[2]=6,2+1,2）进
//		  （5,1,5）   出     （5*ugly[1]=10,1+1,5）进
//		6,1+1,3）出
//		6,2+1,2）出  
//		其实就是说 每出来一个数 看它是多少因子 就把它的因子和ugly数组中的数挨个乘 但是每次只乘一个
//		用index来保存下一次应该乘以哪个数
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((n1,n2)->( n1[0] - n2[0]));

		int[] ans = new int[n];
		ans[0] = 1;

		for (int i = 0; i < primes.length; i++) {
			pq.offer(new int[] { primes[i], 1, primes[i] });
		}

		for (int i = 1; i < n; i++) {
			int next = pq.peek()[0];
			ans[i] = next;
			while (pq.peek()[0] == next) { //会有重复 这里是为了解决重复情况
				int[] cur = pq.poll();
				//注意 这里放进去的value和poll出来的value无关！！！ 只和index与factor有关！
				cur[0] = cur[2] * ans[cur[1]];//注意 这里放进去的value和poll出来的value无关！！！ 只和index与factor有关！
				cur[1] = cur[1] + 1;
				pq.offer(cur);
			}
		}

		return ans[n - 1];
	}
	//一样的思想  O(kN) 
//	这其实就是减脂offer的方法 只不过这边用数组来放idx与val 而不只是三个数了
	
	public int nthSuperUglyNumber1(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length]; //这个数组其实可以不需要 但是如果有的话可以防止重复乘
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
