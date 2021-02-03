import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N;
	static int[][] farm;
	static int value;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T ; t++) {
			N = Integer.parseInt(br.readLine());	
			farm = new int[N][N];
			for(int i=0;i<N;i++) {
				char[] input = br.readLine().toCharArray();
				for(int j=0;j<N;j++) {
					farm[i][j] = input[j]-'0';
				}
			}
			value=0;
			int skip=N/2;
			int start = 0;
			int end = 0;
			for(int i=0;i<N;i++) {
				if(i<=skip) {
					start = skip-i;
					end = skip+i;
					for(int j=start;j<=end;j++)
						value += farm[i][j];
				}
				else {
					start++;
					end--;
					for(int j=start;j<=end;j++)
						value += farm[i][j];
				}
			}
			
			System.out.println("#"+t+" "+value);
		}
		
	}
}
