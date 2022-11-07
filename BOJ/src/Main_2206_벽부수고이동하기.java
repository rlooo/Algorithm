import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_벽부수고이동하기 {
    static int N, M;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int[][] map;
    static boolean[][][] visited;
    static int[][][] dist;

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
        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][2];
        dist = new int[N + 1][M + 1][2];

        for (int i = 1; i <= N; i++) {
            char[] str = in.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
                map[i][j] = str[j - 1] - '0';
            }
        }

        bfs();
        if (visited[N][M][0] == false && visited[N][M][1] == false)
            sb.append(-1);
        else {
            if (Math.min(dist[N][M][0], dist[N][M][1]) == 0) {
                if (dist[N][M][0] != 0) {
                    sb.append(dist[N][M][0]);
                } else {
                    sb.append(dist[N][M][1]);
                }
            } else {
                sb.append(Math.min(dist[N][M][0], dist[N][M][1]));
            }

        }

        out.write(sb.toString());
        out.flush();
        out.close();

    }

    private static void bfs() {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(1, 1, 0));
        visited[1][1][0] = true;
        dist[1][1][0] = 1;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 1 || ny < 1 || nx > N || ny > M)
                    continue;

                if (map[nx][ny] == 0) {

                    if (cur.drill == 0 && visited[nx][ny][0] == false) {
                        dist[nx][ny][0] += dist[cur.x][cur.y][0] + 1;
                        q.add(new Pair(nx, ny, 0));
                        visited[nx][ny][0] = true;
                    } else if (cur.drill == 1 && visited[nx][ny][1] == false) {
                        dist[nx][ny][1] += dist[cur.x][cur.y][1] + 1;
                        q.add(new Pair(nx, ny, 1));
                        visited[nx][ny][1] = true;
                    }

                }

                if (map[nx][ny] == 1 && visited[nx][ny][1] == false && cur.drill == 0) {
                    dist[nx][ny][1] += dist[cur.x][cur.y][0] + 1;
                    q.add(new Pair(nx, ny, 1));
                    visited[nx][ny][1] = true;
                }

            }
        }

        // for (int i = 1; i <= N; i++) {
        // for (int j = 1; j <= M; j++) {
        // System.out.print("(" + dist[i][j][0] + " " + dist[i][j][1] + ")");

        // }
        // System.out.println();
        // }

    }
}
