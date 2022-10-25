import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7793_오나의여신님 {
    static char[][] map;
    static int[][] dist1;
    static int[][] dist2;
    static boolean[][] visited1;
    static boolean[][] visited2;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int N, M;
    static Pair destination, start;

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
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(in.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            dist1 = new int[N][M];
            dist2 = new int[N][M];
            visited1 = new boolean[N][M];
            visited2 = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                String str = in.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == 'D') {
                        destination = new Pair(i, j);
                        dist1[i][j] = Integer.MAX_VALUE;
                    }
                    if (map[i][j] == 'S') {
                        start = new Pair(i, j);
                    }
                }
            }
            for (int i = 0; i < N; i++) { // 악마의 손아귀
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == '*' && visited1[i][j] != true) {
                        bfs1(new Pair(i, j));
                    }
                }
            }
            // for (int i = 0; i < N; i++) {
            // for (int j = 0; j < M; j++) {
            // System.out.print(dist1[i][j] + " ");
            // }
            // System.out.println();
            // }
            // System.out.println();
            bfs2(start); // 수연

            // for (int i = 0; i < N; i++) {
            // for (int j = 0; j < M; j++) {
            // System.out.print(dist2[i][j] + " ");
            // }
            // System.out.println();
            // }

            // System.out.println(visited2[destination.x][destination.y]);
            sb.append("#" + test_case + " ");
            if (visited2[destination.x][destination.y] != false)
                sb.append(dist2[destination.x][destination.y] + "\n");
            else
                sb.append("GAME OVER" + "\n");
        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static void bfs1(Pair start) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(start);
        visited1[start.x][start.y] = true;
        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                if (visited1[nx][ny] != false)
                    continue;
                if (map[nx][ny] == 'X' || map[nx][ny] == 'D')
                    continue;

                visited1[nx][ny] = true;
                dist1[nx][ny] = dist1[cur.x][cur.y] + 1;
                q.add(new Pair(nx, ny));
            }

        }

    }

    private static void bfs2(Pair start) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(start);
        visited2[start.x][start.y] = true;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (visited2[nx][ny] != false)
                    continue;
                if (map[nx][ny] == 'X')
                    continue;
                if (dist1[nx][ny] <= dist2[cur.x][cur.y] + 1 && visited1[nx][ny] == true)
                    continue;

                visited2[nx][ny] = true;
                dist2[nx][ny] = dist2[cur.x][cur.y] + 1;
                q.add(new Pair(nx, ny));
            }
        }
    }
}
