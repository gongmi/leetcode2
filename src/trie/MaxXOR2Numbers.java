package trie;

import java.util.HashSet;
import java.util.Set;

public class MaxXOR2Numbers {
	// 133 ms slow
	// ��һ��Trie���� ����0 ����1 �������߷ֱ�����Trie
	public class Trie {
		public Trie[] child;

		public Trie() {
			child = new Trie[2];
		}
	}

	public int findMaximumXOR(int[] nums) {
		Trie root = new Trie();
		Trie curTrie = root;
		for (int num : nums) {
			for (int i = 31; i >= 0; i--) {
				int bit = (num >>> i) & 1;
				if (curTrie.child[bit] == null)
					curTrie.child[bit] = new Trie();
				else
					curTrie = curTrie.child[bit];
			}
		}
		curTrie = root;
		int max = 0;

		for (int num : nums) {
			int CurNumMax = 0;
			for (int i = 31; i >= 0; i--) {
				int bit = (num >>> i) & 1;

				if (curTrie.child[bit ^ 1] != null) {
					curTrie = curTrie.child[bit ^ 1];
					CurNumMax = CurNumMax + (1 << i);
				} else
					curTrie = curTrie.child[bit];
			}
			max = Math.max(max, CurNumMax);
		}
		return max;
	}

	// ��2
	// mask������ �����λ��ʼ ��Ϊ1
	// set��װ���� ��ͬ��iʱ nums��mask��&
	// Ҳ����nums��ǰiλ
	// tmp�ŵ��ǵ�ǰ���ܵ�max ��iλΪ1
	// if a^b=c, then a^c=b, b^c=a
	// ��� ���set.contains(tmp ^ prefix)
	// ��ô���� set���� prefix1 ��prefix2 �� ^ ����tmp
	// Ҳ��������ϣ���� iλ=1 i��ߵ���Щλ ���ֲ���
	public int findMaximumXOR2(int[] nums) {
		int max = 0, mask = 0;
		for (int i = 31; i >= 0; i--) {
			mask = mask | (1 << i);
			Set<Integer> set = new HashSet<>();
			for (int num : nums) {
				set.add(num & mask);
			}
			// now find out if there are two prefix with different i-th bit
			// if there is, the new max should be current max with one 1 bit at
			// i-th position, which is candidate
			// and the two prefix, say A and B, satisfies:
			// A ^ B = candidate
			// so we also have A ^ candidate = B or B ^ candidate = A
			// thus we can use this method to find out if such A and B exists in
			// the set
			int tmp = max | (1 << i);
			for (int prefix : set) {
				if (set.contains(tmp ^ prefix)) {
					max = tmp;
					break;
				}
			}
		}
		return max;
	}
}
