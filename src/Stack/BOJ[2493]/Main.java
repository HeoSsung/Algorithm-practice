import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// int[0]: 탑의 높이, int[1]: 탑의 번호.
		Stack<int[]> stack = new Stack<>();

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 1번째 탑부터 차례로 비교
		for (int num = 1; num <= n; num++) {
			int input = Integer.parseInt(st.nextToken());

			// stack에 있는 왼쪽 탑들의 높이가 새로운 탑보다 작으면 계속 pop()
			while (!stack.isEmpty()) {
				if (stack.peek()[0] > input) {
					sb.append(stack.peek()[1]).append(" ");
					break;
				}
				stack.pop();
			}
			
			// 새로운 탑의 높이가 제일 높았다면 0을 출력
			if(stack.isEmpty()) sb.append(0).append(" ");
			
			// 새로운 탑 push()
			stack.push(new int[] {input,num});
		}
		
		// 결과 출력
		System.out.println(sb.toString());

	}
}
