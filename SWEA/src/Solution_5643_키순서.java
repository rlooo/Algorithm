import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_키순서 {
    static ArrayList<Integer>[] pre;
    static ArrayList<Integer>[] nxt;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(in.readLine());
            int M = Integer.parseInt(in.readLine());
            pre = new ArrayList[N + 1];
            nxt = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                pre[i] = new ArrayList<>();
                nxt[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                pre[from].add(to);
                nxt[to].add(from);
            }
            int res = 0;
            for (int i = 1; i <= N; i++) {
                boolean[] visited = new boolean[N + 1];
                bfs(i, visited, pre);
                bfs(i, visited, nxt);
                int cnt = 0;
                for (int j = 1; j <= N; j++) {
                    if (visited[j] == true)
                        cnt++;
                }
                if (cnt == N)
                    res++;
            }

            sb.append("#" + tc + " " + res + "\n");
        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static void bfs(int start, boolean[] visited, ArrayList<Integer>[] list) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < list[cur].size(); i++) {
                if (visited[list[cur].get(i)] != false)
                    continue;
                visited[list[cur].get(i)] = true;
                q.add(list[cur].get(i));
            }
        }

    }
}
