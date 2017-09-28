package dynamicProgramming;

import java.util.Arrays;

public class DecodeWays_91 {
	// 自己写出来的答案哦 和top答案差不多~
	public int numDecodings(String s) {
		int len = s.length();
		if (len == 0 || s.charAt(0) == '0')
			return 0;
		int[] dp = new int[len + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < len + 1; i++) {
			if (s.charAt(i - 1) > '0')
				dp[i] = dp[i - 1];
			if (Integer.parseInt(s.substring(i - 2, i)) <= 26
					&& Integer.parseInt(s.substring(i - 2, i)) >= 10)
				dp[i] += dp[i - 2];
		}
		return dp[len];
	}

}
