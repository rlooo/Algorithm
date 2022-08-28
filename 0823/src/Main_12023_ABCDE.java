import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_12023_ABCDE {
	static ArrayList<Integer>[] nodeList;
	static boolean[] visited;
	static int res=0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		nodeList = new ArrayList[N];
//		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			nodeList[i] = new ArrayList<>();
		} // 할당

		int a;
		int b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			nodeList[a].add(b);
			nodeList[b].add(a);
		}
		
		for (int i = 0; i < M; i++) {
			res=0;
//			visited = new boolean[N]; // 이건 왜 이렇게 해야 할까
			dfs(0, i);
			if(res==4) {sb.append(1);break;}
		}
		

		if(res!=4)sb.append(0);
		
		out.write(sb.toString());
		out.flush();
		out.close();

	}

	private static void dfs(int depth, int v) {
		if (depth == 4) {
			res = 4;
			return;
		}

		visited[v] = true;
		
		for (int i = 0; i < nodeList[v].size(); i++) {
			int cur = nodeList[v].get(i);
			if (visited[cur] != false)
				continue;
			visited[cur] = true;
			dfs(depth + 1, cur);
			visited[cur] = false;

		}

	}

}
