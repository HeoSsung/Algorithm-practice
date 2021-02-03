import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N;
  
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int value = 0;
			int skip = 0;
			int center = N / 2;
			int startX, endX;
			for (int i = 0; i < N; i++) {
				char[] input = br.readLine().toCharArray();
				startX = center - skip;
				endX = center + skip;
				for (int j = startX; j <= endX; j++) {
					value += input[j]-'0';
				}
				if (i < center)
					skip++;
				else
					skip--;
			}

			System.out.println("#" + t + " " + value);
		}

	}
}
