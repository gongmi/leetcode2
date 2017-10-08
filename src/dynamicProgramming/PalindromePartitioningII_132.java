package dynamicProgramming;

// memory的自底向上 可是当一开始就是一个很长的Palindrome会超时
// 所以考虑带备忘的自顶向下 还是超时
//因为有一些s 只需要一个cut即可
public class PalindromePartitioningII_132 {
    public int minCut(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        char[] chs = s.toCharArray();
        if (isPalindrome(chs, 0, len - 1))
            return 0;
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i + l <= len; i++) {
                int j = i + l;
                if (!isPalindrome(chs, i, j - 1)) {
                    dp[i][j] = j - i - 1;
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + 1);
                    }
                }
            }
        }
        return dp[0][len];
    }

    private boolean isPalindrome(char[] chs, int i, int j) {
        while (i < j) {
            if (chs[i] != chs[j])
                return false;
            i++;
            j--;
        }
        return true;
    }

//    看了top答案之后 是要利用palindrome的性质！！
//    要分析！
}