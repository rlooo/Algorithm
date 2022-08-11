import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 0; test_case <= T; test_case++) {
			st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken()); // 재료의 수
			int L = Integer.parseInt(st.nextToken()); // 제한 칼로리

			int[] w = new int[N + 1];
			int[] v = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(bf.readLine());
				v[i] = Integer.parseInt(st.nextToken()); // 점수
				w[i] = Integer.parseInt(st.nextToken()); // 칼로리
			}
			int[][] dp = new int[N+1][L+1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= L; j++) {
					if (j - w[i] >= 0) {
						dp[i][j] = Math.max(dp[i - 1][j], (dp[i - 1][j - w[i]] + v[i]));
					} else
						dp[i][j] = dp[i - 1][j];
				}
			}
			System.out.println("#"+test_case+" "+dp[N][L]);

		}
	}
}
