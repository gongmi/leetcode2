package greedy;

import java.util.Arrays;
import java.util.Comparator;
//与OverlappingIntervals_435 一样的思想
//主要是怎么能够想到 转换为 最大的不重叠气球个数 这是一个关键！
public class MinArrowsBurstBalloons_452 {
	// 53 ms
	// 先按照每个气球的finish排序
	public int findMinArrowShots(int[][] points) {
		if (points.length == 0)
			return 0;
//		leetcode中可以用下面的方式排序 这是java 8 我的jdk还是7
//		  Arrays.sort(points, (a, b)->(a[1]-b[1]));
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[1]-b[1];
			}
		});
		// 按照 p421的迭代算法
		int k = 0, sum = 1;
		for (int i = 1; i < points.length; i++)
			if (points[k][1] < points[i][0]) {
				sum++;
				k = i;
			}
		return sum;

	}

	// 别人的答案 43 ms  为什么别人的更快？ 但是我觉得别人的并不好
	public int findMinArrowShots2(int[][] points) {
		if (points == null || points.length == 0 || points[0].length == 0)
			return 0;
		// 先按照每个气球的start排序 如果start一样就按照finish排序
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0])
					return a[1] - b[1];
				else
					return a[0] - b[0];
			}
		});

		int minArrows = 1;//最少需要的arrows数 也就是有间隔的max的气球数
		int arrowLimit = points[0][1];   //第0个气球的finish 之后会变成加入的气球的finish
		for (int i = 1; i < points.length; i++) {
			int[] baloon = points[i];  //当前气球
			if (baloon[0] <= arrowLimit) { //如果当前气球的start<之前加入的最后一个气球的finish
				arrowLimit = Math.min(arrowLimit, baloon[1]); //就在当前气球的finish和加入的最后一个气球的finish 比较 选最小的
			} else {//如果当前气球的start》加入的最后一个气球的finish
				minArrows++;       //把这个当前气球加入进来
				arrowLimit = baloon[1]; //把这个当前气球的finish存起来
			}
		}
		return minArrows;
	}
}
