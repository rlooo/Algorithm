import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18352_특정거리의도시찾기_re {
    static Node[] nodeList;
    static int[] dist;

    static class Node implements Comparable<Node> {
        Node next;
        int w;

        Node(Node next, int w) {
            this.next = next;
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
        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

        nodeList = new Node[N + 1];
        dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            nodeList[A] = new Node(nodeList[A], B);
        }
        // dijkstra(X);

        List<Integer> res = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (dist[i] != Integer.MAX_VALUE && dist[i] == K) {
                res.add(i);
            }
        }

        Collections.sort(res);

        if (res.size() == 0) {
            sb.append(-1 + "\n");
        }

        for (int i = 0; i < res.size(); i++) {
            sb.append(res.get(i) + "\n");
        }

        out.write(sb.toString());
        out.flush();
        out.close();
    }

    // private static void dijkstra(int start) {
    // Queue<Node> q = new PriorityQueue<>();
    // q.add(new Node(start, 0));
    // dist[start] = 0;

    // while (!q.isEmpty()) {
    // Node cur = q.poll();

    // if (dist[cur.v] != cur.w)
    // continue;

    // for (Node node : nodeList[cur.v]) {
    // if (dist[node.v] <= dist[cur.v] + node.w)
    // continue;

    // dist[node.v] = dist[cur.v] + node.w;
    // q.add(new Node(node.v, dist[node.v]));
    // }

    // }

    // }
}
