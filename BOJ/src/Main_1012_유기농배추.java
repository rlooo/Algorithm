import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        for (int tc = 0; tc <= T; tc++) {
            st = new StringTokenizer(in.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            visited = new boolean[N][M];
            map = new int[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(in.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    if (visited[i][j] != false || map[i][j] != 1)
                        continue;
                    bfs(new Pair(i, j));
                    cnt++;
                }
            }
            sb.append(cnt + "\n");
        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static void bfs(Pair start) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(start);
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (map[nx][ny] == 0)
                    continue;
                if (visited[nx][ny] != false)
                    continue;

                visited[nx][ny] = true;
                q.add(new Pair(nx, ny));
            }
        }
    }

}
