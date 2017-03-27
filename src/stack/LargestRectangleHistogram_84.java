package stack;

import java.util.Stack;

public class LargestRectangleHistogram_84 {
//	�ҵĵ�һ���   ��stack�еı� ��ǰi���index���num pop ����֮�� 
//	����˵ 215623
//	2pop����֮�� ��1�Ž�ȥ ���ǲ��ǰ�1��index�Ž�ȥ 
//	����Ҫ��heights[0]��Ϊheights[1]��ֵ ����1��
//	���Ұ�0���index�Ž�ȥ ���൱�� pop������������ǰ�����滻��
//	6 �� 5 pop����֮�� Ҫ��2�Ž�ȥ
//	ͨ����3 �� 2 λ�õ�heights��Ϊֵ 2 
//	���Ұ�index 2 �Ž�ȥ
	public int largestRectangleArea(int[] heights) {
		Stack<Integer> s = new Stack<Integer>();
		int index = 0;
		int i = 0;
		int res = 0;
		int cur = 0;
		int len = heights.length;
		while (i <= len) {
			if (!s.isEmpty() && (i == len ? 0 : heights[i]) < heights[s.peek()]) {
				while (!s.isEmpty() && (i == len ? 0 : heights[i]) < heights[s.peek()]) {
					index = s.pop();
					cur = heights[index] * (i - index);
					res = Math.max(res, cur);
					heights[index] = (i == len ? 0 : heights[i]);
				}
				s.push(index);
			} else
				s.push(i++);
		}
		return res;
	}
//	http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
//	��ʵ�ҵ�˼·��������һ���� �����ڶ�����left��ʱ�� ��ѡ����һ�������취
//	ͨ�����˱��˵Ĵ� �Ľ����Լ�����index�ķ���
//	ͨ����stack��pop������index��ǰһ��index ���ж��Լ��ܹ������ķ�Χ �����ǿ��Լ���index����
//	215623
//	
//	0
//	1
//	123
//	12
//	1
//	14
//	145
	public int largestRectangleArea2(int[] heights) {
		Stack<Integer> s = new Stack<Integer>();
		int index = 0;
		int i = 0;
		int res = 0;
		int cur = 0;
		int len = heights.length;
		while (i <= len) {
			if (!s.isEmpty() && (i == len ? 0 : heights[i]) < heights[s.peek()]) {
					index = s.pop();
					cur = heights[index] * (i-(s.isEmpty()?0:(s.peek()+1)));
					res = Math.max(res, cur);
			} else
				s.push(i++);
		}
		return res;
	}
}
