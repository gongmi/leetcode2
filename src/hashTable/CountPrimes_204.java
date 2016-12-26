package hashTable;

public class CountPrimes_204 {
	// ��ͨ�����ᳬʱ
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

	// 23 ms �Ż���������
//	1 ��sqrt(n)�� �Ͳ����� ��������ı��� ��Ҫɸѡ��������
//	2 k���ô�2��ʼ ��Ϊ i ֮ǰ�Ѿ���� 2�ı��� 3�ı��� ����Ҫ�� i*i��ʼɸ
	
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
