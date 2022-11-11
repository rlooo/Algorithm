import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17835_면접보는승범이네 {
    static ArrayList<Node>[] nodeList;
    static int[] dist;
    static int[] meeting;
    static int N, M, K;

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
        K = Integer.parseInt(st.nextToken());

        nodeList = new ArrayList[N + 1];
        dist = new int[N + 1];
        meeting = new int[K];

        for (int i = 1; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            nodeList[U].add(new Node(V, C));
        }

        int resNum = 0;
        int resDist = 0;
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < K; i++) {
            meeting[i] = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= N; j++) {
                dijkstra(j, meeting[i]);
                if (dist[meeting[i]] > resDist) {
                    resDist = dist[meeting[i]];
                    resNum = j;

                }
            }
        }

        sb.append(resNum + "\n" + resDist);
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static void dijkstra(int start, int end) {
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
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
    }
}
