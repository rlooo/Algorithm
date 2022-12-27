import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15683_감시 {
    static int N, M;
    static int[][] room;
    static int result = Integer.MAX_VALUE;
    static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
    static int[] dy = { 0, 0, -1, 1 };
    static ArrayList<Point> cctvList = new ArrayList<>();

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
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
        M = Integer.parseInt(st.nextToken());

        room = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] != 0 && room[i][j] != 6) {
                    cctvList.add(new Point(i, j));
                }
            }
        }

        dfs(0);

        sb.append(result);
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static void dfs(int idx) {
        if (idx == cctvList.size()) {
            result = Math.min(result, blindSpot());
            return;
        }
        Point cctv = cctvList.get(idx);
        int x = cctv.x;
        int y = cctv.y;

        List<List<Point>> watchList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            watchList.add(new ArrayList<>());
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            while (nx >= 0 && ny >= 0 && nx < N && ny < M && room[nx][ny] != 6) {
                if (room[nx][ny] == 0) {
                    watchList.get(i).add(new Point(nx, ny));
                }
                nx += dx[i];
                ny += dy[i];

            }
        } // 4방향으로 볼 수 있는 모든 좌표 q에 저장

        if (room[x][y] == 1) {
            for (int i = 0; i < 4; i++) {
                changeRoom(watchList.get(i), -1);
                dfs(idx + 1);
                changeRoom(watchList.get(i), 0);
            }
        } else if (room[x][y] == 2) {
            for (int i = 0; i < 3; i += 2) {
                changeRoom(watchList.get(i), -1);
                changeRoom(watchList.get(i + 1), -1);
                dfs(idx + 1);
                changeRoom(watchList.get(i), 0);
                changeRoom(watchList.get(i + 1), 0);
            }
        } else if (room[x][y] == 3) {
            for (int i = 0; i < 2; i++) {
                changeRoom(watchList.get(i), -1);
                for (int j = 2; j < 4; j++) {
                    changeRoom(watchList.get(j), -1);
                    dfs(idx + 1);
                    changeRoom(watchList.get(j), 0);
                }
                changeRoom(watchList.get(i), 0);
            }

        } else if (room[x][y] == 4) {
            for (int i = 0; i < 4; i++) {
                changeRoom(watchList.get(i), -1);
                changeRoom(watchList.get((i + 1) % 4), -1);
                changeRoom(watchList.get((i + 2) % 4), -1);
                dfs(idx + 1);
                changeRoom(watchList.get(i), 0);
                changeRoom(watchList.get((i + 1) % 4), 0);
                changeRoom(watchList.get((i + 2) % 4), 0);
            }

        } else {
            for (int i = 0; i < 4; i++) {
                changeRoom(watchList.get(i), -1);
            }
            dfs(idx + 1);
            for (int i = 0; i < 4; i++) {
                changeRoom(watchList.get(i), 0);
            }

        }

    }

    private static int blindSpot() { // 사각지대
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (room[i][j] == 0) {
                    cnt++;
                }
            }

        }

        return cnt;
    }

    private static void changeRoom(List<Point> watchList, int val) {

        for (int i = 0; i < watchList.size(); i++) {
            Point cur = watchList.get(i);
            room[cur.x][cur.y] = val;
        }
    }

}