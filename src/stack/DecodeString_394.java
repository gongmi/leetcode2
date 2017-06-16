package stack;

import java.util.Stack;

//Character.isDigit这个方法要用啊！！！
public class DecodeString_394 {
	// top 答案 多么优美 他是在放数字时就把数字算出来 而我还傻逼兮兮的 放进去了 再翻过来
	public String decodeString(String s) {
		Stack<Integer> intStack = new Stack<>();
		Stack<StringBuilder> strStack = new Stack<>();
		StringBuilder cur = new StringBuilder();
		int k = 0;
		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				k = k * 10 + ch - '0';
			} else if (ch == '[') {
				intStack.push(k);
				strStack.push(cur);
				cur = new StringBuilder();
				k = 0;
			} else if (ch == ']') {
				StringBuilder tmp = cur;
				cur = strStack.pop();
				for (k = intStack.pop(); k > 0; --k)
					cur.append(tmp);
			} else
				cur.append(ch);
		}
		return cur.toString();
	}
	// public String decodeString(String s) {
	// Stack<Character> num = new Stack<>();
	// Stack<StringBuffer> res = new Stack<>();
	// for (char c : s.toCharArray()) {
	// if (c <= '9' && c >= '0')
	// num.push(c);
	// else if (c == '[') {
	// num.push(',');
	// res.push(new StringBuffer(c + ""));
	//
	// } else if (c == ']') {
	// StringBuffer sb = new StringBuffer();
	//
	// while (!res.peek().toString().equals("["))
	// sb.insert(0, res.pop());
	// res.pop();
	// int count = count(num);
	// StringBuffer sb2 = new StringBuffer();
	// while (count-- > 0)
	// sb2.append(sb);
	// res.push(sb2);
	// } else
	// res.push(new StringBuffer(c + ""));
	// }
	// StringBuffer sb = new StringBuffer();
	// while (res.size() != 0)
	// sb.insert(0, res.pop());
	// return sb.toString();
	// }
	//
	// private int count(Stack<Character> s) {
	// s.pop();
	// String str = "";
	// int res = 0;
	// while (!s.empty() && s.peek() != ',')
	// str = s.pop() + str;
	// for (int i = 0; i < str.length(); i++)
	// res = res * 10 + str.charAt(i) - '0';
	// return res;
	//
	// }
}
