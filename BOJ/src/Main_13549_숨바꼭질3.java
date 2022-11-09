import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//탐색문제는
//1. 탐색순서
//2. 탈출조건
public class Main_13549_숨바꼭질3 {
    static int[] time;

    static class Point {
        int x;
        int time;

        Point(int x, int time) {
            this.x = x;
            this.time = time;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        time = new int[100001];

        bfs(N);

        sb.append(time[K] - 1);
        out.write(sb.toString());
        out.flush();
        out.close();

    }

    private static void bfs(int start) {
        Queue<Point> q = new ArrayDeque();
        q.add(new Point(start, 1));
        time[start] = 1;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int x = cur.x;
            int t = cur.time;
            if (2 * x >= 0 && 2 * x <= 100000) {
                if (time[2 * x] > t || time[2 * x] == 0) {
                    time[2 * x] = t;
                    q.add(new Point(2 * x, t));
                }
            }
            if (x - 1 >= 0 && x - 1 <= 100000) {
                if (time[x - 1] > t + 1 || time[x - 1] == 0) {
                    time[x - 1] = t + 1;
                    q.add(new Point(x - 1, t + 1));
                }

            }
            if (x + 1 >= 0 && x + 1 <= 100000) {
                if (time[x + 1] > t + 1 || time[x + 1] == 0) {
                    time[x + 1] = t + 1;
                    q.add(new Point(x + 1, t + 1));
                }

            }

        }

    }
}