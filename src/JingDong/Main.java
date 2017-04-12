package JingDong;

import java.util.*;

public class Main {
	static double ans = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		double dp[][]=new double[n+1][n+1];
		double[] a = new double[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		dp[0][0]=1;
		for(int i=1;i<n;i++){
			dp[i][0]=dp[i-1][0]*(100.0-a[i-1])/100;
			for(int j=1;j<=i;j++)
				dp[i][j]=dp[i-1][j]*(100.0-a[i])/100+dp[i-1][j-1]*1.0*a[i]/100;
		}
		int low=(3*n+4)/5;
		double ans=0;
		for(int i=low;i<n;i++)
			ans+=dp[n][i];
		System.out.println(ans);
	}
}