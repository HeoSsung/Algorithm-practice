import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;;

public class Main {

	static boolean[][] paper = new boolean[100][100];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					if (paper[y + j][x + k] == false) {
						paper[y + j][x + k] = true;
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);

	}
}
