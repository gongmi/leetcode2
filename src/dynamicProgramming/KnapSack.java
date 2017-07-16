package dynamicProgramming;

public class KnapSack {

	public int knapSack(int length, int weight, int[] v, int[] w) {
		int[][] c = new int[length + 1][weight + 1];

		for (int i = 1; i < v.length; i++) {
			for (int k = 1; k <= weight; k++) {
				if (w[i] <= k) {
					c[i][k] = Math.max(v[i] + c[i - 1][k - w[i]], c[i - 1][k]);
				} else
					c[i][k] = c[i - 1][k];
			}
		}
		return c[length][weight];
	}

	public static void main(String[] args) {
		int[] v = { 0, 60, 100, 120 };
		int[] w = { 0, 10, 20, 30 };
		int weight = 50;
		KnapSack knapsack = new KnapSack();
		knapsack.knapSack(3, weight, v, w);
	}

}
