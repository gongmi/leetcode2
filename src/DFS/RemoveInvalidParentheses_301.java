package DFS;

import java.util.*;

public class RemoveInvalidParentheses_301 {
	public List<String> removeInvalidParentheses(String s) {
		int rmL = 0, rmR = 0;// ����������������¼ ��Ҫɾ���������� �������Ÿ���
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

	// open��ʾ�ж��������� ���������� ��һ ���������ż�һ
	public void dfs(String s, int i, Set<String> res, StringBuilder sb, int rmL, int rmR, int open) {
		if (rmL < 0 || rmR < 0 || open < 0) {
			return;
		}
		if (i == s.length()) {
			if (rmL == 0 && rmR == 0 && open == 0) { // ��Ӧ��ɾ���Ķ�ɾ���� ����open��ȷ��
														// ����valid����������
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

		sb.setLength(len);// ����sb���������ݹ��append����Щchar �ص�dfsǰ��sb
	}
}
