import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573_빙산 {
    static int[][][] map;
    static boolean[][] visited_bfs;
    static List<Pair> ice_list = new LinkedList<>();
    static boolean[][] visited_dfs;
    static int N, M;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M][2];
        visited_bfs = new boolean[N][M];
        visited_dfs = new boolean[N][M];

        Pair start = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j][0] = Integer.parseInt(st.nextToken());
                if (map[i][j][0] > 0) {
                    start = new Pair(i, j);
                }

            }
        }
        bfs(start);

        // while (true) {
        // 전체 빙산에 대한 주변 바다 개수 구하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j][1] + " ");
            }
            System.out.println();
        }
        // 높이 줄이기
        for (int i = 0; i < ice_list.size(); i++) {
            int x = ice_list.get(i).x;
            int y = ice_list.get(i).y;
            map[x][y][0] -= map[x][y][1];
        }

        // }

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static void bfs(Pair start) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(start);
        visited_bfs[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (map[nx][ny][0] == 0) {
                    map[cur.x][cur.y][1]++;
                    continue;
                }
                if (visited_bfs[nx][ny] != false)
                    continue;
                visited_bfs[nx][ny] = true;
                ice_list.add(new Pair(nx, ny));
                q.add(new Pair(nx, ny));

            }

        }
    }

    private static void dfs(Pair cur) {

        visited_bfs[cur.x][cur.y] = true;
        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.x + dx[dir];
            int ny = cur.y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                continue;
            if (visited_dfs[nx][ny] != false)
                continue;
            if (map[nx][ny][0] == 0) {

                continue;
            }

        }

    }
}
