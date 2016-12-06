package bitManipulation;

public class SingleNumberII_137 {
	// ���˵Ĵ� 32��0
	// twos��0000000000000000000000
	// ones��0000000000000000000000

	// ��num����32λ�� ÿһλ������ӣ���twos ones ��λ��������һλ���ĳ��ֵĴ���
	// twos ones= 00>01>10>00 �൱���Ǽӷ� ģ��Ϊ3�ļӷ�
	//
	// public int singleNumber(int[] A) {
	// int ones = 0, twos = 0;
	// for(int i = 0; i < A.length; i++){
	// //���������ʽ�Ӵ����˰�λ��ģ��Ϊ3�ļӷ�
	// ones = (ones ^ A[i]) & ~twos;
	// twos = (twos ^ A[i]) & ~ones;
	// }
	// //��������ֻ������һ�� ��ô����00000000000��ģ��Ϊ3�ļӷ�����ones ^ A[i]
	// return ones;
	// }
	
	
	//��һ�������ط��� ����ʱ����32*n  �� �൱������ķ���һ������32λ��ģ3�ӷ�
	public int singleNumber(int[] A) {
		int result = 0;
		int bit1, sum;
		for (int j = 0; j < 32; j++) {
			sum = 0;
			bit1 = (1 << j); // set bit j as 1 others is 0
			for (int i = 0; i < A.length; i++) {
				if ((A[i] & bit1) != 0)
					sum++;// �����е����ĵ�jλΪ1�ļ�����
			}
			if ((sum % 3) != 0)
				result = result | bit1; // �����һλ��Ϊ1
		}
		return result;
	}

}
