import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int[][] dp = new int[N + 1][3];
		int[][] arr = new int[N + 1][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력
		dp[1][0] = arr[0][0];
		dp[1][1] = arr[0][1];
		dp[1][2] = arr[0][2];

		for (int i = 2; i <= N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i-1][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i-1][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i-1][2];
		}

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			res = Math.min(res, dp[N][i]);
		}

		sb.append(res);

		out.write(sb.toString());
		out.flush();
		out.close();

	}

}
