import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11779_최소비용구하기2 {
    static ArrayList<Node>[] nodeList;
    static int[] dist;
    static int[] pre;

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

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(in.readLine());
        int m = Integer.parseInt(in.readLine());

        nodeList = new ArrayList[n + 1];
        dist = new int[n + 1];
        pre = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nodeList[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            nodeList[a].add(new Node(b, w));
        }

        st = new StringTokenizer(in.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);

        sb.append(dist[end] + "\n");

        int cur = end;
        List<Integer> path = new ArrayList<>();
        while (cur != start) {
            path.add(cur);
            cur = pre[cur];
        }
        path.add(cur);

        sb.append(path.size() + "\n");

        Collections.reverse(path);

        for (int p : path) {
            sb.append(p + " ");
        }

        out.write(sb.toString());
        out.flush();
        out.close();

    }

    private static void dijkstra(int start, int end) {
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
                pre[node.v] = cur.v;
                q.add(new Node(node.v, dist[node.v]));
            }

        }

    }

}
