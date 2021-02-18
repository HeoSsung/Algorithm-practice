import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char[][] map;
	static boolean isFind;

	static int[] dy = { -1, 0, 1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int res = 0;
		for (int i = 0; i < R; i++) {
			isFind = false;
			findPath(i, 0);
			if (isFind)
				res++;
		}
		System.out.println(res);
	}

	// map[?][C-1]에 도달하면 true 반환.
	static void findPath(int r, int c) {
		if (c == C - 1) {
			isFind = true;
			return;
		}
		for (int i = 0; i < 3; i++) {
			int ny = r + dy[i];
			int nx = c + 1;
			if (ny < 0 || ny >= R || map[ny][nx] == 'x')
				continue;
			if (!isFind) {
				map[ny][nx] = 'x';
				findPath(ny, nx);
			}
		}

	}
}
