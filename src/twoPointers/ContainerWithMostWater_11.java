package twoPointers;
//  ������˼��������
//Ϊʲô ����index�Ƚϴ�С ��Ҫ��С���Ǹ��ƶ��أ�
//�ٸ����� ��height1>height10
//���ʱ��˵�� area�Ǳ�height10����Լ��
//��������� right���� left++�� area����ȵ�ǰ���area����С
//��Ϊarea=height10*9
//��leftһֱ���ӵĹ����� ��ȱ�С�� �߶�Ҳ�����ܳ���height10
//��� ���ǲ�Ҫ�ƶ�left  �����ƶ�right ȥ��Ѱ���ܸ����area

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
