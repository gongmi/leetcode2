package stack;

import java.util.List;
import java.util.Stack;

//top´ð°¸  ¼û±Ê¼Ç
public class ExclusiveTimeofFunctions_636 {
	public int[] exclusiveTime(int n, List<String> logs) {
		int[] res = new int[n];
		Stack<Integer> stack = new Stack<>();
		int preTime = 0;
		for (String s : logs) {
			String[] log = s.split(":");
			if (!stack.isEmpty())
				res[stack.peek()] += Integer.parseInt(log[2]) - preTime;
			preTime = Integer.parseInt(log[2]);
			if (log[1].equals("end")) {
				res[stack.pop()]++;
				preTime++;
			} else {
				stack.push(Integer.parseInt(log[0]));
			}

		}
		return res;
	}
}
