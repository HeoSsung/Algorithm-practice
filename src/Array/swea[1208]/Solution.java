import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < 10; t++) {
			int dump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] box = new int[100];
			for (int i=0; st.hasMoreTokens();i++)
				box[i]=Integer.parseInt(st.nextToken());
			int min = 100, max= 0;
			for (int i = 0; i < dump; i++) {
				int maxIndex = 0,minIndex = 0;
				for(int j=0;j<100;j++) {
					if(box[j]==0) break;
					if(max<box[j]) {
						max=box[j];
						maxIndex= j;
					}
					if(min>box[j]) {
						min= box[j];
						minIndex=j;
					}
				}
				if (max - min <= 1)
					break;
				System.out.println(box[maxIndex]);
				box[maxIndex]--;
				System.out.println(box[maxIndex]);
				box[minIndex]++;
			}
			
			sb.append("#").append(t + 1).append(" ").append(max - min).append("\n");
			System.out.println(sb.toString());
			

		}
	}
}
