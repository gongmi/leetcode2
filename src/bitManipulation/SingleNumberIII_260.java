package bitManipulation;

public class SingleNumberIII_260 {
	public int[] singleNumber(int[] nums) {
		int xor = 0;

		for (int i : nums)
			xor ^= i;

		xor = xor ^ (xor & (xor - 1));//这里我没有用减脂offer的方法找第一个为1的位置
        //或者xor&= -xor；
		//负数表示为原码取反加一
		
		int xor1 = 0, xor2 = 0;

		for (int i : nums)
			if ((xor & i) != 0)
				xor1 ^= i;
			else
				xor2 ^= i;

		return new int[] { xor1, xor2 };
	}
}
