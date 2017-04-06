package bitManipulation;

public class PowerofFour_342 {
	//�ҵķ��� ��Ϊ�һ�power of two �������ȿ���
	public boolean isPowerOfFour(int num) {
		double num_sqrt = Math.sqrt(num);
		if (num_sqrt * num_sqrt != num)
			return false;

		return (num > 0 && (num & (num - 1)) == 0);

	}
	
    public boolean isPowerOfFour2(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
        //0x55555555  ��֤��bitΪ1����һλ������λ�� ����˵1 4 16 64
    }
   
    // 326. Power of Three 
    //ͨ�÷��� ���� Integer.toString���� ��������ת���ɼ����� 
    public boolean isPowerOfFour3(int num) {
        return Integer.toString(num, 4).matches("10*");
    }
}
