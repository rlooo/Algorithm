import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2583_영역구하기 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int M, N, K;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(in.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M + 1][N + 1];
        visited = new boolean[M + 1][N + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(in.readLine());
            int x1, y1, x2, y2;
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    visited[j][k] = true;
                }
            }

        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        int cnt = 0;
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < N; k++) {
                if (visited[j][k] != false)
                    continue;
                cnt++;
                bfs(new Pair(j, k));
            }
        }
        sb.append(cnt + "\n");
        while (!pq.isEmpty()) {
            sb.append(pq.poll() + " ");
        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static void bfs(Pair start) {
        int area = 0;
        Queue<Pair> q = new ArrayDeque();
        q.add(start);
        area++;
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N)
                    continue;
                if (visited[nx][ny] != false)
                    continue;

                visited[nx][ny] = true;
                area++;
                q.add(new Pair(nx, ny));
            }
        }
        pq.add(area);

    }

}
