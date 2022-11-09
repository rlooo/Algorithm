import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14442_벽부수고이동하기2 {
    static int[][] map;
    static int[][][] dist;
    static boolean[][][] visited;
    static int[] dx = { -1, 0, 0, 1 };// 하(-1,0) 우(0,1) 왼(0,-1) 상(-1,0)
    static int[] dy = { 0, 1, -1, 0 };
    static int N, M, K;

    static class Pair {
        int x;
        int y;
        int drill;

        Pair(int x, int y, int drill) {
            this.x = x;
            this.y = y;
            this.drill = drill;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1][11];
        visited = new boolean[N + 1][M + 1][11];

        for (int i = 1; i <= N; i++) {
            char[] str = in.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                map[i][j] = str[j - 1] - '0';
            }
        }

        bfs();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= 10; i++) {
            if (dist[N][M][i] != 0)
                res = Math.min(res, dist[N][M][i]);
        }
        res = res == Integer.MAX_VALUE ? -1 : res;

        sb.append(res);
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static void bfs() {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(1, 1, 0));
        dist[1][1][0] = 1;
        visited[1][1][0] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 1 || ny < 1 || nx > N || ny > M)
                    continue;

                if (map[nx][ny] == 1 && cur.drill + 1 <= K && !visited[nx][ny][cur.drill + 1]) {
                    dist[nx][ny][cur.drill + 1] = dist[cur.x][cur.y][cur.drill] + 1;
                    visited[nx][ny][cur.drill + 1] = true;
                    q.add(new Pair(nx, ny, cur.drill + 1));

                } else if (map[nx][ny] == 0 && !visited[nx][ny][cur.drill]) {
                    dist[nx][ny][cur.drill] = dist[cur.x][cur.y][cur.drill] + 1;
                    visited[nx][ny][cur.drill] = true;
                    q.add(new Pair(nx, ny, cur.drill));
                }

            }
        }

    }
}
