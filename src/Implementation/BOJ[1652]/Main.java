import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static char[][] map;
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int seat = 0;
		int rowCnt = 0;
		int colCnt = 0;

		for (int i = 0; i < N; i++) {
			seat = 0;
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '.') {
					seat++;
				}else {
					if(seat>=2)
						rowCnt++;
					seat=0;
				}
			}
			if(seat>=2)
				rowCnt++;
		}
		for (int i = 0; i < N; i++) {
			seat = 0;
			for (int j = 0; j < N; j++) {
				if (map[j][i] == '.') {
					seat++;
				}else {
					if(seat>=2)
						colCnt++;
					seat=0;
				}
			}
			if(seat>=2)
				colCnt++;
		}
		System.out.println(rowCnt + " " + colCnt);

	}
}
