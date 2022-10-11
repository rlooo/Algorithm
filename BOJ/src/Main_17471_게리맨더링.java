import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링 {
    static ArrayList<Integer>[] list;
    static int N;
    static boolean[] selected;
    static boolean[] visited;

    static int res = Integer.MAX_VALUE;
    static int[] popultaion;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        popultaion = new int[N + 1]; // 1-index
        st = new StringTokenizer(in.readLine());

        for (int i = 1; i <= N; i++) {
            popultaion[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList[N + 1];
        selected = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            st = new StringTokenizer(in.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        selected = new boolean[N + 1];
        for (int i = 1; i <= N / 2; i++) {
            comb(1, 0, i);
        }
        sb.append(res == Integer.MAX_VALUE ? "-1" : res);
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static void comb(int start, int cnt, int target) {
        if (target == cnt) {
            int check = 0;
            visited = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                if (visited[i] != false) {
                    continue;
                }

                bfs(i);
                check++;
            }

            if (check == 2) {
                int a = 0;
                int b = 0;
                for (int i = 1; i <= N; i++) {
                    if (selected[i] == true)
                        a += popultaion[i];
                    else
                        b += popultaion[i];
                }

                res = Math.min(res, Math.abs(a - b));
            }
            return;
        }
        for (int i = start; i <= N; i++) {
            if (selected[i] != false)
                continue;
            selected[i] = true;

            comb(i + 1, cnt + 1, target);
            selected[i] = false;
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.add(start);
        boolean check = selected[start];
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < list[cur].size(); i++) {
                if (visited[list[cur].get(i)] != false)
                    continue;
                if (check == selected[list[cur].get(i)]) {
                    visited[list[cur].get(i)] = true;
                    q.add(list[cur].get(i));
                }

            }

        }
    }
}
