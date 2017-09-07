package sort;

import java.util.*;

//�ⷨһ �ý�ָoffer ����Ե�˼· ������Ҫ����һ�ֽṹ ���������ԭ����index����
//�ⷨ�� ��BST ҲҪ����һЩ���� 

public class CountSmallerNumsAfterSelf_315 {

	Integer[] lower; // ��Ȼ�����������Ͳ�����asList ��ô���ð�װ��

	// �ⷨ1

	public List<Integer> countSmaller(int[] nums) {
		NumberIndex[] numberIndexs = new NumberIndex[nums.length];
		NumberIndex[] temp = new NumberIndex[nums.length];
		lower = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++) {
			numberIndexs[i] = new NumberIndex(nums[i], i);
		}
		InversePairsCore(numberIndexs, temp, 0, nums.length - 1);
		return Arrays.asList(lower);
	}

	private void InversePairsCore(NumberIndex[] a, NumberIndex[] temp, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			InversePairsCore(a, temp, left, mid);
			InversePairsCore(a, temp, mid + 1, right);
			Merge(a, temp, left, mid, right);
		}

	}

	private void Merge(NumberIndex[] a, NumberIndex[] temp, int leftStart, int leftPos, int rightPos) {
		int rightStart = leftPos + 1;
		int tempPos = rightPos;
		int numElements = rightPos - leftStart + 1;
		while (leftPos >= leftStart && rightPos >= rightStart) {
			if (a[leftPos].number > a[rightPos].number) {
				lower[a[leftPos].index] += rightPos - rightStart + 1; // ������仰��
				temp[tempPos--] = a[leftPos--];
			} else
				temp[tempPos--] = a[rightPos--];
		}
		while (leftPos >= leftStart)
			temp[tempPos--] = a[leftPos--];
		while (rightPos >= rightStart)
			temp[tempPos--] = a[rightPos--];

		for (int i = 0; i < numElements; i++, leftStart++)
			a[leftStart] = temp[leftStart];
	}

	// �ⷨ2
	Integer[] res;

	public List<Integer> countSmaller2(int[] nums) {
		int n = nums.length;
		res = new Integer[n];
		List<Integer> list = new LinkedList<>();

		if (n == 0)
			return list;

		TreeNode root = new TreeNode(nums[n - 1]);
		for (int i = n - 2; i >= 0; i--) {
			addNode(root, nums, i);
		}
		return Arrays.asList(res);
	}

	private TreeNode addNode(TreeNode root, int[] nums, int index) {
		int val = nums[index];
		if (root == null) {
			return new TreeNode(val);
		}
		if (val > root.val) {
			res[index] += (root.leftNodeCount + root.freq);
			root.right = addNode(root.right, nums, index);
		} else if (val < root.val) {
			root.leftNodeCount++;
			root.left = addNode(root.left, nums, index);
		} else {
			root.freq++;
			res[index] += root.leftNodeCount;
		}
		return root;
	}

	class NumberIndex {
		int number;
		int index;

		NumberIndex(int number, int index) {
			this.number = number;
			this.index = index;
		}
	}

	class TreeNode {
		int val;
		int leftNodeCount; // �������node����ߵĽ������ Ҳ�������������ĳ���� ��߱���С����������
		int freq;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
			this.freq = 1;
		}
	}

}