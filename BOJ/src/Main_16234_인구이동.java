import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234_인구이동 {
    static int N, L, R;
    static int[][] land;
    static boolean[][] visited;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int population = 0;
    static int kan = 0;

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
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        land = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int days = 0;
        while (true) {
            visited = new boolean[N][N];
            int flag = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] != false)
                        continue;
                    flag++;
                    visited[i][j] = true;
                    bfs(new Pair(i, j));
                }
            }
            if (flag == N * N)
                break;
            days++;

        }

        sb.append(days);
        out.write(sb.toString());
        out.flush();
        out.close();

    }

    private static void bfs(Pair start) {
        Queue<Pair> q = new ArrayDeque<>();
        population = land[start.x][start.y];
        kan = 1;
        ArrayList<Pair> unionList = new ArrayList<>();
        unionList.add(start);
        q.add(start);

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;

                if (visited[nx][ny] != false)
                    continue;
                if (Math.abs(land[cur.x][cur.y] - land[nx][ny]) < L || Math.abs(land[cur.x][cur.y] - land[nx][ny]) > R)
                    continue;

                visited[nx][ny] = true;
                unionList.add(new Pair(nx, ny));
                population += land[nx][ny];
                kan++;

                q.add(new Pair(nx, ny));

            }
        }

        int update = population / kan;
        for (int i = 0; i < unionList.size(); i++) { // 연합 인구수 업데이트
            Pair p = unionList.get(i);
            land[p.x][p.y] = update;
        }

    }
}
// bfs 호출을 줄이는 방법은 없을까?