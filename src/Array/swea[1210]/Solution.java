import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {

	static int sy, sx; // 출발점
	static int des; // x좌표
	static int dy[] = { 0, 0, -1 };
	static int dx[] = { -1, 1, 0 };
	static int[][] ladder = new int[100][100];
	static int[] visited = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (int t = 0; t < 10; t++) {
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if (ladder[i][j] == 2) {
						sy = i;
						sx = j;
					}
				}
			}
			dfs(sy, sx, false);
			sb.append("#").append(T).append(" ").append(des).append("\n");

		}
		System.out.println(sb.toString());	
	}

	static void dfs(int y, int x, boolean flag) {
		for (int i = 0; i < 3; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (nx < 0 || nx >= 100 || ny < 0)
				continue;
			if (flag == true)
				continue;
			if (ny == 0) {
				des = nx;
				return;
			}
			if (ladder[ny][nx] == 1) {
				ladder[y][x] = 0;
				dfs(ny, nx, false);
				flag = true;
			}
		}
	}
}
