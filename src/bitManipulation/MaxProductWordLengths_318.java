package bitManipulation;

public class MaxProductWordLengths_318 {
//	ok,int has 32bits,but lower case letters only has 26 .
//	we can use the lowest 26 bit of int indicates that 
//	the word has how many kinds of lower case letters .
//	If the lowest bit of int is 1,it indicates the word has  'a'..
//	��һ��� �����Ȱ��ַ���ת��Ϊ��������
//	Ȼ�����������&��Ϊ0˵������ͬ��char ������Ҫ��
//	���Ϊ0 �������Ǹ�
	public int maxProduct(String[] words) {
		int n = words.length;
		int[] bit_word = new int[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < words[i].length(); j++)
				bit_word[i] = bit_word[i] | (1 << (words[i].charAt(j) - 'a'));
		}
		int max = 0;

		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				if ((bit_word[i] & bit_word[j]) == 0)
					max = Math.max(max, words[i].length() * words[j].length());

		return max;
	}
}
