package hashTable;

public class BullsAndCows_299 {
	// 我的方法 3ms
	public String getHint(String secret, String guess) {
		int[] frequency = new int[10];
		int A = 0, B = 0, diff = 0;
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i))
				A++;
			else {
				frequency[secret.charAt(i) - '0']++;
				frequency[guess.charAt(i) - '0']--;
			}
		}
		for (int freq : frequency) {
			if (freq > 0)
				diff += freq;
		}
		B = secret.length() - A - diff;
		String res = "" + A + 'A' + B + 'B';
		return res;
	}

	// 别人的差不多 我相当于是在最后算完了之后再计算有多少diff
//	别人的是 在算的过程中 当发现原来是负的的时候 secret有一个 就加一
//	或者 当然先原来是正的的时候 guess有一个 也加1
	public String getHint2(String secret, String guess) {
		int bulls = 0;
		int cows = 0;
		int[] numbers = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i))
				bulls++;
			else {
				if (numbers[secret.charAt(i) - '0']++ < 0)
					cows++;
				if (numbers[guess.charAt(i) - '0']-- > 0)
					cows++;
			}
		}
		return bulls + "A" + cows + "B";
	}
}
