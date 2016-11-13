package dynamicProgramming;

public class ArithmeticSlices_413 {
	public int numberOfArithmeticSlices(int[] A) {
		int length = A.length;
		// int[] counts = new int[length+1];
		// counts[0] = 0;
		// counts[1] = 0;
		// counts[2] = 0;
		// counts[3] = 1;
		// for (int i = 4; i < A.length+1; i++)
		// counts[i] = 2 * counts[i - 1] + 1; 
		//֮ǰ�ı�������� �븴���� ��ʵ����1+2+3+������+n-2
		// ����diff��������slices
        if (length<3) return 0;
		int[] B = new int[length - 1];
		for (int i = 1; i < length; i++)
			B[i - 1] = A[i] - A[i - 1];

		int difference = B[0];
		int n = 1;
		int total = 0;
		for (int i = 1; i < length - 1; i++) {
			if (B[i] == difference) {
				n++;
				if (i == length - 2)//��ͷ��
					total = total + sum(n + 1);
			} else {//��֮ǰ������diff ��һ����diff��
				difference = B[i];
				if (n > 1) total = total + sum(n + 1);
                n=1;
			}
		}
		return total;
	}

	public int sum(int n) { //1+2+3+...+n-1 
		int s = 0;
		for (int i = 1; i < n - 1; i++)
			s = s + i;
		return s;

	}
	// ���˵Ĵ��� ��ô�� ��ʵ��һ����˼��	
// 	public int numberOfArithmeticSlices(int[] A) {
//     int curr = 0, sum = 0;
//     for (int i=2; i<A.length; i++)
//         if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
//             curr += 1;
//             sum += curr;
//         } else {
//             curr = 0;
//         }
//     return sum;
// }
}
