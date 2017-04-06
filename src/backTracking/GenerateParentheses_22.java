package backTracking;

import java.util.ArrayList;
import java.util.List;

//哈哈 一下子就做出了
public class GenerateParentheses_22 {
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		backtrack(list, new StringBuilder(), n, 0, 0);
		return list;
	}

	private void backtrack(List<String> list, StringBuilder sb, int n, int left, int right) {
		if (sb.length() == 2 * n)
			list.add(sb.toString());
		if (left < n) {
			sb.append('(');
			backtrack(list, sb, n, left + 1, right);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (right < left) {
			sb.append(')');
			backtrack(list, sb, n, left, right + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
