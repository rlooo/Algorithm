import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {
	static int n;
	static int k;
	static int[] visited = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		if(n==k) {System.out.println(0);return;}
		bfs(n);

	}

	private static void bfs(int num) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(num);
		visited[num] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();

			int next;
			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					next = cur + 1;
				} else if (i == 1) {
					next = cur - 1;
				} else {
					next = 2 * cur;
				}
				
				
				if(next<0||next>100000||visited[next]!=0) continue;
				
				
				q.add(next);
				visited[next]=visited[cur]+1;
				
				if (next == k) {
                    System.out.println(visited[next]);
                    return;
                }

			}
		}

	}
}
