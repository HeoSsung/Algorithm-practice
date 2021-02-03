import java.io.BufferedReader;
import java.io.InputStreamReader;
 
 
public class Solution {
 
 
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int res;
        StringBuilder sb = new StringBuilder();
         
        for (int t = 0; t < T; t++) {
            res = 0;
            String str = br.readLine();
            int len = str.length();
            char[] input = str.toCharArray();
             
 
            for (int i = 0; i < len; i++) {
                if (input[i] =='1') {
                    for (int j = i; j < len; j++) {
                        if (input[j] == '0')
                            input[j] = '1';
                        else
                            input[j] = '0';
                    }
                    res++;
                }
            }
            sb.append("#").append((t+1)).append(" ").append(res).append("\n");
        }
        System.out.println(sb);
    }
 
}
