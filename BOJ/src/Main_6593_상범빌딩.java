import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6593_상범빌딩 {
    static int L, R, C;
    static int[] dx = { -1, 1, 0, 0, 0, 0 };
    static int[] dy = { 0, 0, -1, 1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, -1, 1 };
    static char[][][] building;
    static int[][][] dist;

    static class Point {
        int x;
        int y;
        int z;

        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(in.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                out.write(sb.toString());
                out.flush();
                out.close();

                return;

            }

            building = new char[C + 1][R + 1][L + 1];
            dist = new int[C + 1][R + 1][L + 1];

            Point start = new Point(0, 0, 0);
            Point end = new Point(0, 0, 0);

            for (int z = 1; z <= L; z++) {
                for (int y = 1; y <= R; y++) {
                    char[] input = in.readLine().toCharArray();
                    for (int x = 1; x <= C; x++) {
                        building[x][y][z] = input[x - 1];
                        dist[x][y][z] = -1;
                        if (building[x][y][z] == 'S') {
                            start = new Point(x, y, z);
                        }
                        if (building[x][y][z] == 'E') {
                            end = new Point(x, y, z);
                        }
                    }
                }
                in.readLine();
            }

            bfs(start);

            String res = dist[end.x][end.y][end.z] == -1 ? "Trapped!"
                    : "Escaped in " + dist[end.x][end.y][end.z] + " minute(s).";
            sb.append(res + "\n");

        }

    }

    private static void bfs(Point start) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(start);
        dist[start.x][start.y][start.z] = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (building[cur.x][cur.y][cur.z] == 'E') {
                break;
            }

            for (int dir = 0; dir < 6; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];
                int nz = cur.z + dz[dir];

                if (nx < 1 || ny < 1 || nz < 1 || nx > C || ny > R || nz > L)
                    continue;

                if (building[nx][ny][nz] == '#' || dist[nx][ny][nz] != -1)
                    continue;

                dist[nx][ny][nz] = dist[cur.x][cur.y][cur.z] + 1;
                q.add(new Point(nx, ny, nz));

            }

        }

    }
}