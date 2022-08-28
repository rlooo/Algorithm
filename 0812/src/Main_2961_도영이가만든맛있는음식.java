import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		int[] a = new int[n]; // 신맛
		int[] b = new int[n]; // 쓴맛

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		} // 입력

		int[] dp = new int[n];
		int a_i = 0;
		int b_i = 0;
		dp[0] = Integer.MAX_VALUE;

		for (int i = 1; i < n; i++) {
			a_i = dp[i - 1] * a[i];
			b_i = dp[i - 1] + b[i];

			int i_val = Math.abs(a_i - b_i);
			System.out.println(i + " " + i_val);

			dp[i] = Math.min(i_val, dp[i - 1]);
		}
		System.out.println(dp[n - 1]);
	}

}
