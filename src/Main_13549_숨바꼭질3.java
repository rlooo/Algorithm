import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13549_숨바꼭질3 {
    static int[][] time;
    static int res = 0;
    static int[] visited;
    static int[] dx = { -1, 1, 2 };

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        time = new int[100001][2];
        visited = new int[100001];

        bfs(N);

        sb.append(res);
        out.write(sb.toString());
        out.flush();
        out.close();

    }

    private static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            Integer cur = q.poll();

            for (int dir = 0; dir < 3; dir++) {
                int nx = 0;
                if (dir == 2) {
                    nx = dx[dir] * cur;
                    if (nx < 0 || nx > 100000)
                        continue;
                    if()
                    time[nx][1] = Math.min(time[cur][0], time[cur][1]);

                    
                } else {
                    nx = cur + dx[dir];
                    if (nx < 0 || nx > 100000)
                        continue;
                    time[nx][0] = Math.min(time[nx][0] + 1, time[cur][1]) + 1;
                    
                }

            }

        }

    }
}