package hashTable;

public class CountPrimes_204 {
	// 普通方法会超时
	// public int countPrimes(int n) {
	// int res = 0;
	// for (int i = 2; i < n; i++)
	// if (testIsPrime(i)) res++;
	// return res;
	// }
	//
	// public boolean testIsPrime(int n) {
	// for (int i = 2; i <= Math.sqrt(n); i++) {
	// if (n % i == 0) return false;
	// }
	// return true;
	// }
	// Sieve of Eratosthenes 30 ms
	public int countPrimes(int n) {
		boolean[] notPrime = new boolean[n];
		int res = 0;
		for (int i = 2; i < n; i++) {
			if (!notPrime[i]) {
				res++;
				int k = 2;
				while (k * i < n)
					notPrime[k++ * i] = true;
			}
		}
		return res;
	}

	// 23 ms 优化了两个点
//	1 到sqrt(n)后 就不会有 是这个数的倍数 即要筛选掉的数了
//	2 k不用从2开始 因为 i 之前已经算过 2的倍数 3的倍数 所以要从 i*i开始筛
	
	public int countPrimes2(int n) {
		boolean[] notPrime = new boolean[n];
		int res = 0;
		for (int i = 2; i < n; i++) {
			if (!notPrime[i]) {
				res++;
				if (i < Math.sqrt(n))
					for (int k = i; k * i < n; k++)
						notPrime[k * i] = true;
			}
		}
		return res;
	}
}
