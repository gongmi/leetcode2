package dynamicProgramming;

import java.util.*;

//带memo的
public class WordBreakII_140 {
	private HashSet<String> dict;
	private HashMap<String, List<String>> map = new HashMap<>();

	public List<String> wordBreak(String s, List<String> wordDict) {
		dict = new HashSet<>(wordDict);
		return dfs(s);
	}

	private List<String> dfs(String s) {
		if (map.containsKey(s))
			return map.get(s);

		List<String> right;
		List<String> res = new LinkedList<>();
		for (int j = 1; j < s.length(); j++) {
			if (dict.contains(s.substring(0, j))) { //左边定住 不要把左边也dfs
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
