package dynamicProgramming;

import java.util.List;

public class Triangle_120 {
	//这样不用任何space但是慢 因为get set方法很浪费时间的
	//我是 从上到下 别人的是从下到上 这样不用考虑边界
	public int minimumTotal(List<List<Integer>> triangle) {

		for (int i = 1; i < triangle.size(); i++)
			for (int j = 0; j < i; j++) {
				if (j == 0)
					triangle.get(i)
							.set(j,
									triangle.get(i).get(j)
											+ triangle.get(i - 1).get(j));
				else if (j == triangle.get(i).size() - 1)
					triangle.get(i).set(
							j,
							triangle.get(i).get(j)
									+ triangle.get(i - 1).get(j - 1));
				else
					triangle.get(i).set(
							j,
							triangle.get(i).get(j)
									+ Math.min(triangle.get(i - 1).get(j - 1),
											triangle.get(i - 1).get(j)));
			}
		int min = Integer.MAX_VALUE;
		for (int i : triangle.get(triangle.size() - 1))
			min = Math.min(i, min);
		return min;

	}
//	11ms  从下到上
    public int minimumTotal2(List<List<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >= 0; i--)
            for(int j = 0; j <= i; j++)
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        return triangle.get(0).get(0);
    }
//    5ms  从下到上 并且用一个数组来存 这样不用set
    public int minimumTotal3(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<i+1;j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}
