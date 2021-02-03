import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution {
 
    static int T;
    static char[] input;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            int count = 0;
            input = br.readLine().toCharArray();
 
            int cnt = input.length;
            // 배열의 값이 이전값과 현재값이 다르면 cnt증가.
            char current = '0';
            for (int i = 0; i < cnt; i++) {
                if (input[i] != current) {
                    count++;
                }
                current = input[i];
            }
            System.out.println("#" + t + " " + count);
        }
    }
}
