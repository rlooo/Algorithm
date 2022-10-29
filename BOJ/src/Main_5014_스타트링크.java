import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5014_스타트링크 {
    static int[] dist;
    static int F, S, G, U, D;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(in.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        dist = new int[F + 1];
        for (int i = 0; i < F + 1; i++) {
            dist[i] = -1;
        }
        bfs(S);
        String res = (dist[G] == -1) ? "use the stairs" : sb.append(dist[G]).toString();
        out.write(res);
        out.flush();
        out.close();

    }

    private static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            int next = cur + U;

            if (next >= 1 && next <= F && dist[next] == -1) {
                dist[next] = dist[cur] + 1;
                q.add(next);
            }

            next = cur - D;

            if (next >= 1 && next <= F && dist[next] == -1) {
                dist[next] = dist[cur] + 1;
                q.add(next);
            }

        }

    }
}
