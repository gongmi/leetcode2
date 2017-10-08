package greedy;

import java.util.Arrays;

public class JumpGameII_45 {
    //	��һ�� �𰸳�ʱ �õ� JumpGame_55�տ�ʼ��˼·
//	��һ���������浽��ǰλ�õ�minStep
//    [25000,24999,24998,24997,24996,24995,24994,24993,24992,24991,24990,24989,...,
// 50,49,48,47,46,45,44,43,42,41,40,...
// 16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,1,0]
//    ��ʵһ��ʼ����ֻ2��
//    ����ȴ�����˺ܶ����
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

    //�޸���һ�� ��ʵ����ȥ�Ƚ�min
// ��Ϊ������λ�õ��� ��ôһ������С��
// ��Ϊ�����ﵽ�� ��ô�������ȥ�� һ����֮ǰ��step������һ��
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

    //    ����top�� �õĲ��������˼�� BFS
//    �Ľ���Ĵ���
    public int jump3(int[] nums) {
        if (nums.length <= 1) return 0;
        int cur = 0;  //����ǰ��һ��ı߽�
        int next = 0; //������һ��ı߽�
        int level = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == cur + 1) { // �������֮ǰ�ǲ�ı߽�+1 ˵��������һ��
                level++;
                cur = next;
            }
            next = Math.max(nums[i] + i, next);  // ������һ��߽�������ж��
            if (next >= nums.length - 1)
                return level + 1;

        }
        return level;
    }
}
