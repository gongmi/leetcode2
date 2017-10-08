package greedy;

import java.util.Arrays;

public class JumpGameII_45 {
    //	第一版 答案超时 用的 JumpGame_55刚开始的思路
//	用一个数组来存到当前位置的minStep
//    [25000,24999,24998,24997,24996,24995,24994,24993,24992,24991,24990,24989,...,
// 50,49,48,47,46,45,44,43,42,41,40,...
// 16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,1,0]
//    其实一开始就能只2步
//    可是却多算了很多次呢
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int[] minSteps = new int[nums.length];
        Arrays.fill(minSteps, Integer.MAX_VALUE);
        minSteps[0] = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (minSteps[i] < Integer.MAX_VALUE) {
                for (int step = 1; step <= nums[i]; step++) {
                    if (i + step < nums.length)
                        minSteps[i + step] = Math.min(minSteps[i + step], minSteps[i] + 1);
                }

            }

        }
        return minSteps[nums.length - 1];
    }

    //修改了一下 其实不用去比较min
// 因为如果这个位置到过 那么一定是最小的
// 因为曾经达到过 那么你这次再去到 一定比之前多step、或者一样
    public int jump2(int[] nums) {
        if (nums.length <= 1) return 0;
        int[] minSteps = new int[nums.length];
        Arrays.fill(minSteps, -1);
        minSteps[0] = 0;
        int maxReach = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (minSteps[i] > -1 && i + nums[i] > maxReach) {
                for (int step = maxReach + 1; step <= i + nums[i]; step++) {
                    minSteps[step] = minSteps[i] + 1;
                    if (step == nums.length - 1) {
                        return minSteps[step];
                    }
                }
                maxReach = i + nums[i];
            }
        }
        return minSteps[nums.length - 1];
    }

    //    看了top答案 用的层序遍历的思想 BFS
//    改进后的代码
    public int jump3(int[] nums) {
        if (nums.length <= 1) return 0;
        int cur = 0;  //代表当前这一层的边界
        int next = 0; //代表下一层的边界
        int level = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == cur + 1) { // 如果到了之前那层的边界+1 说明到了下一层
                level++;
                cur = next;
            }
            next = Math.max(nums[i] + i, next);  // 看看下一层边界最大能有多大
            if (next >= nums.length - 1)
                return level + 1;

        }
        return level;
    }
}
