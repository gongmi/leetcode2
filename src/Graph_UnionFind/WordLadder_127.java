package Graph_UnionFind;

import java.util.*;

public class WordLadder_127 {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (wordList == null || wordList.size() == 0)
			return 0;
		wordList.add(beginWord);
		Map<String, List<String>> map = computeAdjacentWords(wordList);
		HashSet<String> visited = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		q.offer(beginWord);
		visited.add(beginWord);
		int len = 0;
		while (!q.isEmpty()) {
			int count = q.size();
			len++;
			while (count-- > 0) {
				String cur = q.poll();
				if (cur.equals(endWord))
					return len;
				List<String> adj = map.get(cur);
				if (adj == null)
					return 0;
				for (String s : adj) {
					if (!visited.contains(s)) {
						q.offer(s);
						visited.add(s);
					}
				}
			}
		}
		return 0;
	}

	// 构建邻接表 使用weiss的方法 由于这道题所有string的长度都是一样的 所以可以化简一下
	public Map<String, List<String>> computeAdjacentWords(List<String> words) {
		Map<String, List<String>> adjWords = new HashMap<>();

		for (int i = 0; i < words.get(0).length(); i++) {
			Map<String, List<String>> repToWord = new HashMap<>();

			for (String str : words) {
				String rep = str.substring(0, i) + str.substring(i + 1);
				update(repToWord, rep, str);
			}

			for (List<String> wordClique : repToWord.values())
				if (wordClique.size() >= 2)
					for (String s1 : wordClique)
						for (String s2 : wordClique)
							if (s1 != s2)
								update(adjWords, s1, s2);
		}

		return adjWords;
	}

	private void update(Map<String, List<String>> m, String key, String value) {
		List<String> lst = m.get(key);
		if (lst == null) {
			lst = new ArrayList<>();
			m.put(key, lst);
		}

		lst.add(value);
	}
}
