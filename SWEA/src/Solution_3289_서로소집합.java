import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#"+test_case+" ");
			st = new StringTokenizer(in.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken()); // 입력으로 주어지는 연산의 개수

			int[] parent = MakeSet(n);

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int type = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				switch (type) {
				case 0:
					union(parent,a,b);
					break;
				case 1:
					int pa = find_parent(parent, a);
					int pb = find_parent(parent, b);
					 if(pa==pb) sb.append(1);
					 else sb.append(0);
					break;
				}

			}
			sb.append("\n");


		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}

	private static int[] MakeSet(int size) {
		int[] arr = new int[size + 1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = i;
		}
		return arr;
	}

	private static int find_parent(int[] parent, int x) {
		if (parent[x] == x) {
			return x;
		} else

		{
			return parent[x] = find_parent(parent, parent[x]);
		}
	}

	private static void union(int[] parent, int a, int b) {
		int pa = find_parent(parent, a);
		int pb = find_parent(parent, b);
		if (pa < pb) {
			parent[pb] = pa;
		} else {
			parent[pa] = pb;
		}

	}
}
