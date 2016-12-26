package hashTable;

public class BullsAndCows_299 {
	// �ҵķ��� 3ms
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

	// ���˵Ĳ�� ���൱���������������֮���ټ����ж���diff
//	���˵��� ����Ĺ����� ������ԭ���Ǹ��ĵ�ʱ�� secret��һ�� �ͼ�һ
//	���� ��Ȼ��ԭ�������ĵ�ʱ�� guess��һ�� Ҳ��1
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
