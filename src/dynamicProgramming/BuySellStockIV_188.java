package dynamicProgramming;


public class BuySellStockIV_188 {
//    local = Math.max(local + diff[i], diff[i]);
//    global = Math.max(local, global);
//    ������������1�� ���׵ĵ��ƹ�ʽ Ҳ���� maxSubArray
//    ���ڸ�Ϊk�ν���
//    local[i][j]=Math.max(local[i-1][j] + diff[i],global[i-1][j-1]+ diff[i]);
//    global[i][j] = Math.max(local[i][j], global[i-1][j]);

    //    ��Ϊlocal[i][j]�� global[i-1][j-1]�й�
//    ���� ȥ��i��  jӦ�ôӴ�С
    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1) return 0;
        int[] diff = new int[prices.length - 1];

        int positiveSum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            diff[i] = prices[i + 1] - prices[i];
            if (diff[i] > 0)
                positiveSum += diff[i];
        }
        if (k >= prices.length / 2)
            return positiveSum;

        return KSubArray(diff, k);
    }

    private int KSubArray(int[] diff, int k) {
        int[] global = new int[k + 1];
        int[] local = new int[k + 1];
        for (int d : diff) {
            for (int j = k; j >= 1; j--) {
                local[j] = Math.max(local[j], global[j - 1]) + d;
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[k];
    }
}
