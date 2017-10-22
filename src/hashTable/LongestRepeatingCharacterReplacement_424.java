package hashTable;

public class LongestRepeatingCharacterReplacement_424 {
	// Ҳ�ǻ�������
	// һ��ʼ�����ھ��� ÿ������������ô�� freq�����Ǹ�char �ѵ��Ǳ���һ����
	// ��ʵ�����Ǹ�charֻ������ԭ���� �����Ǹ�char���¼�����Ǹ�char�бȽ�
	// ����maxCountֻ���ǵ����� ��ΪmaxCountԽ�� len�ſ���Խ�� ����
	// �ں����Ĵ����п��ܻ��и�С��maxCount ���ǲ�������
	public int characterReplacement(String s, int k) {
		int left = 0, right = 0;
		int maxCount = 0;
		int len = 0;
		int[] freq = new int[26];

		for (right = 0; right < s.length(); right++) {
			maxCount = Math.max(maxCount, ++freq[s.charAt(right) - 'A']);
			while (right - left + 1 - maxCount > k)
				freq[s.charAt(left++) - 'A']--;
			len = Math.max(len, right - left + 1);
		}
		return len;
	}
}
