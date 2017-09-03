package trie;

class TrieNode {
	public boolean isWord;
	public TrieNode[] next;

	public TrieNode() {
		next = new TrieNode[26];
	}
}

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (node.next[c - 'a'] == null) {
				node.next[c - 'a'] = new TrieNode();
			}
			node = node.next[c - 'a'];
		}
		node.isWord = true;
	}

	public boolean search(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (node.next[c - 'a'] == null)
				return false;
			node = node.next[c - 'a'];
		}
		return node.isWord;
	}

	public boolean startsWith(String prefix) {
		TrieNode node = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (node.next[c - 'a'] == null)
				return false;
			node = node.next[c - 'a'];
		}
		return true;
	}
}
