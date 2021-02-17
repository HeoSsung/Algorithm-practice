import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int minDistance = Integer.MAX_VALUE;
	static List<Point> chicken = new ArrayList<>();
	static List<Point> house = new ArrayList<>();
	static Point[] tgt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tgt = new Point[M];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				int input = Integer.parseInt(st.nextToken());

				if (input == 1) {
					house.add(new Point(i, j));
				} else if (input == 2) {
					chicken.add(new Point(i, j));
				}
			}
		}
		comb(0, 0);
		System.out.println(minDistance);

	}

	static void comb(int cnt, int sIdx) {
		if (cnt == M) {
			int tmpDistance = findDistance();
			minDistance = Math.min(minDistance, tmpDistance);
			return;
		}

		for (int i = sIdx; i < chicken.size(); i++) {
			tgt[cnt] = chicken.get(i);
			comb(cnt + 1, i + 1);
		}
	}

	static int findDistance() {
		int sum = 0;
		for (int i = 0; i < house.size(); i++) {
			int dis = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				int tmp = Math.abs(house.get(i).r - tgt[j].r) + Math.abs(house.get(i).c - tgt[j].c);
				dis = Math.min(dis, tmp);
			}
			sum += dis;
		}
		return sum;
	}
}

class Point {
	int r;
	int c;

	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}

}
