import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Chemicals[] input = new Chemicals[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i] = new Chemicals(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(input);

		List<Chemicals> list = new ArrayList<>();
		list.add(input[0]);
		int cnt = 1;
		for (int i = 1; i < input.length; i++) {
			if (list.get(list.size() - 1).max >= input[i].min) {
				if (list.get(list.size() - 1).max > input[i].max)
					list.add(input[i]);
				continue;
			} else {
				cnt++;
				list.add(input[i]);
			}
		}
		System.out.println(cnt);
	}

}

class Chemicals implements Comparable<Chemicals> {
	int min;
	int max;

	public Chemicals(int min, int max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public int compareTo(Chemicals o) {
		int diff = this.min - o.min;
		return diff != 0 ? diff : this.max - o.max;
	}

}
