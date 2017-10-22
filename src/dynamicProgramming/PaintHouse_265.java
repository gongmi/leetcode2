package dynamicProgramming;

public class PaintHouse_265 {
//	 we can change the matrix to present sum of prices 
//	 the costs[i][0] represent minimum price to 
//	paint the i+1 house red plus the previous house's sum of price.
	public int minCost(int[][] costs) {
		if (costs == null || costs.length == 0) {
			return 0;
		}
		for (int i = 1; i < costs.length; i++) {
			costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
			costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
			costs[i][2] += Math.min(costs[i - 1][1], costs[i - 1][0]);
		}
		int n = costs.length - 1;
		return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
	}
}
