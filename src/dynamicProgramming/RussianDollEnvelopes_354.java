package dynamicProgramming;

import java.util.Arrays;

public class RussianDollEnvelopes_354 {
	// �õ�LongestIncreasingSubsequence_300 ��һ�ַ���
	// ʱ�临�Ӷ���O(n*n)
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

	// �õ�LongestIncreasingSubsequence_300 ��2�ַ���
	// �Ȱ���width���� ���widthһ�� �Ͱ���height���򣡣���
	// ʱ�临�Ӷ���O(N*logN)
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
				i = -(i + 1);// ���û�ҵ���ԭΪӦ�ô��ڵ�λ��
			dp[i] = envelope[1];
			if (i == len)
				len++; // ����Ǽ���dp�������� ���ǲ�����һ�����ȼ�һ���µ�LIS����
		}

		return len;
	}
}
