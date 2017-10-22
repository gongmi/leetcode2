package dynamicProgramming;

import java.util.Arrays;

public class RussianDollEnvelopes_354 {
	// 用的LongestIncreasingSubsequence_300 第一种方法
	// 时间复杂度是O(n*n)
	public int maxEnvelopes1(int[][] envelopes) {
		// Arrays.sort(envelopes,(a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
		int len = envelopes.length;
		if (len == 0)
			return 0;
		int[] max_lens = new int[len];
		max_lens[0] = 1;
		int res = 1;
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
					max_lens[i] = Math.max(max_lens[i], max_lens[j]);
			}
			max_lens[i]++;
			res = Math.max(res, max_lens[i]);
		}
		return res;
	}

	// 用的LongestIncreasingSubsequence_300 第2种方法
	// 先按照width升序 如果width一样 就按照height倒序！！！
	// 时间复杂度是O(N*logN)
	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes.length == 0) {
			return 0;
		}
		// Arrays.sort(envelopes,(a,b)->(a[0]==b[0]?b[1]-a[1]:a[0]-b[0]));
		int[] dp = new int[envelopes.length];
		int len = 0;

		for (int[] envelope : envelopes) {
			int i = Arrays.binarySearch(dp, 0, len, envelope[1]);
			if (i < 0)
				i = -(i + 1);// 如果没找到还原为应该存在的位置
			dp[i] = envelope[1];
			if (i == len)
				len++; // 如果是加在dp数组的最后 则是产生了一个长度加一的新的LIS数组
		}

		return len;
	}
}
