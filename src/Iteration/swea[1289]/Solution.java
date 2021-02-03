import java.io.BufferedReader;
import java.io.InputStreamReader;
 
// Scanner --> BufferedReader
// int[] --> char[]
// local --> static
 
public class Solution {
 
    static int T;
    static char[] input, memory;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            int count = 0;
            input = br.readLine().toCharArray();
            memory = new char[input.length];
 
            int cnt = memory.length;
            for (int i = 0; i < cnt; i++)
                memory[i] = '0';
         
            for (int i = 0; i < cnt; i++) {
                if (memory[i] != input[i]) {
                    for (int j = i; j < cnt; j++) {
                        memory[j] = input[i];
                    }
 
                    count++;
                }
            }
            System.out.println("#" + t + " " + count);
        }
    }
}
