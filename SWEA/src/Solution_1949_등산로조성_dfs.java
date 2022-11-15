import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1949_등산로조성_dfs {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int N, K;
    static int res;

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            res = Integer.MIN_VALUE;

            st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            int maxHeight = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {

                st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    maxHeight = Math.max(maxHeight, map[i][j]);
                }
            }

            List<Point> maxHeightList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == maxHeight) {
                        maxHeightList.add(new Point(i, j));
                    }
                }
            }

            for (int i = 0; i < maxHeightList.size(); i++) {
                visited = new boolean[N][N];

                Point start = maxHeightList.get(i);
                visited[start.x][start.y] = true;
                dfs(start, 0, 1);

            }
            sb.append("#" + tc + " " + res + "\n");

        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static void dfs(Point cur, int drill, int dist) {

        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.x + dx[dir];
            int ny = cur.y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                continue;

            if (visited[nx][ny] != false)
                continue;

            if (map[nx][ny] < map[cur.x][cur.y] && drill == 0) {

                visited[nx][ny] = true;
                dfs(new Point(nx, ny), 0, dist + 1);
                visited[nx][ny] = false;

            } else if (map[nx][ny] < map[cur.x][cur.y] && drill == 1) {

                visited[nx][ny] = true;
                dfs(new Point(nx, ny), 1, dist + 1);
                visited[nx][ny] = false;

            } else if (map[nx][ny] >= map[cur.x][cur.y] && drill == 0) {
                for (int i = 1; i <= K; i++) {
                    visited[nx][ny] = true;
                    map[nx][ny] -= i;
                    if (map[nx][ny] < map[cur.x][cur.y]) {
                        dfs(new Point(nx, ny), drill + 1, dist + 1);
                    }
                    map[nx][ny] += i;
                    visited[nx][ny] = false;
                }
            }

        }
        res = Math.max(res, dist);
    }

}
