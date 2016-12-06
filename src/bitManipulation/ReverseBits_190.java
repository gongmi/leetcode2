package bitManipulation;

public class ReverseBits_190 {
	 // you need treat n as an unsigned value
	//首先把第一位符号位 置为0
	public int reverseBits(int n) {
		int bit32 = 0;
		if ((n & 0x80000000) != 0) {
			n = n ^ 0x80000000;
			bit32 = 1;
		}
		int temp = 0;
		int result = 0;
		int i = 1;
		int bit = 0;
		while (n != 0) {
			temp = n >> 1;
			bit = n - (temp << 1);
			if (bit == 1)
				result = result + (bit << (32 - i));
			n = temp;
			i++;
		}
		return result + bit32;
	}
	
	//java中有     >>>  无符号右移！！！
	//并且要判断n每一位是多少可以不用上面的方法
//	temp = n >> 1;
//	bit = n - (temp << 1);
//	可以用 n & 1
	public int reverseBits2(int n) {

		int result = 0;
		int i = 1;
		int bit = 0;
		while (n != 0) {
			bit =  n & 1;
			if (bit == 1)
				result = result + (bit << (32 - i));
			n=n>>>1;
			i++;
		}
		return result;
	}
	
	//别人的方法
	//我的result的每一个bit是一次性移到位
	//别人是移动32遍 每一遍所有位移动一下
	public int reverseBits3(int n) {
	    int result = 0;
	    for (int i = 0; i < 32; i++) {
	        result += n & 1;
	        n >>>= 1;   // CATCH: must do unsigned shift
	        if (i < 31) // CATCH: for last digit, don't shift!
	            result <<= 1;
	    }
	    return result;
	}
}
