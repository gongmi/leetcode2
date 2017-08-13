package binarySearch;

public class ValidPerfectSquare_367 {
	// 看到tag有binarySearch 就用了 但是超时了 其实是因为当num为很大时 mid*mid会溢出
	// 这样就会陷入无限的循环中 从而超时 其实时间复杂度是很低
	// 复杂度为 O(log(n))
	public boolean isPerfectSquare(int num) {
		if (num == 1 || num == 0)
			return true;
		long left = 1;
		long right = num;

		while (left <= right) {// 注意这边可以等于！！这是二分法的标准写法
			long mid = (left + right) / 2;
			if (mid * mid > num)
				right = mid - 1;
			else if (mid * mid < num)
				left = mid + 1;
			else
				return true;
		}
		return false;
	}

	// 复杂度为O(sqrt(n))
	public boolean isPerfectSquare2(int num) {
		int i = 1;
		while (num > 0) {
			num -= i;
			i += 2;
		}
		return num == 0;
	}
}
