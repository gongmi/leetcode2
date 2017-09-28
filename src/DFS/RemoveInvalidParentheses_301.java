package DFS;

import java.util.*;

public class RemoveInvalidParentheses_301 {
	public List<String> removeInvalidParentheses(String s) {
		int rmL = 0, rmR = 0;// 用这两个变量来记录 需要删除的左括号 和右括号个数
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				rmL++;
			} else if (s.charAt(i) == ')') {
				if (rmL != 0) {
					rmL--;
				} else {
					rmR++;
				}
			}
		}
		Set<String> res = new HashSet<>();
		dfs(s, 0, res, new StringBuilder(), rmL, rmR, 0);
		return new ArrayList<String>(res);
	}

	// open表示有多少左括号 出现左括号 加一 出现右括号减一
	public void dfs(String s, int i, Set<String> res, StringBuilder sb, int rmL, int rmR, int open) {
		if (rmL < 0 || rmR < 0 || open < 0) {
			return;
		}
		if (i == s.length()) {
			if (rmL == 0 && rmR == 0 && open == 0) { // 当应该删除的都删除了 并且open正确了
														// 就是valid的括号序列
				res.add(sb.toString());
			}
			return;
		}

		char c = s.charAt(i);
		int len = sb.length();

		if (c == '(') {
			dfs(s, i + 1, res, sb, rmL - 1, rmR, open); // not use (
			dfs(s, i + 1, res, sb.append(c), rmL, rmR, open + 1); // use (

		} else if (c == ')') {
			dfs(s, i + 1, res, sb, rmL, rmR - 1, open); // not use )
			dfs(s, i + 1, res, sb.append(c), rmL, rmR, open - 1); // use )

		} else {
			dfs(s, i + 1, res, sb.append(c), rmL, rmR, open);
		}

		sb.setLength(len);// 就是sb放弃后来递归的append的那些char 回到dfs前的sb
	}
}
