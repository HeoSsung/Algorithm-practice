import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	// 각 계단에 도달할 때마다 얻을 수 있는 점수 최댓값을 구하기. -> DP로 해결
	static int N;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		dp[1] = arr[1];
		if (N >= 2)
			dp[2] = dp[1] + arr[2];

		// 1. 건너뛰고 계단을 밟은 경우 -> 2계단 전의 최댓값에서 + 현재 계단의 값
		// 2. 연속으로 계단을 밟은 경우 -> 1계단 전의 값 + 3계단 전의 최댓값 + 현재 계단의 값.
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 2], arr[i - 1] + dp[i - 3]) + arr[i];
		}

		// 마지막 계단에서의 최댓값 출력.
		System.out.println(dp[N]);
	}
}
