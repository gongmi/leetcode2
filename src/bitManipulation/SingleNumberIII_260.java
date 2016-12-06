package bitManipulation;

public class SingleNumberIII_260 {
	public int[] singleNumber(int[] nums) {
		int xor = 0;

		for (int i : nums)
			xor ^= i;

		xor = xor ^ (xor & (xor - 1));//������û���ü�֬offer�ķ����ҵ�һ��Ϊ1��λ��
        //����xor&= -xor��
		//������ʾΪԭ��ȡ����һ
		
		int xor1 = 0, xor2 = 0;

		for (int i : nums)
			if ((xor & i) != 0)
				xor1 ^= i;
			else
				xor2 ^= i;

		return new int[] { xor1, xor2 };
	}
}
