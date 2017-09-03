package trie;

import java.util.List;

public class ReplaceWords_648 {

	public class TrieNode {
		TrieNode[] children;
		boolean isWord;

		public TrieNode() {
			this.children = new TrieNode[26];
		}
	}

	// top �� ����һ����˼�� ֻ������д�ĸ���
	public String replaceWords(List<String> dict, String sentence) {
		String[] tokens = sentence.split(" ");
		TrieNode trie = buildTrie(dict);
		return replaceWords(tokens, trie);
	}

	private String replaceWords(String[] tokens, TrieNode root) {
		for (int i = 0; i < tokens.length; i++) {
			tokens[i] = getReplace(tokens[i], root);
		}
		return String.join(" ", tokens);
	}

	private String getReplace(String token, final TrieNode root) {
		TrieNode temp = root;
		StringBuilder stringBuilder = new StringBuilder();
		for (char c : token.toCharArray()) {
			stringBuilder.append(c);
			if (temp.children[c - 'a'] != null) {
				if (temp.children[c - 'a'].isWord) {
					return stringBuilder.toString();
				}
				temp = temp.children[c - 'a'];
			} else {
				return token;
			}
		}
		return token;
	}

	private TrieNode buildTrie(List<String> dict) {
		TrieNode root = new TrieNode();
		for (String word : dict) {
			TrieNode temp = root;
			for (char c : word.toCharArray()) {
				if (temp.children[c - 'a'] == null) {
					temp.children[c - 'a'] = new TrieNode();
				}
				temp = temp.children[c - 'a'];
			}
			temp.isWord = true;
		}
		return root;
	}

	// �ҵĵ�һ��� д���е㸴�� ����˼·����ȷ��

}
