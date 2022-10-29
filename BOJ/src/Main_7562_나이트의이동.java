import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562_나이트의이동 {
    static int[] dx = { -2, -1, 1, 2, -2, -1, 1, 2 };
    static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };
    static int[][] map;
    static int[][] dist;
    static int l;

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
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
            l = Integer.parseInt(in.readLine());

            map = new int[l][l];
            dist = new int[l][l];

            st = new StringTokenizer(in.readLine());
            Pair cur = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(in.readLine());
            Pair des = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    dist[i][j] = -1;
                }
            }

            bfs(cur);

            sb.append(dist[des.x][des.y] + "\n");

        }
        out.write(sb.toString());
        out.flush();
        out.close();

    }

    private static void bfs(Pair start) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(start);
        dist[start.x][start.y] = 0;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int dir = 0; dir < 8; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= l || ny >= l)
                    continue;

                if (dist[nx][ny] != -1)
                    continue;

                q.add(new Pair(nx, ny));
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
            }

        }
    }

}
