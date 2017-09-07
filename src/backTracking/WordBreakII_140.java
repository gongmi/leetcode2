package backTracking;

import java.util.*;

public class WordBreakII_140 {
	private List<List<Integer>> indexs = new LinkedList<>();
	private HashSet<String> dict;

	// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
	// ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
	// ��һ��𰸳�ʱ ����ջ̫��
	// ��Ϊ�кܶ��ص������� ����aaaa ���Էֽ�Ϊ a+aaa aa+aa aaaa
	// ����s�кܶ�� aaaa ��Ҫȥ��
	// �����ӽṹ �ص������⣡��
	// Ӧ���ö�̬�滮!!! ����Ҫ��֮ǰ�������map������
	public List<String> wordBreak(String s, List<String> wordDict) {
		dict = new HashSet<>(wordDict);
		backTracking(s, 0, new LinkedList<Integer>());
		List<String> res = new LinkedList<String>();
		StringBuilder sb = null;
		for (List<Integer> list : indexs) {
			sb = new StringBuilder(s);
			int count = 0;
			for (int i : list) {
				sb.insert(i + count++, ' ');
			}
			res.add(sb.toString());
		}
		return res;
	}

	private void backTracking(String s, int i, LinkedList<Integer> list) {

		for (int j = i + 1; j <= s.length(); j++) {
			if (dict.contains(s.substring(i, j))) {
				if (j == s.length()) {
					indexs.add(new LinkedList<>(list));
					return;
				}
				list.add(j);
				backTracking(s, j, list);
				list.removeLast();
			}
		}
	}

	// �ڶ���� �ֳ�ʱ�� ��Ϊ���ظ���������HashSet
	// private HashMap<String, HashSet<String>> map = new HashMap<>();
	//
	// public List<String> wordBreak2(String s, List<String> wordDict) {
	// dict = new HashSet<>(wordDict);
	// return new LinkedList<String>(dfs(s));
	// }
	//
	// private HashSet<String> dfs(String s) {
	// if (map.containsKey(s))
	// return map.get(s);
	// HashSet<String> left;
	// HashSet<String> right;
	// HashSet<String> res = new HashSet<>();
	// for (int j = 1; j < s.length(); j++) {
	// left = dfs(s.substring(0, j));
	// right = dfs(s.substring(j, s.length()));
	// for (String l : left) {
	// for (String r : right) {
	// res.add(l + " " + r);
	// }
	// }
	// }
	// if (dict.contains(s))
	// res.add(s);
	// map.put(s, res);
	// return res;
	// }

	private HashMap<String, List<String>> map = new HashMap<>();

	public List<String> wordBreak3(String s, List<String> wordDict) {
		dict = new HashSet<>(wordDict);
		return dfs(s);
	}

	private List<String> dfs(String s) {
		if (map.containsKey(s))
			return map.get(s);

		List<String> right;
		List<String> res = new LinkedList<>();
		for (int j = 1; j < s.length(); j++) {
			if (dict.contains(s.substring(0, j))) {
				right = dfs(s.substring(j));
				for (String r : right) {
					res.add(s.substring(0, j) + " " + r);
				}
			}
		}
		if (dict.contains(s))
			res.add(s);
		map.put(s, res);
		return res;
	}
}
