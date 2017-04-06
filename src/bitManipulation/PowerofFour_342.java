package bitManipulation;

public class PowerofFour_342 {
	//我的方法 因为我会power of two 所以我先开方
	public boolean isPowerOfFour(int num) {
		double num_sqrt = Math.sqrt(num);
		if (num_sqrt * num_sqrt != num)
			return false;

		return (num > 0 && (num & (num - 1)) == 0);

	}
	
    public boolean isPowerOfFour2(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
        //0x55555555  保证了bit为1的那一位在奇数位上 比如说1 4 16 64
    }
   
    // 326. Power of Three 
    //通用方法 运用 Integer.toString方法 可以设置转换成几进制 
    public boolean isPowerOfFour3(int num) {
        return Integer.toString(num, 4).matches("10*");
    }
}
