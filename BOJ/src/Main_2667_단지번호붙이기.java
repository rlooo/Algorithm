import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2667_단지번호붙이기 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static ArrayList<Integer> arr = new ArrayList<>();

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(in.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = in.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] != false || map[i][j] != 1)
                    continue;
                bfs(new Pair(i, j));
                res++;
            }
        }
        Collections.sort(arr);
        sb.append(res + "\n");
        for (int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i) + "\n");
        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static void bfs(Pair start) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(start);
        visited[start.x][start.y] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            cnt++;
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;
                if (visited[nx][ny] != false)
                    continue;
                if (map[nx][ny] != 1)
                    continue;

                visited[nx][ny] = true;
                q.add(new Pair(nx, ny));
            }
        }
        arr.add(cnt);

    }
}
