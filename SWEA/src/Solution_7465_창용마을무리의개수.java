import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

public class Solution_7465_창용마을무리의개수 {
	static ArrayList<Integer>[] nodeList;
	static boolean[] visited;
	static int res = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			res = 0;
			
			st = new StringTokenizer(in.readLine(), " ");

			int N = Integer.parseInt(st.nextToken()); // 사람 수
			int M = Integer.parseInt(st.nextToken()); // 관계 스

			nodeList = new ArrayList[N + 1]; // 1-index이므로
			visited = new boolean[N + 1];

			for (int i = 1; i <= N; i++) {
				nodeList[i] = new ArrayList<>();
			} // 할당

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				nodeList[a].add(b);
				nodeList[b].add(a);
			}
			for (int i = 1; i <= N; i++) {
				bfs(i);
			}

			sb.append(res+"\n");


		}
		out.write(sb.toString());
		out.flush();
		out.close();

	}

	private static void bfs(int start) {
		if (visited[start] != false) {
			return;
		}
		res++;

		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 0; i < nodeList[cur].size(); i++) {
				int next = nodeList[cur].get(i);
				if (visited[next] != false)
					continue;
				visited[next] = true;
				q.add(next);
			}

		}

	}

}
