import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_Contact {
	static StringBuilder sb = new StringBuilder();
	static int len;
	static int start;
	static ArrayList<Integer>[] nodeList;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			st = new StringTokenizer(in.readLine(), " ");
			len = Integer.parseInt(st.nextToken()); // 입력받는 데이터 길이
			start = Integer.parseInt(st.nextToken()); // 시작점
			nodeList = new ArrayList[101];
			visited = new int[101];

			for (int i = 1; i <= 100; i++) {
				nodeList[i] = new ArrayList<>();
			}

			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < len / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				nodeList[from].add(to);
			}
			sb.append("#" + test_case + " ");
			bfs(start);

		}
		out.write(sb.toString());
		out.flush();
		out.close();

	}

	private static void bfs(int cur) {

		Queue<Integer> q = new LinkedList();

		q.add(cur);
		visited[cur] = 1;

		int max_visited = visited[cur];

		while (!q.isEmpty()) {
			int node = q.poll();

			for (int i = 0; i < nodeList[node].size(); i++) {
				int next = nodeList[node].get(i);

				if (visited[next] != 0)
					continue;

				visited[next] = visited[node] + 1;
				q.add(next);
				max_visited = Math.max(max_visited, visited[next]);
			}

		}

		for (int i = 100; i >= 1; i--) {
			if (max_visited == visited[i]) {
				sb.append(i + "\n");
				break;
			}
		}

	}

}
