import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기 {
    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Pair[] arr;
    static ArrayList<ArrayList<Integer>> graph;
    static int n;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(in.readLine());
        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(in.readLine());
            arr = new Pair[n + 2];
            graph = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(in.readLine());
                arr[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            for (int i = 0; i < n + 1; i++) {
                for (int j = i + 1; j < n + 2; j++) {
                    if (dist(arr[i], arr[j]) <= 1000) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            sb.append(bfs() == true ? "happy\n" : "sad\n");
        }
        out.write(sb.toString());
        out.flush();
        out.close();
    }

    private static boolean bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);

        boolean[] visited = new boolean[n + 2];
        visited[0] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == n + 1) {
                return true;
            }
            for (int i = 0; i < graph.get(cur).size(); i++) {
                if (visited[graph.get(cur).get(i)] != false)
                    continue;
                visited[graph.get(cur).get(i)] = true;
                q.add(graph.get(cur).get(i));
            }
        }
        return false;

    }

    private static int dist(Pair a, Pair b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}
