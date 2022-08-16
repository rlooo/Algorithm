import java.awt.font.GraphicAttribute;
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
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
	static int n, m;
	static ArrayList<Integer>[] nodeList;
	static boolean[] isVisited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		st = new StringTokenizer(bf.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); // 간선수
		m = Integer.parseInt(st.nextToken()); // 정점수
		int v = Integer.parseInt(st.nextToken()); // 시작 정점

		nodeList = new ArrayList[n + 1]; // 정점수대로 배열 생성
		isVisited = new boolean[n + 1];

		// 간선 리스트 초기화
		// 1번 정점부터 리스트를 만들어서 배열에 넣기
		for (int i = 1; i <= n; i++) {
			nodeList[i] = new ArrayList<>();
		}

		// 간선수대로 반복하며 연결 리스트 생성
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());

			// 양방향
			nodeList[from].add(to);
			nodeList[to].add(from);
		}

		DFS(v);

		Arrays.fill(isVisited, false);

		BFS(v);

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static void BFS(int v) {
		Queue<Integer> q = new LinkedList<>();

		q.add(v);
		isVisited[v] = true;
		sb.append(v + " ");

		while (!q.isEmpty()) {
			int node = q.poll();

			Collections.sort(nodeList[node]);

			for (int i = 0; i < nodeList[node].size(); i++) {
				int cur = nodeList[node].get(i);
				if (isVisited[cur] == true)
					continue;
				else {
					q.add(cur);
					isVisited[cur] = true;
					sb.append(cur + " ");
				}
			}

		}

	}

	private static void DFS(int v) {
		Stack<Integer> s = new Stack<>();

		s.push(v);
		isVisited[v] = true;
		sb.append(v + " ");

		while (!s.isEmpty()) {
			int node = s.peek();
			boolean flag = false;
			
			Collections.sort(nodeList[node]);

			for (int i = 0; i < nodeList[node].size(); i++) {
				int cur = nodeList[node].get(i);

				if (isVisited[cur] != true) {

					isVisited[cur] = true;
					s.push(cur);
					flag = true;
					sb.append(cur + " ");
					break;
				}
			}
			if(!flag) {System.out.println(s.pop());};

		}
		sb.append("\n");
	}

}
