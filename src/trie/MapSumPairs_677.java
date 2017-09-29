package trie;

import java.util.*;

public class MapSumPairs_677 {
	class TrieNode {
		TrieNode[] children;
		int sum = 0;

		public TrieNode() {
			this.children = new TrieNode[26];
		}
	}

	HashMap<String, Integer> map = new HashMap<>();
	TrieNode root = new TrieNode();

	public MapSumPairs_677() {

	}

	public void insert(String key, int val) {
		val = val - map.getOrDefault(key, 0);
		map.put(key, val);
		TrieNode temp = root;
		for (char c : key.toCharArray()) {
			if (temp.children[c - 'a'] == null) {
				temp.children[c - 'a'] = new TrieNode();
			}
			temp.children[c - 'a'].sum += val;
			temp = temp.children[c - 'a'];
		}
	}

	public int sum(String prefix) {
		TrieNode temp = root;
		for (char c : prefix.toCharArray()) {
			if (temp.children[c - 'a'] == null) {
				return 0;
			}
			temp = temp.children[c - 'a'];
		}
		return temp.sum;
	}
}
