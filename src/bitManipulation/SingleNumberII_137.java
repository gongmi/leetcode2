package bitManipulation;

public class SingleNumberII_137 {
	// 别人的答案 32个0
	// twos：0000000000000000000000
	// ones：0000000000000000000000

	// 将num按照32位数 每一位各自相加，用twos ones 两位来代表这一位数的出现的次数
	// twos ones= 00>01>10>00 相当于是加法 模数为3的加法
	//
	// public int singleNumber(int[] A) {
	// int ones = 0, twos = 0;
	// for(int i = 0; i < A.length; i++){
	// //下面的两个式子代表了按位的模数为3的加法
	// ones = (ones ^ A[i]) & ~twos;
	// twos = (twos ^ A[i]) & ~ones;
	// }
	// //如果这个数只出现了一次 那么它与00000000000的模数为3的加法就是ones ^ A[i]
	// return ones;
	// }
	
	
	//另一种清晰地方法 但是时间是32*n  的 相当于上面的方法一把算了32位的模3加法
	public int singleNumber(int[] A) {
		int result = 0;
		int bit1, sum;
		for (int j = 0; j < 32; j++) {
			sum = 0;
			bit1 = (1 << j); // set bit j as 1 others is 0
			for (int i = 0; i < A.length; i++) {
				if ((A[i] & bit1) != 0)
					sum++;// 把所有的数的第j位为1的加起来
			}
			if ((sum % 3) != 0)
				result = result | bit1; // 则把这一位置为1
		}
		return result;
	}

}
