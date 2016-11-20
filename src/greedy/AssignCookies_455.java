package greedy;

import java.util.Arrays;

public class AssignCookies_455 {
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int i = 0, j = 0, sum = 0;
		while (j < s.length && i < g.length) {
			if (g[i] <= s[j]) {
				i++;
				sum++;
			}
			j++;
		}
		return sum;
		
		//别人的代码一样的思想 更少的代码
//		Arrays.sort(g);
//		Arrays.sort(s);
//		int i = 0;
//		for(int j=0;i<g.length && j<s.length;j++) {
//			if(g[i]<=s[j]) i++;
//		}
//		return i;
	}
}
