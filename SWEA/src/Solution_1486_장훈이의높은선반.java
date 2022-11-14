import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1486_장훈이의높은선반 {
    static int B, N;
    static int res;
    static int[] height;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            res = Integer.MAX_VALUE;
            st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            height = new int[N];
            visited = new boolean[N];

            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }
            comb(0, 0, 0);
            sb.append("#" + tc + " " + (res - B) + "\n");
        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static void comb(int cnt, int start, int h) {
        if (h >= B) {
            res = Math.min(res, h);
            return;
        }

        for (int i = start; i < N; i++) {
            if (visited[i] != false)
                continue;
            visited[i] = true;
            comb(cnt + 1, i + 1, h + height[i]);
            visited[i] = false;

        }
    }
}
