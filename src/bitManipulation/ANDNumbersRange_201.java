package bitManipulation;

public class ANDNumbersRange_201 {
	//先求出两个的xor
	// m 0011 001
	// n 0011 111
//	xor  0000 110
//	找到从左边数第一个为1的位置 从这个位置开始后面的都是0 前面的 mn是什么就是什么
//	即 return m&(1111 000)=0011 000=11 000
//	问题是怎么找到从左边数第一个为1的位置  所以我其实并没有一下子找到
//	而是从左边第二位开始向右移位 如果m与n的这一位是一样的 即(xor & bit1)=0
//	则加进来 不管他们是0是1  一旦遇到不一样的位 则停止
//	其实我的思想是这样的但是我就是想不到别人的那种简单的代码
	
	public int rangeBitwiseAnd(int m, int n) {
		int bit1 = 0x40000000;
		int result = 0;
        int xor=n ^ m;
		while (bit1 != 0) {
			if ((xor & bit1) ==bit1)//如果m与n的bit1位不一样
				break;
			else {
				result = result + (n & bit1);
				bit1 = bit1 >> 1;
			}
		}
		return result;
	}
	
//	find the common prefix of m and n 's binary code.
//	其实就是找m与n的最长公共前缀
//	keeping the common bits of m and n from left to right 
//	until the first bit that they are different, padding zeros for the rest.
//	但是时间比我的长 因为这个方法对比较小的数时间短 我的是对比较大的数时间短
	public int rangeBitwiseAnd2(int m, int n) {
	    int step = 0;
	    while(m!=n){//先右移 直到m与n一样 
	        m >>= 1;
	        n >>= 1;
	        step ++;
	    }
	    return m<<step;//再左移回来
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
