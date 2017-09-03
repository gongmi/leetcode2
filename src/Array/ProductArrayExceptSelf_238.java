package Array;

//主要是不能用除法
//所以可以把左边的乘出来  右边的乘出来

//Numbers:     2    3     4  	     5
//Lefts:       1    2   2*3 		 2*3*4
//Rights:  3*4*5  4*5     5   	     1
//We can calculate lefts and rights in 2 loops.
//The time complexity is O(n).

//We store lefts in result array. 
//To make it O(1), we just need to store it in a variable which is right 
public class ProductArrayExceptSelf_238 {
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		res[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}
		int right = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			res[i] = res[i] * right;
			right *= nums[i];
		}
		return res;
	}
}
