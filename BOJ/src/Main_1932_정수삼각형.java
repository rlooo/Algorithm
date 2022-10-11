import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        int[][] dp = new int[n][n];
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    dp[i][j] = arr[i][j] + dp[i - 1][j];
                else
                    dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);

            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dp[i][j]);
            }

        }

        sb.append(res);
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
