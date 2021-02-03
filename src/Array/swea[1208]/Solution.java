import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int[] floor;
    static int minIdx, maxIdx;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                 
         
        for (int t = 1; t <= 10; t++) {
 
            int dump = Integer.parseInt(br.readLine());
             
            floor = new int[100];
            StringTokenizer st = new StringTokenizer(br.readLine());
             
            for (int i = 0; i < 100; i++) {
                floor[i] = Integer.parseInt(st.nextToken());
            }
 
            // 최대 최소 위치
            resetMinMax();
            for (int i = 0; i < dump; i++) {
                if (floor[maxIdx] - floor[minIdx] <= 1)
                    break;
                floor[maxIdx]--;
                floor[minIdx]++;
                resetMinMax();
            }
            int result = floor[maxIdx]-floor[minIdx];
 
            System.out.println("#" + t + " " + result);
        }
    }
 
    static void resetMinMax() {
        for (int i = 0; i < 100; i++) {
            // min
            if (floor[i] < floor[minIdx]) {
                minIdx = i;
            }
            if (floor[i] > floor[maxIdx]) {
                maxIdx = i;
            }
        }
    }
}
