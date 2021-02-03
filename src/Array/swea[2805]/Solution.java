import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int T, N;
    static int[][] farm;
 
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
            int value=0;
            int skip=0;
            int center = N/2;
            int startX, endX;
            for(int i=0;i<N;i++) {
                startX = center -skip;
                endX = center+skip;
                for(int j= startX;j<=endX;j++)
                    value+=farm[i][j];
                if(i<center) {
                    skip++;
                }else
                    skip--;
            }
             
            System.out.println("#"+t+" "+value);
        }
         
    }
}
