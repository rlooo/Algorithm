import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_벽부수고이동하기 {
    static int[][] map;
    static int[][][] dist;
    static int res = Integer.MAX_VALUE;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int N, M;

    static class Pair {
        int x;
        int y;
        int wall;

        Pair(int x, int y, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;

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
        dist = new int[N + 1][M + 1][2];
        for (int i = 1; i <= N; i++) {
            String str = in.readLine();
            char[] input = str.toCharArray();

            for (int j = 1; j <= M; j++) {
                map[i][j] = input[j - 1] - '0';
            }
        }

        bfs();

        int res = Math.min(dist[N][M][0], dist[N][M][1]);
        String str = res == 0 ? sb.append(-1).toString() : sb.append(res).toString();
        out.write(str);
        out.flush();
        out.close();

    }

    private static void bfs() {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(1, 1, 0));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            System.out.println(1);

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 1 || ny < 1 || nx >= N || ny >= M)
                    continue;

                if (map[nx][ny] == 1) {


                }
                else {
                    dist[nx][ny][0] = Math.min(dist[cur.x][cur.y][0], dist[cur.x][cur.y][1]);
                }

                
            }
        }
       
    }

}
