package dynamicProgramming;

public class ClimbingStairs_70 {
	//��ô���ܿ�������Ѳ��ɴ����� ��������÷Ѳ��ɴ��������ݹ�Ļ� �ظ����˺ܶ� ���������Ե�����
//	������һ��һά���� int��n�� ���ǻ�����ֻ����������
//	��Ϊ climbStairs[n]=climbStairs[n-1]+climbStairs[n-2]
    public int climbStairs(int n) {
    if(n <= 0) return 0;
    if(n == 1) return 1;
    if(n == 2) return 2;
    int prev1 = 2;
    int prev2 = 1;
    int all_ways = 0;
    
    for(int i=3; i<=n; i++){
    	all_ways = prev1 + prev2;
    	prev2 = prev1;
        prev1 = all_ways;
    }
    return all_ways;
}
}
