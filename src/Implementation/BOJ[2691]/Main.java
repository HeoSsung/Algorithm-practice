import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static Ingredient[] src;
	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		src = new Ingredient[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			src[i] = new Ingredient(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		comb(0, 0);
		System.out.println(res);
	}

	static void comb(int sIdx, int mask) {

		if (sIdx >= N) {
			if (mask != 0) {
				int sSum = 1;
				int bSum = 0;
				for (int i = 0; i < N; i++) {
					if ((mask & 1 << i) != 0) {
						sSum *= src[i].sour;
						bSum += src[i].bitter;
					}
				}
				res = Math.min(Math.abs(sSum - bSum), res);
			}

			return;
		}

		comb(sIdx + 1, mask | 1 << sIdx);
		comb(sIdx + 1, mask);

	}

}

class Ingredient {
	int sour;
	int bitter;

	public Ingredient(int sour, int bitter) {
		this.sour = sour;
		this.bitter = bitter;
	}
}
