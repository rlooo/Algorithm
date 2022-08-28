import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리 {
	static int v, e;
	static int[] parent;
	static int res=0;
	static ArrayList<Edge> graph;

	static class Edge implements Comparable<Edge> {
		int node1;
		int node2;
		int weight;

		Edge(int node1, int node2, int weight) {
			this.node1 = node1;
			this.node2 = node2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(in.readLine(), " ");
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		parent = new int[v + 1];
		graph = new ArrayList<>();

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			// 무향
			graph.add(new Edge(a, b, w));
		} // 입력

		// kruskal
		kruskal();
		sb.append(res);
		out.write(sb.toString());
		out.flush();
		out.close();

	}

	private static void kruskal() {
		Collections.sort(graph); // 가중치 오름차순 정렬

		// makeset
		for (int i = 1; i <= v; i++) {
			parent[i] = i;
		}

		for (Edge edge : graph) {
			if (find(edge.node1) != find(edge.node2)) {// 루트 노드가 다르면 서클 아님
				union(edge.node1, edge.node2);
				res+=edge.weight;
			}
		}

	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}

	private static int find(int x) {
		if (parent[x] == x)
			return x;
		else
			return parent[x] = find(parent[x]);
	}

}
