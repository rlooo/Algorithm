import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static List<Robot> list;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };

    static class Robot {
        int x;
        int y;
        int d;

        Robot(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
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

        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(in.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        Robot robot = new Robot(x, y, d);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(robot);

    }

    private static void bfs(Robot start) {
        Queue<Robot> q = new ArrayDeque<>();
        visited[start.x][start.y] = true;
        q.add(start);

        while (!q.isEmpty()) {
            Robot cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {

            }

        }
    }

}
