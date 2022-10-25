import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		int sum = 0;
		for (int test_case = 1; test_case <= T; test_case++) {
			sum = 0;
			int n = Integer.parseInt(in.readLine());
			char[][] str = new char[n][n];

			for (int i = 0; i < n; i++) { // 입력
				str[i] = in.readLine().toCharArray();
			}

			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) { // 입력
				for (int j = 0; j < n; j++) {
					arr[i][j] = Character.getNumericValue(str[i][j]);
				}
			}

			for (int i = n / 2; i >= 0; i--) {
				for (int j = n / 2 - i; j < n - (n / 2 - i); j++) {
					sum += arr[i][j];
				}

			}
			for (int i = n / 2 + 1; i < n; i++) {
				for (int j = i - n / 2; j < n - (i - n / 2); j++) {
					sum += arr[i][j];
				}

			}
			sb.append("#" + test_case + " " + sum + "\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();

	}

}