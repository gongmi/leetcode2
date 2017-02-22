package backTracking;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch_401 {
//	�ҵĴ� 5ms ����ֱ�Ӱ���10��������ƽ�е� ������0-9������  
//	Ȼ����Combinations_77 ��� ��10������ѡn����
//	Ȼ���ٷ������ǵ� �� �����hour �� min
	public List<String> readBinaryWatch(int num) {
		List<String> res = new ArrayList<>();
		backtrack(res, new ArrayList<Integer>(), num, 0);
		return res;
	}

	private void backtrack(List<String> res, List<Integer> tempList, int num,
			int start) {
		if (tempList.size() == num) {
			int hour = 0;
			int min = 0;
			for (int i : tempList) {
				if (i > 5)
					hour += 8 >> (9 - i);
				else
					min += 32 >> (5 - i);
			}
			if (min < 10 && hour < 12)
				res.add("" + hour + ':' + '0' + min);
			else if (min < 60 && hour < 12)
				res.add("" + hour + ':' + min);
			return;
		}
		for (int i = start; i < 10; i++) {
			tempList.add(i);
			backtrack(res, tempList, num, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
	
//	top �� 3ms
//	������������ �ֱ��� ����generateDigit���ֱ���� hour �� min ��ֱ�Ӳ����ͣ�
	public List<String> readBinaryWatch2(int num) {
        List<String> res = new ArrayList<>();
        int[] nums1 = new int[]{8, 4, 2, 1}, nums2 = new int[]{32, 16, 8, 4, 2, 1};
        for(int i = 0; i <= num; i++) {
            List<Integer> list1 = generateDigit(nums1, i);
            List<Integer> list2 = generateDigit(nums2, num - i);
            for(int num1: list1) {
                if(num1 >= 12) continue;
                for(int num2: list2) {
                    if(num2 >= 60) continue;
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                }
            }
        }
        return res;
    }

    private List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> res = new ArrayList<>();
        generateDigitHelper(nums, count, 0, 0, res);
        return res;
    }
// count��Ÿ��� sum������ǵ� ��
    private void generateDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> res) {
        if(count == 0) {
            res.add(sum);
            return;
        }
        for(int i = pos; i < nums.length; i++) {
            generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], res);    
        }
    }
}

