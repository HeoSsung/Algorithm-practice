import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> input = new Stack<>();
		for (int t = 1; t <= 10; t++) {
			int num = Integer.parseInt(br.readLine());
			String str = br.readLine();
			int res = 1;
			for (int i = 0; i < num; i++) {
				char c = str.charAt(i);

				switch (c) {
				case '{':
				case '[':
				case '(':
				case '<':
					input.add(str.charAt(i));
					break;
				case '}':
					if (input.peek() == '{') {
						input.pop();
						break;
					} else {
						res = 0;
						break;
					}

				case ']':
					if (input.peek() == '[') {
						input.pop();
						break;
					} else {
						res = 0;
						break;
					}
				case ')':
					if (input.peek() == '(') {
						input.pop();
						break;
					} else {
						res = 0;
						break;
					}
				case '>':
					if (input.peek() == '<') {
						input.pop();
						break;
					} else {
						res = 0;
						break;
					}
				}
				if (res == 0)
					break;
			}
			if (!input.isEmpty())
				res = 0;
			System.out.println("#" + t + " " + res);
			input.clear();
		}
	}
}
