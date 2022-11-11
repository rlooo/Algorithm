import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18809_Gaaaaaaaaaarden {
    static int N, M, G, R;
    static int[][] map;
    static int[][][] time;
    static List<Pair> possible = new ArrayList<>();
    static List<Pair> rList = new ArrayList<>();
    static List<Pair> gList = new ArrayList<>();
    static Queue<Pair> q = new ArrayDeque<>();
    static boolean[] isused;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int res = 0;

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
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        time = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    possible.add(new Pair(i, j));
                }
            }
        }
        isused = new boolean[possible.size()];

        rBacktracking(0);

        sb.append(res);
        out.write(sb.toString());
        out.flush();
        out.close();

    }

    private static void rBacktracking(int k) { // 현재 k개까지 수를 택했음
        if (k == R) {
            gBacktracking(0);
            return;
        }
        for (int i = 0; i < possible.size(); i++) {
            if (!isused[i]) {
                int x = possible.get(i).x;
                int y = possible.get(i).y;
                rList.add(new Pair(x, y));
                isused[i] = true;
                rBacktracking(k + 1);
                isused[i] = false;
            }
        }
    }

    private static void gBacktracking(int k) { // 현재 k개가지 수를 택했음
        if (k == G) {
            for (int i = 0; i < gList.size(); i++) {
                q.add(gList.get(i));
            }
            for (int i = 0; i < rList.size(); i++) {
                q.add(rList.get(i));
            }
            bfs();
            return;
        }
        for (int i = 0; i < possible.size(); i++) {
            if (!isused[i]) {
                int x = possible.get(i).x;
                int y = possible.get(i).y;
                gList.add(new Pair(x, y));
                isused[i] = true;
                gBacktracking(k + 1);
                isused[i] = false;
            }
        }
    }

    private static void bfs() {
        int cnt = 0;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (map[cur.x][cur.y] != -1) {
                for (int dir = 0; dir < 4; dir++) {
                    int nx;
                    int ny;

                    nx = cur.x + dx[dir];
                    ny = cur.y + dy[dir];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        continue;
                    }
                    if (map[nx][ny] == 0)
                        continue;

                    if (time[nx][ny][0] != 0 && time[cur.x][cur.y][0] > 0)
                        continue;

                    else if (time[nx][ny][1] != 0 && time[cur.x][cur.y][1] < 0)
                        continue;

                    if (time[cur.x][cur.y][0] > 0) {
                        time[nx][ny][0] = time[cur.x][cur.y][0] + 1;
                    } else if (time[cur.x][cur.y][0] < 0) {
                        time[nx][ny][1] = time[cur.x][cur.y][1] - 1;
                    }

                    if (time[nx][ny][0] != 0 && time[nx][ny][1] != 0) {
                        if (time[nx][ny][0] + time[nx][ny][1] == 0) {
                            cnt++;
                            map[nx][ny] = -1;
                        }
                    }

                    q.add(new Pair(nx, ny));

                }

            }

        }
        res = Math.max(res, cnt);
    }
}