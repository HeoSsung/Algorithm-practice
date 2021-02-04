import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Queue<Integer> queue = new LinkedList<>();

		for (int t = 0; t < 10; t++) {
			queue.clear();
			int T = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			int tmp = 0;
			do {
				for (int i = 1; i <= 5; i++) {
					tmp = queue.peek();
					tmp = tmp - i;

					if (tmp <= 0) {
						tmp = 0;
						queue.poll();
						queue.offer(tmp);
						break;
					} else {
						queue.poll();
						queue.offer(tmp);

					}
				}
			} while (tmp > 0);
			System.out.print("#" + T + " ");
			for (int i : queue) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
