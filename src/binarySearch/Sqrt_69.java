package binarySearch;

public class Sqrt_69 {
	// 我的第一版答案 因为最后剩下两个时 难以判断 所以我就跳出来判断了
	public int mySqrt(int x) {
		if (x <= 0)
			return x;
		long i = 1;
		long j = x;
		long mid = (i + j) / 2;
		while (i + 1 < j) {
			mid = (i + j) / 2;
			if (mid * mid > x)
				j = mid - 1;
			else if (mid * mid < x)
				i = mid;
			else
				return (int) mid;
		}

		if (j * j < x)
			return (int) j;
		return (int) i;

	}

	// top 答案
	// 用mid == x / mid 而不是 mid * mid == x
	// 但是isPerfectSquare不可以 因为它需要准确的 mid*mid=x
	// 这道题 不需要准确的double值
	// 只需要int 比如 x=17
	// mid=4时
	// mid=x/mid 即 4=17/4
	public int mySqrt2(int x) {
		int left = 1, right = x;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mid == x / mid) {
				return mid;
			} else if (mid < x / mid) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return right;
	}
}
