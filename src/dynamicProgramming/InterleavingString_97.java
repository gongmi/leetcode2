package dynamicProgramming;

public class InterleavingString_97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 + l2 != l3)
            return false;
        if (l1 == 0)
            return s2.equals(s3);
        if (l2 == 0)
            return s1.equals(s3);
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= l1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1))
                dp[i][0] = dp[i - 1][0];
        }
        for (int i = 1; i <= l2; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1))
                dp[0][i] = dp[0][i - 1];
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                char c3 = s3.charAt(i + j - 1);
                if (c1 != c3 && c2 == c3)
                    dp[i][j] = dp[i][j - 1];
                else if (c2 != c3 && c1 == c3)
                    dp[i][j] = dp[i - 1][j];
                else if (c1 == c3 && c2 == c3)
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
            }
        }
        return dp[l1][l2];
    }

    //降维后的答案
    public boolean isInterleave2(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l1 + l2 != l3)
            return false;
        if (l1 == 0)
            return s2.equals(s3);
        if (l2 == 0)
            return s1.equals(s3);
        boolean[] dp = new boolean[l2 + 1];
        dp[0] = true;
        for (int i = 1; i <= l2; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1))
                dp[i] = dp[i - 1];
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                char c1 = s1.charAt(i - 1);
                char c3 = s3.charAt(i + j - 1);
                if (j == 0) {
                    if (c1 != c3)
                        dp[0] = false;
                    continue;
                }
                char c2 = s2.charAt(j - 1);
//                if (c1 != c3 && c2 == c3)
//                    dp[j] = dp[j - 1];
//                else if (c2 != c3 && c1 != c3)
//                    dp[j] = false;
//                else if (c1 == c3 && c2 == c3)
//                    dp[j] = dp[j - 1] || dp[j];
                dp[j] = (c2 == c3 && dp[j - 1]) || (c1 == c3 && dp[j]);//看了top之后 可以优化为这一句话
            }
        }
        return dp[l2];
    }
}
