import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static boolean[][] visited; // 방문 여부
	static int[][] snail;
	static int N; // 달팽이 크기
	static int sy, sx; // 출발점
	static int nx, ny;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트케이스 수
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());

			visited = new boolean[N][N]; // 방문 여부
			snail = new int[N][N];
			dfs(0, 0, 0, 0);
			System.out.println("#" + (t + 1));
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					System.out.print(snail[i][j] + " ");
				System.out.println();
			}

		}
	}

	public static void dfs(int x, int y, int n, int dir) {
		if (n == N * N)
			return;
		visited[y][x] = true;
		snail[y][x] = n + 1;

		for (int i = 0; i < 4; i++) {
			int nny = y + dy[dir];
			int nnx = x + dx[dir];
			if (nny >= 0 && nnx >= 0 && nny < N && nnx < N && visited[nny][nnx] == false)
				i = dir;
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny >= N || nx >= N)
				continue;
			if (visited[ny][nx] == false) {
				dfs(nx, ny, n + 1, i);
			}
		}

	}

}
