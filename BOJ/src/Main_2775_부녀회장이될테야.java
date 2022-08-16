import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2775_부녀회장이될테야 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int k = Integer.parseInt(bf.readLine());
			int n = Integer.parseInt(bf.readLine());

			int[][] arr = new int[k + 1][n + 1];
			for (int j = 1; j <= n; j++) {
				arr[0][j] = j;
			}

			for (int i = 1; i <= k; i++) {
				for (int j = 1; j <= n; j++) {
					for (int m = 1; m <= j; m++) {
						arr[i][j] += arr[i - 1][m];
					}

				}

			}

			sb.append(arr[k][n] + "\n");
			
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}
