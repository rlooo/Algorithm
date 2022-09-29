import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {
	static int[][] arr;
	static int[][] rec;
	static int[][] index;

	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("res/Solution_4013_특이한자석.txt"));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int K = Integer.parseInt(in.readLine());
			arr = new int[4][8];

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < 8; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			rec = new int[4][4];
			for (int i = 0; i < 4; i++) {
				rec[i][0] = arr[i][0];
				rec[i][1] = arr[i][2];
				rec[i][2] = arr[i][6];
				rec[i][3] = 0;

			}

			index = new int[4][3];
			for (int i = 0; i < 4; i++) {
				index[i][0] = 0;
				index[i][1] = 2;
				index[i][2] = 6;

			}
			// 초기화

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(in.readLine());
				boolean[] change = new boolean[4];
				int num = Integer.parseInt(st.nextToken()); // 1부터 시작
				int dir = Integer.parseInt(st.nextToken());
				change[num - 1] = true;
				rec[num - 1][3] = dir;

				// 자석 회전(왼쪽)
				for (int j = num - 1; j > 0; j--) {
					if (rec[j][2] != rec[j - 1][1] && change[j] == true) {

						change[j - 1] = true;
						rec[j - 1][3] = -rec[j][3];
					}
				}

				// 자석 회전(오른쪽)
				for (int j = num - 1; j < 3; j++) {
					if (rec[j][1] != rec[j + 1][2] && change[j] == true) {

						change[j + 1] = true;
						rec[j + 1][3] = -rec[j][3];
					}

				}

				for (int i = 0; i < 4; i++) {

					if (change[i] == true) {
						for (int idx = 0; idx < 3; idx++) {
							update(rec[i][3], i, idx);
						}
					}

				}

			} // 모든 회전 끝

			int res = 0;
			// 점수 구하기

			for (int j = 0; j < 4; j++) {
				if (rec[j][0] == 1) {// s극이면
					if (j == 0) {
						res += 1;
					} else if (j == 1) {
						res += 2;
					} else if (j == 2) {
						res += 4;
					} else if (j == 3) {
						res += 8;
					}
				}

			}

			sb.append("#" + test_case + " " + res + "\n");

		}
		out.write(sb.toString());
		out.flush();
		out.close();

	}

	private static void update(int dir, int num, int idx) {
		if (dir == 1)
			index[num][idx]--;
		else
			index[num][idx]++;

		if (index[num][idx] > 7)
			index[num][idx] = 0;
		else if (index[num][idx] < 0)
			index[num][idx] = 7;

		rec[num][idx] = arr[num][index[num][idx]];

	}

}
