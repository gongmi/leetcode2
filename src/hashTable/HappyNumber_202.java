package hashTable;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {
//	我之前想的是  当result == 原来的 n时就停止，但是不一定是一个大圈 
//	有可能在中间某一个地方循环
//	所以要用set存所有的result
//	法1
	public boolean isHappy(int n) {
		Set<Integer> inLoop = new HashSet<Integer>();
		int num;
		int result = 0;
		while (inLoop.add(n)) {
			result = 0;
			while (n > 0) {
				num = n % 10;
				result += num * num;
				n /= 10;
			}
			if (result == 1)
				return true;
			n = result;
		}
		return false;
	}
//法2
    public boolean isHappy2(int n) {
        int x = n;
        int y = n;
        while(x>1){
            x = cal(x) ;
            if(x==1) return true ;
            y = cal(cal(y));
            if(y==1) return true ;

            if(x==y) return false;
        }
        return true ;
    }
    public int cal(int n){
        int x = n;
        int s = 0;
        while(x>0){
            s = s+(x%10)*(x%10);
            x = x/10;
        }
        return s ;
    }
}
