import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N, M;
	static int[][] fly;
	static int death;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			fly = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					fly[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			int tmp=0;
			death = 0;
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					for (int k = i; k < i + M; k++) {
						for (int l = j; l < j + M; l++) {
							tmp += fly[k][l];
						}
					}
					if (tmp > death)
						death = tmp;
					tmp = 0;
				}

			}

			System.out.println("#" + t + " " + death);
		}
	}

}
