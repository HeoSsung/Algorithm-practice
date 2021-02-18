import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


// 3 + 8 * 7 - 10 + 5
// 3 + (8 * 7) -10 + 5
// 3 + 8 * (7 - 10) + 5
// 3 + 8 * 7 - (10 + 5)
// 3 + (8 * 7) - (10 + 5)


public class Main {

	static int N;
	static List<Integer> num = new ArrayList<>();
	static List<Character> op = new ArrayList<>();
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		char[] input = br.readLine().toCharArray();
		
		// 짝수 -> 피연산자 
		// 홀수 -> 연산자
		for (int i = 0; i < input.length; i++) {
			if (i % 2 == 0)
				num.add(input[i] - '0');
			else
				op.add(input[i]);
		}

		recur(0, num.get(0));

		System.out.println(max);
	}

	// 1. 괄호x -> 이전 계산값과 오른쪽 피연산자를 현재 인덱스에 해당하는 연산자로 계산.
	// 2. 괄호o -> 이전 계산값과 괄호를 친 오른쪽 계산값을 현재 인덱스에 해당하는 연산자로 계산.
	static void recur(int cnt, int sum) {

		// 모든 연산자 탐색 시 종료
		if (cnt >= op.size()) {
			max = Math.max(max, sum);
			return;
		}

		// 1. 괄호 x
		// 현재 인덱스의 왼쪽, 오른쪽 피연산자 계산.
		int val = calc(cnt, sum, num.get(cnt + 1));
		recur(cnt + 1, val);

		// 2. 괄호 o
		if (cnt + 1 < op.size()) {
			val = calc(cnt, sum, calc(cnt + 1, num.get(cnt + 1), num.get(cnt + 2)));
			recur(cnt + 2, val);
		}

	}

	/*
	 * idx: 연산자 인덱스 값 
	 * prevValue: 이전 계산값 
	 * rightValue: 오른쪽 피연산자 값.
	 */
	static int calc(int idx, int prevValue, int rightValue) {

		int val = 0;
		switch (op.get(idx)) {
		case '*':
			val = prevValue * rightValue;
			break;
		case '+':
			val = prevValue + rightValue;
			break;
		case '-':
			val = prevValue - rightValue;
			break;
		}
		return val;

	}

}
