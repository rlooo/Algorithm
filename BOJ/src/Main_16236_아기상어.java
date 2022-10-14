import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int time = 0;
    static int N;
    static Fish shark;
    static int eat = 0;

    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static int[] fish;

    static class Fish implements Comparable<Fish> {
        int x;
        int y;
        int size;
        int dist;

        Fish(int x, int y, int size, int dist) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish f) {
            if (this.dist == f.dist) {
                if (this.x == f.x) { // x 오름차순 정렬
                    return this.y - f.y;
                }
                return this.x - f.x;
            }

            return this.dist - f.dist;
        }

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(in.readLine());
        map = new int[N][N];
        dist = new int[N][N];
        visited = new boolean[N][N];
        fish = new int[7];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Fish(i, j, 2, 0);
                }
                if (map[i][j] != 0 && map[i][j] != 9) {
                    fish[map[i][j]]++;
                }
            }
        }

        bfs(shark);

        sb.append(time);
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static void bfs(Fish shark) {
        Queue<Fish> q = new PriorityQueue<>();
        q.add(shark);
        visited[shark.x][shark.y] = true;
        map[shark.x][shark.y] = 0;
        while (!q.isEmpty()) {
            Fish cur = q.poll();

            if (map[cur.x][cur.y] != 0 && map[cur.x][cur.y] < shark.size) { // 물고기 먹을 수 있음
                time += dist[cur.x][cur.y];
                eat++;
                fish[map[cur.x][cur.y]]--;

                map[cur.x][cur.y] = 0;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        visited[i][j] = false;
                        dist[i][j] = 0;
                        q.clear();

                    }
                }

                visited[cur.x][cur.y] = true;

                if (shark.size == eat) {
                    shark.size++;
                    eat = 0;
                }
            }
            boolean flag = false;
            for (int i = 1; i < 7; i++) {
                if (fish[i] > 0) {
                    flag = true;
                    break;
                }
            }

            if (flag == false) {
                return;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;
                if (visited[nx][ny] != false)
                    continue;
                if (map[nx][ny] > shark.size)
                    continue;

                visited[nx][ny] = true;
                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.add(new Fish(nx, ny, map[nx][ny], dist[nx][ny]));

            }

        }

    }
}
