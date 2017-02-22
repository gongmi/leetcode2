package backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinations_17 {
//	�ҵ� recursive��backtrack����
	private static final String[] MAP = new String[] { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	public List<String> letterCombinations(String digits) {

		List<String> res = new ArrayList<>();
		if (digits.equals(""))
			return res;
		backtrack(res, "",digits);
		return res;
	}

	private void backtrack(List<String> res, String tempStr, String digits) {
		if (tempStr.length() == digits.length()) {
			res.add(tempStr);
			return;
		}
		String number = MAP[digits.charAt(tempStr.length()) - '1' - 1];
		for (char c : number.toCharArray())
			//����ط�һ��Ҫ��tempStr + c 
			//����tempStr=tempStr+c
			//�ٴ���ȥ 
			//��Ϊ�����͸ı���tempStr
			backtrack(res, tempStr + c, digits); 
	}
//	���˵�iterative
//	��LinkedList��˫�˶���
//	[]
//	[a,b,c]
//	[b,c,ad,ae,af]
//	[c,ad,ae,af,bd,be,bf]
//	[ad,ae,af,bd,be,bf,cd,ce,cf]		
	public List<String> letterCombinations2(String digits) {
	    LinkedList<String> ans = new LinkedList<String>();
	    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	    ans.add("");
	    for(int i =0; i<digits.length();i++){
	        int x = Character.getNumericValue(digits.charAt(i));
	        while(ans.peek().length()==i){
	            String t = ans.remove();
	            for(char s : mapping[x].toCharArray())
	                ans.add(t+s);
	        }
	    }
	    return ans;
	}
}
