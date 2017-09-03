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

	// top 答案 和我一样的思想 只不过他写的更简单
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

	// 我的第一版答案 写的有点复杂 但是思路是正确的

}
