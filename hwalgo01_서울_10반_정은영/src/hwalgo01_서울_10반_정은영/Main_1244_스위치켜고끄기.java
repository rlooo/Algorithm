package hwalgo01_서울_10반_정은영;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int switch_num = Integer.parseInt(bf.readLine()); // 스위치 개수
		int arr[] = new int[switch_num + 1]; // 스위치 상태

		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 1; i <= switch_num; i++) { // 입력
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int st_num = Integer.parseInt(bf.readLine()); // 학생수
		int[][] student = new int[st_num + 1][2];

		for (int i = 1; i <= st_num; i++) {
			st = new StringTokenizer(bf.readLine(), " ");

			student[i][0] = Integer.parseInt(st.nextToken()); // 성별
			student[i][1] = Integer.parseInt(st.nextToken()); // 학생이 받은 수

			if (student[i][0] == 1) { // 남학생
				int x = 1;
				while (student[i][1] * x <= switch_num) {
					arr[student[i][1] * x] = (arr[student[i][1] * x] == 0) ? 1 : 0;
					x++;

				}
			} else { // 여학생
				int x = 1;
				arr[student[i][1]] = (arr[student[i][1]] == 0) ? 1 : 0;
				while ((student[i][1] - x) >= 1 && (student[i][1] + x) <= switch_num) {
					if (arr[student[i][1] - x] == arr[student[i][1] + x]) {
						arr[student[i][1] - x] = (arr[student[i][1] - x] == 0) ? 1 : 0;
						arr[student[i][1] + x] = (arr[student[i][1] + x] == 0) ? 1 : 0;
						x++;

					}else {
						break;
					}
					
				}

			}

		}

		int x = 1;
		for (int i = 1; i <= switch_num; i++) { // 출력
			System.out.print(arr[i] + " ");
			if (i >= 20 * x) {
				System.out.println();
				x++;
			}
		}

	}

}

