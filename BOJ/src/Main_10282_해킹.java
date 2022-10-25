import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10282_해킹 {
    static ArrayList<Pair>[] list;
    static int[] time;
    static int cnt = 0;

    static class Pair implements Comparable<Pair> {
        int v;
        int s;

        Pair(int v, int s) {
            this.v = v;
            this.s = s;
        }

        @Override
        public int compareTo(Pair o) {
            return this.s - o.s;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            cnt = 0;

            st = new StringTokenizer(in.readLine());

            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list = new ArrayList[n + 1];
            time = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
                time[i] = Integer.MAX_VALUE;
            }
            for (int i = 0; i < d; i++) {

                st = new StringTokenizer(in.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                list[b].add(new Pair(a, s));
            }
            dijkstra(c);

            int cnt = 0;
            int res = 0;
            for (int i = 1; i <= n; i++) {
                if (time[i] != Integer.MAX_VALUE) {
                    cnt++;
                    res = Math.max(res, time[i]);
                }

            }

            sb.append(cnt + " " + res + "\n");

        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static void dijkstra(int start) {
        Queue<Pair> q = new PriorityQueue<>();

        time[start] = 0;
        q.add(new Pair(start, 0));

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            int v = cur.v;
            int sec = cur.s;

            if (time[v] != sec)
                continue;

            for (Pair node : list[v]) {

                if (time[node.v] <= time[v] + node.s) {
                    continue;
                }

                time[node.v] = time[cur.v] + node.s;
                q.add(new Pair(node.v, time[node.v]));
            }
        }

    }

}
