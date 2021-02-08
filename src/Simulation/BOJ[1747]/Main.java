import java.io.BufferedReader;
import java.io.InputStreamReader;;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		while (true) {
			if (isPrime(N) && isPalindrome(N)) {
				System.out.println(N);
				break;
			}
			N++;
		}
	}

	// 에라토스테네스의 체 알고리즘을 이용해 소수 판별
	static boolean isPrime(int n) {
		if(n==1) return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	static boolean isPalindrome(int n) {
		StringBuilder sb = new StringBuilder();
		sb.append(n);
		if (sb.toString().equals(sb.reverse().toString()))
			return true;
		return false;
	}
}
