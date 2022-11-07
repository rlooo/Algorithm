import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573_빙산 {
    static int[][][] map;
    static boolean[][] visited;
    static Queue<Pair> q3;

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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M][2];
        Queue<Pair> q = new ArrayDeque<>();
        int ice = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j][0] = Integer.parseInt(st.nextToken());
                if (map[i][j][0] != 0) {
                    q.add(new Pair(i, j));
                    ice++;
                }
            }
        }
        Queue<Pair> q2 = new ArrayDeque<>();
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            q2.add(cur);

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                if (map[nx][ny][0] == 0) {
                    map[nx][ny][1] += 1;
                }
            }
        }

        int cnt = 1;
        q3 = new ArrayDeque<>();
        while (cnt < 2) {
            boolean flag = false;
            while (!q2.isEmpty()) {
                Pair cur = q2.poll();
                q3.add(cur);

                map[cur.x][cur.y][0] -= map[cur.x][cur.y][1];
                if (map[cur.x][cur.y][0] < 0)
                    map[cur.x][cur.y][0] = 0;
                if (map[cur.x][cur.y][0] == 0) {
                    flag = true;
                    ice--;
                }
                if (ice == 0) {
                    sb.append(-1);
                    break;
                }

            }
            // 영역 구하기(빙산 중 높이가 0이 되는게 있을 때에만)
            if (flag == true) {
                visited = new boolean[N][M];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (visited[i][j] != true) {
                            bfs(new Pair(i, j));
                            cnt++;
                        }

                    }
                }
            }

        }
        if (cnt != 1) {
            sb.append(cnt);
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static void bfs( Pair start) {
        q3.add(start);
        visited[start.x][start.y] = true;
        while (!q3.isEmpty()) {
            Pair cur = q3.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (visited[nx][ny] != false)
                    continue;
                visited[nx][ny] = true;
                q3.add(new Pair(nx, ny));

            }
        }

    }
}