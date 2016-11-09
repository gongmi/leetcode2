package dynamicProgramming;

import java.util.Arrays;

public class HouseRobber_198 {
	// 我写的 自底向上 bottom-top 很慢
//	public int rob(int[] nums) {
//
//		int l = nums.length;
//		if (l == 0)
//			return 0;
//		int S[][] = new int[l][l];
//		for (int i = 0; i < l - 1; i++) {
//			S[i][i] = nums[i];
//			S[i][i + 1] = Math.max(nums[i], nums[i + 1]);
//		}
//		S[l - 1][l - 1] = nums[l - 1];
//
//		for (int j = 2; j < l; j++)
//			for (int i = 0; i + j < l; i++)
//				for (int k = i; k < i + j+1; k++)
//
//					S[i][i + j] = Math.max(S[i][i + j], Math.max(nums[k]
//							+ (k - 2 < i ? 0 : S[i][k - 2])
//							+ (k + 2 > i + j ? 0 : S[k + 2][i + j]),
//							(k - 1 < i ? 0 : S[i][k - 1])
//						  + (k + 1 > i + j ? 0 : S[k + 1][i + j])));
//
//		return S[0][l - 1];
//	}
	//别人的 与337. House Robber III 别人的解法有相同的思想
	//dp[i][1] means we rob the current house and dp[i][0] means we don't,
	public int rob(int[] num) {
	    int[][] dp = new int[num.length + 1][2];
	    for (int i = 1; i <= num.length; i++) {
	        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
	        dp[i][1] = num[i - 1] + dp[i - 1][0];
	    }
	    return Math.max(dp[num.length][0], dp[num.length][1]);
	}
	
	public int rob2(int[] num) {
	    int prevNo = 0;
	    int prevYes = 0;
	    for (int n : num) {
	        int temp = prevNo;
	        prevNo = Math.max(prevNo, prevYes);
	        prevYes = n + temp;
	    }
	    return Math.max(prevNo, prevYes);
	}

}
