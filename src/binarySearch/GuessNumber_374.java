package binarySearch;

public class GuessNumber_374 {

	/*
	 * The guess API is defined in the parent class GuessGame.
	 * @param num, your guess
	 * @return -1 if my number is lower, 1 if my number is higher, otherwise
	 * return 0 int guess(int num);
	 */
	// 这是我自己加的 防止程序报错
	class GuessGame {
		public int guess(int i) {
			return 0;
		}
	}


	public class Solution extends GuessGame {
		public int guessNumber(int n) {
			int low = 1;
			int high = n;
			int mid = (low + high) >>> 1;// 这里如果我用/2 就会超时
			// 因为low+high可能会溢出变成了负数 然后就一直循环
			// 用这个最佳： int mid = i + (j - i) / 2;
			while (true) {
				mid = (low + high) >>> 1;
				if (guess(mid) > 0)
					low = mid + 1;
				else if (guess(mid) < 0)
					high = mid - 1;
				else
					return mid;
			}
		}
	}

}