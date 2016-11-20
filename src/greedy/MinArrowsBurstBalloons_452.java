package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinArrowsBurstBalloons_452 {
	// 53 ms
	// �Ȱ���ÿ�������finish����
	public int findMinArrowShots(int[][] points) {
		if (points.length == 0)
			return 0;
//		leetcode�п���������ķ�ʽ����
//		  Arrays.sort(points, (a, b)->(a[0]-b[0]));
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		// ���� p421�ĵ����㷨
		int k = 0, sum = 1;
		for (int i = 1; i < points.length; i++)
			if (points[k][1] < points[i][0]) {
				sum++;
				k = i;
			}
		return sum;

	}

	// ���˵Ĵ� 43 ms  Ϊʲô���˵ĸ��죿
	public int findMinArrowShots2(int[][] points) {
		if (points == null || points.length == 0 || points[0].length == 0)
			return 0;
		// �Ȱ���ÿ�������start���� ���startһ���Ͱ���finish����
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] == b[0])
					return a[1] - b[1];
				else
					return a[0] - b[0];
			}
		});

		int minArrows = 1;//������Ҫ��arrows�� Ҳ�����м����max��������
		int arrowLimit = points[0][1];   //��0�������finish ֮����ɼ���������finish
		for (int i = 1; i < points.length; i++) {
			int[] baloon = points[i];  //��ǰ����
			if (baloon[0] <= arrowLimit) { //�����ǰ�����start<֮ǰ��������һ�������finish
				arrowLimit = Math.min(arrowLimit, baloon[1]); //���ڵ�ǰ�����finish<��������һ�������finish �Ƚ� ѡ��С��
			} else {//�����ǰ�����start����������һ�������finish
				minArrows++;       //�������ǰ����������
				arrowLimit = baloon[1]; //�������ǰ�����finish������
			}
		}
		return minArrows;
	}
}