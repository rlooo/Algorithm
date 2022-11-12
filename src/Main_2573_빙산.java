import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
<<<<<<< HEAD
import java.util.Deque;
import java.util.Iterator;
=======
>>>>>>> 70dc2c68979ce7243d04635326e5884a236f8890
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573_빙산 {
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int N, M, iceNum;

    static class Pair {
        int x;
        int y;
        int water;

        Pair(int x, int y, int water) {
            this.x = x;
            this.y = y;
            this.water = water;
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

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0)
                    iceNum++;
            }
        }

        int time = 0;
        if (iceNum == 0) {
            sb.append(0);
            out.write(sb.toString());
            out.flush();
            out.close();
            return;
        }
        while (true) {
            int area = 0;

            visited = new boolean[N][M];
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (visited[i][j] != true && map[i][j] > 0) {
                        bfs(new Pair(i, j, 0));
                        area++;
                    }
                    if (area >= 2) {
                        break;
                    }
                }
            }
            if (area >= 2) {
                break;
            }
            time++;

        }
        sb.append(time);
        out.write(sb.toString());
        out.flush();
        out.close();
        return;
    }

    private static void bfs(Pair start) {
        Deque<Pair> waterList = new ArrayDeque<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.add(start);
        visited[start.x][start.y] = true;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int cnt = 0;
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (visited[nx][ny] != false)
                    continue;
                if (map[nx][ny] <= 0) {
                    cnt++;
                    continue;
                }

                q.add(new Pair(nx, ny, 0));
                visited[nx][ny] = true;
            }
            waterList.add(new Pair(cur.x, cur.y, cnt));
        }
        for (int i = 0; i < waterList.size(); i++) {
            map[waterList.get(i).x][waterList.get(i).y] -= waterList.get(i).water;
            if (map[waterList.get(i).x][waterList.get(i).y] < 0) {
                iceNum--;
            }

        }

        Iterator iter = waterList.iterator();
		
        while (iter.hasNext()) {
            Object w = iter.next();
            map[waterList.get(i).x][waterList.get(i).y] -= waterList.get(i).water;
        
        }

    }
}
