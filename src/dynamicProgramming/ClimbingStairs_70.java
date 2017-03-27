package dynamicProgramming;

public class ClimbingStairs_70 {
	//怎么才能看出满足费波纳茨数列 但是如果用费波纳茨数列来递归的话 重复算了很多 所以用了自底向上
//	可以用一个一维数组 int【n】 但是还可以只用两个变量
//	因为 climbStairs[n]=climbStairs[n-1]+climbStairs[n-2]
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
