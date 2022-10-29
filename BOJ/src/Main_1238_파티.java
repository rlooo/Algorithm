import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1238_파티 {
    static ArrayList<Node>[] nodeList;
    static int[] dist;
    static int N, M, X;
    static int INF = 100000;

    static class Node implements Comparable<Node> {
        int v;
        int w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
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
        X = Integer.parseInt(st.nextToken());

        nodeList = new ArrayList[N + 1];
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            nodeList[a].add(new Node(b, c));
        }

        int res = 0;
        for (int i = 1; i <= N; i++) {
            int time = 0;
            time += dijkstra(i, X);
            time += dijkstra(X, i);
            res = Math.max(res, time);
        }

        sb.append(res);
        out.write(sb.toString());
        out.flush();
        out.close();

    }

    private static int dijkstra(int start, int end) {
        for (int i = 1; i <= N; i++) {
            dist[i] = INF;
        }

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (dist[cur.v] != cur.w)
                continue;

            for (Node node : nodeList[cur.v]) {
                if (dist[node.v] <= dist[cur.v] + node.w)
                    continue;

                dist[node.v] = dist[cur.v] + node.w;
                q.add(new Node(node.v, dist[node.v]));

            }
        }

        return dist[end];
    }
}
