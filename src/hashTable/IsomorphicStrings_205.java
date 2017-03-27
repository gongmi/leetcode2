package hashTable;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings_205 {
	// ������WordPattern_290��top������
	// ��Ϊ�����໥��Ӧ�� ����Ҳ��һһ��Ӧ��
	// ����˵paper��title ��true
	// ��l->e e->r
	// ��Ϊtop�����Ƿ���ͬһ��map�� s��t��char���޷�������
	
	// ���Ƕ�ӦWordPattern_290�ķ�2 һ��map
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				if (map.get(s.charAt(i)) != t.charAt(i))
					return false;
			} else if (map.containsValue(t.charAt(i)))
				return false;
			else
				map.put(s.charAt(i), t.charAt(i));
		}
		return true;
	}
//	top�� ���˼����� WordPattern_290 top�𰸵�˼�� 
//	����ʹ������װ�� ��Ϊ������͹��� ��Ϊֻ��char
//	�����Ͳ������ s ��t��char������������
//	brilliant
	
    public boolean isIsomorphic2(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1; //��һ��Ϊ�˱����ʼֵ
        }
        return true;
    }
}
