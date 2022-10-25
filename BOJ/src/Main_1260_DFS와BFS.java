import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
	static ArrayList<Integer>[] list;
	static boolean[] isVisited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken()); // 정점수
		int m = Integer.parseInt(st.nextToken()); // 간선수
		int v = Integer.parseInt(st.nextToken()); // 시작 정점

		list = new ArrayList[n + 1]; // 간선수대로 배열 생성
		isVisited = new boolean[n + 1];

		// 간선 리스트 초기화
		// 1번 정점부터 리스트를 만들어서 배열에 넣기
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());

			// 양방향
			list[to].add(from);
			list[from].add(to);

		}

		dfs(v);

		Arrays.fill(isVisited, false);
		sb.append("\n");
		
		bfs(v);

		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();

		q.add(v);
		isVisited[v] = true;
		sb.append(v + " ");

		while (!q.isEmpty()) {
			int node = q.poll();

			Collections.sort(list[node]);

			for (int i = 0; i < list[node].size(); i++) {
				int cur = list[node].get(i);

				if (isVisited[cur] != false) {
					continue;
				} else {
					q.add(cur);
					isVisited[cur] = true;
					sb.append(cur + " ");

				}
			}

		}

	}

	private static void dfs(int v) {
		
		isVisited[v]=true;
		sb.append(v+" ");
		
		for (int i = 0; i < list[v].size(); i++) {
			Collections.sort(list[v]);
			
			int cur = list[v].get(i);
			
			if(isVisited[cur]!=false) continue;
			
			dfs(cur);
		
		}
		
	}
}
