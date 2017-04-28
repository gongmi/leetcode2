package dynamicProgramming;

public class KnapSack {

	public int knapSack(int length, int weight, int[] v, int[] w) {
		int[][] c = new int[length + 1][weight + 1];

		for (int i = 1; i < v.length; i++) {
			for (int k = 1; k <= weight; k++) {
				if (w[i] <= k) {
					if (v[i] + c[i - 1][k - w[i]] > c[i - 1][k])
						c[i][k] = v[i] + c[i - 1][k - w[i]];
					else
						c[i][k] = c[i - 1][k];
				} else
					c[i][k] = c[i - 1][k];
			}
		}
		return c[length][weight];
	}

}
