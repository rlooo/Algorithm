import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1504_특정한최단경로 {
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

    static ArrayList<Node>[] nodeList;
    static int[] dist;
    static int N, E;
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        nodeList = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            nodeList[a].add(new Node(b, c));
            nodeList[b].add(new Node(a, c));
        }

        st = new StringTokenizer(in.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);

        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);

        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);

        sb.append(ans);
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF); // cost 배열 INF로 초기화
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