import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// map에 있는 블록 높이의 최솟값 ~ 최댓값까지 모두 탐색해서 최소 시간을 구함

public class Main {

	static int N, M, B;
	static int[][] map;
	static int minTime = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		int max = 0;
		int min = 257; // 블록의 최대 높이는 256

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}

		int time = 0, height = 0;

		// 높이 min부터 max까지 모두 탐색
		for (int h = min; h <= max; h++) {
			int up = 0;
			int down = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 해당 블록의 높이가 기준높이 h보다 낮으면 그 차이만큼 up해줘야 한다.
					// 반대의 경우 down
					if (h > map[i][j])
						up += h - map[i][j];
					else if (h < map[i][j])
						down += map[i][j] - h;
				}
			}

			// 기존에 갖고 있는 블록 + down시키는 블록 < up시키는 블록 개수 이면
			// 해당 높이로 만들지 못함.
			if (B + down >= up) {
				time = down * 2 + up;

				// 답이 중복인 경우 가장 높은 땅 높이를 출력해야 하므로 >=
				if (minTime >= time) {
					minTime = time;
					height = h;
				}
			}
		}

		System.out.println(minTime + " " + height);
	}
}
