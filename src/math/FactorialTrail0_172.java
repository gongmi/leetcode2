package math;

public class FactorialTrail0_172 {
	public int trailingZeroes2(int n) {
		int res = 0;
		while (n > 0) {
			res += n / 5;
			n = n / 5;
		}
		return res;
	}

	public int trailingZeroes(int n) {
		return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
	}
}
