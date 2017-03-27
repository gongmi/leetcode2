package stack;

import java.util.Stack;
//这道题做得很巧妙 特别是s.isEmpty()? 的三目运算符 要学会使用啊！
public class TrappingRainWater_42 {
	public int trap(int[] A) {
        if (A==null) return 0;
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, maxWater = 0, maxBotWater = 0;
        while (i < A.length){
            if (s.isEmpty() || A[i]<=A[s.peek()]){
                s.push(i++);
            }
            else {
                int bot = s.pop();
                maxBotWater = s.isEmpty()? // empty means no il
                0:(Math.min(A[s.peek()],A[i])-A[bot])*(i-s.peek()-1);
                maxWater += maxBotWater;
            }
        }
        return maxWater;
    }
//	input [3,2,1,0,0,0,2,1,3]
//	s= 3 2 1 0 0 0
//	s= 3 2 1 0 0 
//	s= 3 2 1 0 
//	s= 3 2 1 
//	s= 3 2 
//	s= 3 2 2
//	s= 3 2 2 1
//	s= 3 2 2
//	s= 3 2 
//	s= 3 
//	s= 3 3
}
