import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1210_Ladder1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int num = Integer.parseInt(bf.readLine()); // 테스트 케이스 번호

			String[][] arr = new String[100][100];
			int[][] check = new int[100][100]; // 방문했으면  1, 안했으면 0
			for (int i = 0; i < 100; i++) { // 입력
				st = new StringTokenizer(bf.readLine(), " ");
				for (int j = 0; j < 100; j++) {
					arr[i][j] = st.nextToken();
				}
			}

			int row = 98;
			int col = 0;
			for (int j = 0; j < 100; j++) { // 도착지점 찾기
				if (arr[99][j].equals("2")) {
					col = j; // col 초기값
					break;
				}
			}

			while (row != 0) {
				if (col!=0&&arr[row][col - 1].equals("1") && check[row][col - 1] != 1) {
					check[row][col] = 1;
					col = col - 1;
				} else if (col!=99&&arr[row][col + 1].equals("1") && check[row][col + 1] != 1) {
					check[row][col] = 1;
					col = col + 1;
				} else {
					check[row][col] = 1;
					row = row - 1;
				}
			}
			System.out.println("#"+test_case+ " "+col);

		}

	}

}
