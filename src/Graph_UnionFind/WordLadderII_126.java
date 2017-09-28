package Graph_UnionFind;

import java.util.*;

public class WordLadderII_126 {
	List<List<String>> res = new LinkedList<>();

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		if (wordList == null || wordList.size() == 0)
			return res;
		if (!wordList.contains(beginWord)) // ����begin��wordlist���Ѿ����ڵ�string
											// �ٷŽ�ȥ��Ҫ�ظ���
			wordList.add(beginWord);
		Map<String, List<String>> map = computeAdjacentWords(wordList);
		findChain(map, beginWord, endWord);
		return res;
	}

	// �������ϵĴ�ֻ�ܹ�����һ��·�� Ϊ�˷��ؿ��ܵĶ���·�� �����ҵ�map ��value������list
	public void findChain(Map<String, List<String>> adjacentWords, String first, String second) {
		Map<String, List<String>> prevWords = new HashMap<>();
		Map<String, Integer> levels = new HashMap<>();
		Queue<String> q = new LinkedList<>();

		q.offer(first);
		int level = 0;
		while (!q.isEmpty()) {
			int count = q.size();
			level++;
			while (count-- > 0) {
				String current = q.poll();
				if (current.equals(second)) {
					prevWords.put(first, null);
					LinkedList<String> list = new LinkedList<String>();
					list.add(second);
					getChain(prevWords, second, list);
				}

				List<String> adj = adjacentWords.get(current);

				if (adj != null)
					for (String adjWord : adj) {
						if (prevWords.get(adjWord) == null) {
							prevWords.put(adjWord, new LinkedList<String>());
							levels.put(adjWord, level);
							prevWords.get(adjWord).add(current);
							q.add(adjWord);
						} else if (level == levels.get(adjWord))
							prevWords.get(adjWord).add(current);
					}
			}
		}
	}

	public void getChain(Map<String, List<String>> prev, String last, LinkedList<String> list) {
		if (prev.get(last) == null) {
			res.add(new LinkedList<String>(list));
			return;
		}
		for (String str : prev.get(last)) {
			list.addFirst(str);
			getChain(prev, str, list);
			list.removeFirst();
		}
	}

	// �����ڽӱ� ʹ��weiss�ķ��� �������������string�ĳ��ȶ���һ���� ���Կ��Ի���һ��
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
