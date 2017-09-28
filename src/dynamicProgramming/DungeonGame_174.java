package dynamicProgramming;

import java.util.Arrays;

public class DungeonGame_174 {
	// 看了答案后的第一版答案
	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		int health[][] = new int[m + 1][n + 1];
		Arrays.fill(health[m], Integer.MAX_VALUE);
		for (int i = m - 1; i >= 0; i--) {
			health[i][n] = Integer.MAX_VALUE;
		}
		health[m][n - 1] = 1;
		health[m - 1][n] = 1;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				health[i][j] = Math.min(health[i + 1][j], health[i][j + 1]) - dungeon[i][j];
				if (health[i][j] <= 0)
					health[i][j] = 1;
			}
		}
		return health[0][0];
	}

	// 降维后的答案
	public int calculateMinimumHP2(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;
		int health[] = new int[n + 1];
		Arrays.fill(health, Integer.MAX_VALUE);
		health[n - 1] = 1;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				health[j] = Math.min(health[j], health[j + 1]) - dungeon[i][j];
				if (health[j] <= 0)
					health[j] = 1;
			}
		}
		return health[0];
	}
}
