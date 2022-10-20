import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1106_호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(in.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][2];
        int[][] dp = new int[N + 1][C + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(in.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int cost = Integer.MAX_VALUE;
        int res = 0;
        if (arr[1][0] == 1) {
            dp[1][1] = 1;
        } else {
            dp[1][1] = 0;
        }
        for (int i = 1; i <= N; i++) {
            int index = 1;
            int j = 1;
            while (j < C) {
                if (arr[i][0] * (index) > j) {
                    dp[i][j] = dp[i][j - 1];
                    System.out.print(dp[i][j] + " ");
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j],
                            dp[i - 1][j] + arr[i][1] * (index) * j % arr[i - 1][0]);
                    System.out.print(dp[i][j] + " ");
                }

                if (arr[i][0] * index == j) {
                    index++;
                }
                if (dp[i][j] == C) {
                    break;
                }
                if (dp[i][j] > C) {

                    break;
                }

                j++;
            }

            System.out.println();
            if (cost >= dp[i][j]) {
                res = j;
            }

        }

        sb.append(res);

        out.write(sb.toString());
        out.flush();
        out.close();

    }

}
