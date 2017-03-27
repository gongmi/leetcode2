package stack;

import java.util.Stack;

public class LargestRectangleHistogram_84 {
//	我的第一版答案   当stack中的比 当前i这个index大的num pop 出来之后 
//	比如说 215623
//	2pop出来之后 把1放进去 但是不是把1的index放进去 
//	而是要把heights[0]改为heights[1]的值 （即1）
//	并且把0这个index放进去 就相当于 pop出来的数被当前的数替换了
//	6 与 5 pop出来之后 要把2放进去
//	通过把3 和 2 位置的heights改为值 2 
//	并且把index 2 放进去
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
//	其实我的思路和他们是一样的 就是在对于找left的时候 我选择了一个笨蛋办法
//	通过看了别人的答案 改进了自己关于index的方法
//	通过看stack中pop出来的index的前一个index 来判断自己能够波及的范围 而不是看自己的index！！
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
