package hashTable;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {
//	��֮ǰ�����  ��result == ԭ���� nʱ��ֹͣ�����ǲ�һ����һ����Ȧ 
//	�п������м�ĳһ���ط�ѭ��
//	����Ҫ��set�����е�result
//	��1
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
//��2
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
