import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, 1);
		System.out.println(res);

	}

	static int[] dx = { 1, 1, 0 }; // 우- 대각 - 하
	static int[] dy = { 0, 1, 1 };
	static int res;

	static void dfs(int dir, int y, int x) {
		if (y == N - 1 && x == N - 1) {
			res++;
			return;
		}
		for (int i = 0; i < 3; i++) {
			// 우->하, 하->우 경우 예외처리
			if ((dir == 0 && i == 2) || (dir == 2 && i == 0))
				continue;
			int ny = y + dy[i];
			int nx = x + dx[i];

			// 배열 범위, 벽, 갈 수 있는지 체크
			if (ny >= N || nx >= N || !canGo(i, ny, nx))
				continue;
			dfs(i, ny, nx);
		}
	}

	static boolean canGo(int dir, int y, int x) {
		if (dir == 0 || dir == 2) {
			return map[y][x] == 0;
		} else {
			return map[y][x] == 0 && map[y - 1][x] == 0 && map[y][x - 1] == 0;
		}
	}
}
