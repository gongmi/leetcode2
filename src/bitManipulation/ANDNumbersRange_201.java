package bitManipulation;

public class ANDNumbersRange_201 {
	//�����������xor
	// m 0011 001
	// n 0011 111
//	xor  0000 110
//	�ҵ����������һ��Ϊ1��λ�� �����λ�ÿ�ʼ����Ķ���0 ǰ��� mn��ʲô����ʲô
//	�� return m&(1111 000)=0011 000=11 000
//	��������ô�ҵ����������һ��Ϊ1��λ��  ��������ʵ��û��һ�����ҵ�
//	���Ǵ���ߵڶ�λ��ʼ������λ ���m��n����һλ��һ���� ��(xor & bit1)=0
//	��ӽ��� ����������0��1  һ��������һ����λ ��ֹͣ
//	��ʵ�ҵ�˼���������ĵ����Ҿ����벻�����˵����ּ򵥵Ĵ���
	
	public int rangeBitwiseAnd(int m, int n) {
		int bit1 = 0x40000000;
		int result = 0;
        int xor=n ^ m;
		while (bit1 != 0) {
			if ((xor & bit1) ==bit1)//���m��n��bit1λ��һ��
				break;
			else {
				result = result + (n & bit1);
				bit1 = bit1 >> 1;
			}
		}
		return result;
	}
	
//	find the common prefix of m and n 's binary code.
//	��ʵ������m��n�������ǰ׺
//	keeping the common bits of m and n from left to right 
//	until the first bit that they are different, padding zeros for the rest.
//	����ʱ����ҵĳ� ��Ϊ��������ԱȽ�С����ʱ��� �ҵ��ǶԱȽϴ����ʱ���
	public int rangeBitwiseAnd2(int m, int n) {
	    int step = 0;
	    while(m!=n){//������ ֱ��m��nһ�� 
	        m >>= 1;
	        n >>= 1;
	        step ++;
	    }
	    return m<<step;//�����ƻ���
	}
	
	public int rangeBitwiseAnd3(int m, int n) {
	    int r=Integer.MAX_VALUE;//0x7fffffff
	    while((m&r)!=(n&r))  r=r<<1;
	    return n&r;
	}
	// m 0011 001
	// n 0011 111
//res    0011 000 	
	 public int rangeBitwiseAnd4(int m, int n) {
	        while(m<n) n = n & (n-1);
	        return n;
	    }
}
