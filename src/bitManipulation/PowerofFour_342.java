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
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position 
    }
    //通用方法
    // 326. Power of Three 
    public boolean isPowerOfFour3(int num) {
        return Integer.toString(num, 4).matches("10*");
    }
}
