package twoPointers;
//  这道题的思想很巧妙的
//为什么 两个index比较大小 就要把小的那个移动呢？
//举个例子 当height1>height10
//这个时候说明 area是被height10所制约的
//因此在所有 right不动 left++的 area都会比当前这个area来的小
//因为area=height10*9
//在left一直增加的过程中 宽度变小了 高度也不可能超过height10
//因此 我们不要移动left  而是移动right 去找寻可能更大的area

public class ContainerWithMostWater_11 {
	public int maxArea(int[] height) {
		int max = 0;
		int i = 0, j = height.length - 1;
		while (i < j) {
			int area = Math.min(height[i], height[j]) * (j - i);
			if (area > max)
				max = area;
			if (height[i] > height[j])
				j--;
			else
				i++;
		}
		return max;
	}
}
