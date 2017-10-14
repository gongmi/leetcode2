package heap;

import java.util.*;
//һ��ʼ��˼· ���� ��Ʊ ��������ַ��� ����
//[[1,2,1],[2147483646,2147483647,2147483647]]
//Memory Limit Exceeded 

public class SkylineProblem_218 {
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> res = new LinkedList<>();
		if (buildings == null || buildings.length == 0 || buildings[0].length == 0)
			return res;
		int len = 0;
		for (int[] b : buildings)
			len = Math.max(len, b[1]);
		int[] heights = new int[len];
		for (int[] b : buildings) {
			for (int i = b[0]; i <= b[1]; i++)
				if (i != len)
					heights[i] = Math.max(b[2], heights[i]);
		}
		int pre = 0;
		for (int i = 0; i < len; i++) {
			if (heights[i] > pre) {
				res.add(new int[] { i, heights[i] });
			} else if (heights[i] < pre) {
				res.add(new int[] { i - 1, heights[i] });
			}
			pre = heights[i];
		}
		res.add(new int[] { len, heights[len - 1] });
		return res;

	}

	// ���ǲ���ʶlambda���ʽ ע�� һ��Ҫ���յ����� ��� ����ͬ ��ô һ��Ҫ����height ���� Ҳ����˵
	// ������¥ �߶Ȳ�ͬ ����������ͬʱ
	// |������������|5
	// |..... |
	// |..... |
	// |������������|3
	// |..... |
	// |������������|����������
	// 2..... 4
	// ˳���� [2,5][2,3][2,-3][2,-5]
	// �����ʱ�� 5�ȼ��� ���� ����� 2,5
	// �뿪��ʱ��-3 ���뿪 -5 ���뿪 ��������� 4,5
	// ���� ��point�Ž�ȥ�� height�Ǹ���Ҳ�������õ�
	public List<int[]> getSkyline2(int[][] buildings) {
		List<int[]> res = new LinkedList<>();
		if (buildings == null || buildings.length == 0 || buildings[0].length == 0)
			return res;
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		// PriorityQueue<Integer> heap=new PriorityQueue<>((a,b)->(b-a));
		List<int[]> points = new ArrayList<>();
		for (int[] b : buildings) {
			points.add(new int[] { b[0], b[2] });
			points.add(new int[] { b[1], -b[2] });
		}

		// Collections.sort(points,(a,b)->(a[0]==b[0])?b[1]-a[1]:a[0]-b[0]);
		int pre = 0;
		for (int[] point : points) {
			if (point[1] > 0) {
				heap.offer(point[1]);
			} else {
				heap.remove(-point[1]);
			}
			int cur = heap.isEmpty() ? 0 : heap.peek();
			if (cur != pre) {
				res.add(new int[] { point[0], cur });
				pre = cur;
			}

		}
		return res;
	}
}