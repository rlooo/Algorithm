import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10971_외판원순회2_2 {
	static boolean[] visited;
	static int arr[][];
	static int res = Integer.MAX_VALUE;
	static int n;
// cost는 static으로 하지말고 파라미터로 넘겨줘야 함.. 재귀식마다 cost를 다르게 쓰니까....
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(in.readLine()); // 도시의 수
		visited = new boolean[n + 1];
		arr = new int[n + 1][n + 1]; // 1-index

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력

		for (int i = 1; i <= n; i++) {
			Arrays.fill(visited, false);
			visited[i] = true;
			func(i, i, 0, 0);// 시작점

		}
		sb.append(res);
		out.write(sb.toString());
		out.flush();
		out.close();

	}

	private static void func(int start, int cur, int cnt, int cost) {
		if (cnt == n - 1) { // 처음 노드는 위에서 방문해서 n-1
			// 마지막 노드에서 맨 처음 노드로 가는 비용 더해야함
			if (arr[cur][start] != 0) {
				cost += arr[cur][start];
				res = Math.min(res, cost);

			}

			return;
		}

		for (int next = 1; next <= n; next++) {
			if (visited[next] != false || arr[cur][next] == 0)
				continue;
			visited[next] = true;

			func(start, next, cnt + 1, cost + arr[cur][next]);

			visited[next] = false;

		}

	}

}
