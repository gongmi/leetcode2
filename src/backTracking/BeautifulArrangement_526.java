package backTracking;

//就是求满足条件的permutation的个数 求个数可以不用backtracking 而是用dp
//但是仿佛不能用dp
//而且 如果k从后往前 会快很多 因为当k很小时 总是很容易被满足 但是到后来可能就无法被满足 那么前面的都前功尽弃了

public class BeautifulArrangement_526 {
	int res = 0;
	boolean[] used;

	public int countArrangement(int N) {
		used = new boolean[N + 1];
		backTracking(N, N);
		return res;
	}

	private void backTracking(int N, int k) {
		if (k == 1) {
			res++;
			return;
		}
		for (int i = 1; i <= N; i++)
			if (!used[i] && (i % k == 0 || k % i == 0)) {
				used[i] = true;
				backTracking(N, k - 1);
				used[i] = false;

			}

	}
}
