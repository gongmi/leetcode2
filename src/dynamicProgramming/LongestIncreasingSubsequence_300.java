package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence_300 {
	//https://segmentfault.com/a/1190000003819886
	//或者看第二top的discuss的英文
	//可以参考IncreasingTripletSubsequence_334 length=3的情况 思想是一样的
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		// len表示当前最长的升序序列长度（为了方便操作tails我们减1）
		int len = 0;
		// tails[i]表示长度为i的升序序列其末尾的数字
		int[] tails = new int[nums.length];
		tails[0] = nums[0];
		// 根据三种情况更新不同升序序列的集合
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] <= tails[0]) //相等时就替换吧 替换花不了多少时间 但是可以节约下一个判断的写法
				tails[0] = nums[i];
			// 如果在中间，则二分搜索  要注意 当相等时就不要再搜索了 因为相等时搜索时间是最慢的 
			else if (nums[i] < tails[len]) 
				tails[binarySearch(tails, 0, len, nums[i])] = nums[i];
			else if (nums[i] > tails[len]) 
				tails[++len] = nums[i];
		}
		return len + 1;
	}
	//这个二分法是如果找到了 就返回 如果没找到 就返回它如果存在所处的位置
    private int binarySearch(int[] tails, int min, int max, int target){
        while(min <= max){
            int mid = min + (max - min) / 2;
            if(tails[mid] == target){
                return mid;
            }
            if(tails[mid] < target){
                min = mid + 1;
            }
            if(tails[mid] > target){
                max = mid - 1;
            }
        }
        return min;
    }
    //top 1 简洁的代码 一样的思想  Arrays.binarySearch的返回值解释
//    * @return index of the search key, if it is contained in the array
//    *         within the specified range;
//    *         otherwise   -(insertion point) - 1

// 如   int[] a= new int[]{1,3,5,6,7};
//	Arrays.binarySearch(a, 4)=-3;
//	Arrays.binarySearch(a, 0)=-1;
//	Arrays.binarySearch(a, 8)=-6;
    public int lengthOfLIS2(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);//如果没找到还原为应该存在的位置
            dp[i] = x;
            if(i == len) len++; //如果是加在dp数组的最后 则是产生了一个长度加一的新的LIS数组
        }

        return len;
    }
    
    // Follow-up: O(N) time for pre-processing, O(Mlog?) for each S.
    // Eg-1. s="abc", t="bahbgdca"
    // idx=[a={1,7}, b={0,3}, c={6}]
    //  i=0 ('a'): prev=1
    //  i=1 ('b'): prev=3
    //  i=2 ('c'): prev=6 (return true)
    // Eg-2. s="abc", t="bahgdcb"
    // idx=[a={1}, b={0,6}, c={5}]
    //  i=0 ('a'): prev=1
    //  i=1 ('b'): prev=6
    //  i=2 ('c'): prev=? (return false)
    public boolean isSubsequence(String s, String t) {
        List<Integer>[] idx = new List[256]; // Just for clarity
        for (int i = 0; i < t.length(); i++) {
            if (idx[t.charAt(i)] == null)
                idx[t.charAt(i)] = new ArrayList();
            idx[t.charAt(i)].add(i);
        }
        
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (idx[s.charAt(i)] == null) return false; // Note: char of S does NOT exist in T causing NPE
            int j = Collections.binarySearch(idx[s.charAt(i)], prev);
            if (j < 0) j = -j - 1;
            if (j == idx[s.charAt(i)].size()) return false;
            prev = idx[s.charAt(i)].get(j) + 1;
        }
        return true;
    }
}
