package dynamicProgramming;

public class UniquePaths_62 {
	public int uniquePaths(int m, int n) {
		// 就是组合！！ 从m+n-2中 选 min（m-1，n-1）个位置 傻逼了吧
		//要注意 防止溢出要用long
		long min = Math.min(m - 1, n - 1);
		long sum = 1L;
		for (long i = 1L; i <= min; i++) {
			sum = sum / i * (m + n - 1 - i);
		}
		return (int) sum;
	}
	
//别人的动态规划方法
// 1 1 1  1   1  1  1
// 1 2 3  4   5  6  7
// 1 3 6 10  15 21 28
	public int uniquePaths2(int m, int n) {
	    int[][] tab = new int[m][n];
	    
	    for(int i=0; i<m; i++){
	        for(int j=0; j<n; j++){
	            if(i==0 || j==0){
	                tab[i][j] = 1;
	            }
	            else{
	                tab[i][j] = tab[i-1][j]+tab[i][j-1];
	            }
	        }
	    }
	    
	    return tab[m-1][n-1];
	}
}
