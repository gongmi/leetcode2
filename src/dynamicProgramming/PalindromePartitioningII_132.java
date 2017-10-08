package dynamicProgramming;

// memory���Ե����� ���ǵ�һ��ʼ����һ���ܳ���Palindrome�ᳬʱ
// ���Կ��Ǵ��������Զ����� ���ǳ�ʱ
//��Ϊ��һЩs ֻ��Ҫһ��cut����
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

//    ����top��֮�� ��Ҫ����palindrome�����ʣ���
//    Ҫ������
}