import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] stateOfSwitch;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfSwitch = Integer.parseInt(br.readLine()); // 스위치의 개수 입력

		// 스위치의 상태를 입력받아서 stateOfSwitch[]에 저장.
		StringTokenizer st = new StringTokenizer(br.readLine());
		stateOfSwitch = new int[numOfSwitch];
		for (int i = 0; i < numOfSwitch; i++)
			stateOfSwitch[i] = Integer.parseInt(st.nextToken());

		int numOfStudent = Integer.parseInt(br.readLine());
		for (int i = 0; i < numOfStudent; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());

			int[] student = new int[2];
			for (int j = 0; j < 2; j++)
				student[j] = Integer.parseInt(st2.nextToken()); // 학생의 성별, 번호를 입력받아 저장
			
			
			// 남자:1 여자:2
			if (student[0] == 1) {
				int num = student[1]; // 학생이 부여받은 번호
				int count = numOfSwitch / num; // 제어할 스위치의 수
				for (int j = 1; j <= count; j++) {
					int index = j * num - 1;
					switchState(index);
				}
			} else {
				int index = student[1] - 1;

				switchState(index);
				for (int j = 1; 0 <= index - j && index + j < numOfSwitch ; j++) {
					if (stateOfSwitch[index - j] == stateOfSwitch[index + j]) {
						switchState(index - j);
						switchState(index + j);
					} else
						break;
				}

			}
		}
		int count =0;
		for (int state : stateOfSwitch) {
			System.out.print(state + " ");
			count++;
			if(count==20)
			{
				System.out.println();
				count =0;
			}
		}
	}

	public static void switchState(int index) {
		if (stateOfSwitch[index] == 1)
			stateOfSwitch[index] = 0;
		else
			stateOfSwitch[index] = 1;
	}
}
