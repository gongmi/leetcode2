package dynamicProgramming;
//这道题是一道典型的应用DP来解的题，
//如果我们看到这种求总数，而不是列出所有情况的题，十有八九都是用DP来解，
//重中之重就是在于找出递推式。
//如果你第一反应没有想到用DP来做，想得是用贪心算法来做，
//比如先给字符串数组排个序，让长度小的字符串在前面，
//然后遍历每个字符串，遇到0或者1就将对应的m和n的值减小，
//这种方法在有的时候是不对的，
//比如对于{"11", "01", "10"}，m=2，n=2这个例子，
//我们将遍历完“11”的时候，把1用完了，那么对于后面两个字符串就没法处理了，
//而其实正确的答案是应该组成后面两个字符串才对。
//所以我们需要建立一个DP数组，其中dp[i][j]表示有i个0和j个1时能组成的最多字符串的个数，
//而对于当前遍历到的字符串，我们统计出其中0和1的个数为zeros和ones，
//dp[i][j] = max(dp[i][j], dp[i - zeros][j - ones] + 1);

//这道题 和别的dp题相比 不同之处在于 每个str都要dp一下 
public class OnesAndZeroes_474 {
	public int findMaxForm(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (String s : strs) {
			int ones = 0;
			int zeroes = 0;
			for (int i = 0; i < s.length(); i++)
				if (s.charAt(i) == '0')
					zeroes++;
				else
					ones++;
			for (int i = m; i >= zeroes; i--)
				for (int j = n; j >= ones; j--) {
					dp[i][j] = Math.max(dp[i - zeroes][j - ones] + 1, dp[i][j]);
				}
		}
		return dp[m][n];
	}

}
