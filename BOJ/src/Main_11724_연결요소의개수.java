import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {
	static ArrayList<Integer>[] arr;
	static boolean[] isVisited;
	static int cnt=0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new ArrayList[N + 1]; // 정점 수 대로 배열 생성
		isVisited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u].add(v);
			arr[v].add(u);
		}

		for (int i = 1; i <= N; i++) {
			bfs(i);
		}
		sb.append(cnt);
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		if(isVisited[start]==false) {
			q.add(start);
			isVisited[start] = true;

			while (!q.isEmpty()) {
				int node = q.poll();
				for (int i = 0; i < arr[node].size(); i++) {
					if (isVisited[arr[node].get(i)] == true)
						continue;
					q.add(arr[node].get(i));
					isVisited[arr[node].get(i)] = true;
				}

			}
			cnt++;
			return;
		}
		else {return;} 
		
	}
}
