package trie;

import java.util.*;
//No need to use StringBuilder. Storing word itself at leaf node is enough.
//No need to use HashSet to de-duplicate. Use "one time search" trie.

//20ms: Remove StringBuilder completely by storing word instead of boolean in TrieNode.
//20ms: Remove visited[m][n] completely by modifying board[i][j] = '#' directly.
//18ms: check validity, e.g., if(i > 0) dfs(...), before going to the next dfs.
//17ms: De-duplicate c - a with one variable i.

public class WordSearchII_212 {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		TrieNode root = buildTrie(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, root, res);
			}
		}
		return res;
	}

	public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
		char c = board[i][j];
		if (c == '#' || p.next[c - 'a'] == null)
			return;
		p = p.next[c - 'a'];
		if (p.word != null) { // found one
			res.add(p.word);
			p.word = null; // de-duplicate 这样只允许找一次
		}

		board[i][j] = '#';
		if (i > 0) // 提前终止递归 不要再dfs刚开始的时候终止
			dfs(board, i - 1, j, p, res);
		if (j > 0)
			dfs(board, i, j - 1, p, res);
		if (i < board.length - 1)
			dfs(board, i + 1, j, p, res);
		if (j < board[0].length - 1)
			dfs(board, i, j + 1, p, res);
		board[i][j] = c;
	}

	public TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String w : words) {
			TrieNode p = root;
			for (char c : w.toCharArray()) {
				int i = c - 'a';
				if (p.next[i] == null)
					p.next[i] = new TrieNode();
				p = p.next[i];
			}
			p.word = w;
		}
		return root;
	}

	class TrieNode {
		TrieNode[] next = new TrieNode[26];
		String word; // 官方是用boolean isWord 但是这道题 为了不再dfs数组的时候用StringBuilder
						// 来存放string 就在trie里放
	}
}