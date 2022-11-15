import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_8382_방향전환 {
    static int[] hDx = { 0, 0 };
    static int[] hDy = { -1, 1 };
    static int[] vDx = { -1, 1 };
    static int[] vDy = { 0, 0 };
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static int x2, y2;
    static int res;

    static class Point {
        int x;
        int y;
        boolean move; // true이면 가로이동, false이면 세로이동

        Point(int x, int y, boolean move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            res = Integer.MAX_VALUE;
            st = new StringTokenizer(in.readLine());
            int x1 = Integer.parseInt(st.nextToken()) + 100;
            int y1 = Integer.parseInt(st.nextToken()) + 100;
            x2 = Integer.parseInt(st.nextToken()) + 100;
            y2 = Integer.parseInt(st.nextToken()) + 100;

            map = new int[201][201];
            dist = new int[201][201];
            visited = new boolean[201][201];

            Point start = new Point(x1, y1, true);

            bfs(start);

            start = new Point(x1, y1, false);
            bfs(start);

            sb.append("#" + tc + " " + res + "\n");
        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static void bfs(Point start) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(start);
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == x2 && cur.y == y2) {
                res = Math.min(res, dist[x2][y2]);
            }
            for (int dir = 0; dir < 2; dir++) {
                int nx = 0, ny = 0;
                if (cur.move == true) { // 지금 이동이 가로이동
                    nx = cur.x + vDx[dir];
                    ny = cur.y + vDy[dir];
                }
                if (cur.move == false) { // 지금 이동이 세로이동0
                    nx = cur.x + hDx[dir];
                    ny = cur.y + hDy[dir];
                }

                if (nx < 0 || ny < 0 || nx > 200 || ny > 200)
                    continue;

                if (visited[nx][ny] != false)
                    continue;

                visited[nx][ny] = true;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.add(new Point(nx, ny, !cur.move));
            }

        }

    }
}
