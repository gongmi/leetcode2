package sort;

class Solution {
	class Trie {
		public Trie[] child = new Trie[2];
	}

	public int findMaximumXOR(int[] nums) {
		int bit1 = 0x40000000;
		Trie root = new Trie();
		Trie trie = root;
		for (int num : nums) {
			bit1 = 0x40000000;
			trie = root;
			while (bit1 > 0) {
				int curBit = bit1 & num;
				if (curBit != 0) {
					trie.child[1] = new Trie();
					trie = trie.child[1];
				} else {
					trie.child[0] = new Trie();
					trie = trie.child[0];
				}

				bit1 = bit1 >>> 1;
			}
		}
		int res = 0;
		int XOR = 0;

		for (int num : nums) {
			trie = root;
			bit1 = 0x40000000;
			XOR = 0;
			while (bit1 > 0) {
				int curBit = bit1 & num;
				if (curBit == 0) {
					if (trie.child[1] != null) {
						trie = trie.child[1];
						XOR = XOR | bit1;
					} else {
						trie = trie.child[0];
					}

				} else {
					if (trie.child[0] != null) {
						trie = trie.child[0];
						XOR = XOR | bit1;
					} else {
						trie = trie.child[1];
					}
				}
				bit1 = bit1 >>> 1;
			}
			res = Math.max(res, XOR);
		}
		return res;

	}
}